package net.luis.nero.api.common.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

public class ModCaveWorldCarver extends ModWorldCarver<CaveCarverConfiguration> {

	public ModCaveWorldCarver() {
		super(CaveCarverConfiguration.CODEC);
	}
	
	@Override
	public int getRange() {
		return 4;
	}
	
	public int calcRange(Random rng, int range, int chunkX, int chunkZ) {
		return (range * 2 - 1) * 16;
	}
	
	public int getCaveBound(Random rng, int range) {
		return 15;
	}
	
	public float getThickness(Random rng, float verticalModifier, float horizontalModifier) {
		float f = rng.nextFloat() * 2.0F + rng.nextFloat();
		if (rng.nextInt(10) == 0) {
			f *= rng.nextFloat() * rng.nextFloat() * 3.0F + 1.0F;
		}
		return f;
	}
	
	public double getYScale(Random rng, double posX, double posY, double posZ) {
		return 1.0D;
	}
	
	public int getCaveY(CarvingContext context, Random rng) {
		return rng.nextInt(rng.nextInt(120) + 8);
	}
	
	public int getRoomChance(Random rng, double posX, double posY, double posZ) {
		return rng.nextInt(4);
	}
	
	public float getRoomWidth(CaveCarverConfiguration caveConfig, Random rng, double posX, double posY, double posZ) {
		return 1.0F + rng.nextFloat() * 0.6F;
	}
	
	public double getRoomHeight(CaveCarverConfiguration caveConfig, Random rng, double width, double posX, double posY, double posZ) {
		return 0.5;
	}
	
	public double calcRoomWidth(Random rng, double width, double posX, double posY, double posZ) {
		return 1.5D + Math.sin(Math.PI / 2F) * width;
	}
	
	public double calcRoomHeight(Random rng, double roomWidth, double heigth) {
		return roomWidth * heigth;
	}
	
	public double getNextXPos(Random rng, double oldPosX, float horizontalModifier, float verticalModifier, float[] motionModifiers) {
		return oldPosX + (Math.cos(horizontalModifier) * motionModifiers[2]);
	}
	
	public double getNextYPos(Random rng, double oldPosY, float horizontalModifier, float verticalModifier, float[] motionModifiers) {
		return oldPosY + (Math.sin(verticalModifier));
	}
	
	public double getNextZPos(Random rng, double oldPosZ, float horizontalModifier, float verticalModifier, float[] motionModifiers) {
		return oldPosZ + (Math.sin(horizontalModifier) * motionModifiers[2]);
	}
	
	@Override
	public boolean carve(CarvingContext context, CaveCarverConfiguration caveConfig, ChunkAccess chunkAccess,Function<BlockPos, Biome> toBiome, Random rng, 
			Aquifer aquifer, ChunkPos chunkPos, BitSet bitSet) {
		int range = this.calcRange(rng, this.getRange(), chunkPos.x, chunkPos.z);
		int caveBound = rng.nextInt(rng.nextInt(rng.nextInt(this.getCaveBound(rng, range)) + 1) + 1);
		for (int i = 0; i < caveBound; ++i) {
			double posX = (double) chunkPos.getBlockX(rng.nextInt(16));
			double posY = (double) this.getCaveY(context, rng);
			double posZ = (double) chunkPos.getBlockZ(rng.nextInt(16));
			double horizontalMultiplier = (double) caveConfig.horizontalRadiusMultiplier.sample(rng);
			double verticalMultiplier = (double) caveConfig.verticalRadiusMultiplier.sample(rng);
			double floorLevel = (double) caveConfig.floorLevel.sample(rng);
			WorldCarver.CarveSkipChecker skipChecker = (carvingContext, xOffset, yOffset, zOffset, y) -> {
				return this.shouldSkip(xOffset, yOffset, zOffset, floorLevel);
			};
			int tunnelLength = 1;
			if (this.getRoomChance(rng, posX, posY, posZ) == 0) {
				float width = this.getRoomWidth(caveConfig, rng, posX, posY, posZ);
				double height = this.getRoomHeight(caveConfig, rng, width, posX, posY, posZ);
				this.createRoom(context, caveConfig, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, width, height, bitSet, skipChecker);
				tunnelLength += rng.nextInt(4);
			}
			for (int j = 0; j < tunnelLength; ++j) {
				float verticalModifier = rng.nextFloat() * ((float) Math.PI * 2F);
				float horizontalModifier = (rng.nextFloat() - 0.5F) / 4.0F;
				float thickness = this.getThickness(rng, verticalModifier, horizontalModifier);
				int length = range - rng.nextInt(range / 4);
				this.createTunnel(context, caveConfig, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, 
						thickness, verticalModifier, horizontalModifier, 0, length, this.getYScale(rng, posX, posY, posZ), bitSet, skipChecker);
			}
		}
		return true;
	}
	
	protected void createRoom(CarvingContext context, CaveCarverConfiguration caveConfig, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, 
			Aquifer aquifer, double posX, double posY, double posZ, float width, double height, BitSet bitSet, WorldCarver.CarveSkipChecker skipChecker) {
		double roomWidth = this.calcRoomWidth(new Random(seed), width, posX, posY, posZ);
		double roomHeight = this.calcRoomHeight(new Random(seed), roomWidth, height);
		this.carveEllipsoid(context, caveConfig, chunkAccess, toBiome, seed, aquifer, posX + 1.0D,
				posY, posZ, roomWidth, roomHeight, bitSet, skipChecker);
	}

	protected void createTunnel(CarvingContext context, CaveCarverConfiguration caveConfig, ChunkAccess chunkAccess, Function<BlockPos, Biome> toBiome, long seed, 
			Aquifer aquifer, double posX, double posY, double posZ, double horizontalMultiplier, double verticalMultiplier, float thickness, float horizontalModifier, 
			float verticalModifier, int startGen, int length, double yScale, BitSet bitSet, WorldCarver.CarveSkipChecker skipChecker) {
		Random rng = new Random(seed);
		int i = rng.nextInt(length / 2) + length / 4;
		boolean flag = rng.nextInt(6) == 0;
		float[] motionModifiers = new float[] { 0.0F, 0.0F, Mth.cos(horizontalModifier) };
		for (int j = startGen; j < length; ++j) {
			double width = 1.5D + (double) (Mth.sin((float) Math.PI * (float) j / (float) length) * thickness);
			double height = width * yScale;
			posX = this.getNextXPos(rng, posX, horizontalModifier, verticalModifier, motionModifiers);
			posY = this.getNextYPos(rng, posX, horizontalModifier, verticalModifier, motionModifiers);
			posZ = this.getNextZPos(rng, posX, horizontalModifier, verticalModifier, motionModifiers);
			horizontalModifier *= (flag ? 0.92F : 0.7F);
			horizontalModifier += motionModifiers[1] * 0.1F;
			verticalModifier += motionModifiers[0] * 0.1F;
			motionModifiers[1] *= 0.9F;
			motionModifiers[0] *= 0.75F;
			motionModifiers[1] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			motionModifiers[0] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (j == i && thickness > 1.0F) {
				this.createTunnel(context, caveConfig, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, 
						rng.nextFloat() * 0.5F + 0.5F, verticalModifier - ((float) Math.PI / 2F), horizontalModifier / 3.0F, j, length, 1.0D, bitSet, skipChecker);
				this.createTunnel(context, caveConfig, chunkAccess, toBiome, rng.nextLong(), aquifer, posX, posY, posZ, horizontalMultiplier, verticalMultiplier, 
						rng.nextFloat() * 0.5F + 0.5F, verticalModifier + ((float) Math.PI / 2F), horizontalModifier / 3.0F, j, length, 1.0D, bitSet, skipChecker);
				return;
			}
			if (rng.nextInt(4) != 0) {
				if (!canReach(chunkAccess.getPos(), posX, posZ, j, length, thickness)) {
					return;
				}
				this.carveEllipsoid(context, caveConfig, chunkAccess, toBiome, seed, aquifer, posX, posY, posZ, width * horizontalMultiplier, height * verticalMultiplier, 
						bitSet, skipChecker);
			}
		}
	}

	private boolean shouldSkip(double xOffset, double yOffset, double zOffset, double floorLevel) {
		if (yOffset <= floorLevel) {
			return true;
		} else {
			return xOffset * xOffset + yOffset * yOffset + zOffset * zOffset >= 1.0D;
		}
	}

}
