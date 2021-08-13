package net.luis.nero.common.potion;

import net.luis.nero.api.common.potion.ModEffect;
import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class IceEffect extends ModEffect {
	
	// TODO: 1.17 render ice hearts & overlay
	
	public IceEffect(MobEffectCategory effectType, int color) {
		super(effectType, color);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "acb7ea00-1235-40f3-a3b2-77a836fa3898", -0.25, AttributeModifier.Operation.MULTIPLY_TOTAL);	
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration % 15 == 0;
	}
	
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		Level world = livingEntity.getCommandSenderWorld();
		if (!world.dimensionType().ultraWarm()) {
			double d = 1.0 + ((amplifier - 1) / 10);
			livingEntity.hurt(ModDamageSources.ICE, (float) d);
		}
	}
	
}
