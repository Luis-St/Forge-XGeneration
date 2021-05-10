package net.luis.industry.common.world.carver.cave;

//import java.util.Random;
//
//public class DeepCaveWorldCarver extends ModCaveWorldCarver {
//
//	public DeepCaveWorldCarver() {
//		super(14);
//	}
//	
//	@Override
//	public int getRange() {
//		return 3;
//	}
//	
//	@Override
//	public int calcRange(int range) {
//		return (range * 2 - 1) * 10;
//	}
//	
//	@Override
//	protected int getCaveBound() {
//		return 20;
//	}
//
//	@Override
//	protected float getThickness(Random rng) {
//		return super.getThickness(rng) * (rng.nextFloat() + 0.5F);
//	}
//	
//	@Override
//	protected double getYScale() {
//		Random rng = new Random();
//		return 0.9 + (rng.nextFloat() / 2);
//	}
//	
//	@Override
//	protected int getCaveY(Random rng) {
//		return 40 - rng.nextInt(8);
//	}
//	
//}
