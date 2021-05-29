package net.luis.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.nero.api.capability.CapabilityFactory;
import net.luis.nero.api.capability.CapabilityStorage;
import net.luis.nero.api.capability.interfaces.IBloodOrbCapability;
import net.luis.nero.common.world.dimension.biome.DeepslateBiomeProvider;
import net.luis.nero.common.world.dimension.chunk.DeepslateChunkGenerator;
import net.luis.nero.core.NetworkHandler;
import net.luis.nero.init.ModEnchantments;
import net.luis.nero.init.ModEntityTypes;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.block.util.ModContainerTypes;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.luis.nero.init.items.ModItems;
import net.luis.nero.init.recipe.ModRecipeSerializer;
import net.luis.nero.init.villager.ModPointOfInterestTypes;
import net.luis.nero.init.villager.ModVillagerProfessions;
import net.luis.nero.init.world.ModFeatures;
import net.luis.nero.init.world.ModSurfaceBuilders;
import net.luis.nero.init.world.ModWorldCarvers;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// TODO: "nero" -> "nero"

@Mod(Nero.MOD_ID)
public class Nero {
	
	// TODO: proxy -> client and server registry -> move events in event package & itemgrops/ Client commen setup event
	// TODO: change itemgrooups
	// TODO: config common
	// TODO: mineshaft strukture (separate armor bar and armor protection)
	// TODO: armor overwrite -> new mechanics
	// TODO: test order of damage events (LivingDamageEvent, LivingHurtEvent, LivingAttackEvent) -> prefer the last ones
	// TODO: use RenderGameOverlayEvent$Text to change the y pos in the deepslate dimension
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "nero";
	public static final String MINECRAFT_ID = "minecraft";
	
	
	public Nero() {

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientSetup);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
		
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
		
		ModFeatures.FEATURES.register(eventBus);
		ModSurfaceBuilders.SURFACE_BUILDERS.register(eventBus);
		ModWorldCarvers.WORLD_CARVERS.register(eventBus);
		ModBiomes.BIOMES.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}

	private void doCommonSetup(FMLCommonSetupEvent event) {
		NetworkHandler.init();
		this.registerCapability(IBloodOrbCapability.class);
		event.enqueueWork(() -> {
			Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Nero.MOD_ID, "deepslate_chunk_generator"), DeepslateChunkGenerator.CODEC);
			Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Nero.MOD_ID, "biomes"), DeepslateBiomeProvider.CODEC);
		});
		this.createBiomes();
	}
	
	private <T> void registerCapability(Class<T> clazz) {
		CapabilityManager.INSTANCE.register(clazz, new CapabilityStorage<T>(), new CapabilityFactory<T>());
	}

	private void doClientSetup(FMLClientSetupEvent event) {
		
	}
	
	private void createBiomes() {
		BiomeDictionary.addTypes(ModBiomeKeys.DEEPSLATE, Type.MODIFIED);
	}
	
	public static final ItemGroup BUILDING_BLOCKS = new ItemGroup("nero_building_blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModBlockItems.DEEPSLATE.get());
		}
	};
	
	public static final ItemGroup DECORATIONS = new ItemGroup("nero_decorations") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.PEONY);
		}
	};
	
	public static final ItemGroup REDSTONE = new ItemGroup("nero_redstone") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.REDSTONE);
		}
	};
	
	public static final ItemGroup TRANSPORTATION = new ItemGroup("nero_transportation") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.POWERED_RAIL);
		}
	};
	
	public static final ItemGroup MISC = new ItemGroup("nero_miscellaneous") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.LAVA_BUCKET);
		}
	};
	
	public static final ItemGroup FOOD = new ItemGroup("nero_food") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.APPLE);
		}
	};
	
	public static final ItemGroup TOOLS = new ItemGroup("nero_tools") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.IRON_AXE);
		}
	};
	
	public static final ItemGroup COMBAT = new ItemGroup("nero_combat") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.GOLDEN_SWORD);
		}
	};
	
	public static final ItemGroup BREWING = new ItemGroup("nero_brewing") {
		@Override
		public ItemStack makeIcon() {
			return Items.POTION.getDefaultInstance();
		}
	};
	
	public static final ItemGroup BLOOD_MACIC = new ItemGroup("nero_blood_magic") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.APPRENTICE_BLOOD_ORB.get());
		}
	};
	
	private void loadComplete(FMLLoadCompleteEvent event) {
//		List<Biome> biomes = ForgeRegistries.BIOMES.getValues().stream().collect(Collectors.toList());
//		for (Biome biome : biomes) {
//			Nero.LOGGER.debug("Biome: " + biome.getRegistryName());
//			Nero.LOGGER.debug("Biome Key: " + ForgeRegistries.BIOMES.getKey(biome));
//		}
//		try {
//			File itemFile = new File(System.getProperty("user.home") + "\\Desktop\\Items.txt");
//			File blockFile = new File(System.getProperty("user.home") + "\\Desktop\\Blocks.txt");
//			itemFile.createNewFile();
//			blockFile.createNewFile();
//			FileWriter itemWriter = new FileWriter(itemFile);
//			FileWriter blockWriter = new FileWriter(blockFile);
//			
//			List<Item> items = Registry.ITEM.stream()
//					.filter(item -> item.getRegistryName() != null && item.getRegistryName().getNamespace().equals(Nero.MOD_ID)).collect(Collectors.toList());
//			List<Block> blocks = Registry.BLOCK.stream()
//					.filter(block -> block.getRegistryName() != null && block.getRegistryName().getNamespace().equals(Nero.MOD_ID)).collect(Collectors.toList());
//			
//			for (int i = 0; i < items.size(); i++) {
//				Item item = items.get(i);
//				String registryName = item.getRegistryName().toString();
//				String namespace = registryName.split(":")[0];
//				String name = registryName.split(":")[1]; 
//				itemWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
//			}
//			
//			itemWriter.flush();
//			itemWriter.close();
//			
//			for (int i = 0; i < blocks.size(); i++) {
//				Block block = blocks.get(i);
//				String registryName = block.getRegistryName().toString();
//				String namespace = registryName.split(":")[0];
//				String name = registryName.split(":")[1]; 
//				blockWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
//			}
//			
//			blockWriter.flush();
//			blockWriter.close();
//			
//		} catch (Exception e) {}
	}
	
}