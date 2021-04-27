package net.luis.industry.common.block.fluid;

import java.util.List;
import java.util.stream.Collectors;

import net.luis.industry.init.util.tags.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SixWayBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class PipeBlock extends SixWayBlock {

	public PipeBlock(Properties properties) {
		super(0.25F, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(DOWN, Boolean.valueOf(false)).setValue(UP, Boolean.valueOf(false))
				.setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false)));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return makeConnections(context.getLevel(), context.getClickedPos());
	}
	
	public BlockState makeConnections(IBlockReader blockReader, BlockPos pos) {
		Block down = blockReader.getBlockState(pos.below()).getBlock();
		Block up = blockReader.getBlockState(pos.above()).getBlock();
		Block north = blockReader.getBlockState(pos.north()).getBlock();
		Block east = blockReader.getBlockState(pos.east()).getBlock();
		Block south = blockReader.getBlockState(pos.south()).getBlock();
		Block west = blockReader.getBlockState(pos.west()).getBlock();
		return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(PipeBlock.isAllowedConnection(down)))
				.setValue(UP, Boolean.valueOf(PipeBlock.isAllowedConnection(up)))
				.setValue(NORTH, Boolean.valueOf(PipeBlock.isAllowedConnection(north)))
				.setValue(EAST, Boolean.valueOf(PipeBlock.isAllowedConnection(east)))
				.setValue(SOUTH, Boolean.valueOf(PipeBlock.isAllowedConnection(south)))
				.setValue(WEST, Boolean.valueOf(PipeBlock.isAllowedConnection(west)));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VoxelShape pipeShape = super.getShape(state, worldIn, pos, context);
		VoxelShape dispatcherShape = VoxelShapes.join(Block.box(2, 2, 2, 14, 14, 14), pipeShape, IBooleanFunction.OR);
		List<BooleanProperty> properties = PROPERTY_BY_DIRECTION.values().stream().collect(Collectors.toList());
		properties.removeIf(property -> !state.getValue(property));
		return properties.size() >= 3 ? dispatcherShape : pipeShape;
	}
	
	
	
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		boolean flag = PipeBlock.isAllowedConnection(facingState.getBlock());
		return stateIn.setValue(PROPERTY_BY_DIRECTION.get(facing), Boolean.valueOf(flag));	
	}
	
	public static boolean isAllowedConnection(Block block) {
		return BlockTags.getAllTags().getTag(ModBlockTags.FLUID_SYSTEM).contains(block);
	}
	
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
	}
	
	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
	
}
