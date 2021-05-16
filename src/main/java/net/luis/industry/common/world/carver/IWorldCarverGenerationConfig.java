package net.luis.industry.common.world.carver;

import java.util.Random;
import java.util.Set;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;

public interface IWorldCarverGenerationConfig {
	
	default int getFillerHight() {
		return -1;
	}
	
	default FillerType getFillerType() {
		return FillerType.AIR;
	}
	
	Set<GenerationType> getGenerationTypes();
	
	void generateConfigDecoration(IChunk chunk, BlockPos pos, Random rng);

}
