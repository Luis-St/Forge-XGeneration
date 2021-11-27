package net.luis.nero.data.provider;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;

import net.luis.nero.Nero;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class BiomeProvider implements DataProvider {
	
	protected static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	
	protected final DataGenerator generator;
	
	public BiomeProvider(DataGenerator generator) {
		this.generator = generator;
	}
	
	@Override
	public String getName() {
		return "Biomes";
	}
	
	@Override
	public void run(HashCache hashCache) throws IOException {
		Path path = this.generator.getOutputFolder();
		Set<ResourceLocation> dataBiomes = Sets.newHashSet();
		this.buildBiome((biome) -> {
			ResourceLocation location = biome.getRegistryName();
			Nero.LOGGER.info(location);
			if (!dataBiomes.add(location)) {
				throw new IllegalStateException("Duplicate biome " + location);
			} else {
				try {
					Function<Supplier<Biome>, DataResult<JsonElement>> function = JsonOps.INSTANCE.withEncoder(Biome.CODEC);
					Optional<JsonElement> optional = function.apply(() -> {
						return biome;
					}).result();
					if (optional.isPresent()) {
						Nero.LOGGER.info(path.resolve("data/" + location.getNamespace() + "/worldgen/biome/" + location.getPath() + ".json"));
						DataProvider.save(GSON, hashCache, optional.get(), path.resolve("data/" + location.getNamespace() + "/worldgen/biome/" + location.getPath() + ".json"));
					} else {
						Nero.LOGGER.error("Couldn't serialize biome {}", location);
					}
					
				} catch (IOException e) {
					Nero.LOGGER.error("Couldn't save biome {}", location, e);
				}
			}
		});
	}
	
	protected void buildBiome(Consumer<Biome> consumer) {
		
	}
	
}
