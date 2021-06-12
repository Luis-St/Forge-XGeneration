package net.luis.nero.common.potion;

import net.luis.nero.init.util.ModDamageSources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;

public class IceEffect extends Effect {
	
	// TODO: 1.17 render ice hearts & overlay
	
	public IceEffect(EffectType effectType, int color) {
		super(effectType, color);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "acb7ea00-1235-40f3-a3b2-77a836fa3898", -0.3, AttributeModifier.Operation.MULTIPLY_TOTAL);	
	}
	
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return duration % 15 == 0;
	}
	
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
		World world = livingEntity.getCommandSenderWorld();
		if (!world.dimensionType().ultraWarm()) {
			double d = 1.0 + ((amplifier - 1) / 10);
			livingEntity.hurt(ModDamageSources.ICE, (float) d);
		}
	}
	
}
