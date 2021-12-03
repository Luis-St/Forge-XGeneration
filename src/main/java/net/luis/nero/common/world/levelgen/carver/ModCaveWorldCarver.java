package net.luis.nero.common.world.levelgen.carver;

import java.util.Random;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.luis.nero.common.world.levelgen.carver.config.ModCaveCarverConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;

// TODO: fix
public class ModCaveWorldCarver extends ModWorldCarver<ModCaveCarverConfiguration> {
	
	public ModCaveWorldCarver(Codec<ModCaveCarverConfiguration> codec) {
		super(codec);
	}
	
	@Override
	public boolean isStartChunk(ModCaveCarverConfiguration config, Random rng) {
		return rng.nextFloat() <= config.probability;
	}
	
	@Override
	public boolean carve(CarvingContext p_190766_, ModCaveCarverConfiguration p_190767_, ChunkAccess p_190768_,
			Function<BlockPos, Biome> p_190769_, Random p_190770_, Aquifer p_190771_, ChunkPos p_190772_,
			CarvingMask p_190773_) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	public boolean carve(CarvingContext context, ModCaveCarverConfiguration config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, Random rng, Aquifer aquifer, ChunkPos chunkPos, BitSet bitSet) {
//		int range = SectionPos.sectionToBlockCoord(config.range * 2 - 1);
//		int bound = rng.nextInt(rng.nextInt(rng.nextInt(config.bound) + 1) + 1);
//		for (int i = 0; i < bound; ++i) {
//			double posX = chunkPos.getBlockX(rng.nextInt(16));
//			double posY = config.y.sample(rng, context);
//			double posZ = chunkPos.getBlockZ(rng.nextInt(16));
//			double horizontalMultiplier = config.horizontalMultiplier.sample(rng);
//			double verticalMultiplier = config.verticalMultiplier.sample(rng);
//			double floorLevel = config.floorLevel.sample(rng);
//			WorldCarver.CarveSkipChecker skipChecker = (carvingContext, xOffset, yOffset, zOffset, y) -> {
//				return this.shouldSkip(xOffset, yOffset, zOffset, floorLevel);
//			};
//			int roomCount = 1;
//			if (rng.nextInt(4) == 0) {
//				double yScale =  config.yRoomScale.sample(rng);
//				float width = 1.0F + rng.nextFloat() * 6.0F;
//				this.createRoom(context, config, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, width, yScale, bitSet, skipChecker);
//				roomCount += rng.nextInt(4);
//			}
//			for (int k = 0; k < roomCount; ++k) {
//				float f = rng.nextFloat() * ((float) Math.PI * 2F);
//				float f3 = (rng.nextFloat() - 0.5F) / 4.0F;
//				float thickness = this.getThickness(rng);
//				int length = range - rng.nextInt(range / 4);
//				this.createTunnel(context, config, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, thickness, f, f3, 0, length, config.yTunnelScale.sample(rng), bitSet, skipChecker);
//			}
//		}
//
//		return true;
//	}

	protected float getThickness(Random rng) {
		float thickness = rng.nextFloat() * 2.0F + rng.nextFloat();
		if (rng.nextInt(10) == 0) {
			thickness *= rng.nextFloat() * rng.nextFloat() * 3.0F + 1.0F;
		}
		return thickness;
	}

//	protected void createRoom(CarvingContext context, ModCaveCarverConfiguration config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, Aquifer aquifer, double posX, double posY, double posZ, float widthIn, 
//			double yScale, BitSet bitSet, WorldCarver.CarveSkipChecker skipChecker) {
//		double width = 1.5D + (Mth.sin(((float) Math.PI / 2F)) * widthIn);
//		double height = width * yScale;
//		this.carveEllipsoid(context, config, chunkAccess, toBiome, seed, aquifer, posX + 1.0D, posY, posZ, width, height, bitSet, skipChecker);
//	}
	
//	protected void createTunnel(CarvingContext context, ModCaveCarverConfiguration config, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, Aquifer aquifer, double posX, double posY, double posZ, double horizontalMultiplier, 
//			double verticalMultiplier, float thickness, float motionHorizontal, float motionVertical, int startGen, int lengthIn, double yScale, BitSet bitSet, WorldCarver.CarveSkipChecker skipChecker) {
//		Random rng = new Random(seed);
//		int range = rng.nextInt(lengthIn / 2) + lengthIn / 4;
//		boolean flag = rng.nextInt(6) == 0;
//		float f = 0.0F;
//		float g = 0.0F;
//		for (int length = startGen; length < lengthIn; ++length) {
//			double width = 1.5D + (Mth.sin((float) Math.PI * (float) length / (float) lengthIn) * thickness);
//			double height = width * yScale;
//			float h = Mth.cos(motionVertical);
//			posX += Mth.cos(motionHorizontal) * h;
//			posY +=  Mth.sin(motionVertical);
//			posZ += Mth.sin(motionHorizontal) * h;
//			motionVertical *= (flag ? 0.92F : 0.7F);
//			motionVertical += g * 0.1F;
//			motionHorizontal += f * 0.1F;
//			g *= 0.9F;
//			f *= 0.75F;
//			g += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
//			f += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
//			if (length == range && thickness > 1.0F) {
//				this.createTunnel(context, config, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, rng.nextFloat() * 0.5F + 0.5F, motionHorizontal - ((float) Math.PI / 2F), 
//						motionVertical / 3.0F, length, lengthIn, config.yTunnelScale.sample(rng), bitSet, skipChecker);
//				this.createTunnel(context, config, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, rng.nextFloat() * 0.5F + 0.5F, motionHorizontal + ((float) Math.PI / 2F), 
//						motionVertical / 3.0F, length, lengthIn, config.yTunnelScale.sample(rng), bitSet, skipChecker);
//				return;
//			}
//			if (rng.nextInt(4) != 0) {
//				if (!canReach(chunkAccess.getPos(), posX, posZ, length, lengthIn, thickness)) {
//					return;
//				}
//				this.carveEllipsoid(context, config, chunkAccess, toBiome, seed, aquifer, posX, posY, posZ, width * horizontalMultiplier, height * verticalMultiplier, bitSet, skipChecker);
//			}
//		}
//	}

	protected boolean shouldSkip(double xOffset, double yOffset, double zOffset, double floorLevel) {
		if (yOffset <= floorLevel) {
			return true;
		} else {
			return xOffset * xOffset + yOffset * yOffset + zOffset * zOffset >= 1.0D;
		}
	}
	
}
