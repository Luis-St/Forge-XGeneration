package net.luis.industry.api.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergy<T extends TileEntity> extends IEnergyStorage {
	
	default void onEnergyReceive(T tileEntity, int receive) {
		
	}
	
	default void onEnergyExtract(T tileEntity, int extract) {
		
	}

}
