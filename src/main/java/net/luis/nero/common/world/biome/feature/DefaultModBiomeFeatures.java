package net.luis.nero.common.world.biome.feature;

import net.luis.nero.common.world.biome.ModBiomeFeatures;
import net.luis.nero.common.world.levelgen.configured.ConfiguredModFeatures;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

public class DefaultModBiomeFeatures {
	
	public static void addDeepslateUndergroundVariety(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_ORES, () -> ConfiguredModFeatures.OVERWORLD_TUFF_ORE);
	}
	
	public static void addDeepslateMonsterRoom(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.UNDERGROUND_STRUCTURES, () -> ConfiguredModFeatures.OVERWORLD_MONSTER_ROOM);
	}

	public static void addDeepslateCarvers(ModBiomeFeatures modBiomeFeatures) {
		
	}
	
	public static void addAmethystGeode(ModBiomeFeatures modBiomeFeatures) {
		modBiomeFeatures.addModFeature(Decoration.LOCAL_MODIFICATIONS, () -> ConfiguredModFeatures.OVERWORLD_AMETHYST_GEODE);
	}
	
	public static void addOreOverwrites(BiomeGenerationSettingsBuilder generationBuilder) {
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_COAL_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_COPPER_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_COPPER_ORE_BLOBS);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_IRON_ORE);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_IRON_ORE_BLOBS);
		generationBuilder.addFeature(Decoration.UNDERGROUND_ORES.ordinal(), () -> ConfiguredModFeatures.OVERWORLD_GOLD_ORE);
	}
	
}
