package net.luis.industry.common.world.feature;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class ModMineshaftFeature extends Feature<NoFeatureConfig>{

	public ModMineshaftFeature() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rng, BlockPos pos, NoFeatureConfig config) {
		return false;
	}

}
