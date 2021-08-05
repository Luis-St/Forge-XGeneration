package net.luis.nero.common.world.gen.feature;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.common.DungeonHooks;

public class ModDungeonsFeature extends Feature<NoneFeatureConfiguration> {
	
	// allow player to change loot table and chest placement via config
	
	protected static final BlockState CAVE_AIR = Blocks.CAVE_AIR.defaultBlockState();
	protected static final BlockState DEEPSLATE_BRICKS = Blocks.DEEPSLATE_BRICKS.defaultBlockState();
	protected static final BlockState CRACKED_DEEPSLATE_BRICKS = Blocks.CRACKED_DEEPSLATE_BRICKS.defaultBlockState();
	protected static final BlockState DEEPSLATE_TILES = Blocks.DEEPSLATE_TILES.defaultBlockState();
	protected static final BlockState CRACKED_DEEPSLATE_TILES = Blocks.CRACKED_DEEPSLATE_TILES.defaultBlockState();
	
	private final Set<Block> replaceBlocks = getReplaceableBlocks();
	
	public ModDungeonsFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (context.random().nextInt(1000) == 0) {
			Random rng = new Random();
			BlockState mainStone;
			BlockState chanceStone;
			int centerX = context.origin().getX();
			int centerY = context.origin().getY();
			int centerZ = context.origin().getZ();
			int width = 2 + rng.nextInt(3);
			int height = 3 + rng.nextInt(2);
			if (centerY > 5 && centerY < 245) {
				for (int x = centerX - width; x <= centerX + width; x++) {
					for (int y = centerY; y <= centerY + height; y++) {
						for (int z = centerZ - width; z <= centerZ + width; z++) {
							BlockPos roomPos = new BlockPos(x, y, z);
							context.level().setBlock(roomPos, CAVE_AIR, 2);
						}
					}
				}
				if (rng.nextInt(10) == 0) {
					mainStone = DEEPSLATE_TILES;
					chanceStone = CRACKED_DEEPSLATE_TILES;
				} else {
					mainStone = DEEPSLATE_BRICKS;
					chanceStone = CRACKED_DEEPSLATE_BRICKS;
				}
				for (int x = centerX - width - 1; x <= centerX + width + 1; x++) {
					for (int y = centerY - 1; y <= centerY + height + 1; y++) {
						for (int z = centerZ - width - 1; z <= centerZ + width + 1; z++) {
							BlockPos roomPos = new BlockPos(x, y, z);
							int stone = rng.nextInt(4);
							if (this.canReplace(context.level().getBlockState(roomPos))) {
								if (stone == 0) {
									context.level().setBlock(roomPos, chanceStone, stone);
								} else {
									context.level().setBlock(roomPos, mainStone, stone);
								}
							}
						}
					}
				}
				this.setChestPos(context.level(), context.origin(), rng, width);
				this.setSpawner(context.level(), context.origin(), rng);
			}
		}
		return true;
	}
	
	protected void setSpawner(WorldGenLevel worldLevel, BlockPos center, Random rng) {
		final BlockState spawner = Blocks.SPAWNER.defaultBlockState();
		worldLevel.setBlock(center, spawner, 2);
		SpawnerBlockEntity spawnerBlockEntity = (SpawnerBlockEntity) worldLevel.getBlockEntity(center);
		spawnerBlockEntity.getSpawner().setEntityId(this.randomEntityId(rng));
	}
	
	protected EntityType<?> randomEntityId(Random rng) {
		return DungeonHooks.getRandomDungeonMob(rng);
	}
	
	protected void setChestPos(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		if (width == 2) {
			boolean northOrSouth = rng.nextBoolean();
			boolean eastOrWest = rng.nextBoolean();
			this.setChestAndLoot(worldLevel, center, rng, width, northOrSouth, eastOrWest);
		} else if (width == 3) {
			boolean north = rng.nextBoolean();
			boolean east = north ? rng.nextBoolean() : true;
			boolean south = north && east ? rng.nextBoolean() : true;
			boolean west = north && east && south ? false : true;
			this.setChestAndLoot(worldLevel, center, rng, width, north, east, south, west);
		} else if (width == 4) {
			this.setChestAndLoot(worldLevel, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel worldLevel, BlockPos center, Random rng, int width, boolean northOrSouth, boolean eastOrWest) {
		if (northOrSouth) {
			this.setNorth(worldLevel, center, rng, width);
		} else {
			this.setEast(worldLevel, center, rng, width);
		}
		if (eastOrWest) {
			this.setSouth(worldLevel, center, rng, width);
		} else {
			this.setWest(worldLevel, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel worldLevel, BlockPos center, Random rng, int width, boolean north, boolean east, boolean south, boolean west) {
		if (north) {
			this.setNorth(worldLevel, center, rng, width);
		} 
		if (east) {
			this.setEast(worldLevel, center, rng, width);
		}
		if (south) {
			this.setSouth(worldLevel, center, rng, width);
		} 
		if (west) {
			this.setWest(worldLevel, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		this.setNorth(worldLevel, center, rng, width);
		this.setEast(worldLevel, center, rng, width);
		this.setSouth(worldLevel, center, rng, width);
		this.setWest(worldLevel, center, rng, width);
	}
	
	@SuppressWarnings("deprecation")
	protected void setNorth(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.CLOCKWISE_180);
		worldLevel.setBlock(center.north(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(worldLevel, rng, center.north(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setEast(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.COUNTERCLOCKWISE_90);
		worldLevel.setBlock(center.east(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(worldLevel, rng, center.east(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setSouth(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.NONE);
		worldLevel.setBlock(center.south(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(worldLevel, rng, center.south(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setWest(WorldGenLevel worldLevel, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.CLOCKWISE_90);
		worldLevel.setBlock(center.west(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(worldLevel, rng, center.west(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	protected boolean canReplace(BlockState state) {
		return this.replaceBlocks.contains(state.getBlock());
	}
	
	public static Set<Block> getReplaceableBlocks() {
		return ImmutableSet.of(Blocks.DEEPSLATE, Blocks.DEEPSLATE_COAL_ORE, Blocks.DEEPSLATE_COPPER_ORE, 
				Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_LAPIS_ORE,
				Blocks.DEEPSLATE_REDSTONE_ORE,Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
	}

}
