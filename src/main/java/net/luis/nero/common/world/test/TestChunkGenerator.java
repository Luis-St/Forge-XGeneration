package net.luis.nero.common.world.test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class TestChunkGenerator extends ChunkGenerator {
	
	private static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("base_height").forGetter(Settings::getBaseHeight),
					Codec.INT.fieldOf("min_height").forGetter(Settings::getMinHeight),
					Codec.INT.fieldOf("max_height").forGetter(Settings::getMaxHeight),
					Codec.INT.fieldOf("sea_level").forGetter(Settings::getSeaLevel),
					Codec.INT.fieldOf("water_ocean_level").forGetter(Settings::getWaterOceanLevel),
					Codec.INT.fieldOf("lava_ocean_level").forGetter(Settings::getLavaOceanLevel),
					Codec.INT.fieldOf("bedrock_top_layer").forGetter(Settings::getBedrockTopLayer),
					Codec.INT.fieldOf("bedrock_top_layer_size").forGetter(Settings::getBedrockTopLayerSize))
			.apply(instance, Settings::new));

	public static final Codec<TestChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
					.forGetter(TestChunkGenerator::getBiomeRegistry),
					SETTINGS_CODEC.fieldOf("settings").forGetter(TestChunkGenerator::getDimensionSettings))
			.apply(instance, TestChunkGenerator::new));

	protected final Settings settings;
	protected final WorldgenRandom worldRandom;
	protected final long seed;
	protected final PerlinSimplexNoise noise;
	
	public TestChunkGenerator(Registry<Biome> registry, Settings settings) {
		super(new TestBiomeSource(registry), new StructureSettings(false));
		this.settings = settings;
		this.seed = new Random().nextLong();
		this.worldRandom = new WorldgenRandom(this.seed);
		this.noise = new PerlinSimplexNoise(this.worldRandom, IntStream.rangeClosed(-3, 0));
	}

	public Settings getDimensionSettings() {
		return this.settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((TestBiomeSource) this.biomeSource).getBiomeRegistry();
	}
	
	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion genRegion, ChunkAccess chunkAccess) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int worldX = chunkAccess.getPos().getMinBlockX() + x;
				int worldZ = chunkAccess.getPos().getMinBlockZ() + z;
				double noise = this.noise.getSurfaceNoiseValue(worldX * 0.0625, worldZ * 0.0625, 0.0625, x * 0.0625) * 15;
				for (int y = 0; y <= 64; y++) {
					BlockPos pos = new BlockPos(x, y, z);
					this.buildWorld(chunkAccess, pos);
					this.buildSurface(chunkAccess, this.biomeSource.getNoiseBiome(worldX, 0, worldZ), pos, noise);
					this.buildBedrock(chunkAccess, pos);
				}
			}
		}
	}
	
	protected void buildWorld(ChunkAccess chunkAccess, BlockPos pos) {
		if (pos.getY() >= 60) {
			chunkAccess.setBlockState(pos, Blocks.GRASS_BLOCK.defaultBlockState(), false);
		} else {
			chunkAccess.setBlockState(pos, Blocks.STONE.defaultBlockState(), false);
		}
	}
	
	protected void buildSurface(ChunkAccess chunkAccess, Biome biome, BlockPos pos, double noise) {
		int worldX = chunkAccess.getPos().getMinBlockX() + pos.getX();
		int worldZ = chunkAccess.getPos().getMinBlockZ() + pos.getZ();
		int y = chunkAccess.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ()) + 1;
		biome.buildSurfaceAt(this.worldRandom, chunkAccess, worldX, worldZ, y, noise, Blocks.DEEPSLATE.defaultBlockState(), Blocks.WATER.defaultBlockState(), this.getSeaLevel(), 0, this.seed);
	}
	
	protected void buildBedrock(ChunkAccess chunkAccess, BlockPos pos) {
		if (pos.getY() <= this.worldRandom.nextInt(5)) {
			chunkAccess.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
		}
	}
	
	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long seed) {
		return new TestChunkGenerator(this.getBiomeRegistry(), this.settings);
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, StructureFeatureManager structureManager, ChunkAccess chunk) {
		return CompletableFuture.supplyAsync(() -> chunk, executor);
	}

	@Override
	public int getBaseHeight(int x, int z, Types types, LevelHeightAccessor levelAccessor) {
		return 65;
	}
	
	@Override
	public int getSeaLevel() {
		return 40;
	}

	@Override
	public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor levelAccessor) {
		return new NoiseColumn(0, new BlockState[0]);
	}
	
	static class Settings {
		
		private final int baseHeight;
		private final int minHeight;
		private final int maxHeight;
		private final int seaLevel;
		private final int waterOceanLevel;
		private final int lavaOceanLevel;
		private final int bedrockTopLayer;
		private final int bedrockTopLayerSize;
		
		public Settings(int baseHeight, int minHeight, int maxHeight, int seaLevel, int waterOceanLevel, int lavaOceanLevel, int bedrockTopLayer, int bedrockTopLayerSize) {
			this.baseHeight = baseHeight;
			this.minHeight = minHeight;
			this.maxHeight = maxHeight;
			this.seaLevel = seaLevel;
			this.waterOceanLevel = waterOceanLevel;
			this.lavaOceanLevel = lavaOceanLevel;
			this.bedrockTopLayer = bedrockTopLayer;
			this.bedrockTopLayerSize = bedrockTopLayerSize;
		}

		public int getBaseHeight() {
			return this.baseHeight;
		}

		public int getMinHeight() {
			return this.minHeight;
		}

		public int getMaxHeight() {
			return this.maxHeight;
		}

		public int getSeaLevel() {
			return this.seaLevel;
		}

		public int getWaterOceanLevel() {
			return this.waterOceanLevel;
		}
		
		public int getLavaOceanLevel() {
			return this.lavaOceanLevel;
		}

		public int getBedrockTopLayer() {
			return this.bedrockTopLayer;
		}

		public int getBedrockTopLayerSize() {
			return this.bedrockTopLayerSize;
		}
		
	}

}
