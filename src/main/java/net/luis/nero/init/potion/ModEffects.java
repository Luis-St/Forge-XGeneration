package net.luis.nero.init.potion;

import net.luis.nero.Nero;
import net.luis.nero.api.common.potion.ModEffect;
import net.luis.nero.common.potion.IceEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
	
	// https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Nero.MOD_ID);
	
	
	public static final RegistryObject<ModEffect> HARVEST = EFFECTS.register("harvest", () -> new ModEffect(MobEffectCategory.BENEFICIAL, 1301533));
	public static final RegistryObject<ModEffect> HARVEST_FATIGUE = EFFECTS.register("harvest_fatigue", () -> new ModEffect(MobEffectCategory.BENEFICIAL, 8978478));
	public static final RegistryObject<IceEffect> ICE = EFFECTS.register("ice", () -> new IceEffect(MobEffectCategory.HARMFUL, 10878975));
	public static final RegistryObject<ModEffect> BRIDGE = EFFECTS.register("bridge", () -> new ModEffect(MobEffectCategory.BENEFICIAL, 0));

}
