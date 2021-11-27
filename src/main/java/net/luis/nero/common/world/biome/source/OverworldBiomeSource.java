package net.luis.nero.common.world.biome.source;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;

import net.luis.nero.common.util.annotation.NotTested;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.luis.nero.init.world.biome.ModBiomes;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.newbiome.layer.Layer;

@NotTested
public class OverworldBiomeSource extends BiomeSource {

	public static final Codec<OverworldBiomeSource> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
			.xmap(OverworldBiomeSource::new, OverworldBiomeSource::getRegistry).codec();
	
	protected final Registry<Biome> registry;
	protected final long seed;
	protected final Layer surfaceLayer;
	protected final Layer undergroundLayer;
	
	public OverworldBiomeSource(Registry<Biome> registry) {
		this(registry, new Random().nextLong());
	}
	
	public OverworldBiomeSource(Registry<Biome> registry, long seed) {
		super(ModBiomeKeys.BIOMES.stream().map(ResourceKey::location).map(registry::getOptional).filter(Optional::isPresent).map(optional -> optional.get()).collect(Collectors.toList()));
		this.registry = registry;
		this.seed = seed;
		this.surfaceLayer = null;
		this.undergroundLayer = null;
	}
	
	public Registry<Biome> getRegistry() {
		return this.registry;
	}
	
	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long seed) {
		return new OverworldBiomeSource(this.registry, seed);
	}
	
	@Override
	@SuppressWarnings("removal")
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.registry.get(ModBiomes.BADLANDS.location());
	}
	
}
