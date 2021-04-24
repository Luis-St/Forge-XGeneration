package net.luis.industry.api.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.industry.api.util.exception.NotExecuteException;
import net.luis.industry.common.enums.ModRecipeType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
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
	
	@Nullable
	public static RecipeProgress of(CompoundNBT nbt) {
		if (nbt.contains("progressTime") && nbt.contains("recipeType") && nbt.contains("recipeId")) {
			int progressTime = nbt.getInt("progressTime");
			ModRecipeType recipeType = ModRecipeType.byId(nbt.getInt("recipeType"));
			IModRecipeHelper<?> recipeHelper = (IModRecipeHelper<?>) recipeType.getRecipeHelper();
			recipeHelper.createRecipeList();
			IModRecipe recipe = recipeHelper.getRecipeFromId(nbt.getInt("recipeId"));
			return new RecipeProgress(recipe, recipeType, progressTime);
		}
		return null;
	}
	
	public IModRecipe getRecipe() {
		return recipe;
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
		
		if (this.progressTime > 0) {
			this.reduceProgressTime();
		}
		
		if (this.progressTime == 0) {
			this.dropResultItems(world, pos);
		}
		
	}
	
	protected void dropResultItems(World world, BlockPos pos) {
		
		for (ItemStack itemStack : this.getRecipe().getResultItems()) {
			world.addFreshEntity(new ItemEntity(world, this.getPos(pos)[0], this.getPos(pos)[1], this.getPos(pos)[2], itemStack));
		}
		
	}
	
	private double[] getPos(BlockPos pos) {
		double[] xyz = new double[3];
		xyz[0] = pos.getX() + 0.5;
		xyz[1] = pos.getY() + 0.9;
		xyz[2] = pos.getZ() + 0.5;
		return xyz;
	}

	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("recipeId", this.recipe.getId());
		nbt.putInt("recipeType", this.recipeType.getId());
		nbt.putInt("progressTime", this.progressTime);
		return nbt;
	}
	
	public static CompoundNBT serializeList(List<RecipeProgress> recipeProgresses) {
		CompoundNBT nbt = new CompoundNBT();
		if (recipeProgresses != null) {
			nbt.putInt("size", recipeProgresses.size());
			ListNBT listNBT = new ListNBT();
			for (int i = 0; i < recipeProgresses.size(); i++) {
				RecipeProgress recipeProgress = recipeProgresses.get(i);
				if (recipeProgress != null) {
					listNBT.add(i, recipeProgress.serializeNBT());
				}
			}
			nbt.put("list", listNBT);
		}
		return nbt;
	}
	
	public static List<RecipeProgress> ofList(CompoundNBT nbt) {
		if (nbt.contains("size") && nbt.contains("list")) {
			int size = nbt.getInt("size");
			ListNBT listNBT = nbt.getList("list", 9);
			List<RecipeProgress> recipeProgresses = new ArrayList<RecipeProgress>();
			for (int i = 0; i < size; i++) {
				RecipeProgress recipeProgress = RecipeProgress.of(listNBT.getCompound(i));
				recipeProgresses.add(i, recipeProgress);
			}
			return recipeProgresses;
		}
		return Lists.newArrayList();
	}

}
