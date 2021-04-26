package net.luis.industry.api.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import net.luis.industry.api.inventory.IRecipeInventory;
import net.luis.industry.api.inventory.InventorySlot;
import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.progress.RecipeProgress;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public abstract class AbstractRecipeTileEntity<T extends IModRecipe> extends TileEntity implements IClearable, ITickableTileEntity {
	
	private ModRecipeType recipeType;
	private IModRecipeHelper<T> recipeHelper;
	protected IRecipeInventory inventory;
	protected RecipeProgress recipeProgress;
	
	public AbstractRecipeTileEntity(TileEntityType<?> tileEntityType, ModRecipeType recipeType, IModRecipeHelper<T> recipeHelper, IRecipeInventory inventory) {
		super(tileEntityType);
		this.recipeType = recipeType;
		this.recipeHelper = recipeHelper;
		this.inventory = inventory;
		this.recipeProgress = null;
	}
	
	protected ModRecipeType getRecipeType() {
		return this.recipeType;
	}
	
	public IModRecipeHelper<T> getRecipeHelper() {
		return this.recipeHelper;
	}
	
	public IRecipeInventory getInventory() {
		return this.inventory;
	}
	
	protected boolean hasItemsForRecipe(T recipe) {
		return recipe.canDrop(this.inventory.getInput());
	}
	
	@Nullable 
	public T getRecipe() {
		return this.getRecipeHelper().getNextRecipe(this.inventory.getInput());
	}
	
	public boolean canInteract(PlayerEntity player, ItemStack itemStack) {
		
		this.recipeHelper.createRecipeList();
		
		if (player != null) {
			
			if (this.getInventory().hasEmptySlots(this.inventory.getInput()) || itemStack.isEmpty()) {
				
				return this.getRecipeHelper().hasRecipe(itemStack) || itemStack.isEmpty();
				
			}
			
		}
		
		return false;
		
	}
	
	public void onInteract(PlayerEntity player, Hand hand) {
		
		ItemStack itemStack = player.getItemInHand(hand);
		
		if (itemStack.isEmpty()) {
			
			ItemStack extractStack = this.inventory.extract(-1, itemStack, this.inventory.getInput(), true);
			ItemHandlerHelper.giveItemToPlayer(player, extractStack);
			
		} else {
			
			this.inventory.insert(-1, itemStack, this.inventory.getInput());
			player.setItemInHand(hand, ItemStack.EMPTY);
			
		}
		
		this.markUpdated();
		this.updateInventory(this.getRecipe());
		
	}
	
	public void updateInventory(T recipe) {
		
		if (recipe != null && this.recipeProgress == null) {
			
			List<InventorySlot> inventorySlots = this.inventory.hasItemsForRecipe(this.inventory.getInput(), recipe);
			
			if (!inventorySlots.isEmpty()) {
				
				this.inventory.extractRecipe(recipe, this.inventory.getInput());
				this.recipeProgress = new RecipeProgress(recipe, this.getRecipeType(), recipe.getProgressTime());
				
			}
			
			this.markUpdated();
			
		}
		
	}
	
	@Override
	public void tick() {
		if (this.recipeProgress != null && this.getLevel() != null) {
			this.recipeUpdate(this.getLevel(), this.getBlockPos());
		}
	}
	
	public void recipeUpdate(World world, BlockPos pos) {
		if (this.recipeProgress != null) {
			this.recipeProgress.executeRecipe(world, pos);
			if (this.recipeProgress.getProgressTime() < 0) {
				this.recipeProgress = null;
				this.markUpdated();
			}
		}
	}
	
	protected void markUpdated() {
		if (this.getLevel() != null) {
			this.setChanged();
			this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
		}
	}
	
	@Override
	public void clearContent() {
		this.inventory.clearInput();
		this.inventory.clearOutput();
		this.markUpdated();
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(worldPosition, -1, this.save(new CompoundNBT()));
	}
	
	@Override
	public void onDataPacket(NetworkManager networkManager, SUpdateTileEntityPacket packet) {
		if (this.getLevel() != null) {
			if (this.getLevel().isAreaLoaded(this.getBlockPos(), 1)) {
				this.load(this.getBlockState(), packet.getTag());
			}
		}
	}
		
	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		nbt.putInt("recipeType", this.recipeType.getId());
		this.inventory.serializeNBT(nbt);
		if (this.recipeProgress != null) {
			nbt.put("recipeProgress", this.recipeProgress.serializeNBT());
		}
		return nbt;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.inventory.deserializeNBT(nbt);
		this.recipeType = ModRecipeType.byId(nbt.getInt("recipeType"));
		this.recipeHelper = (IModRecipeHelper<T>) this.getRecipeType().getRecipeHelper();
		if (nbt.contains("recipeProgress")) {
			this.recipeProgress = RecipeProgress.of(nbt.getCompound("recipeProgress"));
		} else {
			this.recipeProgress = null;
		}
	}

}
