package net.luis.nero.init.potion;

import net.luis.nero.Nero;
import net.luis.nero.common.potion.ModEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
	
	// https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	
	public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Nero.MOD_ID);
	
	
	public static final RegistryObject<ModEffect> HARVEST = EFFECTS.register("harvest", () -> new ModEffect(EffectType.BENEFICIAL, 1301533));

}
