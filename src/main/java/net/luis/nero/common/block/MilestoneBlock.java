package net.luis.nero.common.block;

import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MilestoneBlock extends Block {
	
	private static final VoxelShape SHAPE = Stream.of(Block.box(0, 0, 0, 16, 6, 16),
			Block.box(3, 13, 3, 13, 16, 13), Block.box(2, 6, 2, 14, 13, 14))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public MilestoneBlock(Properties properties) {
		super(properties);
	}
	
//	@Override
//	public boolean hasTileEntity(BlockState state) {
//		return true;
//	}
	
//	@Override
//	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//		return new MilestoneTileEntity();
//	}
	
	@Override
	public RenderShape getRenderShape(BlockState p_149645_1_) {
		return RenderShape.MODEL;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}
	
//	@Override
//	@SuppressWarnings("deprecation")
//	public void onRemove(BlockState oldState, World world, BlockPos pos, BlockState newState, boolean flag) {
//		TileEntity tileEntity = world.getBlockEntity(pos);
//		if (tileEntity instanceof MilestoneTileEntity) {
//			MilestoneTileEntity milestoneTileEntity = (MilestoneTileEntity) tileEntity;
//			InventoryHelper.dropContents((World) world, pos, milestoneTileEntity.getInventory().get());
//			if (milestoneTileEntity.isProgressing()) {
//				List<ItemStack> items = milestoneTileEntity.getRecipeProgress().getRecipe().getInput();
//				for (ItemStack itemStack : items) {
//					world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack));
//				}
//			}
//		}
//		super.onRemove(oldState, world, pos, newState, flag);
//	}
//	
//	@Override
//	@SuppressWarnings("deprecation")
//	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
//		TileEntity tileEntity = world.getBlockEntity(pos);
//		if (tileEntity instanceof MilestoneTileEntity) {
//			MilestoneTileEntity milestoneTileEntity = (MilestoneTileEntity) tileEntity;
//			if (milestoneTileEntity.canInteract(player, player.getItemInHand(hand))) {
//				milestoneTileEntity.onInteract(player, hand);
//				return ActionResultType.SUCCESS;
//			}
//		}
//		return super.use(state, world, pos, player, hand, rayTraceResult);
//	}
	
}
