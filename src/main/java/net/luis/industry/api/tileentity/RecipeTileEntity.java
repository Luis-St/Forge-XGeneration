package net.luis.industry.api.tileentity;

import static net.luis.industry.Industry.LOGGER;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class RecipeTileEntity<T extends IModRecipe> extends TileEntity implements ITickableTileEntity {
	
	private final ModRecipeType recipeType;
	private final IModRecipeHelper<T> recipeHelper;
	protected ItemStackHandler inputInventory;
	protected ItemStackHandler outputInventory;
	protected T currentRecipe = null;
	protected int progressTime = 0;
	
	public RecipeTileEntity(TileEntityType<?> tileEntityType, ModRecipeType recipeType, IModRecipeHelper<T> recipeHelper) {
		super(tileEntityType);
		this.recipeType = recipeType;
		this.recipeHelper = recipeHelper;
		this.inputInventory = new ItemStackHandler(5);
		this.outputInventory = new ItemStackHandler(5);
		recipeHelper.createRecipeList();
	}
	
	protected ModRecipeType getRecipeType() {
		return this.recipeType;
	}
	
	public IModRecipeHelper<T> getRecipeHelper() {
		return this.recipeHelper;
	}
	
	public ItemStackHandler getInputInventory() {
		return this.inputInventory;
	}
	
	public ItemStackHandler getOutputInventory() {
		return this.outputInventory;
	}
	
	public int getProgressTime() {
		return this.progressTime;
	}
	
	public void setProgressTime(int progressTime) {
		this.progressTime = progressTime;
	}
	
	@Override
	public void tick() {
		
		T currentRecipe = this.getCurrentRecipe();
		
		if (this.hasCurrentRecipe()) {
			
			if (this.allItemsAvailable(currentRecipe)) {
				
				this.recipeTick(currentRecipe);
				
			}
			
		}
		
	}

	public boolean canInteract(PlayerEntity player, ItemStack itemStack) {
		
		if (player != null) {
			
//			if (this.getRecipeHelper().hasRecipe(itemStack) || itemStack.isEmpty()) {
//				
				return true;
//				
//			}
			
		}
		
		return false;
		
	}
	
	public void onInteract(PlayerEntity player, Hand hand, boolean isSneaking) {
		
		if (player != null) {
			
			ItemStack itemStack = player.getItemInHand(hand);
			
			LOGGER.debug(itemStack);
			
			if (itemStack.isEmpty()) {
				
				LOGGER.debug("isEmpty");
				this.dropInventory(null, this.inputInventory);
				
			} else {
				
				ItemStack leftStack = ItemStack.EMPTY;
				int slot = this.getNextSlot(this.inputInventory, itemStack);
				
				if (isSneaking) {
					
					ItemStack copy = new ItemStack(itemStack.getItem(), 1);
					leftStack = this.inputInventory.insertItem(slot, copy, true);
					itemStack.shrink(1);
					
				} else {
					
					leftStack = this.inputInventory.insertItem(slot, itemStack, true);
					itemStack.shrink(itemStack.getCount());
					
				}
				
				LOGGER.debug(this.inputInventory.getStackInSlot(slot));
				
				if (!leftStack.isEmpty()) {
					
					ItemHandlerHelper.giveItemToPlayer(player, leftStack);
					
				}
				
			}
			
		}
		
		this.updateCurrentRecipe();
		this.setChanged();
		
	}
	
	protected int getNextSlot(ItemStackHandler inventory, ItemStack itemStack) {
		
		int slot = 0;
		for (; slot < inventory.getSlots(); slot++) {
			
			ItemStack stack = inventory.getStackInSlot(slot);
			
			if (stack.isEmpty() || (stack.getCount() < stack.getMaxStackSize() && stack.getItem() == itemStack.getItem())) {
				
				break;
				
			}
			
		}
		
		return slot;
		
	}
	
	protected final void dropInventory(@Nullable PlayerEntity player, ItemStackHandler inventory) {
		
		ArrayList<ItemStack> inventoryList = this.inventoryToList(inventory);
//		this.inputInventory = new ItemStackHandler(5);
		
		if (player != null) {
			
			LOGGER.debug("!=");
			LOGGER.debug("" + inventoryList);
			
			for (ItemStack itemStack : inventoryList) {
				
				LOGGER.debug(itemStack.toString());
				ItemHandlerHelper.giveItemToPlayer(player, itemStack);
				
			}
			
		} else {
			
			LOGGER.debug("else");
			
			this.dropItems(inventoryList);
			
		}
		
		this.setChanged();
		
	}
	
	protected final void updateCurrentRecipe() {
		
		List<T> currentRecipes = new ArrayList<T>();
		List<T> allRecipes = this.getRecipeHelper().getRecipes();
		
		for (T recipe : allRecipes) {
			
			if (this.hasItemsForRecipe(recipe)) {
				
				currentRecipes.add(recipe);
				
			}
			
		}
		
		this.setCurrentRecipe(currentRecipes.isEmpty() ? null : currentRecipes.get(0));
		this.updateProgressTime();
		this.setChanged();
		
	}
	
	protected void updateProgressTime() {
		
		T currentRecipe = this.getCurrentRecipe();
		
		if (currentRecipe != null) {
			
			this.setProgressTime(currentRecipe.getRecipeProgressTime());
			this.setChanged();
			
		}
		
	}
	
	@Nullable
	public T getCurrentRecipe() {
		return this.currentRecipe;
	}
	
	public void setCurrentRecipe(@Nullable T currentRecipe) {
		this.currentRecipe = currentRecipe;
	}
	
	public boolean hasCurrentRecipe() {
		return this.getCurrentRecipe() != null;
	}
	
	public boolean isCurrentRecipe(T recipe) {
		return this.getCurrentRecipe() == recipe;
	}
	
	public boolean hasItemsForRecipe(T recipe) {
		return recipe.allItemsAvailable(this.inventoryToList(this.inputInventory));
	}
	
	public boolean allItemsAvailable(T recipe) {
		return recipe.allItemsAvailable(this.inventoryToList(this.getInputInventory()));
	}
	
	protected ArrayList<ItemStack> inventoryToList(ItemStackHandler inventory) {
		
		ArrayList<ItemStack> inventoryList = new ArrayList<ItemStack>();
		
		for (int i = 0; i < inventory.getSlots(); i++) {
			
			inventoryList.add(inventory.getStackInSlot(i));
			
		}
		
		return inventoryList;
		
	}
	
	// TODO
	protected void recipeTick(T recipe) {
		
		
		
	}
	
	private double[] getPosToDrop() {
		
		double[] xyz = new double[3];
		xyz[0] = this.getBlockPos().getX() + 0.5;
		xyz[1] = this.getBlockPos().getY() + 0.85;
		xyz[2] = this.getBlockPos().getZ() + 0.5;
		return xyz;
		
	}
	
	protected List<ItemEntity> toItemEntity(List<ItemStack> stacks) {
		
		List<ItemEntity> itemEntities = new ArrayList<ItemEntity>();
		World world = this.getLevel();
		
		if (world != null) {
			
			for (ItemStack itemStack : stacks) {
				
				ItemEntity itemEntity = new ItemEntity(world, this.getPosToDrop()[0], this.getPosToDrop()[1], this.getPosToDrop()[2], itemStack);
				itemEntities.add(itemEntity);
				
			}
			
		}
		
		return itemEntities;
		
	}
	
	protected void dropItems(List<ItemStack> itemsToDrop) {
		
		if (this.hasCurrentRecipe()) {
			
			List<ItemEntity> itemEntities = this.toItemEntity(itemsToDrop);
			World world = this.getLevel();
			
			if (world != null && world instanceof ServerWorld) {
				
				for (ItemEntity itemEntity : itemEntities) {
					
					world.addFreshEntity(itemEntity);
					
				}
				
			}
			
			this.setChanged();
			
		}
		
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		
		CompoundNBT nbt = new CompoundNBT();
		nbt.put("inputInventory", this.inputInventory.serializeNBT());
		nbt.put("outputInventory", this.outputInventory.serializeNBT());
		return new SUpdateTileEntityPacket(worldPosition, -1, nbt);
		
	}
	
	@Override
	public void onDataPacket(NetworkManager networkManager, SUpdateTileEntityPacket packet) {
		
		super.onDataPacket(networkManager, packet);
		CompoundNBT nbt = packet.getTag();
		this.inputInventory.deserializeNBT(nbt.getCompound("inputInventory"));
		this.outputInventory.deserializeNBT(nbt.getCompound("outputInventory"));
		
		if (this.getLevel() != null) {
			
			World world = this.getLevel();
			
			if (world.isAreaLoaded(this.getBlockPos(), 1)) {
				

				
			}
			
		}
		
	}
		
	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		
		super.save(nbt);
		nbt.put("inputInventory", this.inputInventory.serializeNBT());
		nbt.put("outputInventory", this.outputInventory.serializeNBT());
		return nbt;
		
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		
		super.load(state, nbt);
		this.outputInventory.deserializeNBT(nbt.getCompound("inputInventory"));
		this.inputInventory.deserializeNBT(nbt.getCompound("outputInventory"));
		this.updateCurrentRecipe();
		this.updateProgressTime();
		
	}
	
}
