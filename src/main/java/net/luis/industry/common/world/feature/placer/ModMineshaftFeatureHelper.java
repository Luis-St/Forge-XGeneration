package net.luis.industry.common.world.feature.placer;

import java.util.List;
import java.util.Random;

import net.luis.industry.common.world.feature.config.MineshaftConfig;
import net.luis.industry.init.block.ModBlocks;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

public class ModMineshaftFeatureHelper {
	
	protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
	protected static final BlockState OAK_PLANKS = Blocks.OAK_PLANKS.defaultBlockState();
	protected static final BlockState OAK_FENCE = Blocks.OAK_FENCE.defaultBlockState();
	protected static final BlockState TORCH = Blocks.WALL_TORCH.defaultBlockState();
	protected static final BlockState COBWEB = Blocks.COBWEB.defaultBlockState();
	protected static final BlockState RAIL = Blocks.RAIL.defaultBlockState();
	
	protected static final List<Block> DEEP_ORES = List.of(ModBlocks.DEEPSLATE_DIAMOND_ORE.get(), ModBlocks.DEEPSLATE_REDSTONE_ORE.get(),
			ModBlocks.DEEPSLATE_EMERALD_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get());
	protected static final List<Block> MIDDLE_ORES = List.of(ModBlocks.DEEPSLATE_GOLD_ORE.get(), ModBlocks.DEEPSLATE_LAPIS_ORE.get(),
			ModBlocks.DEEPSLATE_EMERALD_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get());
	protected static final List<Block> TOP_ORES = List.of(ModBlocks.DEEPSLATE_COPPER_ORE.get(), ModBlocks.DEEPSLATE_COAL_ORE.get(),
			ModBlocks.DEEPSLATE_EMERALD_ORE.get(), ModBlocks.DEEPSLATE_IRON_ORE.get());
	
	public static void generateShaftFiller(ISeedReader seedReader, BlockPos pos, int y) {
		seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() + y, pos.getZ() + 1), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() + y, pos.getZ() - 1), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() + y, pos.getZ() - 1), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() + y, pos.getZ() + 1), OAK_PLANKS, 2);
	}
	
	public static void generateSimpleShaftX(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, MineshaftConfig config) {
		for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 1; z <= pos.getZ() + 1; z++) {
					seedReader.setBlock(new BlockPos(x, y, z), CAVE_AIR, 2);
				}
			}
		}
		if (config.generateRails()) {
			generateRailX(seedReader, pos, rng, seedRng);
		}
		if (config.generatePillar()) {
			generatePillarX(seedReader, pos, rng, seedRng, config.generateSpawner());
		}
		if (config.generateRandomBlock()) {
			generateRandomBlock(seedReader, pos, rng, seedRng);
		}
		if (config.generateSpawner()) {
			generateSpawner(seedReader, pos, rng, seedRng);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected static void generatePillarX(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, boolean spawner) {
		BlockState torchEast = TORCH.rotate(Rotation.CLOCKWISE_90);
		BlockState torchWest = TORCH.rotate(Rotation.COUNTERCLOCKWISE_90);;
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1), OAK_FENCE, 2);
		if (seedRng.nextInt(2) == 0 && !spawner) {
			seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ()), torchEast, 2);
		}
		if (seedRng.nextInt(2) == 0 && !spawner) {
			seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), torchWest, 2);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected static void generateRailX(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng) {
		BlockState rail = RAIL.rotate(Rotation.CLOCKWISE_90);
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX() + 2, pos.getY() - 1, pos.getZ()), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ()), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ()), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX() - 2, pos.getY() - 1, pos.getZ()), rail, 2);
		}
	}
	
	public static void generateSimpleShaftZ(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, MineshaftConfig config) {
		for (int x = pos.getX() - 1; x <= pos.getX() + 1; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++) {
					seedReader.setBlock(new BlockPos(x, y, z), CAVE_AIR, 2);
				}
			}
		}
		if (config.generateRails()) {
			generateRailZ(seedReader, pos, rng, seedRng);
		}
		if (config.generatePillar()) {
			generatePillarZ(seedReader, pos, rng, seedRng, config.generateSpawner());
		}
		if (config.generateRandomBlock()) {
			generateRandomBlock(seedReader, pos, rng, seedRng);
		}
		if (config.generateSpawner()) {
			generateSpawner(seedReader, pos, rng, seedRng);
		}
	}
	
	@SuppressWarnings("deprecation")
	protected static void generatePillarZ(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng, boolean spawner) {
		BlockState torchNorth = TORCH.rotate(Rotation.NONE);
		BlockState torchSouth = TORCH.rotate(Rotation.CLOCKWISE_180);
		seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ()), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ()), OAK_PLANKS, 2);
		seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX() + 1, pos.getY() - 1, pos.getZ()), OAK_FENCE, 2);
		seedReader.setBlock(new BlockPos(pos.getX() - 1, pos.getY() - 1, pos.getZ()), OAK_FENCE, 2);
		if (seedRng.nextInt(2) == 0 && !spawner) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1), torchSouth, 2);
		}
		if (seedRng.nextInt(2) == 0 && !spawner) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1), torchNorth, 2);
		}
	}
	

	
	@SuppressWarnings("deprecation")
	protected static void generateRailZ(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng) {
		BlockState rail = RAIL.rotate(Rotation.NONE);
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 2), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() + 1), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 1), rail, 2);
		}
		if (seedRng.nextInt(3) == 0) {
			seedReader.setBlock(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ() - 2), rail, 2);
		}
	}
	
	protected static void generateRandomBlock(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng) {
		for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++) {
					if (seedReader.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof AirBlock) {
						if (seedRng.nextInt(10) > 8 && y == pos.getY() + 1) {
							Block randomBlock = getRandomBlock(seedRng, y);
							seedReader.setBlock(new BlockPos(x, y, z), randomBlock.defaultBlockState(), 2);
						}
					}
				}
			}
		}
	}
	
	protected static Block getRandomBlock(Random seedRng, int y) {
		if (0 > y || seedRng.nextInt(5) > 1) {
			return COBWEB.getBlock();
		} else {
			if (y >= 176) {
				return TOP_ORES.get(seedRng.nextInt(TOP_ORES.size()));
			} else if (y >= 80) {
				return MIDDLE_ORES.get(seedRng.nextInt(MIDDLE_ORES.size()));
			} else {
				return DEEP_ORES.get(seedRng.nextInt(DEEP_ORES.size()));
			}
		}
	}
	
	protected static void generateSpawner(ISeedReader seedReader, BlockPos pos, Random rng, Random seedRng) {
		seedReader.setBlock(pos.below(), Blocks.SPAWNER.defaultBlockState(), 2);
		MobSpawnerTileEntity spawnerTileEntity = (MobSpawnerTileEntity) seedReader.getBlockEntity(pos.below());
		spawnerTileEntity.getSpawner().setEntityId(EntityType.CAVE_SPIDER);
		for (int x = pos.getX() - 2; x <= pos.getX() + 2; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = pos.getZ() - 2; z <= pos.getZ() + 2; z++) {
					if (seedReader.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof AirBlock) {
						if (seedRng.nextInt(10) > 3) {
							seedReader.setBlock(new BlockPos(x, y, z), COBWEB, 2);
						}
					}
				}
			}
		}
	}

}
