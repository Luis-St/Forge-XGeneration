package net.luis.nero.common.world.biome.noise;

import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.chunk.ChunkAccess;

public interface IBiomeNoiseModifier {
	
	double modifyNoise(ChunkAccess chunkAccess, double noise, int x, int y, int z, StructureFeatureManager structureManager);
	
}
