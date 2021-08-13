package net.luis.nero.common.world.gen.configured;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.decorator.config.DepthAverageDecoratorConfiguration;
import net.luis.nero.init.world.gen.decorator.ModFeatureDecorators;
import net.luis.nero.init.world.gen.feature.ModFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class ConfiguredModFeatures {
	
	// TODO: test rangeTriangle then remove DEPTH_AVERAGE
	
	// TODO: allow some modifications via config
	// TODO: add airExposure -> float in OreConfiguration 0.0 = 0% airExposure, 1.0 = 100% airExposure
	
	private static final RuleTest DEEPSLATE = OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES;
	private static final RuleTest STONE = OreConfiguration.Predicates.NATURAL_STONE;
	
	public static final ConfiguredFeature<?, ?> COAL_ORE = register("coal_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.COAL_ORE, 17))
			.range(triangle(0, 128, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 128)))
			.squared().count(20));
	
	public static final ConfiguredFeature<?, ?> COPPER_ORE = register("copper_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.COPPER_ORE, 10))
			.range(triangle(0, 96, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 96)))
			.squared().count(20));
	
	public static final ConfiguredFeature<?, ?> COPPER_ORE_BLOBS = register("copper_ore_blobs",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.COPPER_ORE, 6))
			.rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(96)).squared().count(10));
	
	public static final ConfiguredFeature<?, ?> IRON_ORE = register("iron_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.IRON_ORE, 9))
			.range(triangle(0, 64, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 64)))
			.squared().count(20));
	
	public static final ConfiguredFeature<?, ?> IRON_ORE_BLOBS = register("iron_ore_blobs",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.IRON_ORE, 5))
			.rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)).squared().count(5));
	
	public static final ConfiguredFeature<?, ?> GOLD_ORE = register("gold_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.GOLD_ORE, 7))
			.range(triangle(0, 48, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 48)))
			.squared().count(4));
	
	public static final ConfiguredFeature<?, ?> EMERALD_ORE = register("emerald_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, BlockStates.EMERALD_ORE, 8))
			.rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_COAL_ORE = register("deepslate_coal_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_COAL_ORE, 15))
			.range(triangle(384, 512, 512))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(512, 128)))
			.squared().count(20));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_COPPER_ORE = register("deepslate_copper_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_COPPER_ORE, 10))
			.range(triangle(448, 512, 512))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(512, 64)))
			.squared().count(16));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_IRON_ORE = register("deepslate_iron_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_IRON_ORE, 12))
			.range(triangle(0, 512, 256))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(256, 256)))
			.squared().count(30));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_GOLD_ORE = register("deepslate_gold_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_GOLD_ORE, 8))
			.range(triangle(64, 512, 288))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(288, 224)))
			.squared().count(14));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_LAPIS_ORE = register("deepslate_lapis_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_LAPIS_ORE, 7))
			.range(triangle(128, 384, 256))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(256, 128)))
			.squared().count(10));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_REDSTONE_ORE = register("deepslate_redstone_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_REDSTONE_ORE, 9))
			.rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192))
			.squared().count(14));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_EXTRA_REDSTONE_ORE = register("deepslate_extra_redstone_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_REDSTONE_ORE, 10))
			.range(triangle(0, 64, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 64)))
			.squared().count(4));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_DIAMOND_ORE = register("deepslate_diamond_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_DIAMOND_ORE, 8))
			.range(triangle(0, 64, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 64)))
			.squared().count(10));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_EMERALD_ORE = register("deepslate_emerald_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.DEEPSLATE_EMERALD_ORE, 4))
			.range(triangle(0, 512, 0))
			.decorated(ModFeatureDecorators.DEPTH_AVERAGE.get().configured(new DepthAverageDecoratorConfiguration(0, 512)))
			.squared());

	public static final ConfiguredFeature<?, ?> TUFF_ORE = register("tuff_ore", 
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, BlockStates.TUFF_ORE, 35))
			.rangeUniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(512)).squared().count(16));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_MONSTER_ROOM = register("deepslate_monster_room",
			ModFeatures.MONSTER_ROOM.get().configured(FeatureConfiguration.NONE)
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(12), VerticalAnchor.absolute(500))))
			.squared().count(15));
	
	public static final ConfiguredFeature<?, ?> FLAT_BEDROCK = register("flat_bedrock", 
			ModFeatures.FLAT_BEDROCK.get().configured(FeatureConfiguration.NONE).count(1).squared()
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(5)))));

	protected static RangeDecoratorConfiguration triangle(int min, int max, int plateau) {
		return new RangeDecoratorConfiguration(TrapezoidHeight.of(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max), plateau));
	}
	
	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Nero.MOD_ID, name), configuredFeature);
	}

	public static class BlockStates {
		public static final BlockState DEEPSLATE_COAL_ORE = Blocks.DEEPSLATE_COAL_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_COPPER_ORE = Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_IRON_ORE = Blocks.DEEPSLATE_IRON_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_GOLD_ORE = Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_LAPIS_ORE = Blocks.DEEPSLATE_LAPIS_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_REDSTONE_ORE = Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_DIAMOND_ORE = Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState();
		public static final BlockState DEEPSLATE_EMERALD_ORE = Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState();
		public static final BlockState TUFF_ORE = Blocks.TUFF.defaultBlockState();
		public static final BlockState COAL_ORE = Blocks.COAL_ORE.defaultBlockState();
		public static final BlockState COPPER_ORE = Blocks.COPPER_ORE.defaultBlockState();
		public static final BlockState IRON_ORE = Blocks.IRON_ORE.defaultBlockState();
		public static final BlockState GOLD_ORE = Blocks.GOLD_ORE.defaultBlockState();
		public static final BlockState EMERALD_ORE = Blocks.EMERALD_ORE.defaultBlockState();
		public static final BlockState LAVA = Blocks.LAVA.defaultBlockState();
		public static final BlockState WATER = Blocks.WATER.defaultBlockState();
	}
	
	public static class FluidStates {
		public static final FluidState LAVA = Fluids.LAVA.defaultFluidState();
		public static final FluidState WATER = Fluids.WATER.defaultFluidState();
	}

}
