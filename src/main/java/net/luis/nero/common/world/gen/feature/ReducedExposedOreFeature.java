package net.luis.nero.common.world.gen.feature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ReducedExposedOreFeature extends Feature<OreConfiguration> {

	// TODO: create -> 1.17 not needed copy vanilla create custom for removing/overwriteing of ores
	
	public ReducedExposedOreFeature() {
		super(OreConfiguration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<OreConfiguration> p_159749_) {
		return true;
	}

}
