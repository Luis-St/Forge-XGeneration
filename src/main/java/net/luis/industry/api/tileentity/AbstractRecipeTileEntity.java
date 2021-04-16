package net.luis.industry.api.tileentity;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class AbstractRecipeTileEntity extends TileEntity implements ITickableTileEntity {

	public AbstractRecipeTileEntity(TileEntityType<?> type) {
		
		super(type);
		
	}

	@Override
	public abstract void tick();

}
