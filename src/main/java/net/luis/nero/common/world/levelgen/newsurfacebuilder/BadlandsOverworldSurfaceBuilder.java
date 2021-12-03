package net.luis.nero.common.world.levelgen.newsurfacebuilder;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// TODO: fix
public class BadlandsOverworldSurfaceBuilder extends OverworldSurfaceBuilder {
	
	protected static final BlockState BROWN_TERRACOTTA = Blocks.BROWN_TERRACOTTA.defaultBlockState();
	protected static final BlockState LIGHT_GRAY_TERRACOTTA = Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState();
	protected static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.defaultBlockState();
	protected static final BlockState TERRACOTTA = Blocks.TERRACOTTA.defaultBlockState();
	protected static final BlockState YELLOW_TERRACOTTA = Blocks.YELLOW_TERRACOTTA.defaultBlockState();
	protected static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.defaultBlockState();
	protected static final BlockState RED_TERRACOTTA = Blocks.RED_TERRACOTTA.defaultBlockState();
	
//	protected BlockState[] terracottaLayer;
//	protected PerlinSimplexNoise terracottaLayerNoise;
//	
//	@SuppressWarnings("unused")
//	@Override
//	public void apply(Random rng, ChunkAccess chunkAccess, int x, int z, double noise, int minSurface, int maxSurface, int seaLevel, long seed) {
//		WorldgenRandom worldRng = new WorldgenRandom(seed);
//		int surfaceNoise = (int) Math.round((noise + 1) * 2);
//		for (int y = maxSurface; y >= minSurface; y--) {
//			BlockPos pos = new BlockPos(x, y, z);
//			BlockState state = null;
//
//			if (seaLevel > y) {
//
//				if (seaLevel - 4 > y) {
//
//					if (y > maxSurface - 3) {
//
//						state = GRAVEL;
//
//					}
//
//				} else {
//
//					state = RED_SAND;
//
//				}
//
//			} else {
//
//				if (y > seaLevel + 6 /*|| y > maxSurface - 7*/) {
//					
//					state = this.getTerracottaLayer(x, y, z);
//
//				} else {
//
//					state = RED_SAND;
//
//				}
//
//			}
//
//			if (state != null) {
//				chunkAccess.setBlockState(pos, state, false);
//			}
//
//		}
//	}
//	
//	@Override
//	protected void init(long seed) {
//		if (this.terracottaLayer == null) {
//			this.generateTerracottaLayer(seed);
//		}
//	}
//	
//	protected void generateTerracottaLayer(long seed) {
//		this.terracottaLayer = new BlockState[64];
//		Arrays.fill(this.terracottaLayer, TERRACOTTA);
//		WorldgenRandom worldRandom = new WorldgenRandom(seed);
//		this.terracottaLayerNoise = new PerlinSimplexNoise(worldRandom, Lists.newArrayList(0));
//		for (int y = 0; y < 64; ++y) {
//			y += worldRandom.nextInt(5) + 1;
//			if (64 > y) {
//				this.terracottaLayer[y] = ORANGE_TERRACOTTA;
//			}
//		}
//		int indexMax0 = worldRandom.nextInt(4) + 2;
//		for (int i = 0; i < indexMax0; ++i) {
//			int yMax = worldRandom.nextInt(3) + 1;
//			int yOffset = worldRandom.nextInt(64);
//			for (int y = 0; yOffset + y < 64 && y < yMax; ++y) {
//				this.terracottaLayer[yOffset + y] = YELLOW_TERRACOTTA;
//			}
//		}
//		int indexMax1 = worldRandom.nextInt(4) + 2;
//		for (int i = 0; i < indexMax1; ++i) {
//			int yMax = worldRandom.nextInt(3) + 2;
//			int yOffset = worldRandom.nextInt(64);
//			for (int y = 0; yOffset + y < 64 && y < yMax; ++y) {
//				this.terracottaLayer[yOffset + y] = BROWN_TERRACOTTA;
//			}
//		}
//		int indexMax2 = worldRandom.nextInt(4) + 2;
//		for (int i = 0; i < indexMax2; ++i) {
//			int yMax = worldRandom.nextInt(3) + 1;
//			int yOffset = worldRandom.nextInt(64);
//			for (int y = 0; yOffset + y < 64 && y < yMax; ++y) {
//				this.terracottaLayer[yOffset + y] = RED_TERRACOTTA;
//			}
//		}
//		int yMax = worldRandom.nextInt(3) + 3;
//		int yOffset = 0;
//		for (int i = 0; i < yMax; ++i) {
//			yOffset += worldRandom.nextInt(16) + 4;
//			for (int y = 0; yOffset + y < 64 && y < 1; ++y) {
//				this.terracottaLayer[yOffset + y] = WHITE_TERRACOTTA;
//				if (yOffset + y > 1 && worldRandom.nextBoolean()) {
//					this.terracottaLayer[yOffset + y - 1] = LIGHT_GRAY_TERRACOTTA;
//				}
//				if (yOffset + y < 63 && worldRandom.nextBoolean()) {
//					this.terracottaLayer[yOffset + y + 1] = LIGHT_GRAY_TERRACOTTA;
//				}
//			}
//		}
//	}
//
//	protected BlockState getTerracottaLayer(int x, int y, int z) {
//		int noise = (int) Math.round(this.terracottaLayerNoise.getValue(x / 512.0, z / 512.0, false) * 2.0D);
//		return this.terracottaLayer[(y + noise + 64) % 64];
//	}
	
}
