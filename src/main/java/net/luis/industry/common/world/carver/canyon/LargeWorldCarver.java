package net.luis.industry.common.world.carver.canyon;

//import java.util.BitSet;
//import java.util.Random;
//import java.util.function.Function;
//
//import net.luis.industry.common.world.carver.cave.ModCaveWorldCarver;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.chunk.IChunk;
//
//public class LargeWorldCarver extends ModCaveWorldCarver {
//	
//	public LargeWorldCarver() {
//		super(-1);
//	}
//	
//	@Override
//	public int calcRange(int range) {
//		return (range * 2 - 1) * 4;
//	}
//	
//	@Override
//	protected int getCaveBound() {
//		return 5;
//	}
//	
//	@Override
//	protected float getThickness(Random rng) {
//		return 4.0F;
//	}
//	
//	@Override
//	protected double getYScale() {
//		return 2.2;
//	}
//	
//	@Override
//	protected int getCaveY(Random rng) {
//		return MathHelper.nextInt(rng, 160, 224);
//	}
//	
//	@Override
//	protected void genRoom(IChunk chunk, Function<BlockPos, Biome> toBiome, long seed, int j0, int j1, int j2,
//			double e0, double e1, double e2, float g0, double e3, BitSet bitSet) {
//	}
//
//}
