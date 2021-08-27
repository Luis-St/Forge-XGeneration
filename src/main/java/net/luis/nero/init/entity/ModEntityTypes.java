package net.luis.nero.init.entity;

import net.luis.nero.Nero;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.luis.nero.common.entity.ModVillagerEntity;
import net.luis.nero.common.entity.SoulBlazeEntity;
import net.luis.nero.common.entity.SoulFireballEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Nero.MOD_ID);
	
	
	public static final RegistryObject<EntityType<SoulBlazeEntity>> SOUL_BLAZE = ENTITIES.register("soul_blaze", 
			() -> EntityType.Builder.<SoulBlazeEntity>of(SoulBlazeEntity::new, MobCategory.MONSTER).fireImmune().sized(0.6F, 1.8F)
			.clientTrackingRange(8).build("soul_blaze"));
	
	public static final RegistryObject<EntityType<SoulFireballEntity>> SOUL_FIREBALL = ENTITIES.register("soul_fireball", 
			() -> EntityType.Builder.<SoulFireballEntity>of(SoulFireballEntity::new, MobCategory.MISC).sized(0.3125F, 0.3125F)
			.clientTrackingRange(4).updateInterval(10).build("soul_fireball"));
	
	public static final RegistryObject<EntityType<HoveringInfernoEntity>> HOVERING_INFERNO = ENTITIES.register("hovering_inferno", 
			() -> EntityType.Builder.<HoveringInfernoEntity>of(HoveringInfernoEntity::new, MobCategory.MONSTER).sized(0.8F, 1.8F)
			.clientTrackingRange(8).build("hovering_inferno"));
	
	public static final RegistryObject<EntityType<ModVillagerEntity>> VILLAGER = ENTITIES.register("villager", 
			() -> EntityType.Builder.<ModVillagerEntity>of(ModVillagerEntity::new, MobCategory.MISC).sized(0.6F, 1.95F).clientTrackingRange(10)
			.build("villager"));
	
}
