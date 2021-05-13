package net.luis.industry.common.world.feature.config;

import java.util.Random;

import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;

public class MineshaftConfig {
	
	private final Direction direction;
	private final boolean isStartPos;
	private final boolean generateRails;
	private final boolean generatePillar;
	private final boolean generateRandomBlock;
	private final boolean generateSpawner;
	
	public MineshaftConfig(boolean isStartPos, boolean rails, boolean pillar, boolean randomBlock, boolean spawner) {
		this(Util.getRandom(Direction.values(), new Random()), isStartPos, rails, pillar, randomBlock, spawner);
	}
	
	public MineshaftConfig(Direction direction, boolean isStartPos, boolean rails, boolean pillar, boolean randomBlock, boolean spawner) {
		this.direction = direction == Direction.DOWN ? Direction.UP : direction;
		this.isStartPos = isStartPos;
		this.generateRails = rails;
		this.generatePillar = pillar;
		this.generateRandomBlock = randomBlock;
		this.generateSpawner = spawner;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Direction getRightCurve() {
		return this.direction.getClockWise();
	}
	
	public Direction getLeftCurve() {
		return this.direction.getCounterClockWise();
	}
	
	public Direction getOpposite() {
		return this.direction.getOpposite();
	}
	
	public Direction getRandomCurve(Random rng) {
		return rng.nextBoolean() ? this.getRightCurve() : this.getLeftCurve();
	}
	
	public BlockPos asBlockPos() {
		switch (this.direction) {
		case UP: return new BlockPos(0, 1, 0);
		case NORTH: return new BlockPos(0, 0, -1);
		case EAST: return new BlockPos(1, 0, 0);
		case SOUTH: return new BlockPos(0, 0, 1);
		case WEST: return new BlockPos(-1, 0, 0);
		default: throw new IllegalArgumentException();
		}
	}
	
	public BlockPos asBlockPos(BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		switch (this.direction) {
		case UP: return new BlockPos(x, y + 1, z);
		case NORTH: return new BlockPos(x, y, z - 1);
		case EAST: return new BlockPos(x + 1, y, z);
		case SOUTH: return new BlockPos(x, y, z + 1);
		case WEST: return new BlockPos(x - 1, y, z);
		default: throw new IllegalArgumentException();
		}
	}
	
	public void moveTo(BlockPos.Mutable pos) {
		pos.move(this.direction);
	}
	
	public boolean isStartPos() {
		return this.isStartPos;
	}
	
	public boolean generateRails() {
		return this.generateRails;
	}
	
	public boolean generatePillar() {
		return this.generatePillar;
	}
	
	public boolean generateRandomBlock() {
		return this.generateRandomBlock;
	}
	
	public boolean generateSpawner() {
		return this.generateSpawner;
	}

	public MineshaftConfig newWith(Direction direction) {
		return new MineshaftConfig(direction, this.isStartPos, this.generateRails, this.generatePillar, this.generateRandomBlock, this.generateSpawner);
	}
	
}
