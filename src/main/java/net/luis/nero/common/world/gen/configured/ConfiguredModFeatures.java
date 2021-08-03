package net.luis.nero.common.world.gen.configured;

import net.luis.nero.Nero;
import net.luis.nero.init.world.gen.feature.ModFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ConfiguredModFeatures {
	
	// TODO: allow some modifications via config
	// TODO: add airExposure -> float in OreConfiguration 0.0 = 0% airExposure, 1.0 = 100% airExposure
	
	private static final RuleTest DEEPSLATE = OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES;
	private static final RuleTest STONE = new BlockMatchTest(Blocks.STONE);

	public static final ConfiguredFeature<?, ?> DEEPSLATE_COAL_ORE = register("deepslate_coal_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_COAL_ORE, 12))
			.rangeTriangle(VerticalAnchor.absolute(190), VerticalAnchor.top()).squared().count(18));

	public static final ConfiguredFeature<?, ?> COAL_ORE = register("coal_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.COAL_ORE, 17))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(128)).squared().count(20));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_COPPER_ORE = register("deepslate_copper_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_COPPER_ORE, 8))
			.rangeTriangle(VerticalAnchor.absolute(222), VerticalAnchor.top()).squared().count(16));

	public static final ConfiguredFeature<?, ?> COPPER_ORE = register("copper_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.COPPER_ORE, 10))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(96)).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> COPPER_ORE_BLOBS = register("copper_ore_blobs",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.COPPER_ORE, 6))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(96))))
			.squared().count(10));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_IRON_ORE = register("deepslate_iron_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_IRON_ORE, 10))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.top()).squared().count(26));

	public static final ConfiguredFeature<?, ?> IRON_ORE = register("iron_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.IRON_ORE, 9))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> IRON_ORE_BLOBS = register("iron_ore_blobs",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.IRON_ORE, 5))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))))
			.squared().count(5));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_GOLD_ORE = register("deepslate_gold_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_GOLD_ORE, 7))
			.rangeTriangle(VerticalAnchor.absolute(48), VerticalAnchor.top()).squared().count(8));

	public static final ConfiguredFeature<?, ?> GOLD_ORE = register("gold_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.GOLD_ORE, 7))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(48)).squared().count(4));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_LAPIS_ORE = register("deepslate_lapis_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_LAPIS_ORE, 7))
			.rangeTriangle(VerticalAnchor.absolute(64), VerticalAnchor.absolute(192)).squared().count(6));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_REDSTONE_ORE = register("deepslate_redstone_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_REDSTONE_ORE, 8))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(96)).squared().count(12));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_EXTRA_REDSTONE_ORE = register("deepslate_extra_redstone_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_REDSTONE_ORE, 10))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(32)).squared().count(2));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_DIAMOND_ORE = register("deepslate_diamond_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_DIAMOND_ORE, 8))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(32)).squared().count(8));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_EMERALD_ORE = register("deepslate_emerald_ore",
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.DEEPSLATE_EMERALD_ORE, 4))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(192))))
			.squared());
	
	public static final ConfiguredFeature<?, ?> EMERALD_ORE = register("emerald_ore_overwrite",
			ModFeatures.ORE.get().configured(new OreConfiguration(STONE, States.EMERALD_ORE, 8))
			.rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(96)).squared().count(20));

	public static final ConfiguredFeature<?, ?> TUFF_ORE = register("tuff_ore", 
			ModFeatures.ORE.get().configured(new OreConfiguration(DEEPSLATE, States.TUFF_ORE, 33))
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top())))
			.squared().count(10));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_LAVE_LAKE = register("deepslate_lava_lake",
			ModFeatures.LAKE.get().configured(new BlockStateConfiguration(States.LAVA)).rarity(40));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_WATER_LAKE = register("deepslate_water_lake",
			Feature.LAKE.configured(new BlockStateConfiguration(States.WATER)).rarity(40));

	public static final ConfiguredFeature<?, ?> DEEPSLATE_MONSTER_ROOM = register("deepslate_monster_room",
			ModFeatures.MONSTER_ROOM.get().configured(FeatureConfiguration.NONE)
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()))).squared().count(8));
	
	public static final ConfiguredFeature<?, ?> FLAT_BEDROCK = register("flat_bedrock", 
			ModFeatures.FLAT_BEDROCK.get().configured(FeatureConfiguration.NONE).count(1).squared()
			.range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(5)))));

	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Nero.MOD_ID, name), configuredFeature);
	}

	public static class States {
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

}
