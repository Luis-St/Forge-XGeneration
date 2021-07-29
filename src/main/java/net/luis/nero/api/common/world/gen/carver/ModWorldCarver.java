 package net.luis.nero.api.common.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import org.apache.commons.lang3.mutable.MutableBoolean;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;

import net.luis.nero.init.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

// TODO: more things to edit -> via get methods
public abstract class ModWorldCarver<C extends CarverConfiguration> extends WorldCarver<C> {
	
	public ModWorldCarver(Codec<C> codec) {
		super(codec);
		this.replaceableBlocks = ImmutableSet.of(ModBlocks.DEEPSLATE.get(), ModBlocks.DEEPSLATE_COAL_ORE.get(),
		ModBlocks.DEEPSLATE_COPPER_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get(),
		ModBlocks.DEEPSLATE_GOLD_ORE.get(), ModBlocks.DEEPSLATE_LAPIS_ORE.get(),
		ModBlocks.DEEPSLATE_REDSTONE_ORE.get(), ModBlocks.DEEPSLATE_DIAMOND_ORE.get(),
		ModBlocks.DEEPSLATE_EMERALD_ORE.get());
	}

	protected int getFluidFillHeight(int x, int y, int z) {
		return 14;
	}
	
	protected FluidState getFluidFillState(int x, int y, int z) {
		return Fluids.LAVA.defaultFluidState();
	}
	
	@Override
	public boolean isStartChunk(CarverConfiguration config, Random rng) {
		return rng.nextFloat() <= config.probability;
	}
	
	@Override
	protected boolean carveEllipsoid(CarvingContext context, C config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, 
			Aquifer aquifer, double xIn, double yIn, double zIn, double width, double height, BitSet bitSet, WorldCarver.CarveSkipChecker skipChecker) {
		ChunkPos chunkpos = chunkAccess.getPos();
		int chunkX = chunkpos.x;
		int chunkZ = chunkpos.z;
		Random rng = new Random(seed + (long) chunkX + (long) chunkZ);
		double chunkCenterX = (double) chunkpos.getMiddleBlockX();
		double chunkCenterZ = (double) chunkpos.getMiddleBlockZ();
		double chunkCenterY = 16.0D + width * 2.0D;
		if (!(Math.abs(xIn - chunkCenterX) > chunkCenterY) && !(Math.abs(zIn - chunkCenterZ) > chunkCenterY)) {
			int chunkMinX = chunkpos.getMinBlockX();
			int chunkMinZ = chunkpos.getMinBlockZ();
			int xMax = Math.max(Mth.floor(xIn - width) - chunkMinX - 1, 0);
			int xMin = Math.min(Mth.floor(xIn + width) - chunkMinX, 15);
			int yMax = Math.max(Mth.floor(yIn - height) - 1, context.getMinGenY() + 1);
			int yMin = Math.min(Mth.floor(yIn + height) + 1, context.getMinGenY() + context.getGenDepth() - 8);
			int zMax = Math.max(Mth.floor(zIn - width) - chunkMinZ - 1, 0);
			int zMin = Math.min(Mth.floor(zIn + width) - chunkMinZ, 15);
			if (!config.aquifersEnabled && this.hasDisallowedLiquid(chunkAccess, xMax, xMin, yMax, yMin, zMax, zMin)) {
				return false;
			} else {
				boolean flag = false;
				BlockPos.MutableBlockPos pos0 = new BlockPos.MutableBlockPos();
				BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos();
				for (int x = xMax; x <= xMin; ++x) {
					int blockX = chunkpos.getBlockX(x);
					double xOffset = ((double) blockX + 0.5D - xIn) / width;
					for (int z = zMax; z <= zMin; ++z) {
						int blockZ = chunkpos.getBlockZ(z);
						double zOffset = ((double) blockZ + 0.5D - zIn) / width;
						if (!(xOffset * xOffset + zOffset * zOffset >= 1.0D)) {
							MutableBoolean mutable = new MutableBoolean(false);
							for (int y = yMin; y > yMax; --y) {
								double yOffset = ((double) y - 0.5D - yIn) / height;
								if (!skipChecker.shouldSkip(context, xOffset, yOffset, zOffset, y)) {
									int minGenY = y - context.getMinGenY();
									int i = x | z << 4 | minGenY << 8;
									if (!bitSet.get(i) || this.isDebugEnabled(config)) {
										bitSet.set(i);
										pos0.set(blockX, y, blockZ);
										flag |= this.carveBlock(context, config, chunkAccess, toBiome, bitSet, rng, pos0, pos1, aquifer, mutable);
									}
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
	protected boolean carveBlock(CarvingContext context, C config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, BitSet bitSet, Random rng, 
			BlockPos.MutableBlockPos pos0, BlockPos.MutableBlockPos pos1, Aquifer aquifer, MutableBoolean mutable) {
		BlockState state = chunkAccess.getBlockState(pos0);
		BlockState stateUp = chunkAccess.getBlockState(pos1.setWithOffset(pos0, Direction.UP));
		if (state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MYCELIUM)) {
			mutable.setTrue();
		}
		if (!this.canReplaceBlock(state, stateUp) && !this.isDebugEnabled(config)) {
			return false;
		} else {
			BlockState carveState = this.getCarveState(context, config, pos0, aquifer);
			if (carveState == null) {
				return false;
			} else {
				chunkAccess.setBlockState(pos0, carveState, false);
				if (mutable.isTrue()) {
					pos1.setWithOffset(pos0, Direction.DOWN);
					if (chunkAccess.getBlockState(pos1).is(Blocks.DIRT)) {
						chunkAccess.setBlockState(pos1, toBiome.apply(pos0).getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial(), false);
					}
				}
				return true;
			}
		}
	}
	
	protected BlockState getCarveState(CarvingContext context, C config, BlockPos pos, Aquifer aquifer) {
		if (pos.getY() <= this.getFluidFillHeight(pos.getX(), pos.getY(), pos.getZ())) {
			return this.getFluidFillState(pos.getX(), pos.getY(), pos.getZ()).createLegacyBlock();
		} else if (!config.aquifersEnabled) {
			return this.isDebugEnabled(config) ? this.getDebugState(config, AIR) : AIR;
		} else {
			BlockState blockstate = aquifer.computeState(STONE_SOURCE, pos.getX(), pos.getY(), pos.getZ(), 0.0D);
			if (blockstate == Blocks.STONE.defaultBlockState()) {
				return this.isDebugEnabled(config) ? config.debugSettings.getBarrierState() : null;
			} else {
				return this.isDebugEnabled(config) ? this.getDebugState(config, blockstate) : blockstate;
			}
		}
	}
	
	protected BlockState getDebugState(C config, BlockState state) {
		if (state.is(Blocks.AIR)) {
			return config.debugSettings.getAirState();
		} else if (state.is(Blocks.WATER)) {
			BlockState waterState = config.debugSettings.getWaterState();
			boolean waterLogable = waterState.hasProperty(BlockStateProperties.WATERLOGGED);
			return waterLogable ? waterState.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)) : waterState;
		} else {
			return state.is(Blocks.LAVA) ? config.debugSettings.getLavaState() : state;
		}
	}
	
	protected boolean isDebugEnabled(C config) {
		return config.debugSettings.isDebugMode();
	}
	
}
