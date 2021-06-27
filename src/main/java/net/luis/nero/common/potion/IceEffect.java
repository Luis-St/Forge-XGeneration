package net.luis.nero.common.potion;

import net.luis.nero.api.config.Config;
import net.luis.nero.api.config.value.ConfigValue;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;

@Config
public class IceEffect extends Effect {
	
	// TODO: 1.17 render ice hearts & overlay
	
	@ConfigValue(comment = "Default value of ice effcet movement speed modifier is -0.25,\nthe value should be negative or it use the default")
	private static Double ICE_EFFECT_MOVEMENT_SPEED_MODIFIER = -0.25;
	@ConfigValue
	private static Boolean ICE_EFFECT_DAMAGE_IN_WARM_DIMENSION = false;
	@ConfigValue
	private static Double ICE_EFFECT_DEFAULT_DAMAGE = 1.0;
	
	public IceEffect(EffectType effectType, int color) {
		super(effectType, color);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "acb7ea00-1235-40f3-a3b2-77a836fa3898", 
				ICE_EFFECT_MOVEMENT_SPEED_MODIFIER > 0 ? -0.25 : ICE_EFFECT_MOVEMENT_SPEED_MODIFIER, AttributeModifier.Operation.MULTIPLY_TOTAL);	
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration % 15 == 0;
	}
	
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		World world = livingEntity.getCommandSenderWorld();
		if (!world.dimensionType().ultraWarm() || ICE_EFFECT_DAMAGE_IN_WARM_DIMENSION) {
			double d = ICE_EFFECT_DEFAULT_DAMAGE + ((amplifier - 1) / 10);
			livingEntity.hurt(ModDamageSources.ICE, (float) d);
		}
	}
	
}
