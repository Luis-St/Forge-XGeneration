package net.luis.nero.init.util;

import net.luis.nero.Nero;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

public class ModDamageSources {
	
	public static final DamageSource ORB = createDamageSource("orb");
	public static final DamageSource DAGGER = createDamageSource("dagger");
	
	
	protected static DamageSource createDamageSource(String name) {
		return new DamageSource(new ResourceLocation(Nero.MOD_ID, name).toString().replace(":", "_").replace("/", "_"));
	}

}
