package net.luis.industry.common.world.feature;

import net.luis.industry.Industry;
import net.luis.industry.init.block.ModBlocks;
import net.luis.industry.init.world.ModFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class ModFeatures {
	
	private static final RuleTest DEEPSLATE = new BlockMatchRuleTest(ModBlocks.DEEPSLATE.get());
	private static final RuleTest STONE = new BlockMatchRuleTest(Blocks.STONE);
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_COAL_ORE = ModFeatures.register("deepslate_coal_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_COAL_ORE, 12))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(255, 64))).squared().count(18));
	
	public static final ConfiguredFeature<?, ?> COAL_ORE = ModFeatures.register("coal_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.STONE, States.COAL_ORE, 17))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 128))).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_COPPER_ORE = ModFeatures.register("deepslate_copper_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_COPPER_ORE, 8))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(255, 32))).squared().count(16));
	
	public static final ConfiguredFeature<?, ?> COPPER_ORE = ModFeatures.register("copper_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.STONE, States.COPPER_ORE, 8))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 96))).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_IRON_ORE = ModFeatures.register("deepslate_iron_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_IRON_ORE, 10))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(128, 176))).squared().count(26));
	
	public static final ConfiguredFeature<?, ?> IRON_ORE = ModFeatures.register("iron_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.STONE, States.IRON_ORE, 9))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 64))).squared().count(20));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_GOLD_ORE = ModFeatures.register("deepslate_gold_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_GOLD_ORE, 7))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(176, 128))).squared().count(8));
	
	public static final ConfiguredFeature<?, ?> GOLD_ORE = ModFeatures.register("gold_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.STONE, States.GOLD_ORE, 7))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 48))).squared().count(2));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_LAPIS_ORE = ModFeatures.register("deepslate_lapis_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_LAPIS_ORE, 7))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(128, 64))).squared().count(6));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_REDSTONE_ORE = ModFeatures.register("deepslate_redstone_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_REDSTONE_ORE, 8))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 96))).squared().count(12));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_EXTRA_REDSTONE_ORE = ModFeatures.register("deepslate_extra_redstone_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_REDSTONE_ORE, 10))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 32))).squared().count(2));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_DIAMOND_ORE = ModFeatures.register("deepslate_diamond_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_DIAMOND_ORE, 8))
			.decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(0, 32))).squared().count(8));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_EMERALD_ORE = ModFeatures.register("deepslate_emerald_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.DEEPSLATE_EMERALD_ORE, 4))
			.decorated(Placement.RANGE.configured(new TopSolidRangeConfig(0, 0, 192))).squared());
	
	public static final ConfiguredFeature<?, ?> TUFF_ORE = ModFeatures.register("tuff_ore", 
			Feature.ORE.configured(new OreFeatureConfig(ModFeatures.DEEPSLATE, States.TUFF_ORE, 33))
			.range(256).squared().count(10));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_LAVE_LAKE = ModFeatures.register("deepslate_lava_lake", 
			ModFeature.LAKE.get().configured(new BlockStateFeatureConfig(States.LAVA))
			.decorated(Placement.WATER_LAKE.configured(new ChanceConfig(40))));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_WATER_LAKE = ModFeatures.register("deepslate_water_lake", 
			Feature.LAKE.configured(new BlockStateFeatureConfig(States.WATER))
			.decorated(Placement.WATER_LAKE.configured(new ChanceConfig(40))));
	
	public static final ConfiguredFeature<?, ?> DEEPSLATE_MONSTER_ROOM = ModFeatures.register("deepslate_monster_room", 
			ModFeature.MONSTER_ROOM.get().configured(IFeatureConfig.NONE).range(256).squared().count(8));
	
	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Industry.MOD_ID, name), configuredFeature);
	}
	
	public static class States {
		public static final BlockState DEEPSLATE_COAL_ORE = ModBlocks.DEEPSLATE_COAL_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_COPPER_ORE = ModBlocks.DEEPSLATE_COPPER_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_IRON_ORE = ModBlocks.DEEPSLATE_IRON_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_GOLD_ORE = ModBlocks.DEEPSLATE_GOLD_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_LAPIS_ORE = ModBlocks.DEEPSLATE_LAPIS_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_REDSTONE_ORE = ModBlocks.DEEPSLATE_REDSTONE_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_DIAMOND_ORE = ModBlocks.DEEPSLATE_DIAMOND_ORE.get().defaultBlockState();
		public static final BlockState DEEPSLATE_EMERALD_ORE = ModBlocks.DEEPSLATE_EMERALD_ORE.get().defaultBlockState();
		public static final BlockState TUFF_ORE = ModBlocks.TUFF.get().defaultBlockState();
		public static final BlockState COAL_ORE = Blocks.COAL_ORE.defaultBlockState();
		public static final BlockState COPPER_ORE = ModBlocks.COPPER_ORE.get().defaultBlockState();
		public static final BlockState IRON_ORE = Blocks.IRON_ORE.defaultBlockState();
		public static final BlockState GOLD_ORE = Blocks.GOLD_ORE.defaultBlockState();
		public static final BlockState LAVA = Blocks.LAVA.defaultBlockState();
		public static final BlockState WATER = Blocks.WATER.defaultBlockState();
	}

}
