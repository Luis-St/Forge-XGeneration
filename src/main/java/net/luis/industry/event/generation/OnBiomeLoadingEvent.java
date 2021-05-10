package net.luis.industry.event.generation;

import static net.luis.industry.Industry.MOD_ID;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.FORGE;

import net.luis.industry.common.world.feature.ModDefaultFeatures;
import net.luis.industry.init.world.ModBiomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.Category;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = MOD_ID, bus = FORGE)
public class OnBiomeLoadingEvent {
	
	// execute at Dev run fill ~-15 ~-15 ~-15 ~15 ~15 ~15 air replace industry:deepslate
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void biomeLoading(BiomeLoadingEvent event) {
		
		ResourceLocation biomeName = event.getName();
		Category category = event.getCategory();
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		
		if (biomeName.equals(ModBiomes.DEEPSLATE_CAVE.location())) {
			
			// TODO : EventPriority HIGHT
			ModDefaultFeatures.addDeepslateCarvers(generationBuilder); // TODO : modify
			ModDefaultFeatures.addDeepslateStructures(generationBuilder);
			ModDefaultFeatures.addDeepslateUndergroundVariety(generationBuilder);
			ModDefaultFeatures.addDeepslateOres(generationBuilder);
			// TODO : modify lava lake generation & waterlake generation
			// TODO : add ores & modify features
			// TODO : overwrite vailla features
			
		} else if (category == Category.THEEND) {
			
		} else if (category == Category.NETHER) {
			
		} else {
			
//			generationBuilder.getFeatures(Decoration.UNDERGROUND_ORES).removeIf((supplier) -> {
//				ConfiguredFeature<?, ?> feature = supplier.get();
//				if (feature.config instanceof OreFeatureConfig) {
//					OreFeatureConfig oreConfig = (OreFeatureConfig) feature.config;
//					if (oreConfig.state.getBlock() == Blocks.COAL_ORE) {
//						return true;
//					} else if (oreConfig.state.getBlock() == Blocks.IRON_ORE) {
//						return true;
//					} else if (oreConfig.state.getBlock() == Blocks.GOLD_ORE) {
//						return true;
//					} else if (oreConfig.state.getBlock() == Blocks.LAPIS_ORE) {
//						return true;
//					} else if (oreConfig.state.getBlock() == Blocks.REDSTONE_ORE) {
//						return true;
//					} else if (oreConfig.state.getBlock() == Blocks.DIAMOND_ORE) {
//						return true;
//					}
//				}
//				return false;
//			}); 
			
		}
		
	}

}
