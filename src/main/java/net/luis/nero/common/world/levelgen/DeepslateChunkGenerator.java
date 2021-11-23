 package net.luis.nero.common.world.levelgen;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.luis.nero.common.world.biome.source.DeepslateBiomeSource;
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
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

public class DeepslateChunkGenerator extends ChunkGenerator {
	
	private static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("min_height").forGetter(Settings::getMinHeight),
					Codec.INT.fieldOf("max_height").forGetter(Settings::getMaxHeight),
					Codec.INT.fieldOf("bedrock_top_layer_size").forGetter(Settings::getBedrockTopLayerSize))
			.apply(instance, Settings::new));

	public static final Codec<DeepslateChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
					.forGetter(DeepslateChunkGenerator::getBiomeRegistry),
					SETTINGS_CODEC.fieldOf("settings").forGetter(DeepslateChunkGenerator::getDimensionSettings))
			.apply(instance, DeepslateChunkGenerator::new));

	protected final Settings settings;
	protected final WorldgenRandom worldRandom;
	protected final PerlinNoise surfaceNoise;
	protected final long seed;
	
	public DeepslateChunkGenerator(Registry<Biome> registry, Settings settings) {
		this(registry, settings, new Random().nextLong());
	}
	
	public DeepslateChunkGenerator(Registry<Biome> registry, Settings settings, long seed) {
		super(new DeepslateBiomeSource(registry), new StructureSettings(false));
		this.settings = settings;
		this.seed = seed;
		this.worldRandom = new WorldgenRandom(this.seed);
		this.surfaceNoise = new PerlinNoise(this.worldRandom, IntStream.rangeClosed(-3, 0));
		this.worldRandom.consumeCount(2620);
	}

	public Settings getDimensionSettings() {
		return this.settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((DeepslateBiomeSource) this.biomeSource).getBiomeRegistry();
	}
	
	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion genRegion, ChunkAccess chunkAccess) {
		int yMin = this.settings.minHeight;
		int yMax = this.settings.maxHeight;
		for (int x = 0; x < 16; x++) {
			for (int y = yMin; y < yMax; y++) {
				for (int z = 0; z < 16; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					this.buildWorld(chunkAccess, pos);
					this.buildBedrock(chunkAccess, pos);
					this.buildSurface(chunkAccess, genRegion.getBiome(pos), pos, z);
				}
			}
		}
	}
	
	protected void buildWorld(ChunkAccess chunkAccess, BlockPos pos) {
		chunkAccess.setBlockState(pos, Blocks.DEEPSLATE.defaultBlockState(), false);
	}
	
	protected void buildBedrock(ChunkAccess chunkAccess, BlockPos pos) {
		if (pos.getY() > this.settings.maxHeight - this.settings.bedrockTopLayerSize - 1) {
			chunkAccess.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
		} else if (pos.getY() <= this.worldRandom.nextInt(5) + this.settings.minHeight) {
			chunkAccess.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
		}
	}
	
	protected void buildSurface(ChunkAccess chunkAccess, Biome biome, BlockPos pos, long seed) {
		int worldX = chunkAccess.getPos().getMinBlockX() + pos.getX();
		int worldZ = chunkAccess.getPos().getMinBlockZ() + pos.getZ();
		int y = chunkAccess.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ()) + 1;
		double noise = this.surfaceNoise.getSurfaceNoiseValue(worldX * 0.0625, worldZ * 0.0625, 0.0625, pos.getX() * 0.0625) * 15;
		biome.buildSurfaceAt(this.worldRandom, chunkAccess, worldX, worldZ, y, noise, Blocks.DEEPSLATE.defaultBlockState(), Blocks.WATER.defaultBlockState(), this.getSeaLevel(), 0, seed);
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long seed) {
		return new DeepslateChunkGenerator(this.getBiomeRegistry(), this.settings, seed);
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, StructureFeatureManager structureManager, ChunkAccess chunkAccess) {
		return CompletableFuture.supplyAsync(() -> chunkAccess, executor);
	}

	@Override
	public int getBaseHeight(int x, int z, Types types, LevelHeightAccessor levelAccessor) {
		return this.settings.maxHeight / 2;
	}
	
	@Override
	public int getSeaLevel() {
		return this.settings.maxHeight;
	}

	@Override
	public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor levelAccessor) {
		return new NoiseColumn(0, new BlockState[0]);
	}

	static class Settings {
		
		private final int minHeight;
		private final int maxHeight;
		private final int bedrockTopLayerSize;
		
		public Settings(int minHeight, int maxHeight, int bedrockTopLayerSize) {
			this.minHeight = minHeight;
			this.maxHeight = maxHeight;
			this.bedrockTopLayerSize = bedrockTopLayerSize;
		}

		public int getMinHeight() {
			return this.minHeight;
		}

		public int getMaxHeight() {
			return this.maxHeight;
		}

		public int getBedrockTopLayerSize() {
			return this.bedrockTopLayerSize;
		}
		
	}
	
}
