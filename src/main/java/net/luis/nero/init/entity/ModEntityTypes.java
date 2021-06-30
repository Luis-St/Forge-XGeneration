package net.luis.nero.init.entity;

import net.luis.nero.Nero;
import net.luis.nero.common.entity.HoveringInfernoEntity;
import net.luis.nero.common.entity.SoulBlazeEntity;
import net.luis.nero.common.entity.SoulFireballEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Nero.MOD_ID);
	
	
	public static final RegistryObject<EntityType<SoulBlazeEntity>> SOUL_BLAZE = ENTITIES.register("soul_blaze", 
			() -> EntityType.Builder.<SoulBlazeEntity>of(SoulBlazeEntity::new, EntityClassification.MONSTER).fireImmune().sized(0.6F, 1.8F)
			.clientTrackingRange(8).build("soul_blaze"));
	
	public static final RegistryObject<EntityType<SoulFireballEntity>> SOUL_FIREBALL = ENTITIES.register("soul_fireball", 
			() -> EntityType.Builder.<SoulFireballEntity>of(SoulFireballEntity::new, EntityClassification.MISC).sized(0.3125F, 0.3125F)
			.clientTrackingRange(4).updateInterval(10).build("soul_fireball"));
	
	public static final RegistryObject<EntityType<HoveringInfernoEntity>> HOVERING_INFERNO = ENTITIES.register("hovering_inferno", 
			() -> EntityType.Builder.<HoveringInfernoEntity>of(HoveringInfernoEntity::new, EntityClassification.MONSTER).sized(0.8F, 1.8F)
			.clientTrackingRange(8).build("hovering_inferno"));
	
}
