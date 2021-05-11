package net.luis.industry.common.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ReducedExposedOreFeature extends Feature<OreFeatureConfig> {

	public ReducedExposedOreFeature(Codec<OreFeatureConfig> p_i231953_1_) {
		super(p_i231953_1_);
	}

	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rng, BlockPos pos, OreFeatureConfig config) {
		return true;
	}

}
