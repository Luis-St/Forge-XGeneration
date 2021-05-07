package net.luis.industry.common.world.dimension;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.mojang.serialization.Codec;

import net.luis.industry.init.world.ModBiomes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

public class DeepslateBiomeProvider extends BiomeProvider {

    public static final Codec<DeepslateBiomeProvider> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
            .xmap(DeepslateBiomeProvider::new, DeepslateBiomeProvider::getBiomeRegistry).codec();

    private final Biome biome;
    private final Registry<Biome> biomeRegistry;
    private static final List<RegistryKey<Biome>> SPAWN = Collections.singletonList(ModBiomes.DEEPSLATE_CAVE);

    public DeepslateBiomeProvider(Registry<Biome> biomeRegistry) {
        super(getStartBiomes(biomeRegistry));
        this.biomeRegistry = biomeRegistry;
        biome = biomeRegistry.get(ModBiomes.DEEPSLATE_CAVE.location());
    }

    private static List<Biome> getStartBiomes(Registry<Biome> registry) {
        return DeepslateBiomeProvider.SPAWN.stream().map(s -> registry.get(s.location())).collect(Collectors.toList());
    }

    public Registry<Biome> getBiomeRegistry() {
        return this.biomeRegistry;
    }

    @Override
    public boolean canGenerateStructure(Structure<?> structure) {
        return false;
    }

    @Override
    protected Codec<? extends BiomeProvider> codec() {
        return DeepslateBiomeProvider.CODEC;
    }

    @Override
    public BiomeProvider withSeed(long seed) {
        return this;
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return this.biome;
    }
}