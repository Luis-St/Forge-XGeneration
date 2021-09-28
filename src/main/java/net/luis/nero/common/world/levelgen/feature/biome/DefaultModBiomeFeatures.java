package net.luis.nero.common.world.levelgen.feature.biome;

import net.luis.nero.api.common.world.biome.util.ModBiomeFeatures;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

public class DefaultModBiomeFeatures {
	
	public static void addDeepslateOres(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_COAL_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_COPPER_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_IRON_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_GOLD_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_LAPIS_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_REDSTONE_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_EXTRA_REDSTONE_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_DIAMOND_ORE);
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.DEEPSLATE_EMERALD_ORE);
	}
	
	public static void addDeepslateUndergroundVariety(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.TUFF_ORE);
	}
	
	public static void addDeepslateMonsterRoom(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_STRUCTURES, () -> ConfiguredModFeatures.DEEPSLATE_MONSTER_ROOM);
	}

	public static void addDeepslateCarvers(ModBiomeFeatures modBiomeFeatures) {
		
	}
	
	public static void addAmethystGeode(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.LOCAL_MODIFICATIONS, () -> ConfiguredModFeatures.DEEPSLATE_AMETHYST_GEODE);
	}
	
	public static void addFlatBedrock(BiomeGenerationSettingsBuilder generationBuilder) {
		generationBuilder.addFeature(Decoration.RAW_GENERATION.ordinal(), () -> ConfiguredModFeatures.FLAT_BEDROCK);
	}
	
	public static void addOreOverwrites(BiomeGenerationSettingsBuilder generationBuilder) {
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.COAL_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.COPPER_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.COPPER_ORE_BLOBS);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.IRON_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.IRON_ORE_BLOBS);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.GOLD_ORE);
	}
	
}
