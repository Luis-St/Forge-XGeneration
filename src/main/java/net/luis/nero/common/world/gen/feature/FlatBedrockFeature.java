package net.luis.nero.common.world.gen.feature;

import java.util.Random;

import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FlatBedrockFeature extends Feature<NoFeatureConfig> {

	public FlatBedrockFeature() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rng, BlockPos pos, NoFeatureConfig config) {
		IChunk chunk = seedReader.getChunk(pos);
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 5; y++) {
				for (int z = 0; z < 16; z++) {
					BlockPos chunkPos = new BlockPos(x, y, z);
					if (y == 0 || y == 1) {
						chunk.setBlockState(chunkPos, Blocks.BEDROCK.defaultBlockState(), false);
					} else {
						Block block = chunk.getBlockState(chunkPos).getBlock();
						if (block == Blocks.BEDROCK || block == Blocks.LAVA || block == Blocks.WATER || block instanceof AirBlock) {
							chunk.setBlockState(chunkPos, Blocks.STONE.defaultBlockState(), false);
						}
					}
				}
			}
		}
		return true;
	}

}
