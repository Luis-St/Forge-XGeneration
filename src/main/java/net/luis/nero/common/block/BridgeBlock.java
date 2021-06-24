package net.luis.nero.common.block;

import net.luis.nero.common.tileentity.BridgeTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BridgeBlock extends BreakableBlock {

	public BridgeBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BridgeTileEntity();
	}
	
	@Override
	public void onPlace(BlockState newState, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
		TileEntity tileEntity = world.getBlockEntity(pos);
		if (tileEntity instanceof BridgeTileEntity) {
			BridgeTileEntity bridgeTileEntity = (BridgeTileEntity) tileEntity;
			bridgeTileEntity.setTimeExist(MathHelper.nextInt(world.random, 10, 30) * 20);
		}
	}

}
