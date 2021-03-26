package net.luis.industry.common.blocks.mechanical;

import java.util.stream.Stream;

import net.luis.industry.common.tileentities.MilestoneTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class MilestoneBlock extends Block {
	
	private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(0, 0, 0, 16, 6, 16),
			Block.makeCuboidShape(3, 13, 3, 13, 16, 13), Block.makeCuboidShape(2, 6, 2, 14, 13, 14))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

	public MilestoneBlock(Properties properties) {
		
		super(properties);
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		
		return new MilestoneTileEntity();
		
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		
		return BlockRenderType.MODEL;
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		return SHAPE;
		
	}
	
//	@Override
//	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//		
//		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//		
//	}
	
}
