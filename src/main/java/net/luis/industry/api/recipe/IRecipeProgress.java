package net.luis.industry.api.recipe;

import net.luis.industry.api.util.IProgress;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IRecipeProgress extends IProgress {
	
	void executeRecipe(World world, BlockPos pos);
	
}
