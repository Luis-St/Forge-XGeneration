package net.luis.nero.common.world.levelgen.newsurfacebuilder;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class OverworldSurfaceBuilderConfiguration implements SurfaceBuilderConfiguration {
	
	public static final Codec<OverworldSurfaceBuilderConfiguration> CODEC = Codec.unit(OverworldSurfaceBuilderConfiguration::new);
	
	public OverworldSurfaceBuilderConfiguration() {
		
	}
	
	@Override
	public BlockState getTopMaterial() {
		return Blocks.AIR.defaultBlockState();
	}
	
	@Override
	public BlockState getUnderMaterial() {
		return Blocks.AIR.defaultBlockState();
	}
	
	@Override
	public BlockState getUnderwaterMaterial() {
		return Blocks.AIR.defaultBlockState();
	}
	
}
