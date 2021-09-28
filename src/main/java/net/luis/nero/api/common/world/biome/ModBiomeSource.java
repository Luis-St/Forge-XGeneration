package net.luis.nero.api.common.world.biome;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import net.luis.nero.api.common.world.levelgen.ModChunkGenerator;
import net.luis.nero.init.world.biome.ModBiomeKeys;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;

public abstract class ModBiomeSource extends BiomeSource {
	
	protected final Registry<Biome> registry;
	protected final long seed;
	private Optional<ModChunkGenerator> chunkGenerator;
	
	protected ModBiomeSource(Registry<Biome> registry, long seed) {
		super(ModBiomeKeys.BIOMES.stream().map(ResourceKey::location).map(registry::getOptional).filter(Optional::isPresent).map(optional -> optional.get()).collect(Collectors.toList()));
		this.registry = registry;
		this.seed = seed;
	}
	
	public Registry<Biome> getRegistry() {
		return this.registry;
	}

	protected ModChunkGenerator getChunkGenerator() {
		return this.chunkGenerator.orElseThrow(NullPointerException::new);
	}

	public void setChunkGenerator(ModChunkGenerator chunkGenerator) {
		this.chunkGenerator = Optional.of(chunkGenerator);
	}
	
	@Nullable
	public IBiome getIBiome(int x, int y, int z) {
		return IBiome.byVanilla(this.getNoiseBiome(x, y, z));
	}
	
} 
