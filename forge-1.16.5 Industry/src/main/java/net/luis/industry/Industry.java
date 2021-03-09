package net.luis.industry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.industry.init.ModEnchantments;
import net.luis.industry.init.ModEntityTypes;
import net.luis.industry.init.blocks.ModBlocks;
import net.luis.industry.init.blocks.items.ModBlockItems;
import net.luis.industry.init.blocks.util.ModContainerTypes;
import net.luis.industry.init.blocks.util.ModTileEntityTypes;
import net.luis.industry.init.items.ModItems;
import net.luis.industry.init.recipe.ModRecipeSerializer;
import net.luis.industry.init.util.tags.ModBlockTags;
import net.luis.industry.init.villager.ModPointOfInterestTypes;
import net.luis.industry.init.villager.ModVillagerProfessions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Industry.MOD_ID)
public class Industry {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private static final String MOD_NAME = "Industry";
	public static final String MOD_ID = "industry";
	public static final String MINECRAFT_ID = "minecraft";
	
	
	public Industry() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientSetup);
		
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlockItems.ITEMS.register(eventBus);
		ModContainerTypes.CONTAINERS.register(eventBus);
		ModTileEntityTypes.TILE_ENTITIES.register(eventBus);
		ModBlocks.BLOCKS.register(eventBus);
		
		ModItems.ITEMS.register(eventBus);
		
		ModRecipeSerializer.RECIPE_SERIALIZERS.register(eventBus);
		
		ModPointOfInterestTypes.POI_TYPES.register(eventBus);
		ModVillagerProfessions.PROFESSIONS.register(eventBus);
		
		ModEnchantments.ENCHANTMENTS.register(eventBus);
		
		ModEntityTypes.ENTITIES.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		LOGGER.debug("gjsdjshdgjshdjshdsj" + ModBlockTags.FLUID_SYSTEM.getPath());
		
	}

	private void doCommonSetup(FMLCommonSetupEvent event) {
		
	}

	private void doClientSetup(FMLClientSetupEvent event) {
		
	}
	
	public static final ItemGroup INDUSTRY = new ItemGroup(MOD_NAME) {
		
		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.STICKY_PISTON);
			
		}
		
	};
	
}