package net.luis.industry.common.world.dimension.chunk;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.luis.industry.common.world.dimension.biome.DeepslateBiomeProvider;
import net.luis.industry.init.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.Blockreader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.INoiseGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

@SuppressWarnings("unused")
public class DeepslateChunkGenerator extends ChunkGenerator {
	
	// TODO: more biome -> later after understand of layer system
	
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

	public static final Codec<DeepslateChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
					.forGetter(DeepslateChunkGenerator::getBiomeRegistry),
					SETTINGS_CODEC.fieldOf("settings").forGetter(DeepslateChunkGenerator::getDimensionSettings))
			.apply(instance, DeepslateChunkGenerator::new));

	private final Settings settings;
	
	protected final SharedSeedRandom random;
	private final INoiseGenerator surfaceNoise;
	private final long seed;
	private final int height = 256;

	public DeepslateChunkGenerator(Registry<Biome> registry, Settings settings) {
		super(new DeepslateBiomeProvider(registry), new DimensionStructuresSettings(false));
		this.settings = settings;
		this.seed = new Random().nextLong();
		this.random = new SharedSeedRandom(this.seed);
		this.surfaceNoise = new OctavesNoiseGenerator(this.random, IntStream.rangeClosed(-3, 0));
		this.random.consumeCount(2620);
	}

	public Settings getDimensionSettings() {
		return this.settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((DeepslateBiomeProvider) this.biomeSource).getBiomeRegistry();
	}
	
	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion region, IChunk chunk) {
		ChunkPos chunkpos = chunk.getPos();
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 256; y++) {
				for (int z = 0; z < 16; z++) {
					BlockPos pos = new BlockPos(x, y, z);
					chunk.setBlockState(pos, ModBlocks.DEEPSLATE.get().defaultBlockState(), false);
					this.buildBedrock(chunk, pos);
					this.buildSurface(chunk, region.getBiome(pos), pos, z);
				}
			}
		}
	}

	protected void buildBedrock(IChunk chunk, BlockPos pos) {
		if (pos.getY() > this.getDimensionSettings().getBedrockTopLayer() - this.getDimensionSettings().getBedrockTopLayerSize() - 1) {
			chunk.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
		} else if (pos.getY() <= this.random.nextInt(5)) {
			chunk.setBlockState(pos, Blocks.BEDROCK.defaultBlockState(), false);
		}
	}
	
	protected void buildSurface(IChunk chunk, Biome biome, BlockPos pos, long seed) {
		int worldX = chunk.getPos().getMinBlockX() + pos.getX();
		int worldZ = chunk.getPos().getMinBlockZ() + pos.getZ();
		int y = chunk.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos.getX(), pos.getZ()) + 1;
		double noise = this.surfaceNoise.getSurfaceNoiseValue(worldX * 0.0625, worldZ * 0.0625, 0.0625, pos.getX() * 0.0625) * 15;
		biome.buildSurfaceAt(this.random, chunk, worldX,worldZ, y, noise, ModBlocks.DEEPSLATE.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), this.getSeaLevel(), seed);
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long seed) {
		return new DeepslateChunkGenerator(this.getBiomeRegistry(), this.settings);
	}

	@Override
	public void fillFromNoise(IWorld world, StructureManager structureManager, IChunk chunk) {

	}

	@Override
	public int getBaseHeight(int x, int z, Heightmap.Type heightmapType) {
		return this.getDimensionSettings().getBaseHeight();
	}
	
	@Override
	public int getSeaLevel() {
		return this.getDimensionSettings().getSeaLevel();
	}

	@Override
	public IBlockReader getBaseColumn(int x, int z) {
		return new Blockreader(new BlockState[0]);
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
