package net.luis.nero.common.block;

import net.luis.nero.common.tileentity.BridgeTileEntity;
import net.luis.nero.init.block.util.ModTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BridgeBlock extends BaseEntityBlock {

	public BridgeBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new BridgeTileEntity(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> blockEntityType) {
		return world.isClientSide ? null : createTickerHelper(blockEntityType, ModTileEntityTypes.BRIDGE.get(), BridgeTileEntity::serverTick);
	}
	
	@Override
	public void onPlace(BlockState newState, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
		BlockEntity tileEntity = world.getBlockEntity(pos);
		if (tileEntity instanceof BridgeTileEntity) {
			BridgeTileEntity bridgeTileEntity = (BridgeTileEntity) tileEntity;
			bridgeTileEntity.setTimeExist(Mth.nextInt(world.random, 10, 30) * 20);
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean skipRendering(BlockState blockState, BlockState neighborState, Direction direction) {
		return neighborState.is(this) ? true : super.skipRendering(blockState, neighborState, direction);
	}

}
