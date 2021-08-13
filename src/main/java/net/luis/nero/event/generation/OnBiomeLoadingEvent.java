package net.luis.nero.event.generation;

import java.util.List;
import java.util.stream.Collectors;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.configured.ConfiguredModWorldCarvers;
import net.luis.nero.common.world.gen.feature.DefaultModFeatures;
import net.luis.nero.common.world.gen.feature.ModOreFeature;
import net.luis.nero.init.world.biome.ModBiomeKeys;
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

@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnBiomeLoadingEvent {
	
	// TODO: disable/enable feature via config
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoadingAdd(BiomeLoadingEvent event) {

		ResourceLocation biome = event.getName();
		BiomeCategory biomeCategory = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		
		if (biome.equals(ModBiomeKeys.DEEPSLATE.location())) {
			
			generationBuilder.addCarver(GenerationStep.Carving.AIR, ConfiguredModWorldCarvers.CAVE);
			
//			DefaultModFeatures.addDeepslateCarvers(generationBuilder);
//			DefaultModFeatures.addDeepslateStructures(generationBuilder);
//			DefaultModFeatures.addDeepslateUndergroundVariety(generationBuilder);
//			DefaultModFeatures.addDeepslateOres(generationBuilder);
		} else if (biomeCategory == BiomeCategory.THEEND) {
			
		} else if (biomeCategory == BiomeCategory.NETHER) {
			
		} else { 
			DefaultModFeatures.addOreOverwrites(generationBuilder);
			DefaultModFeatures.addFlatBedrock(generationBuilder);
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
							List<Block> oreConigBlocks = oreConfig.targetStates.stream().map(targetState -> targetState.state)
									.map(BlockState::getBlock).collect(Collectors.toList());
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
		
	}

}
