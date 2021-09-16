package net.luis.nero.common.world.biome.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;

public interface BiomeTransformer extends SimpleAreaTransformer {
	
	default int applyPixel(BigContext<?> context, Area area, int x, int z) {
		return this.apply(context, area.get(x, z));
	}
	
	int apply(BigContext<?> context, int biomeId);
	
}
