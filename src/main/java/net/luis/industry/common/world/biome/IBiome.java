package net.luis.industry.common.world.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

public interface IBiome {
	
	Biome createBiome(Biome.Builder biomeBuilder);
	
	Biome.RainType getRainType();
	
	Biome.Category getCategory();
	
	float getDepth();
	
	float getScale();
	
	float getTemperature();
	
	float getDownfall();
	
	BiomeAmbience getBiomeAmbience(BiomeAmbience.Builder ambienceBuilder);
	
	default int calculateSkyColor(float f) {
		float g = f / 3.0F;
		g = MathHelper.clamp(g, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
	}
	
	MobSpawnInfo getMobSpawnSettings(MobSpawnInfo.Builder modBuilder);
	
	BiomeGenerationSettings getBiomeGenerationSettings(BiomeGenerationSettings.Builder generationBuilder);

}
