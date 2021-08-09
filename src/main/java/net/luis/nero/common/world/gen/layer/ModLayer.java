package net.luis.nero.common.world.gen.layer;

import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.Biomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.newbiome.area.AreaFactory;
import net.minecraft.world.level.newbiome.area.LazyArea;
import net.minecraft.world.level.newbiome.layer.Layer;

public class ModLayer extends Layer {
	
	private final LazyArea area;
	
	public ModLayer(AreaFactory<LazyArea> areaFactory) {
		super(areaFactory);
		this.area = areaFactory.make();
	}
	
	@Override
	public Biome get(Registry<Biome> registry, int x, int z) {
		int i = this.area.get(x, z);
		ResourceKey<Biome> resourceKey = getBiome(i);
		if (resourceKey == null) {
			throw new IllegalStateException("Unknown biome id emitted by layers: " + i);
		} else {
			Biome biome = registry.get(resourceKey);
			if (biome == null) {
				if (SharedConstants.IS_RUNNING_IN_IDE) {
					throw Util.pauseInIde(new IllegalStateException("Unknown biome id: " + i));
				} else {
//					Nero.LOGGER.warn("Unknown biome id: {}", i);
					return registry.get(Biomes.byId(0));
				}
			} else {
				return biome;
			}
		}
	}
	
	public static ResourceKey<Biome> getBiome(int keyValue) {
		ResourceKey<Biome> resourceKey = null;
		if (keyValue >= 0) {
			resourceKey = Biomes.byId(keyValue);
		} else {
			resourceKey = ModBiomeKeys.byId(keyValue);
		}
		return resourceKey;
	}
	
}
