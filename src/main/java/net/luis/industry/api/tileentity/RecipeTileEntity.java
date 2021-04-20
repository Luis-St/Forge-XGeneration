package net.luis.industry.api.tileentity;

import net.luis.industry.api.inventory.IRecipeInventory;
import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IClearable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraftforge.items.ItemHandlerHelper;

public class RecipeTileEntity<T extends IModRecipe> extends TileEntity implements IClearable {
	
	private final ModRecipeType recipeType;
	private final IModRecipeHelper<T> recipeHelper;
	protected IRecipeInventory inventory;
	protected T currentRecipe = null;
	protected int progressTime = 0;
	
	public RecipeTileEntity(TileEntityType<?> tileEntityType, ModRecipeType recipeType, IModRecipeHelper<T> recipeHelper, IRecipeInventory inventory) {
		super(tileEntityType);
		this.recipeType = recipeType;
		this.recipeHelper = recipeHelper;
		this.inventory = inventory;
		recipeHelper.createRecipeList();
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
	
	public boolean canInteract(PlayerEntity player, ItemStack itemStack) {
		
		if (player != null) {
			
			if (this.inventory.hasEmptySlots(this.inventory.getInput()) || itemStack.isEmpty()) {
				
//				if (this.getRecipeHelper().hasRecipe(itemStack) || itemStack.isEmpty()) {
//				
					return true;
//				
//				}
				
			}
			
		}
		
		return false;
		
	}
	
	public void onInteract(PlayerEntity player, Hand hand) {
		
		ItemStack itemStack = player.getItemInHand(hand);
		
		if (itemStack.isEmpty()) {
			
			ItemStack extractStack = this.inventory.extract(-1, itemStack, this.inventory.getInput());
			ItemHandlerHelper.giveItemToPlayer(player, extractStack);
			this.markUpdated();
			
		} else {
			
			this.inventory.insert(-1, itemStack, this.inventory.getInput());
			player.setItemInHand(hand, ItemStack.EMPTY);
			this.markUpdated();
			
		}
		
	}
	
	private void markUpdated() {
		this.setChanged();
		this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 2);
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
		
		if (this.getLevel().isAreaLoaded(this.getBlockPos(), 1)) {
			
			this.load(this.getBlockState(), packet.getTag());
			
		}
		
	}
	
	@Override
	public CompoundNBT getTileData() {
		CompoundNBT nbt = super.getTileData();
		this.inventory.serializeNBT(nbt);
		return nbt;
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
