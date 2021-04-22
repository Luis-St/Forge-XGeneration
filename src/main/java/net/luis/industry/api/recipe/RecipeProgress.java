package net.luis.industry.api.recipe;

import java.util.ArrayList;
import java.util.List;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.exception.NotExecuteException;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RecipeProgress<T extends IModRecipe> implements IRecipeProgress {
	
	private final T recipe;
	private int progressTime;
	
	public RecipeProgress(T recipe, int progressTime) {
		this.recipe = recipe;
		this.progressTime = progressTime;
	}
	
	public T getRecipe() {
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
	
	protected void itemEntityList(World world, BlockPos pos, List<ResultItemStack> resultItems) {
		
		List<ItemEntity> itemEntities = new ArrayList<ItemEntity>();
		
		for (ResultItemStack resultItemStack : resultItems) {
			
			if (resultItemStack.isResult()) {
				
				itemEntities.add(new ItemEntity(world, this.getPos(pos)[0], this.getPos(pos)[1], this.getPos(pos)[2], resultItemStack.getItemStack()));
				
			}
			
		}
		
	}
	
	private double[] getPos(BlockPos pos) {
		double[] xyz = new double[3];
		xyz[0] = pos.getX() + 0.5;
		xyz[1] = pos.getY() + 0.9;
		xyz[2] = pos.getZ() + 0.5;
		return xyz;
	}

}
