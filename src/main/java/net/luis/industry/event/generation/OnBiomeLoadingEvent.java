package net.luis.industry.event.generation;

import java.util.stream.Collectors;

import net.luis.industry.common.world.feature.DefaultModFeatures;
import net.luis.industry.common.world.feature.ModOreFeature;
import net.luis.industry.init.world.biome.ModBiomeKeys;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnBiomeLoadingEvent {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoadingAdd(BiomeLoadingEvent event) {
		
		ResourceLocation biomeName = event.getName();
		Category category = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		
		if (biomeName.equals(ModBiomeKeys.DEEPSLATE.location())) {
			
			DefaultModFeatures.addDeepslateCarvers(generationBuilder);
			DefaultModFeatures.addDeepslateStructures(generationBuilder);
			DefaultModFeatures.addDeepslateUndergroundVariety(generationBuilder);
			DefaultModFeatures.addDeepslateOres(generationBuilder);
			
		} else if (category == Category.THEEND) {
			
		} else if (category == Category.THEEND) {
			
		} else if (category == Category.NETHER) {
			
		} else { 
			
			DefaultModFeatures.addOreOverwrites(generationBuilder);
			DefaultModFeatures.addFlatBedrock(generationBuilder);
			
		}
		
	}
	
	@SubscribeEvent
	public static void biomeLoadingRemove(BiomeLoadingEvent event) {
		
		Category category = event.getCategory();
		BiomeGenerationSettingsBuilder genBuilder = event.getGeneration();
		
		if (category == Category.THEEND) {
			
		} else if (category == Category.NETHER) {
			
		} else { 
			for (Decoration stage : GenerationStage.Decoration.values()) {
				genBuilder.getFeatures(stage).removeIf((supplier) -> {
					ConfiguredFeature<?, ?> configuredFeature = supplier.get();
					for (ConfiguredFeature<?, ?> feature : configuredFeature.getFeatures().collect(Collectors.toList())) {
						if (feature.feature instanceof OreFeature && !(feature.feature instanceof ModOreFeature)) {
							OreFeatureConfig oreConfig = (OreFeatureConfig) feature.config;
							if (oreConfig.state.getBlock() == Blocks.COAL_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.IRON_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.GOLD_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.LAPIS_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.REDSTONE_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.DIAMOND_ORE) {
								return true;
							} else if (oreConfig.state.getBlock() == Blocks.EMERALD_ORE) {
								return true;
							}
						}
					}
					return false;
				});
			}
		}
		
	}

}
