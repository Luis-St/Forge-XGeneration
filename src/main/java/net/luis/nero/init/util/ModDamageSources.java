package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;

public class ModDamageSources {
	
	public static final DamageSource ICE = createDamageSource("ice");
	public static final DamageSource DEATH_RUNE = createDamageSource("death_rune");
	public static final DamageSource RUNE = createDamageSource("rune");
	public static final DamageSource ORB = createDamageSource("orb");
	public static final DamageSource DAGGER = createDamageSource("dagger");
	
	
	protected static DamageSource createDamageSource(String name) {
		return new DamageSource(new ResourceLocation(Nero.MOD_ID, name).toString().replace(":", "_").replace("/", "_"));
	}

}
