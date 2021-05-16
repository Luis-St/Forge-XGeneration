package net.luis.industry.common.world.carver;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;

public enum FillerType {
	
	LAVA(Fluids.LAVA.defaultFluidState().createLegacyBlock()),
	WATER(Fluids.WATER.defaultFluidState().createLegacyBlock()),
	AIR(Blocks.CAVE_AIR.defaultBlockState());
	
	private final BlockState filler;
	
	private FillerType(BlockState filler) {
		this.filler = filler;
	}
	
	public BlockState getFiller() {
		return this.filler;
	}

}
