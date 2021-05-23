package net.luis.industry.common.world.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;

public interface IBiome {
	
	default Biome createBiome() {
		Biome.Builder biomeBuilder = new Biome.Builder();
		biomeBuilder.precipitation(this.getRainType());
		biomeBuilder.biomeCategory(this.getCategory());
		biomeBuilder.depth(this.getDepth());
		biomeBuilder.scale(this.getScale());
		biomeBuilder.temperature(this.getTemperature());
		biomeBuilder.downfall(this.getDownfall());
		biomeBuilder.specialEffects(this.getBiomeAmbience());
		biomeBuilder.mobSpawnSettings(this.getMobSpawnSettings());
		biomeBuilder.generationSettings(this.getBiomeGenerationSettings());
		return biomeBuilder.build();
	}
	
	Biome.RainType getRainType();
	
	Category getCategory();
	
	float getDepth();
	
	float getScale();
	
	float getTemperature();
	
	float getDownfall();
	
	BiomeAmbience getBiomeAmbience();
	
	default int calculateSkyColor(float f) {
		float g = f / 3.0F;
		g = MathHelper.clamp(g, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
	}
	
	MobSpawnInfo getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();

}
