package net.luis.nero.common.block.fluid;

import java.util.List;
import java.util.stream.Collectors;

import net.luis.nero.init.util.tags.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PipeBlock extends net.minecraft.world.level.block.PipeBlock {
	
	public PipeBlock(Properties properties) {
		super(0.25F, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DOWN, Boolean.valueOf(false)).setValue(UP, Boolean.valueOf(false))
				.setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false)));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return makeConnections(context.getLevel(), context.getClickedPos());
	}
	
	public BlockState makeConnections(BlockGetter blockGetter, BlockPos pos) {
		Block down = blockGetter.getBlockState(pos.below()).getBlock();
		Block up = blockGetter.getBlockState(pos.above()).getBlock();
		Block north = blockGetter.getBlockState(pos.north()).getBlock();
		Block east = blockGetter.getBlockState(pos.east()).getBlock();
		Block south = blockGetter.getBlockState(pos.south()).getBlock();
		Block west = blockGetter.getBlockState(pos.west()).getBlock();
		return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(PipeBlock.isAllowedConnection(down)))
				.setValue(UP, Boolean.valueOf(PipeBlock.isAllowedConnection(up)))
				.setValue(NORTH, Boolean.valueOf(PipeBlock.isAllowedConnection(north)))
				.setValue(EAST, Boolean.valueOf(PipeBlock.isAllowedConnection(east)))
				.setValue(SOUTH, Boolean.valueOf(PipeBlock.isAllowedConnection(south)))
				.setValue(WEST, Boolean.valueOf(PipeBlock.isAllowedConnection(west)));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		VoxelShape pipeShape = super.getShape(state, blockGetter, pos, context);
		VoxelShape dispatcherShape = Shapes.join(Block.box(2, 2, 2, 14, 14, 14), pipeShape, BooleanOp.OR);
		List<BooleanProperty> properties = PROPERTY_BY_DIRECTION.values().stream().collect(Collectors.toList());
		properties.removeIf(property -> !state.getValue(property));
		return properties.size() >= 3 ? dispatcherShape : pipeShape;
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor levelAccessor, BlockPos currentPos, BlockPos facingPos) {
		boolean flag = PipeBlock.isAllowedConnection(facingState.getBlock());
		return state.setValue(PROPERTY_BY_DIRECTION.get(facing), Boolean.valueOf(flag));	
	}
	
	public static boolean isAllowedConnection(Block block) {
		return ModBlockTags.FLUID_SYSTEM.contains(block);
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
	}
	
	@Override
	public boolean isPathfindable(BlockState state, BlockGetter blockGetter, BlockPos pos, PathComputationType pathType) {
		return false;
	}
	
}
