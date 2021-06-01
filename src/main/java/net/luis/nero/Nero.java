package net.luis.nero;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.nero.init.block.ModBlocks;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.block.util.ModContainerTypes;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.luis.nero.init.enchantment.ModEnchantments;
import net.luis.nero.init.entity.ModEntityTypes;
import net.luis.nero.init.items.ModItems;
import net.luis.nero.init.potion.ModEffects;
import net.luis.nero.init.potion.ModPotions;
import net.luis.nero.init.recipe.ModRecipeSerializer;
import net.luis.nero.init.villager.ModPointOfInterestTypes;
import net.luis.nero.init.villager.ModVillagerProfessions;
import net.luis.nero.init.world.ModFeatures;
import net.luis.nero.init.world.ModSurfaceBuilders;
import net.luis.nero.init.world.ModWorldCarvers;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Nero.MOD_ID)
public class Nero {
	
	// TODO: config common
	// TODO: mineshaft strukture (separate armor bar and armor protection)
	// TODO: armor overwrite -> new mechanics
	// TODO: test order of damage events (LivingDamageEvent, LivingHurtEvent, LivingAttackEvent) -> prefer the last ones
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "nero";
	public static final String MINECRAFT_ID = "minecraft";
	private static Nero nero;
	
	public Nero() {
		
		nero = this;
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
		
		ModEffects.EFFECTS.register(eventBus);
		ModPotions.POTIONS.register(eventBus);
		
		ModFeatures.FEATURES.register(eventBus);
		ModSurfaceBuilders.SURFACE_BUILDERS.register(eventBus);
		ModWorldCarvers.WORLD_CARVERS.register(eventBus);
		ModBiomes.BIOMES.register(eventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	public static Nero getInstance() {
		return nero;
	}
	
}