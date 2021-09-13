package net.luis.nero.common.world.biome.layer.traits;

import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.BigContext;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset0Transformer;

public interface RainfallTransformer extends SimpleAreaTransformer, DimensionOffset0Transformer {
	
	@Override
	default int apply(BigContext<?> context, Area area, int x, int z) {
		return this.apply(context, area, area.get(this.getParentX(x + 1), this.getParentY(z + 0)), area.get(this.getParentX(x + 2), this.getParentY(z + 1)), area.get(this.getParentX(x + 1), this.getParentY(z + 2)),
				area.get(this.getParentX(x + 0), this.getParentY(z + 1)), area.get(this.getParentX(x + 1), this.getParentY(z + 1)));
	}
	
	int apply(BigContext<?> context, Area temperatureArea, int temperatureNorth, int temperatureEast, int temperatureSouth, int temperatureWest, int temperature);
	
}
