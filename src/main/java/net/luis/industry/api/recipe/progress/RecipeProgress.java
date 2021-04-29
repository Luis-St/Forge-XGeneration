package net.luis.industry.api.recipe.progress;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.util.exception.NotExecuteException;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RecipeProgress implements IRecipeProgress {
	
	private IModRecipe recipe;
	private ModRecipeType recipeType;
	private int progressTime;
	
	public RecipeProgress(IModRecipe recipe, ModRecipeType recipeType, int progressTime) {
		this.recipe = recipe;
		this.recipeType = recipeType;
		this.progressTime = progressTime;
	}
	
	public static RecipeProgress of(CompoundNBT nbt) {
		if (nbt.contains("progressTime") && nbt.contains("recipeType") && nbt.contains("recipeId")) {
			int progressTime = nbt.getInt("progressTime");
			ModRecipeType recipeType = ModRecipeType.byId(nbt.getInt("recipeType"));
			IModRecipeHelper<?> recipeHelper = (IModRecipeHelper<?>) recipeType.getRecipeHelper();
			recipeHelper.createRecipeList();
			IModRecipe recipe = recipeHelper.getRecipeFromId(NBTUtil.loadUUID(nbt.get("recipeId")));
			return new RecipeProgress(recipe, recipeType, progressTime);
		}
		return null;
	}
	
	public IModRecipe getRecipe() {
		return recipe;
	}
	
	public ModRecipeType getRecipeType() {
		return recipeType;
	}
	
	public int getProgressTime() {
		return progressTime;
	}
	
	public void reduceProgressTime() {
		this.progressTime = this.getProgressTime() - 1;
	}
	
	@Override
	@Deprecated
	public void execute() {
		throw new NotExecuteException("A normally unused method was executed!");
	}

	@Override
	public void executeRecipe(World world, BlockPos pos) {
		if (world.getGameTime() % 20 == 0 && !world.isClientSide) {
			if (this.progressTime > 0) {
				this.reduceProgressTime();
			}
			if (this.progressTime == 0) {
				this.dropResultItems(world, pos);
				this.progressTime = -1;
			}
		}
	}
	
	protected void dropResultItems(World world, BlockPos pos) {
		if (this.getRecipe() != null) {
			for (ItemStack itemStack : this.getRecipe().getResult()) {
				ItemEntity itemEntity = new ItemEntity(world, this.getPos(pos)[0], this.getPos(pos)[1], this.getPos(pos)[2], itemStack);
				itemEntity.setDeltaMovement(0, 0, 0);
				world.addFreshEntity(itemEntity);
			}
		}
	}
	
	private double[] getPos(BlockPos pos) {
		double[] xyz = new double[3];
		xyz[0] = pos.getX() + 0.5;
		xyz[1] = pos.getY() + 1.1;
		xyz[2] = pos.getZ() + 0.5;
		return xyz;
	}

	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		if (this.recipe != null && this.recipeType != null && this.progressTime >= 0) {
			nbt.put("recipeId", NBTUtil.createUUID(this.recipe.getId()));
			nbt.putInt("recipeType", this.recipeType.getId());
			nbt.putInt("progressTime", this.progressTime);
		}
		return nbt;
	}

}
