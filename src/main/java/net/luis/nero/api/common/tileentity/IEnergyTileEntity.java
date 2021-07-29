package net.luis.nero.api.common.tileentity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergyTileEntity<T extends BlockEntity> extends IEnergyStorage {
	
	default void onEnergyReceive(T tileEntity, int receive) {
		
	}
	
	default void onEnergyExtract(T tileEntity, int extract) {
		
	}

}
