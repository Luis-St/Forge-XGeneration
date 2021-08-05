package net.luis.nero.common.world.gen.decorator;

import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.luis.nero.common.world.gen.decorator.config.DepthAverageDecoratorConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class DepthAverageDecorator extends FeatureDecorator<DepthAverageDecoratorConfiguration> {

	public DepthAverageDecorator(Codec<DepthAverageDecoratorConfiguration> codec) {
		super(codec);
	}

	@Override
	public Stream<BlockPos> getPositions(DecorationContext context, Random rng, DepthAverageDecoratorConfiguration config, BlockPos pos) {
		int y = rng.nextInt(config.spread) + rng.nextInt(config.spread) - config.spread + config.baseLine;
		return Stream.of(new BlockPos(pos.getX(), y, pos.getZ()));
	}

}
