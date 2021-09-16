package net.luis.nero.common.world.biome.features;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.luis.nero.common.world.levelgen.configured.ConfiguredModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DefaultModBiomeFeatures {
	
	public static void addDeepslateOres(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_COAL_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_COPPER_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_IRON_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_GOLD_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_LAPIS_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_REDSTONE_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_EXTRA_REDSTONE_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_DIAMOND_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.DEEPSLATE_EMERALD_ORE);
	}
	
	public static void addDeepslateUndergroundVariety(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	public static void addDeepslateMonsterRoom(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.UNDERGROUND_STRUCTURES).add(() -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM);
	}

	public static void addDeepslateCarvers(Map<Carving, List<Supplier<ConfiguredWorldCarver<?>>>> modCarvers) {
		
	}
	
	public static void addAmethystGeode(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.LOCAL_MODIFICATIONS).add(() -> ConfiguredModFeatures.DEEPSLATE_AMETHYST_GEODE);
	}
	public static void addFlatBedrock(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.RAW_GENERATION).add(() -> ConfiguredModFeatures.FLAT_BEDROCK);
	}
	
	public static void addOreOverwrites(Map<Decoration, List<Supplier<ConfiguredFeature<?, ?>>>> modFeatures) {
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.COAL_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.COPPER_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.COPPER_ORE_BLOBS);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.IRON_ORE);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.IRON_ORE_BLOBS);
		modFeatures.get(Decoration.UNDERGROUND_ORES).add(() -> ConfiguredModFeatures.GOLD_ORE);
	}
	
}
