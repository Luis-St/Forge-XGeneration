package net.luis.nero.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DriftSandBlock extends SandBlock {

	// TODO: copy logic from 1.17 powder snow block

	public DriftSandBlock(int dustColor, Properties properties) {
		super(dustColor, properties);
	}

	@Override
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.WALKABLE;
	}

	@Override
	public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		entity.fallDistance = 0;
	}
	
	@Override
	public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
		entity.fallDistance = 0;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter blockReader, BlockPos pos, CollisionContext context) {
		if (!(blockReader.getBlockState(pos.above()).getBlock() instanceof AirBlock)) {
			return Shapes.block();
		}
		return Shapes.empty();
	}

}
