package net.luis.industry.data;

import static net.luis.industry.Industry.MOD_ID;
import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = MOD_ID, bus = MOD)
public class ModDataGenerator {
	
	@SubscribeEvent
	public static void dataEvent(GatherDataEvent event) {
		
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
		}
		if (event.includeServer()) {
			ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, fileHelper);
			generator.addProvider(blockTagsProvider);
			generator.addProvider(new ModItemTagsProvider(generator, blockTagsProvider, fileHelper));
			generator.addProvider(new LootTableProvider(generator));
			generator.addProvider(new ModRecipeProvider(generator));
		}
		
	}

}
