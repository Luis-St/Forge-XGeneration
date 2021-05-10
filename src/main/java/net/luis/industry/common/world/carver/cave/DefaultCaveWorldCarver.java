package net.luis.industry.common.world.carver.cave;

//import java.util.Random;
//
//import net.minecraft.util.math.MathHelper;
//
//public class DefaultCaveWorldCarver extends ModCaveWorldCarver {
//	
//	private float thickness = -1;
//	
//	public DefaultCaveWorldCarver() {
//		super(-1);
//	}
//	
//	@Override
//	protected float getThickness(Random rng) {
//		float f = super.getThickness(rng) * 1.5F + 0.5F;
//		float g = super.getThickness(rng) + rng.nextFloat();
//		float h = f * g + rng.nextFloat() * rng.nextFloat();
//		float i = h + rng.nextFloat() + 0.5F;
//		float j = i * (rng.nextFloat() + 0.5F);
//		if (j > 7) {
//			j *= (rng.nextFloat() + 0.1F);
//		}
//		this.thickness = j;
//		return j;
//	}
//	
//	@Override
//	protected double getYScale() {
//		Random rng = new Random();
//		float f = 0 > this.thickness ? this.getThickness(rng) : this.thickness;
//		double d = f / 10;
//		double e = 1.0 - d;
//		return e + 0.3;
//	}
//	
//	@Override
//	protected int getCaveY(Random rng) {
//		return MathHelper.nextInt(rng, 64 - rng.nextInt(16), 160 + rng.nextInt(16));
//	}
//	
//}
