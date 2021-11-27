package net.luis.nero.event.generation;

import java.util.List;
import java.util.stream.Collectors;

import net.luis.nero.Nero;
import net.luis.nero.common.world.biome.IBiome;
import net.luis.nero.common.world.biome.feature.DefaultModBiomeFeatures;
import net.luis.nero.common.world.levelgen.feature.ModOreFeature;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnBiomeLoadingEvent {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoadingAdd(BiomeLoadingEvent event) {
		ResourceLocation biomeLocation = event.getName();
		IBiome biome = ModBiomes.BIOME_IDS.get(biomeLocation);
		BiomeCategory biomeCategory = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		if (biome != null) {
			biome.getModFeatures().addAllFeatures(generationBuilder);
		}
		if (biomeCategory == BiomeCategory.THEEND) {
			
		} else if (biomeCategory == BiomeCategory.NETHER) {
			
		} else if (!biomeLocation.getNamespace().equals("nero")) {
			DefaultModBiomeFeatures.addOreOverwrites(generationBuilder);
		}
	}
	
	@SubscribeEvent
	public static void biomeLoadingRemove(BiomeLoadingEvent event) {
		BiomeCategory biomeCategory = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		if (biomeCategory == BiomeCategory.THEEND) {
			
		} else if (biomeCategory == BiomeCategory.NETHER) {
			
		} else {
			for (Decoration stage : GenerationStep.Decoration.values()) {
				generationBuilder.getFeatures(stage).removeIf((supplier) -> {
					for (ConfiguredFeature<?, ?> configuredFeature : supplier.get().getFeatures().collect(Collectors.toList())) {
						if (configuredFeature.feature instanceof OreFeature && !(configuredFeature.feature instanceof ModOreFeature)) {
							OreConfiguration oreConfig = (OreConfiguration) configuredFeature.config;
							List<Block> oreConigBlocks = oreConfig.targetStates.stream().map(targetState -> targetState.state).map(BlockState::getBlock).collect(Collectors.toList());
							if (oreConigBlocks.contains(Blocks.COAL_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.IRON_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.GOLD_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.LAPIS_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.REDSTONE_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.DIAMOND_ORE)) {
								return true;
							} else if (oreConigBlocks.contains(Blocks.EMERALD_ORE)) {
								return true;
							}
						}
					}
					return false;
				});
			}
		}	
//		removeAllSettings(generationBuilder);
//		generationBuilder.addFeature(Decoration.VEGETAL_DECORATION.ordinal(), () -> ConfiguredModFeatures.MEADOW_FLOWERS);
	}
	
	protected static void removeAllSettings(BiomeGenerationSettingsBuilder generationBuilder) {
		for (GenerationStep.Decoration decoration : GenerationStep.Decoration.values()) {
			generationBuilder.getFeatures(decoration).removeIf(t -> true);
		}
		for (GenerationStep.Carving carving : GenerationStep.Carving.values()) {
			generationBuilder.getCarvers(carving).removeIf(t -> true);
		}
		generationBuilder.getStructures().removeIf(t -> true);
	}

}
