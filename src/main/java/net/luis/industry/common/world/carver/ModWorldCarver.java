package net.luis.industry.common.world.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.lang3.mutable.MutableBoolean;

import net.luis.industry.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public abstract class ModWorldCarver extends WorldCarver<ProbabilityConfig> {
	
	public ModWorldCarver() {
		super(ProbabilityConfig.CODEC, 256);
		this.replaceableBlocks = Set.of(ModBlocks.DEEPSLATE.get(), ModBlocks.DEEPSLATE_COAL_ORE.get(),
				ModBlocks.DEEPSLATE_COPPER_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get(),
				ModBlocks.DEEPSLATE_GOLD_ORE.get(), ModBlocks.DEEPSLATE_LAPIS_ORE.get(),
				ModBlocks.DEEPSLATE_REDSTONE_ORE.get(), ModBlocks.DEEPSLATE_DIAMOND_ORE.get(),
				ModBlocks.DEEPSLATE_EMERALD_ORE.get());
	}
	
	protected int getFluidFillHeight(Random rng, int chunkX, int y, int chunkZ) {
		return 14;
	}
	
	protected FluidState getFluidFillState(Random rng, int chunkX, int y, int chunkZ) {
		return Fluids.LAVA.defaultFluidState();
	}
	
	@Override
	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return rng.nextFloat() <= config.probability;
	}
	
	@Override
	protected boolean carveSphere(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, 
			double posX, double posY, double posZ, double width, double height, BitSet bitSet) {
		Random random = new Random(seed + (long) chunkX + (long) chunkZ);
		double chunkCenterX = (double) (chunkX * 16 + 8);
		double chunkCenterZ = (double) (chunkZ * 16 + 8);
		if (!(posX < chunkCenterX - 16.0D - width * 2.0D) && !(posZ < chunkCenterZ - 16.0D - width * 2.0D)
			&& !(posX > chunkCenterX + 16.0D + width * 2.0D) && !(posZ > chunkCenterZ + 16.0D + width * 2.0D)) {
			int posXMax = Math.max(MathHelper.floor(posX - width) - chunkX * 16 - 1, 0);
			int posXMin = Math.min(MathHelper.floor(posX + width) - chunkX * 16 + 1, 16);
			int posYMax = Math.max(MathHelper.floor(posY - height) - 1, 1);
			int posYMin = Math.min(MathHelper.floor(posY + height) + 1, this.genHeight - 8);
			int posZMax = Math.max(MathHelper.floor(posZ - width) - chunkZ * 16 - 1, 0);
			int posZMin = Math.min(MathHelper.floor(posZ + width) - chunkZ * 16 + 1, 16);
			if (this.hasWater(chunk, chunkX, chunkZ, posXMax, posXMin, posYMax, posYMin, posZMax, posZMin)) {
				return false;
			} else {
				boolean flag = false;
				BlockPos.Mutable pos0 = new BlockPos.Mutable();
				BlockPos.Mutable pos1 = new BlockPos.Mutable();
				BlockPos.Mutable pos2 = new BlockPos.Mutable();

				for (int k1 = posXMax; k1 < posXMin; ++k1) {
					int l1 = k1 + chunkX * 16;
					double d2 = ((double) l1 + 0.5D - posX) / width;

					for (int i2 = posZMax; i2 < posZMin; ++i2) {
						int j2 = i2 + chunkZ * 16;
						double d3 = ((double) j2 + 0.5D - posZ) / width;
						if (!(d2 * d2 + d3 * d3 >= 1.0D)) {
							MutableBoolean mutableboolean = new MutableBoolean(false);

							for (int k2 = posYMin; k2 > posYMax; --k2) {
								double d4 = ((double) k2 - 0.5D - posY) / height;
								if (!this.skip(d2, d4, d3, k2)) {
									flag |= this.carveBlock(chunk, toBiome, bitSet, random, pos0, pos1, pos2, seaLevel, chunkX, chunkZ, l1, j2, k1, k2, i2, 
											mutableboolean);
								}
							}
						}
					}
				}

				return flag;
			}
		} else {
			return false;
		}
	}
	
	@Override
	protected boolean carveBlock(IChunk chunk, Function<BlockPos, Biome> toBiome, BitSet bitSet, Random rng, Mutable pos0, Mutable pos1, Mutable pos2, 
			int seaLevel, int chunkX, int chunkZ, int carverX, int carverZ, int carverPosX, int carverPosY,  int carverPosZ, MutableBoolean mutableboolean) {
		int i = carverPosX | carverPosZ << 4 | carverPosY << 8;
		if (bitSet.get(i)) {
			return false;
		} else {
			bitSet.set(i);
			pos0.set(carverX, carverPosY, carverZ);
			BlockState blockState = chunk.getBlockState(pos0);
			BlockState blockStateUp = chunk.getBlockState(pos1.setWithOffset(pos0, Direction.UP));
			if (!this.canReplaceBlock(blockState, blockStateUp)) {
				return false;
			} else {
				if (carverPosY <= this.getFluidFillHeight(rng, chunkX, carverPosY, chunkZ)) {
					chunk.setBlockState(pos0, this.getFluidFillState(rng, chunkX, carverPosY, chunkZ).createLegacyBlock(), false);
				} else {
					chunk.setBlockState(pos0, CAVE_AIR, false);
				}
				return true;
			}
		}
	}
	
}
