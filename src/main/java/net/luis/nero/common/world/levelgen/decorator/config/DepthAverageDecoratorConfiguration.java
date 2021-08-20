package net.luis.nero.common.world.levelgen.decorator.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;

public class DepthAverageDecoratorConfiguration implements DecoratorConfiguration {
	
	public static final Codec<DepthAverageDecoratorConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.INT.fieldOf("base_line").forGetter((config) -> {
			return config.baseLine;
		}), Codec.INT.fieldOf("spread").forGetter((config) -> {
			return config.spread;
		})).apply(instance, DepthAverageDecoratorConfiguration::new);
	});
	
	public final int baseLine;
	public final int spread;
	
	public DepthAverageDecoratorConfiguration(int baseLine, int spread) {
		this.baseLine = baseLine;
		this.spread = spread;
	}
	
}
