package net.luis.nero.event.generation;

import java.util.List;
import java.util.stream.Collectors;

import net.luis.nero.Nero;
import net.luis.nero.api.config.Config;
import net.luis.nero.common.world.gen.ConfiguredModStructures;
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

@Config
@EventBusSubscriber(modid = Nero.MOD_ID)
public class OnBiomeLoadingEvent {
	
	// TODO: disable/enable feature via config
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoadingAdd(BiomeLoadingEvent event) {

		ResourceLocation biomeName = event.getName();
		BiomeCategory category = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		
		if (biomeName.equals(ModBiomeKeys.DEEPSLATE.location())) {
			
			DefaultModFeatures.addDeepslateCarvers(generationBuilder);
			DefaultModFeatures.addDeepslateStructures(generationBuilder);
			DefaultModFeatures.addDeepslateUndergroundVariety(generationBuilder);
			DefaultModFeatures.addDeepslateOres(generationBuilder);
			generationBuilder.addStructureStart(ConfiguredModStructures.DEEPSLATE_MINESHAFT);
			
		} else if (category == BiomeCategory.THEEND) {
			
		} else if (category == BiomeCategory.NETHER) {
			
		} else { 
			
			DefaultModFeatures.addOreOverwrites(generationBuilder);
			DefaultModFeatures.addFlatBedrock(generationBuilder);
			
		}
		
	}
	
	@SubscribeEvent
	public static void biomeLoadingRemove(BiomeLoadingEvent event) {
		
		BiomeCategory category = event.getCategory();
		BiomeGenerationSettingsBuilder genBuilder = event.getGeneration();
		
		if (category == BiomeCategory.THEEND) {
			
		} else if (category == BiomeCategory.NETHER) {
			
		} else { 
			for (Decoration stage : GenerationStep.Decoration.values()) {
				genBuilder.getFeatures(stage).removeIf((supplier) -> {
					ConfiguredFeature<?, ?> configuredFeature = supplier.get();
					for (ConfiguredFeature<?, ?> feature : configuredFeature.getFeatures().collect(Collectors.toList())) {
						if (feature.feature instanceof OreFeature && !(feature.feature instanceof ModOreFeature)) {
							OreConfiguration oreConfig = (OreConfiguration) feature.config;
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
