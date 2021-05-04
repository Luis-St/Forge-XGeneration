package net.luis.industry;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.industry.init.ModEnchantments;
import net.luis.industry.init.ModEntityTypes;
import net.luis.industry.init.block.ModBlocks;
import net.luis.industry.init.block.item.ModBlockItems;
import net.luis.industry.init.block.util.ModContainerTypes;
import net.luis.industry.init.block.util.ModTileEntityTypes;
import net.luis.industry.init.items.ModItems;
import net.luis.industry.init.recipe.ModRecipeSerializer;
import net.luis.industry.init.villager.ModPointOfInterestTypes;
import net.luis.industry.init.villager.ModVillagerProfessions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Industry.MOD_ID)
public class Industry {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "industry";
	public static final String MINECRAFT_ID = "minecraft";
	
	
	public Industry() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientSetup);
		
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		
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
		
	}

	private void doCommonSetup(FMLCommonSetupEvent event) {
		
	}

	private void doClientSetup(FMLClientSetupEvent event) {
		
	}
	
	public static final ItemGroup INDUSTRY_BLOCKS = new ItemGroup("industry_blocks") {
		
		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(Items.STICKY_PISTON);
			
		}
		
	};
	
	public static final ItemGroup INDUSTRY_DEEPSLATE = new ItemGroup("industry_deepslate") {
		
		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(ModBlockItems.DEEPSLATE.get());
			
		}
		
	};
	
	public static final ItemGroup INDUSTRY_ITEMS = new ItemGroup("industry_items") {
		
		@Override
		public ItemStack makeIcon() {
			
			return new ItemStack(Items.LEVER);
			
		}
		
	};
	
	@SuppressWarnings({ "deprecation", "unused" })
	private void loadComplete(FMLLoadCompleteEvent event) {
		try {
			File itemFile = new File(System.getProperty("user.home") + "\\Desktop\\Items.txt");
			File blockFile = new File(System.getProperty("user.home") + "\\Desktop\\Blocks.txt");
			itemFile.createNewFile();
			blockFile.createNewFile();
			FileWriter itemWriter = new FileWriter(itemFile);
			FileWriter blockWriter = new FileWriter(blockFile);
			
			List<Item> items = Registry.ITEM.stream()
					.filter(item -> item.getRegistryName() != null && item.getRegistryName().getNamespace().equals(Industry.MOD_ID)).collect(Collectors.toList());
			List<Block> blocks = Registry.BLOCK.stream()
					.filter(block -> block.getRegistryName() != null && block.getRegistryName().getNamespace().equals(Industry.MOD_ID)).collect(Collectors.toList());
			
			for (int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				String registryName = item.getRegistryName().toString();
				String namespace = registryName.split(":")[0];
				String name = registryName.split(":")[1]; 
				itemWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
			}
			
			itemWriter.flush();
			itemWriter.close();
			
			for (int i = 0; i < blocks.size(); i++) {
				Block block = blocks.get(i);
				String registryName = block.getRegistryName().toString();
				String namespace = registryName.split(":")[0];
				String name = registryName.split(":")[1]; 
				blockWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
			}
			
			blockWriter.flush();
			blockWriter.close();
			
		} catch (Exception e) {}
	}
	
}