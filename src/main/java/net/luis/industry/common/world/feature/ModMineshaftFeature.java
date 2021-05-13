package net.luis.industry.common.world.feature;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.industry.common.world.feature.config.MineshaftConfig;
import net.luis.industry.common.world.feature.placer.ModMineshaftFeatureHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

/* TODO :
 * 	- manuele generierung
 *  - enum for gen parts
 *  - edit position moving
 */
public class ModMineshaftFeature extends Feature<NoFeatureConfig> {
	
	private final BlockState caveAir = Blocks.CAVE_AIR.defaultBlockState();
	protected final List<MineshaftExtension> mineshaftExtensions = Lists.newArrayList();

	public ModMineshaftFeature() {
		super(NoFeatureConfig.CODEC);
	}

	@Override
	public boolean place(ISeedReader seedReader, ChunkGenerator chunkGenerator, @Nullable Random random, BlockPos pos, NoFeatureConfig config) {
		ChunkPos chunkPos = seedReader.getChunk(pos).getPos();
		int chunkXCenter = chunkPos.getMinBlockX() + 8;
		int chunkZCenter = chunkPos.getMinBlockZ() + 8;
		Random rng = new Random();
		Random seedRng = new Random(seedReader.getSeed() * chunkXCenter * chunkZCenter);
		if (chunkPos.x % 20 == 0 && chunkPos.z % 20 == 0) {
//			if (rng.nextInt(2) == 0) {
//				
//			}
			this.placeMineshaft(seedReader, pos, rng, seedRng);
		}
		return true;
	}
	
	protected void placeMineshaft(ISeedReader seedReader, BlockPos startPos, Random rng, Random seedRng) {
		BlockPos.Mutable pos = new BlockPos.Mutable(startPos.getX(), startPos.getY(), startPos.getZ());
		boolean isStartPos = pos.getX() == startPos.getX() && pos.getY() == startPos.getY() && pos.getZ() == startPos.getZ();
		MineshaftConfig config = new MineshaftConfig(Direction.NORTH, isStartPos, true, true, true, true);
		this.placeMainShaft(seedReader, startPos, rng, seedRng, config);
	}
	
	protected void placeMainShaft(ISeedReader seedReader, BlockPos startPos, Random rng, Random seedRng, MineshaftConfig config) {
		this.generateStartShaft(seedReader, startPos, rng, seedRng, config);
	}
	
	protected void placeShaftExtensions(ISeedReader seedReader, BlockPos.Mutable pos, Random rng, Random seedRng, MineshaftConfig config) {
		
	}
	
	protected void generateStartShaft(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, MineshaftConfig config) {
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() + 8, pos.getZ()), seedRng);
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ()), seedRng);
		this.generateCrossShaft(seedReader, pos, seedRng);
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() - 4, pos.getZ()), seedRng);
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() - 8, pos.getZ()), seedRng);
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
				seedReader.setBlock(new BlockPos(x, pos.getY() + 6, z), this.caveAir, 2);
				seedReader.setBlock(new BlockPos(x, pos.getY() + 2, z), this.caveAir, 2);
				seedReader.setBlock(new BlockPos(x, pos.getY() - 2, z), this.caveAir, 2);
				seedReader.setBlock(new BlockPos(x, pos.getY() - 6, z), this.caveAir, 2);
			}
		}
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, 6);
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, 2);
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, -2);
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, -6);
	}
	

	
	protected void generateSimpleShaft(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, MineshaftConfig config) {
		if (config.getDirection().getAxis() == Axis.X) {
			ModMineshaftFeatureHelper.generateSimpleShaftX(seedReader, pos, rng, seedRng, config);
		} else if ((config.getDirection().getAxis() == Axis.Z)) {
			ModMineshaftFeatureHelper.generateSimpleShaftZ(seedReader, pos, rng, seedRng, config);
		}
	}
	
	protected void generateCrossShaft(ISeedReader seedReader, BlockPos pos, Random seedRng) {
		for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
					seedReader.setBlock(new BlockPos(x, y, z), this.caveAir, 2);
				}
			}
		}
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++) {
					seedReader.setBlock(new BlockPos(x, y, z), this.caveAir, 2);
				}
			}
		}
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, -1);
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, 0);
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, 1);
	}
	
	protected void generateUpShaft(ISeedReader seedReader, BlockPos pos, Random seedRng) {
		this.generateCrossShaft(seedReader, pos, seedRng);
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() + 4, pos.getZ()), seedRng);
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
				seedReader.setBlock(new BlockPos(x, pos.getY() + 2, z), this.caveAir, 2);
			}
		}
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, 2);
	}
	
	protected void generateDownShaft(ISeedReader seedReader, BlockPos pos, Random seedRng) {
		this.generateCrossShaft(seedReader, pos, seedRng);
		this.generateCrossShaft(seedReader, new BlockPos(pos.getX(), pos.getY() - 4, pos.getZ()), seedRng);
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
				seedReader.setBlock(new BlockPos(x, pos.getY() - 2, z), this.caveAir, 2);
			}
		}
		ModMineshaftFeatureHelper.generateShaftFiller(seedReader, pos, -2);
	}
	
//	protected void addGenerationPart(MineshaftPart mineshaftPart, Random seedRng) {
//		if (seedRng.nextInt(4) > 1) {
//			this.generationParts.add(mineshaftPart);
//		}
//	}
	
	public static class MineshaftExtension {
		
		private BlockPos pos;
		private Direction direction;
		
		public MineshaftExtension(BlockPos pos, Direction direction) {
			this.setPos(pos);
			this.setDirection(direction);
		}

		public BlockPos getPos() {
			BlockPos.Mutable mutable = pos.mutable();
			mutable.move(this.getDirection(), 5);
			return mutable.immutable();
		}

		public void setPos(BlockPos pos) {
			this.pos = pos;
		}

		public Direction getDirection() {
			return direction;
		}

		public void setDirection(Direction direction) {
			this.direction = direction;
		}
		
	}
	
}
