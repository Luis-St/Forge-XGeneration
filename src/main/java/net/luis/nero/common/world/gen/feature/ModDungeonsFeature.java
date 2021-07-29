package net.luis.nero.common.world.gen.feature;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.luis.nero.init.block.ModBlocks;
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
	protected static final BlockState DEEPSLATE_BRICKS = ModBlocks.DEEPSLATE_BRICKS.get().defaultBlockState();
	protected static final BlockState CRACKED_DEEPSLATE_BRICKS = ModBlocks.CRACKED_DEEPSLATE_BRICKS.get().defaultBlockState();
	protected static final BlockState DEEPSLATE_TILES = ModBlocks.DEEPSLATE_TILES.get().defaultBlockState();
	protected static final BlockState CRACKED_DEEPSLATE_TILES = ModBlocks.CRACKED_DEEPSLATE_TILES.get().defaultBlockState();
	
	private final Set<Block> replaceBlocks = ImmutableSet.of(ModBlocks.DEEPSLATE.get(), ModBlocks.TUFF.get());
	
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
	
	protected void setSpawner(WorldGenLevel seedReader, BlockPos center, Random rng) {
		final BlockState spawner = Blocks.SPAWNER.defaultBlockState();
		seedReader.setBlock(center, spawner, 2);
		SpawnerBlockEntity spawnerTileEntity = (SpawnerBlockEntity) seedReader.getBlockEntity(center);
		spawnerTileEntity.getSpawner().setEntityId(this.randomEntityId(rng));
	}
	
	protected EntityType<?> randomEntityId(Random rng) {
		return DungeonHooks.getRandomDungeonMob(rng);
	}
	
	protected void setChestPos(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		if (width == 2) {
			boolean northOrSouth = rng.nextBoolean();
			boolean eastOrWest = rng.nextBoolean();
			this.setChestAndLoot(seedReader, center, rng, width, northOrSouth, eastOrWest);
		} else if (width == 3) {
			boolean north = rng.nextBoolean();
			boolean east = north ? rng.nextBoolean() : true;
			boolean south = north && east ? rng.nextBoolean() : true;
			boolean west = north && east && south ? false : true;
			this.setChestAndLoot(seedReader, center, rng, width, north, east, south, west);
		} else if (width == 4) {
			this.setChestAndLoot(seedReader, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel seedReader, BlockPos center, Random rng, int width, boolean northOrSouth, boolean eastOrWest) {
		if (northOrSouth) {
			this.setNorth(seedReader, center, rng, width);
		} else {
			this.setEast(seedReader, center, rng, width);
		}
		if (eastOrWest) {
			this.setSouth(seedReader, center, rng, width);
		} else {
			this.setWest(seedReader, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel seedReader, BlockPos center, Random rng, int width, boolean north, boolean east, boolean south, boolean west) {
		if (north) {
			this.setNorth(seedReader, center, rng, width);
		} 
		if (east) {
			this.setEast(seedReader, center, rng, width);
		}
		if (south) {
			this.setSouth(seedReader, center, rng, width);
		} 
		if (west) {
			this.setWest(seedReader, center, rng, width);
		}
	}
	
	protected void setChestAndLoot(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		this.setNorth(seedReader, center, rng, width);
		this.setEast(seedReader, center, rng, width);
		this.setSouth(seedReader, center, rng, width);
		this.setWest(seedReader, center, rng, width);
	}
	
	@SuppressWarnings("deprecation")
	protected void setNorth(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.CLOCKWISE_180);
		seedReader.setBlock(center.north(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(seedReader, rng, center.north(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setEast(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.COUNTERCLOCKWISE_90);
		seedReader.setBlock(center.east(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(seedReader, rng, center.east(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setSouth(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.NONE);
		seedReader.setBlock(center.south(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(seedReader, rng, center.south(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	@SuppressWarnings("deprecation")
	protected void setWest(WorldGenLevel seedReader, BlockPos center, Random rng, int width) {
		BlockState chest = Blocks.CHEST.defaultBlockState().rotate(Rotation.CLOCKWISE_90);
		seedReader.setBlock(center.west(width), chest, 2);
		RandomizableContainerBlockEntity.setLootTable(seedReader, rng, center.west(width), BuiltInLootTables.SIMPLE_DUNGEON);
	}
	
	protected boolean canReplace(BlockState state) {
		return this.replaceBlocks.contains(state.getBlock());
	}

}
