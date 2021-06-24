package net.luis.nero.api.common.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class ModCanyonWorldCarver extends ModWorldCarver {
	
	protected final float[] rs = new float[1024];
	
	public ModCanyonWorldCarver() {
		super();
	}
	
	public int getCanyonYMin() {
		return 25;
	}
	
	public int getCanyonYMax() {
		return 200;
	}
	
	public int getCanyonY(Random rng) {
		return MathHelper.nextInt(rng, this.getCanyonYMin(), this.getCanyonYMax());
	}
	
	@Override
	public int getRange() {
		return 4;
	}
	
	public int calcRange(int range) {
		return (range * 2 - 1) * 16;
	}
	
	public int getCanyonLength(Random rng, int range) {
		return range - rng.nextInt(range / 4);
	}
	
	public double getCanyonWidth(Random rng, int canyonLength, int canyonMaxLength, float widthMultiplier) {
		double d = canyonLength * Math.PI / canyonMaxLength;
		double e = 1.5D + Math.sin(d) * widthMultiplier;
		double f = rng.nextFloat() * 0.25D + 0.75D;
		return e * f;
	}
	
	public double getCanyonHeight(Random rng, double canyonWidth, double heightMultiplier) {
		double d = canyonWidth * heightMultiplier;
		double e = rng.nextFloat() * 0.25 + 0.75;
		return d * e;
	}
	
	public double getNextXPos(Random rng, double oldPosX, float axisMultiplier0, float axisMultiplier1, float[] motionModifiers) {
		return oldPosX + (Math.cos(axisMultiplier0) * motionModifiers[2]);
	}
	
	public double getNextYPos(Random rng, double oldPosY, float axisMultiplier0, float axisMultiplier1, float[] motionModifiers) {
		return oldPosY + motionModifiers[3];
	}
	
	public double getNextZPos(Random rng, double oldPosZ, float axisMultiplier0, float axisMultiplier1, float[] motionModifiers) {
		return oldPosZ + (Math.sin(axisMultiplier0) * motionModifiers[2]);
	}
	
	@Override
	public boolean isStartChunk(Random rng, int chunkX, int chunkZ, ProbabilityConfig config) {
		return super.isStartChunk(rng, chunkX, chunkZ, config);
	}
	
	@Override
	public boolean carve(IChunk chunk, Function<BlockPos, Biome> toBiome, Random rng, int seaLevel, int chunkXOffset, int chunkZOffset, 
			int chunkX, int chunkZ, BitSet bitSet, ProbabilityConfig config) {
		int range = this.calcRange(this.getRange());
		double posX = chunkXOffset * 16 + rng.nextInt(16);
		double posY = this.getCanyonY(rng);
		double posZ = chunkZOffset * 16 + rng.nextInt(16);
		float firstAxisMultiplier = (float) (rng.nextFloat() * Math.PI * 2F);
		float secondAxisMultiplier = (rng.nextFloat() - 0.5F) * 2.0F / 8.0F;
		float widthMultiplier = (rng.nextFloat() * 2.0F + rng.nextFloat()) * 2.0F;
		int canyonLength = this.getCanyonLength(rng, range);
		this.genCanyon(chunk, toBiome, rng.nextLong(), seaLevel, chunkX, chunkZ, posX, posY, posZ, widthMultiplier, firstAxisMultiplier, secondAxisMultiplier, 
				canyonLength, 3.0D, bitSet);
		return true;
	}
	
	protected void genCanyon(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int seaLevel, int chunkX, int chunkZ, double posX, double posY, 
			double posZ, float widthMultiplier, float axisMultiplier0, float axisMultiplier1, int canyonMaxLength, double heightMultiplier, BitSet bitSet) {
		Random rng = new Random(seed);
		float f = 1.0F;
		for (int i = 0; i < 256; ++i) {
			if (i == 0 || rng.nextInt(3) == 0) {
				f = 1.0F + rng.nextFloat() * rng.nextFloat();
			}
			this.rs[i] = f * f;
		}
		float[] motionModifiers = new float[4];
		motionModifiers[0] = 0.0F;
		motionModifiers[1] = 0.0F;		
		for (int canyonLength = 0; canyonLength < canyonMaxLength; ++canyonLength) {
			double canyonWidth = this.getCanyonWidth(rng, canyonLength, canyonMaxLength, widthMultiplier);
			double canyonHeight = this.getCanyonHeight(rng, canyonWidth, heightMultiplier);
			motionModifiers[2] = MathHelper.cos(axisMultiplier1);
			motionModifiers[3] = MathHelper.sin(axisMultiplier1);
			posX = this.getNextXPos(rng, posX, axisMultiplier0, axisMultiplier1, motionModifiers);
			posY = this.getNextYPos(rng, posY, axisMultiplier0, axisMultiplier1, motionModifiers);
			posZ = this.getNextZPos(rng, posZ, axisMultiplier0, axisMultiplier1, motionModifiers);
			axisMultiplier0 += motionModifiers[0] * 0.05F;
			motionModifiers[1] *= 0.8F;
			motionModifiers[0] *= 0.5F;
			motionModifiers[1] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 2.0F;
			motionModifiers[0] += (rng.nextFloat() - rng.nextFloat()) * rng.nextFloat() * 4.0F;
			if (rng.nextInt(4) != 0) {
				if (!this.canReach(chunkX, chunkZ, posX, posZ, canyonLength, canyonMaxLength, widthMultiplier)) {
					return;
				}
				this.carveSphere(chunk, toBiome, seed, seaLevel, chunkX, chunkZ, posX, posY, posZ, canyonWidth, canyonHeight, bitSet);
			}
		}
	}
	
	@Override
	protected boolean skip(double d0, double d1, double d2, int i) {
		return (d0 * d0 + d2 * d2) * (double) this.rs[i - 1] + d1 * d1 / 6.0D >= 1.0D;
	}
	
}
