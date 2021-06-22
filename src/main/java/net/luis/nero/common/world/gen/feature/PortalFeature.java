package net.luis.nero.common.world.gen.feature;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

// TODO: tp block
// TODO: find better solution

public abstract class PortalFeature extends Feature<NoFeatureConfig> {
	
	protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
	protected static final BlockState STONE = Blocks.STONE.defaultBlockState();
	protected static final BlockState DEEPSLATE = ModBlocks.DEEPSLATE.get().defaultBlockState();
	
	public PortalFeature() {
		super(NoFeatureConfig.CODEC);
	}
	
	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rng, BlockPos blockPos, NoFeatureConfig config) {
		ChunkPos chunkPos = seedReader.getChunk(blockPos).getPos();
		if (chunkPos.x % 5 == 0 && chunkPos.z % 5 == 0 && rng.nextInt(2) == 0) {
			int xOffset = MathHelper.nextInt(new Random(), 2, 14);
			int zOffset = MathHelper.nextInt(new Random(), 2, 14);
			this.place(seedReader, chunkPos, rng, xOffset, 7, zOffset);
		}
		return true;
	}
	
	public void place(ISeedReader seedReader, ChunkPos chunkPos, Random rng, int posX, int posY, int posZ) {
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
