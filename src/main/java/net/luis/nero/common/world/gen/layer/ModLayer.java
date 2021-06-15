package net.luis.nero.common.world.gen.layer;

import net.luis.nero.Nero;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;

public class ModLayer extends Layer {
	
	private final LazyArea area;
	
	public ModLayer(IAreaFactory<LazyArea> areaFactory) {
		super(areaFactory);
		this.area = areaFactory.make();
	}
	
	@Override
	public Biome get(Registry<Biome> biomeRegistry, int x, int z) {
		int i = this.area.get(x, z);
		RegistryKey<Biome> registrykey = getBiome(i);
		if (registrykey == null) {
			throw new IllegalStateException("Unknown biome id emitted by layers: " + i);
		} else {
			Biome biome = biomeRegistry.get(registrykey);
			if (biome == null) {
				if (SharedConstants.IS_RUNNING_IN_IDE) {
					throw Util.pauseInIde(new IllegalStateException("Unknown biome id: " + i));
				} else {
					Nero.LOGGER.warn("Unknown biome id: ", i);
					return biomeRegistry.get(BiomeRegistry.byId(0));
				}
			} else {
				return biome;
			}
		}
	}
	
	public static RegistryKey<Biome> getBiome(int keyValue) {
		RegistryKey<Biome> registrykey = null;
		if (keyValue >= 0) {
			registrykey = BiomeRegistry.byId(keyValue);
		} else {
			registrykey = ModBiomeKeys.byId(keyValue);
		}
		return registrykey;
	}
	
}
