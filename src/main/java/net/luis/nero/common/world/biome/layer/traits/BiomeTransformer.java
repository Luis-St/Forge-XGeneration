package net.luis.nero.common.world.biome.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset0Transformer;

public interface BiomeTransformer extends SimpleAreaTransformer, DimensionOffset0Transformer {
	
	default int applyPixel(BigContext<?> context, Area area, int x, int z) {
		return this.apply(context, area.get(this.getParentX(x), this.getParentY(z)));
	}
	
	int apply(BigContext<?> context, int biomeId);
	
}
