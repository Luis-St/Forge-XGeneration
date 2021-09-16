package net.luis.nero;

import java.io.File;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.nero.client.model.ModEntityModelSet;
import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.block.util.ModBlockEntityTypes;
import net.luis.nero.init.block.util.ModMenuTypes;
import net.luis.nero.init.enchantment.ModEnchantments;
import net.luis.nero.init.entity.ModEntityTypes;
import net.luis.nero.init.items.ModItems;
import net.luis.nero.init.potion.ModEffects;
import net.luis.nero.init.potion.ModPotions;
import net.luis.nero.init.recipe.ModRecipeSerializer;
import net.luis.nero.init.villager.ModPoiTypes;
import net.luis.nero.init.villager.ModVillagerProfessions;
import net.luis.nero.init.world.biome.ModBiomes;
import net.luis.nero.init.world.levelgen.carver.ModWorldCarvers;
import net.luis.nero.init.world.levelgen.decorator.ModFeatureDecorators;
import net.luis.nero.init.world.levelgen.feature.ModFeatures;
import net.luis.nero.init.world.levelgen.feature.structure.ModStructures;
import net.luis.nero.init.world.levelgen.surfacebuilder.ModSurfaceBuilders;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

// TODO: after current work finished sort world package
@Mod(Nero.MOD_ID)
public class Nero {
	
	// TODO: custom config system
	// TODO: expands nether gen to 256 and height to 320
	// TODO: drift sand -> spawn desert biome & edit texture
	// TODO: custom strong hold in deepslate -> without portal & god loot
	// TODO: mineshaft structure 
	// TODO: armor overwrite -> new mechanics (separate armor bar and armor protection) (LivingHurtEvent)
	// TODO: debug register time for all entrys and events
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "nero";
	public static final String MINECRAFT_ID = "minecraft";
	private static Nero nero;
	
	private final ModEntityModelSet modModelSet;
	
	public Nero() {
		nero = this;
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.BLOCKS.register(eventBus);
		ModBlockItems.ITEMS.register(eventBus);
		ModMenuTypes.CONTAINERS.register(eventBus);
		ModBlockEntityTypes.BLOCK_ENTITIES.register(eventBus);
		
		ModItems.ITEMS.register(eventBus);
		
		ModRecipeSerializer.RECIPE_SERIALIZERS.register(eventBus);
		
		ModPoiTypes.POI_TYPES.register(eventBus);
		ModVillagerProfessions.PROFESSIONS.register(eventBus);
		
		ModEnchantments.ENCHANTMENTS.register(eventBus);
		
		ModEntityTypes.ENTITIES.register(eventBus);
		
		ModEffects.MOB_EFFECTS.register(eventBus);
		ModPotions.POTIONS.register(eventBus);
		
		ModFeatureDecorators.DECORATORS.register(eventBus);
		ModFeatures.FEATURES.register(eventBus);
		ModSurfaceBuilders.SURFACE_BUILDERS.register(eventBus);
		ModWorldCarvers.WORLD_CARVERS.register(eventBus);
		ModStructures.STRUCTURES.register(eventBus);
		ModBiomes.BIOME_REGISTRY.register(eventBus);
		
//		this.buildConfig();
		
		this.modModelSet = new ModEntityModelSet();
	}
	
	public static Nero getInstance() {
		return nero;
	}
	
	public Path getConfigPath()  {
		return new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(Nero.MOD_ID))).toPath();
	}
	
	protected void buildConfig() {
		this.createConfigPath();
//		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModClientConfig.buildConfig(), this.getConfigPath().resolve("client-config.toml").toString());
//		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModCommonConfig.buildConfig(), this.getConfigPath().resolve("common-config.toml").toString());
//		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModServerConfig.buildConfig(), this.getConfigPath().resolve("server-config.toml").toString());
	}
	
	private void createConfigPath() {
		File configDirectory = new File(this.getConfigPath().toString());
		if (!configDirectory.exists()) {
			configDirectory.mkdirs();
		}
	}
	
	public ModEntityModelSet getModModelSet() {
		return this.modModelSet;
	}
	
}