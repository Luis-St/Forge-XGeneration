package net.luis.nero.api.recipe.progress;

import net.luis.nero.api.util.IProgress;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IRecipeProgress extends IProgress {
	
	void executeRecipe(World world, BlockPos pos);
	
}
