package net.luis.nero.common.world.gen.feature;

import java.util.Random;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;

public class ModLakesFeature extends Feature<BlockStateFeatureConfig> {

	private static final BlockState AIR = Blocks.CAVE_AIR.defaultBlockState();

	public ModLakesFeature() {
		super(BlockStateFeatureConfig.CODEC);
	}

	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random rng, BlockPos pos, BlockStateFeatureConfig config) {
		while (pos.getY() > 5 && seedReader.isEmptyBlock(pos)) {
			pos = pos.below();
		}

		if (pos.getY() <= 4) {
			return false;
		} else {
			pos = pos.below(4);
			if (seedReader.startsForFeature(SectionPos.of(pos), Structure.VILLAGE).findAny().isPresent()) {
				return false;
			} else {
				boolean[] aboolean = new boolean[2048];
				int i = rng.nextInt(4) + 4;
				for (int j = 0; j < i; ++j) {
					double d0 = rng.nextDouble() * 6.0D + 3.0D;
					double d1 = rng.nextDouble() * 4.0D + 2.0D;
					double d2 = rng.nextDouble() * 6.0D + 3.0D;
					double d3 = rng.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
					double d4 = rng.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
					double d5 = rng.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

					for (int l = 1; l < 15; ++l) {
						for (int i1 = 1; i1 < 15; ++i1) {
							for (int j1 = 1; j1 < 7; ++j1) {
								double d6 = ((double) l - d3) / (d0 / 2.0D);
								double d7 = ((double) j1 - d4) / (d1 / 2.0D);
								double d8 = ((double) i1 - d5) / (d2 / 2.0D);
								double d9 = d6 * d6 + d7 * d7 + d8 * d8;
								if (d9 < 1.0D) {
									aboolean[(l * 16 + i1) * 8 + j1] = true;
								}
							}
						}
					}
				}
				for (int k1 = 0; k1 < 16; ++k1) {
					for (int l2 = 0; l2 < 16; ++l2) {
						for (int k = 0; k < 8; ++k) {
							boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k] && (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k]
									|| k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k]|| l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k]
											|| l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k] || k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1]
											|| k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
							if (flag) {
								Material material = seedReader.getBlockState(pos.offset(k1, k, l2)).getMaterial();
								if (k >= 4 && material.isLiquid()) {
									return false;
								}
								if (k < 4 && !material.isSolid() && seedReader.getBlockState(pos.offset(k1, k, l2)) != config.state) {
									return false;
								}
							}
						}
					}
				}
				for (int l1 = 0; l1 < 16; ++l1) {
					for (int i3 = 0; i3 < 16; ++i3) {
						for (int i4 = 0; i4 < 8; ++i4) {
							if (aboolean[(l1 * 16 + i3) * 8 + i4]) {
								seedReader.setBlock(pos.offset(l1, i4, i3), i4 >= 4 ? AIR : config.state, 2);
							}
						}
					}
				}
				if (config.state.getMaterial() == Material.LAVA) {
					for (int j2 = 0; j2 < 16; ++j2) {
						for (int k3 = 0; k3 < 16; ++k3) {
							for (int k4 = 0; k4 < 8; ++k4) {
								boolean flag1 = !aboolean[(j2 * 16 + k3) * 8 + k4]
										&& (j2 < 15 && aboolean[((j2 + 1) * 16 + k3) * 8 + k4] || j2 > 0 && aboolean[((j2 - 1) * 16 + k3) * 8 + k4]
												|| k3 < 15 && aboolean[(j2 * 16 + k3 + 1) * 8 + k4] || k3 > 0 && aboolean[(j2 * 16 + (k3 - 1)) * 8 + k4]
												|| k4 < 7 && aboolean[(j2 * 16 + k3) * 8 + k4 + 1] || k4 > 0 && aboolean[(j2 * 16 + k3) * 8 + (k4 - 1)]);
								if (flag1 && (k4 < 4 || rng.nextInt(2) != 0) && seedReader.getBlockState(pos.offset(j2, k4, k3)).getMaterial().isSolid()) {
									seedReader.setBlock(pos.offset(j2, k4, k3), ModBlocks.DEEPSLATE.get().defaultBlockState(), 2);
								}
							}
						}
					}
				}
				return true;
			}
		}
	}
}
