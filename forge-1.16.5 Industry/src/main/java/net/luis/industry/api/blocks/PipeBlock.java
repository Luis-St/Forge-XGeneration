package net.luis.industry.api.blocks;

import net.luis.industry.init.util.tags.ModBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SixWayBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class PipeBlock extends SixWayBlock {

	public PipeBlock(Properties properties) {
		
		super(0.3125F, properties);
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		return makeConnections(context.getWorld(), context.getPos());
		
	}
	
	public BlockState makeConnections(IBlockReader blockReader, BlockPos pos) {
		
		Block down = blockReader.getBlockState(pos.down()).getBlock();
		Block up = blockReader.getBlockState(pos.up()).getBlock();
		Block north = blockReader.getBlockState(pos.north()).getBlock();
		Block east = blockReader.getBlockState(pos.east()).getBlock();
		Block south = blockReader.getBlockState(pos.south()).getBlock();
		Block west = blockReader.getBlockState(pos.west()).getBlock();
		
		return this.getDefaultState().with(DOWN, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(down)))
				.with(UP, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(up)))
				.with(NORTH, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(north)))
				.with(EAST, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(east)))
				.with(SOUTH, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(south)))
				.with(WEST, Boolean.valueOf(BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(west)));
		
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		
		boolean flag = BlockTags.getCollection().get(ModBlockTags.FLUID_SYSTEM).contains(facingState.getBlock());
		
		return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(flag));
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
		
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		
		return false;
		
	}
	
}
