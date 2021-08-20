package net.luis.nero.api.common.world.levelgen.carver.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.material.FluidState;

public class ModCaveCarverConfiguration extends ModCarverConfiguration {
	
	public static final Codec<ModCaveCarverConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(ModCarverConfiguration.CODEC.forGetter((carverConfig) -> {
			return carverConfig;
		}), FloatProvider.CODEC.fieldOf("y_room_scale").forGetter((carverConfig) -> {
			return carverConfig.yRoomScale;
		}), FloatProvider.CODEC.fieldOf("y_tunnel_scale").forGetter((carverConfig) -> {
			return carverConfig.yTunnelScale;
		}), Codec.INT.fieldOf("bound").forGetter((carverConfig) -> {
			return carverConfig.bound;
		}), FloatProvider.CODEC.fieldOf("horizontal_multiplier").forGetter((carverConfig) -> {
			return carverConfig.horizontalMultiplier;
		}), FloatProvider.CODEC.fieldOf("vertical_multiplier").forGetter((carverConfig) -> {
			return carverConfig.verticalMultiplier;
		}), FloatProvider.codec(-1.0F, 1.0F).fieldOf("floor_level").forGetter((carverConfig) -> {
			return carverConfig.floorLevel;
		})).apply(instance, ModCaveCarverConfiguration::new);
	});
	
	public final FloatProvider yRoomScale;
	public final FloatProvider yTunnelScale;
	public final int bound;
	public final FloatProvider horizontalMultiplier;
	public final FloatProvider verticalMultiplier;
	public final FloatProvider floorLevel;
	
	protected ModCaveCarverConfiguration(ModCarverConfiguration config, FloatProvider yRoomScale, FloatProvider yTunnelScale, int bound, FloatProvider horizontalMultiplier, FloatProvider verticalMultiplier, FloatProvider floorLevel) {
		this(config.probability, config.y, yRoomScale, yTunnelScale, config.fluidLevel, config.fluid, config.aquifersEnabled, config.range, bound, horizontalMultiplier, verticalMultiplier, floorLevel);
	}
	
	public ModCaveCarverConfiguration(float probability, HeightProvider y, FloatProvider yRoomScale, FloatProvider yTunnelScale, VerticalAnchor fluidLevel, FluidState fluid, boolean aquifersEnabled, int range, int bound, FloatProvider horizontalMultiplier, FloatProvider verticalMultiplier, FloatProvider floorLevel) {
		super(probability, y, ConstantFloat.ZERO, fluidLevel, fluid, aquifersEnabled, range);
		this.yRoomScale = yRoomScale;
		this.yTunnelScale = yTunnelScale;
		this.bound = bound;
		this.horizontalMultiplier = horizontalMultiplier;
		this.verticalMultiplier = verticalMultiplier;
		this.floorLevel = floorLevel;
	}

}
