package net.luis.nero.common.block;

import net.luis.nero.common.block.entity.BridgeBlockEntity;
import net.luis.nero.init.block.util.ModBlockEntityTypes;
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
		return new BridgeBlockEntity(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntityTypes.BRIDGE.get(), BridgeBlockEntity::serverTick);
	}
	
	@Override
	public void onPlace(BlockState newState, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
		BlockEntity tileEntity = level.getBlockEntity(pos);
		if (tileEntity instanceof BridgeBlockEntity) {
			BridgeBlockEntity bridgeTileEntity = (BridgeBlockEntity) tileEntity;
			bridgeTileEntity.setTimeExist(Mth.nextInt(level.random, 10, 30) * 20);
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean skipRendering(BlockState blockState, BlockState neighborState, Direction direction) {
		return neighborState.is(this) ? true : super.skipRendering(blockState, neighborState, direction);
	}

}
