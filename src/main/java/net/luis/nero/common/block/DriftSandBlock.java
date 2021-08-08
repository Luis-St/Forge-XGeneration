package net.luis.nero.common.block;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DriftSandBlock extends SandBlock {

	public DriftSandBlock(int dustColor, Properties properties) {
		super(dustColor, properties);
	}
	
	public boolean skipRendering(BlockState state, BlockState neighborState, Direction direction) {
		return neighborState.is(this) ? true : false;
	}
	
	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter blockGetter, BlockPos pos) {
		return Shapes.empty();
	}
	
	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		if (context instanceof EntityCollisionContext) {
			EntityCollisionContext entityContext = (EntityCollisionContext) context;
			Optional<Entity> optionalEntity = entityContext.getEntity();
			if (optionalEntity.isPresent()) {
				if (optionalEntity.get() instanceof FallingBlockEntity) {
					return Shapes.block();
				}
			}
		}
		return Shapes.empty();
	}
	
	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity || entity instanceof ItemEntity) {
			entity.makeStuckInBlock(state, new Vec3(0.75, 0.05, 0.75));
		}
	}
	
	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		entity.fallDistance = 0;
	}
	
	@Override
	public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
		entity.fallDistance = 0;
	}
	

	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter blockGetter, BlockPos pos, PathComputationType pathType) {
		return true;
	}

}
