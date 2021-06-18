package net.luis.nero.common.world.gen.feature.structure;

import java.util.Random;
import java.util.function.BiPredicate;

import net.luis.nero.api.world.gen.feature.structure.ModStructurePiece;
import net.luis.nero.init.world.gen.feature.structure.ModStructurePieceTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RailBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.RailShape;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class DeepslateMineshaftStructurePiece extends ModStructurePiece {
	
	// TODO: (not final) DeepslateMineshaftStructurePiece -> DeepslateMineshaftPieces & abstract add base methodes handle gen in generatePieces in Start Factory
	
	protected static final BlockState OAK_PLANKS = Blocks.OAK_PLANKS.defaultBlockState();
	protected static final BlockState OAK_FENCE = Blocks.OAK_FENCE.defaultBlockState();
	protected static final BlockState COBWEB = Blocks.COBWEB.defaultBlockState();
	protected static final BlockState TORCH_NORTH = Blocks.WALL_TORCH.defaultBlockState().setValue(WallTorchBlock.FACING, Direction.NORTH);
	protected static final BlockState TORCH_EAST = Blocks.WALL_TORCH.defaultBlockState().setValue(WallTorchBlock.FACING, Direction.EAST);
	protected static final BlockState TORCH_SOUTH = Blocks.WALL_TORCH.defaultBlockState().setValue(WallTorchBlock.FACING, Direction.SOUTH);
	protected static final BlockState TORCH_WEST = Blocks.WALL_TORCH.defaultBlockState().setValue(WallTorchBlock.FACING, Direction.WEST);
	protected static final BlockState RAIL_X = Blocks.RAIL.defaultBlockState().setValue(RailBlock.SHAPE, RailShape.EAST_WEST);
	protected static final BlockState RAIL_Z = Blocks.RAIL.defaultBlockState().setValue(RailBlock.SHAPE, RailShape.NORTH_SOUTH);
	
	protected static final BiPredicate<ISeedReader, Random> RAIL_PREDICATE = (seedReader, rng) -> {
		rng.setSeed(seedReader.getSeed());
		return rng.nextInt(10) > 6;
	};
	protected static final BiPredicate<ISeedReader, Random> COBWEB_PREDICATE = (seedReader, rng) -> {
		rng.setSeed(seedReader.getSeed());
		return rng.nextInt(10) > 7;
	};
	protected static final BiPredicate<ISeedReader, Random> SPAWNER_COBWEB_PREDICATE = (seedReader, rng) -> {
		rng.setSeed(seedReader.getSeed());
		return rng.nextInt(10) > 1;
	};
	protected static final BiPredicate<ISeedReader, Random> CHEST_MINECART_PREDICATE = (seedReader, rng) -> {
		rng.setSeed(seedReader.getSeed());
		return rng.nextInt(100) == 0;
	};
	
	public DeepslateMineshaftStructurePiece(Random rng, int x, int y, int z) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, rng, x, y, z);
		this.setRotationAndMirror();
	}

	public DeepslateMineshaftStructurePiece(TemplateManager templateManager, CompoundNBT nbt) {
		super(ModStructurePieceTypes.DEEPSLATE_MINESHAFT, templateManager, nbt);
		this.setRotationAndMirror();
	}
	
	private void setRotationAndMirror() {
		ObfuscationReflectionHelper.setPrivateValue(StructurePiece.class, this, Rotation.NONE, "field_186169_c");
		ObfuscationReflectionHelper.setPrivateValue(StructurePiece.class, this, Mirror.NONE, "field_186168_b");
	}
	
	@Override
	public boolean postProcess(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rng, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
		this.placeShaftX(seedReader, boundingBox, 0, 0, 0, rng, true, false, false, false, false);
		return true;
	}
	
	protected void spawnChestMinecart(ISeedReader seedReader, MutableBoundingBox boundingBox, int x, int y, int z, Random rng) {
		ChestMinecartEntity chestMinecart = new ChestMinecartEntity(seedReader.getLevel(), x, y, z);
		chestMinecart.setLootTable(LootTables.ABANDONED_MINESHAFT, rng.nextLong());
		this.placeBlock(seedReader, rng.nextBoolean() ? RAIL_X : RAIL_Z, x, y, z, boundingBox);
		seedReader.addFreshEntity(chestMinecart);
	}
	
	protected void updateBlock(ISeedReader seedReader, int x, int y, int z, Random rng) {
		seedReader.getChunk(new BlockPos(x, y, z)).markPosForPostprocessing(new BlockPos(x, y, z));
	}
	
	// x -> do things on z
	private void placeShaftX(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, 
			boolean rail, boolean rngCobweb, boolean spawnerCobweb, boolean spawner, boolean chestMinecrat) {
		this.generateAirCube(seedReader, boundingBox, xIn - 2, yIn - 1, zIn - 1, xIn + 2, yIn + 1, zIn + 1);
		this.placeBlock(seedReader, OAK_PLANKS, xIn, yIn + 1, zIn, boundingBox);
		this.placeBlock(seedReader, TORCH_EAST, xIn + 1, yIn + 1, zIn, boundingBox);
		this.placeBlock(seedReader, TORCH_WEST, xIn - 1, yIn + 1, zIn, boundingBox);
		this.placeBlock(seedReader, OAK_PLANKS, xIn, yIn + 1, zIn - 1, boundingBox);
		this.placeBlock(seedReader, OAK_PLANKS, xIn, yIn + 1, zIn + 1, boundingBox);
		this.placeBlock(seedReader, OAK_FENCE, xIn, yIn, zIn - 1, boundingBox);
		this.placeBlock(seedReader, OAK_FENCE, xIn, yIn, zIn + 1, boundingBox);
		this.placeBlock(seedReader, OAK_FENCE, xIn, yIn - 1, zIn - 1, boundingBox);
		this.placeBlock(seedReader, OAK_FENCE, xIn, yIn - 1, zIn + 1, boundingBox);
		if (rail) {
			for (int x = -2; x < 3; x++) {
				if (RAIL_PREDICATE.test(seedReader, rng)) {
					this.placeBlock(seedReader, RAIL_X, xIn + x, yIn - 1, zIn, boundingBox);
				}
			}
		}
		if (rngCobweb) {
			for (int x = -2; x <= 2; x++) {
				for (int z = -1; z <= 1; z++) {
					if (COBWEB_PREDICATE.test(seedReader, rng)) {
						this.placeBlock(seedReader, COBWEB, xIn + x, yIn + 1, zIn + z, boundingBox);
					}
				}
			}
		}
		if (spawnerCobweb) {
			for (int x = -2; x <= 2; x++) {
				for (int y = -1; y <= 1; y++) {
					for (int z = -1; z <= 1; z++) {
						if (SPAWNER_COBWEB_PREDICATE.test(seedReader, rng) && (x != xIn && y != yIn - 1 && z != zIn)) {
							this.placeBlock(seedReader, COBWEB, xIn + x, yIn + y, zIn + z, boundingBox);
						}
					}
				}
			}
		}
		if (spawner) {
			this.placeBlock(seedReader, Blocks.SPAWNER.defaultBlockState(), xIn, yIn - 1, zIn, boundingBox);
			MobSpawnerTileEntity spawnerTileEntity = (MobSpawnerTileEntity) seedReader.getBlockEntity(new BlockPos(xIn, yIn - 1, zIn));
			spawnerTileEntity.getSpawner().setEntityId(EntityType.CAVE_SPIDER);
		}
		if (chestMinecrat) {
			for (int x = -2; x <= 2; x++) {
				for (int z = -1; z <= 1; z++) {
					if (CHEST_MINECART_PREDICATE.test(seedReader, rng)) {
						this.spawnChestMinecart(seedReader, boundingBox, x, yIn, z, rng);
					}
				}
			}
		}
	}
	
	// z -> do things on x
	private void placeShaftZ(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, 
			boolean rail, boolean rngCobweb, boolean spawnerCobweb, boolean spawner, boolean chestMinecrat) {
	}
	
	private void placeShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, 
			boolean rail, boolean rngCobweb, boolean spawnerCobweb, boolean spawner, boolean chestMinecrat, Direction direction) {
		if (direction.getAxis() == Axis.X) {
			this.placeShaftX(seedReader, boundingBox, xIn, zIn, yIn, rng, rail, rngCobweb, spawnerCobweb, spawner, chestMinecrat);
		} else if (direction.getAxis() == Axis.Z) {
			this.placeShaftZ(seedReader, boundingBox, xIn, zIn, yIn, rng, rail, rngCobweb, spawnerCobweb, spawner, chestMinecrat);
		}
	}
	
	protected void placeDefaultShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, Direction direction) {
		this.placeShaft(seedReader, boundingBox, xIn, yIn, zIn, rng, true, true, false, false, true, direction);
	}
	
	protected void placeSpawnerShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, Direction direction) {
		this.placeShaft(seedReader, boundingBox, xIn, yIn, zIn, rng, true, false, true, true, false, direction);
	}
	
	protected void placeChestMinecratShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng, Direction direction) {
		this.placeShaft(seedReader, boundingBox, xIn, yIn, zIn, rng, true, false, false, false, true, direction);
	}
	
	// TODO: base shaft (part shaft 3 hight, 3 width, 1 length) -> move to direction (check also axis)
	protected void placeStairsUpShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, BlockPos pos, Random rng, Direction direction) {
		
	}
	
	// TODO: base shaft (part shaft 3 hight, 3 width, 1 length) -> move to direction (check also axis)
	protected void placeStairsDownShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, BlockPos pos, Random rng, Direction direction) {
		
	}
	
	private void placeCross(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int zIn, int yStart, int yEnd, Random rng) {
		int xMin = xIn - 1;
		int yMin = yStart - 1;
		int zMin = zIn - 1;
		int xMax = xIn + 1;
		int yMax = yEnd + 1;
		int zMax = zIn + 1;
		this.generateCube(seedReader, boundingBox, xMin, yMin, zMin, xMax, yMax, zMax, CAVE_AIR);
		for (int x = xMin; x <= xMax; x++) {
			for (int y = yMin; y <= yMax; y++) {
				for (int z = zMin; z <= zMax; z++) {
					if (x == xMin && z == zMin) {
						this.placeBlock(seedReader, OAK_PLANKS, x, y, z, boundingBox);
					} else if (x == xMin && z == zMax) {
						this.placeBlock(seedReader, OAK_PLANKS, x, y, z, boundingBox);
					} else if (x == xMax && z == zMax) {
						this.placeBlock(seedReader, OAK_PLANKS, x, y, z, boundingBox);
					} else if (x == xMax && z == zMin) {
						this.placeBlock(seedReader, OAK_PLANKS, x, y, z, boundingBox);
					}
				}
			}
		}
	}
	
	protected void placeDefaultCrossShaft(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng) {
		this.placeCross(seedReader, boundingBox, xIn, zIn, yIn, yIn, rng);
	}

	protected void placeCrossShaftUp(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng) {
		this.placeCross(seedReader, boundingBox, xIn, zIn, yIn, yIn + 4, rng);
	}

	protected void placeCrossShaftDown(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int yIn, int zIn, Random rng) {
		this.placeCross(seedReader, boundingBox, xIn, zIn, yIn - 4, yIn, rng);
	}
	
	protected void placeCrossShaftWithSize(ISeedReader seedReader, MutableBoundingBox boundingBox, int xIn, int zIn, int yIn, int yUp,
			int yDown, Random rng) {
		this.placeCross(seedReader, boundingBox, xIn, zIn, yIn - yDown + 2, yIn + yUp - 2, rng);
	}
	
	@Override
	protected void placeBlock(ISeedReader seedReader, BlockState blockState, int x, int y, int z, MutableBoundingBox boundingBox) {
		BlockPos pos = new BlockPos(this.getWorldX(x, z), this.getWorldY(y), this.getWorldZ(x, z));
		if (boundingBox.isInside(pos)) {
			seedReader.setBlock(pos, blockState, 2);
		}
	}
	
}