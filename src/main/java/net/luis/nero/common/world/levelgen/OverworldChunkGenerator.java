package net.luis.nero.common.world.levelgen;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;

import net.luis.nero.common.util.annotation.NotTested;
import net.luis.nero.common.world.biome.IBiome;
import net.luis.nero.common.world.biome.biomes.vanilla.overworld.OverworldBiome;
import net.luis.nero.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.common.world.biome.source.OverworldBiomeSource;
import net.luis.nero.common.world.levelgen.newsurfacebuilder.OverworldSurfaceBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSamplingSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.NoiseSlideSettings;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

@NotTested
public class OverworldChunkGenerator extends NoiseBasedChunkGenerator {
	
	public static final Codec<OverworldChunkGenerator> CODEC = RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
			.xmap(OverworldChunkGenerator::new, OverworldChunkGenerator::getRegistry).codec();
	public static final List<OverworldBiome> SEA_SMOOTH_BIOMES = Lists.newArrayList();
	
	protected final PerlinSimplexNoise worldNoise;
	
	public OverworldChunkGenerator(Registry<Biome> registry) {
		this(registry, new Random().nextLong());
	}
	
	protected OverworldChunkGenerator(Registry<Biome> registry, long seed) {
		this(new OverworldBiomeSource(registry, seed), seed);
	}
	
	protected OverworldChunkGenerator(BiomeSource biomeSource, long seed) {
		super(biomeSource, biomeSource, seed, overworldNoiseSettings());
		this.baseStoneSource = new OverworldStoneSource(seed);
		WorldgenRandom worldRandom = new WorldgenRandom(seed);
		worldRandom.consumeCount(1234);
		this.worldNoise = new PerlinSimplexNoise(worldRandom, IntStream.rangeClosed(-3, 0));
	}
	
	public Registry<Biome> getRegistry() {
		return ((OverworldBiomeSource) this.biomeSource).getRegistry();
	}
	
	@Override 
	public int getSeaLevel() {
		return 302;
	}
	
	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion worldRegion, ChunkAccess chunkAccess) {
		ChunkPos chunkPos = chunkAccess.getPos();
		WorldgenRandom worldRandom = new WorldgenRandom();
		worldRandom.setBaseChunkSeed(chunkPos.x, chunkPos.z);
		int minChunkX = chunkPos.getMinBlockX();
		int minChunkZ = chunkPos.getMinBlockZ();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int worldX = minChunkX + x;
				int worldZ = minChunkZ + z;
				for (int y = 0; y < 5; y++) {
					if (worldRandom.nextInt(5) >= y) {
						chunkAccess.setBlockState(new BlockPos(worldX, y, worldZ), Blocks.BEDROCK.defaultBlockState(), false);
					}
				}
				double noise = this.surfaceNoise.getSurfaceNoiseValue(worldX * 0.0325, worldZ * 0.0325, 0, 0);
				Biome biome = worldRegion.getBiome(new BlockPos(worldX, height, worldZ));
				SurfaceBuilder<?> surfaceBuilder = biome.getGenerationSettings().getSurfaceBuilder().get().surfaceBuilder;
				if (surfaceBuilder instanceof OverworldSurfaceBuilder overworldSurfaceBuilder) {
					overworldSurfaceBuilder.initNoise(worldRegion.getSeed());
					int maxSurface = this.getWorldNoise(worldX, worldZ);
					int minSurface = maxSurface - 50;
					overworldSurfaceBuilder.apply(worldRandom, chunkAccess, IBiome.byVanilla(biome), worldX, worldZ, noise, Math.max(0, minSurface), maxSurface, this.getSeaLevel(), worldRegion.getSeed());
				}
			}
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	protected ChunkAccess doFill(StructureFeatureManager structureManager, ChunkAccess chunkAccess, int cellMin, int cellMax) {
		Heightmap oceanHeightmap = chunkAccess.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
		Heightmap surfaceHeightmap = chunkAccess.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);
		ChunkPos chunkPos = chunkAccess.getPos();
		int minChunkX = chunkPos.getMinBlockX();
		int minChunkZ = chunkPos.getMinBlockZ();
		NoiseSettings noiseSettings = this.settings.get().noiseSettings();
		int sectionCount = noiseSettings.height() / 16;
		for (int section = 0; section < sectionCount; section++) {
			LevelChunkSection chunkSection = chunkAccess.getOrCreateSection(section);
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					int worldX = minChunkX + x;
					int worldZ = minChunkZ + z;
					int worldNoise = this.getWorldNoise(worldX, worldZ);
					for (int y = 0; y < 16; y++) {
						int worldY = chunkSection.bottomBlockY() + y;
						BlockState state = this.getState(worldX, worldY, worldZ, worldNoise);
						if (!(state.getBlock() instanceof AirBlock)) {
							if (state.getLightEmission() != 0 && chunkAccess instanceof ProtoChunk protoChunk) {
								protoChunk.addLight(new BlockPos(worldX, worldNoise, worldZ));
							}
							chunkSection.setBlockState(x, y, z, state, false);
							oceanHeightmap.update(x, worldY, z, state);
							surfaceHeightmap.update(x, worldY, z, state);
						}
					}
				}
			}
		}
		return chunkAccess;
	}
	
	protected BlockState getState(int worldX, int worldY, int worldZ, int worldNoise) {
		if (worldY > worldNoise) {
			if (this.getSeaLevel() > worldY) {
				return Blocks.WATER.defaultBlockState();
			}
			return Blocks.AIR.defaultBlockState();
		}
		return this.baseStoneSource.getBaseBlock(worldX, worldY, worldZ);
	}
	
	protected int getWorldNoise(int worldX, int worldZ) {
		double noise = this.worldNoise.getSurfaceNoiseValue(worldX * 0.0425, worldZ * 0.0425, 0.0, 0.0);
		IBiome biome = IBiome.byVanilla(this.biomeSource.getNoiseBiome(worldX, this.getSeaLevel(), worldZ));
		if (biome instanceof OverworldBiome overworldBiome) {
			IBiomeNoise biomeNoise = overworldBiome.getBiomeNoise();
			int worldNoise = (int) (noise * biomeNoise.getNoiseScale() + biomeNoise.getBaseNoise());
			if (SEA_SMOOTH_BIOMES.contains(biome) && this.getSeaLevel() > worldNoise) {
				worldNoise += this.getSmoothnessLevel(worldNoise);
			}
			return worldNoise;
		}
		return 0;
	}
	
	protected int getSmoothnessLevel(int worldNoise) {
		double difference = this.getSeaLevel() - worldNoise;
		if (0 > difference) {
			difference *= -1;
		}
		return (int) Math.round(difference / 4.0);
	}
	
	public int getWorldNoise(BlockPos pos) {
		return this.getWorldNoise(pos.getX(), pos.getZ());
	}
	
	public static Supplier<NoiseGeneratorSettings>  overworldNoiseSettings() {
		return () -> new NoiseGeneratorSettings(
				new StructureSettings(
						true /*stronghold*/) /*structureSettings*/,
				NoiseSettings.create(0 /*minY*/, 
						640 /*height*/,
						new NoiseSamplingSettings(0.9999999814507745D /*xzScale*/, 
								0.9999999814507745D /*yScale*/, 
								80.0D /*xzFactor*/, 
								160.0D /*yFactor*/) /*noiseSamplingSettings*/,
						new NoiseSlideSettings(-10 /*target*/, 
								3 /*size*/, 
								0 /*offset*/) /*topSlideSettings*/, 
						new NoiseSlideSettings(15 /*target*/, 
								3 /*size*/, 
								0 /*offset*/) /*bottomSlideSettings*/, 
						1 /*noiseSizeHorizontal*/, 
						2 /*noiseSizeVertical*/, 
						1.0D /*densityFactor*/, 
						-0.46875D /*densityOffset*/, 
						true /*useSimplexSurfaceNoise*/, 
						true /*randomDensityOffset*/, 
						false /*islandNoiseOverride*/, 
						false /*amplified*/) /*noiseSettings*/,
				Blocks.STONE.defaultBlockState() /*defaultBlock*/, 
				Blocks.WATER.defaultBlockState() /*defaultFluid*/, 
				Integer.MIN_VALUE /*bedrockRoofPosition*/, 
				0 /*bedrockFloorPosition*/, 
				302 /*seaLevel*/, 
				282 /*minSurfaceLevel*/, 
				false /*disableMobGeneration*/,
				false /*aquifersEnabled*/, 
				false /*noiseCavesEnabled*/, 
				false /*deepslateEnabled*/, 
				false /*oreVeinsEnabled*/, 
				false /*noodleCavesEnabled*/);
	}
		
}
