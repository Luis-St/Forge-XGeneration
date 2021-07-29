package net.luis.nero.client.world;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.phys.Vec3;

public class ModDimensionRenderInfo extends DimensionSpecialEffects {
	
	public static final DimensionSpecialEffects DEEPSLATE = new ModDimensionRenderInfo(Float.NaN, true, SkyType.NONE, true, false);
	
	private ModDimensionRenderInfo(float cloudLevel, boolean hasGround, SkyType skyType, boolean brightLightmap, boolean ambientLight) {
		super(cloudLevel, hasGround, skyType, brightLightmap, ambientLight);
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 vector, float worldTime) {
		return vector.multiply(worldTime * 0.94F + 0.06F, worldTime * 0.94F + 0.06F, worldTime * 0.91F + 0.09F);
	}

	@Override
	public boolean isFoggyAt(int x, int z) {
		return false;
	}

}
