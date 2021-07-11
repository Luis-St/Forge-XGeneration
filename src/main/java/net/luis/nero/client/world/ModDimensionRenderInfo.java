package net.luis.nero.client.world;

import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.math.vector.Vector3d;

public class ModDimensionRenderInfo extends DimensionRenderInfo {
	
	public static final DimensionRenderInfo DEEPSLATE = new ModDimensionRenderInfo(Float.NaN, true, FogType.NONE, true, false);
	
	private ModDimensionRenderInfo(float cloudLevel, boolean hasGround, FogType skyType, boolean brightLightmap, boolean ambientLight) {
		super(cloudLevel, hasGround, skyType, brightLightmap, ambientLight);
	}

	@Override
	public Vector3d getBrightnessDependentFogColor(Vector3d vector, float worldTime) {
		return vector.multiply(worldTime * 0.94F + 0.06F, worldTime * 0.94F + 0.06F, worldTime * 0.91F + 0.09F);
	}

	@Override
	public boolean isFoggyAt(int x, int z) {
		return false;
	}

}
