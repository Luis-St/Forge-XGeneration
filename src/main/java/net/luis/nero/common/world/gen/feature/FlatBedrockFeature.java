package net.luis.nero.common.world.gen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FlatBedrockFeature extends Feature<NoneFeatureConfiguration> {

	public FlatBedrockFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		ChunkAccess chunkAccess = context.level().getChunk(context.origin());
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 5; y++) {
				for (int z = 0; z < 16; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					if (y == 0 || y == 1) {
						chunkAccess.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
					} else {
						Block block = chunkAccess.getBlockState(pos).getBlock();
						if (block == Blocks.BEDROCK || block == Blocks.LAVA || block == Blocks.WATER || block instanceof AirBlock) {
							chunkAccess.setBlockState(pos, Blocks.STONE.defaultBlockState(), false);
						}
					}
				}
			}
		}
		return true;
	}

}
