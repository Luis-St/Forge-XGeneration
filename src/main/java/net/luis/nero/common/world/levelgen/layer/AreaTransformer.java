package net.luis.nero.common.world.levelgen.layer;

import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer1;
import net.minecraft.world.level.newbiome.layer.traits.DimensionOffset0Transformer;

public interface AreaTransformer extends AreaTransformer1, DimensionOffset0Transformer {
	
	@Override
	default int getParentX(int x) {
		return x;
	}
	
	@Override
	default int getParentY(int y) {
		return y;
	}
	
}
