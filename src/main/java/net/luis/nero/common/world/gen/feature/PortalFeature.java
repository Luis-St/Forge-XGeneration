package net.luis.nero.common.world.gen.feature;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

// TODO: tp block
// TODO: find better solution

public abstract class PortalFeature extends Feature<NoneFeatureConfiguration> {
	
	protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
	protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
	protected static final BlockState DEEPSLATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	
	public PortalFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		ChunkPos chunkPos = context.level().getChunk(context.origin()).getPos();
		if (chunkPos.x % 5 == 0 && chunkPos.z % 5 == 0 && context.random().nextInt(2) == 0) {
			int xOffset = Mth.nextInt(new Random(), 2, 14);
			int zOffset = Mth.nextInt(new Random(), 2, 14);
			this.place(context.level(), chunkPos, context.random(), xOffset, 7, zOffset);
		}
		return true;
	}
	
	public void place(WorldGenLevel seedReader, ChunkPos chunkPos, Random rng, int posX, int posY, int posZ) {
		BlockPos pos = new BlockPos(chunkPos.getMinBlockX() + posX, posY, chunkPos.getMinBlockZ() + posZ);
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int y = pos.getY() - 2; y <= pos.getY() + 2; y++) {
				for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
					if (x > pos.getX() - 2 && pos.getX() + 2 > x && z > pos.getZ() - 2 && pos.getZ() + 2 > z) {
						if (y == pos.getY() - 2) {
							seedReader.setBlock(new BlockPos(x, y, z), this.getFloorBlock(), 2);
						} else if (y > pos.getY() - 3 && pos.getY() + 3 > y) {
							seedReader.setBlock(new BlockPos(x, y, z), this.getAirBlock(), 2);
						}
					} else {
						seedReader.setBlock(new BlockPos(x, y, z), this.getBaseStone(), 2);
					}
				}
			}
		}
	}
	
	protected BlockState getAirBlock() {
		return CAVE_AIR;
	}
	
	protected abstract BlockState getBaseStone();
	
	protected abstract BlockState getFloorBlock();
	
	public static class ToDeepslate extends PortalFeature {

		@Override
		protected BlockState getBaseStone() {
			return STONE;
		}

		@Override
		protected BlockState getFloorBlock() {
			return DEEPSLATE;
		}
		
	}
	
	public static class ToOverworld extends PortalFeature {

		@Override
		protected BlockState getBaseStone() {
			return DEEPSLATE;
		}

		@Override
		protected BlockState getFloorBlock() {
			return STONE;
		}
		
	}
	
}
