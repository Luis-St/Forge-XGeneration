package net.luis.industry.api.tileentity;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.luis.industry.api.inventory.IRecipeInventory;
import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IClearable;
import net.minecraft.inventory.InventoryHelper;
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

public class RecipeTileEntity<T extends IModRecipe> extends TileEntity implements IClearable, ITickableTileEntity {
	
	private final ModRecipeType recipeType;
	private final IModRecipeHelper<T> recipeHelper;
	protected IRecipeInventory inventory;
	
	public RecipeTileEntity(TileEntityType<?> tileEntityType, ModRecipeType recipeType, IModRecipeHelper<T> recipeHelper, IRecipeInventory inventory) {
		super(tileEntityType);
		this.recipeType = recipeType;
		this.recipeHelper = recipeHelper;
		this.inventory = inventory;
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
			
			ItemStack extractStack = this.inventory.extract(-1, itemStack, this.inventory.getInput());
			ItemHandlerHelper.giveItemToPlayer(player, extractStack);
			
		} else {
			
			this.inventory.insert(-1, itemStack, this.inventory.getInput());
			player.setItemInHand(hand, ItemStack.EMPTY);
			
		}
		
		this.markUpdated();
		this.updateInventory(this.getRecipe());
		
	}
	
	public void updateInventory(T recipe) {
		
		if (recipe != null) {
			
			if (recipe.canDrop(this.getInventory().getInput())) {
				
				this.inventory.extractAll(recipe.getRecipeItems(), this.inventory.getInput());
				ArrayList<ItemStack> tempList = new ArrayList<ItemStack>();
				ItemStackList resultStacks;
				
				for (ResultItemStack resultStack : recipe.getAllResultItems()) {
					
					if (resultStack.isResult()) {
						
						ItemStack itemStack = resultStack.getItemStack();
						tempList.add(itemStack);
						this.inventory.extract(-1, itemStack, this.inventory.getInput());
						
					}
					
				}
				
				resultStacks = ItemStackList.of(ItemStack.EMPTY, tempList);
				this.drop(resultStacks);
				
			}
			
			this.markUpdated();
			
		}
		
	}
	
	// TODO : modify
	@Override
	public void tick() {
		
	}
	
	// TODO : modify
	public void recipeUpdate(World world, BlockPos pos, BlockState state) {
		
	}
	
	// TODO : modify
	public void drop(ItemStackList inventory) {
		World world = this.getLevel();
		BlockPos pos = this.getBlockPos();
		InventoryHelper.dropContents(world, pos, inventory);
		this.markUpdated();
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
	}
	
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(worldPosition, -1, this.save(new CompoundNBT()));
	}
	
	@Override
	public void onDataPacket(NetworkManager networkManager, SUpdateTileEntityPacket packet) {
		this.load(this.getBlockState(), packet.getTag());
	}
		
	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
		this.inventory.serializeNBT(nbt);
		return nbt;
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.inventory.deserializeNBT(nbt);
	}

}
