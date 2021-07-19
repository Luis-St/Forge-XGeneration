package net.luis.nero.common.block;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class DriftSandBlock extends SandBlock {

	// TODO: copy logic from 1.17 powder snow block

	public DriftSandBlock(int dustColor, Properties properties) {
		super(dustColor, properties);
	}

	@Override
	public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
		return PathNodeType.WALKABLE;
	}

	@Override
	public void fallOn(World world, BlockPos pos, Entity entity, float fallDistance) {
		entity.fallDistance = 0;
	}

	@Override
	public void stepOn(World world, BlockPos pos, Entity entity) {
		entity.fallDistance = 0;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) {
		if (!(blockReader.getBlockState(pos.above()).getBlock() instanceof AirBlock)) {
			return VoxelShapes.block();
		}
		return VoxelShapes.empty();
	}

}
