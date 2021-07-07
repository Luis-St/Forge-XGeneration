package net.luis.nero.common.world.test;

import java.util.Random;
import java.util.stream.IntStream;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

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
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

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

	private final Settings settings;
	protected final SharedSeedRandom rng;
	private final long seed;
	private final PerlinNoiseGenerator noise;

	public TestChunkGenerator(Registry<Biome> registry, Settings settings) {
		super(new TestBiomeProvider(registry), new DimensionStructuresSettings(false));
		this.settings = settings;
		this.seed = new Random().nextLong();
		this.rng = new SharedSeedRandom(this.seed);
		this.noise = new PerlinNoiseGenerator(rng, IntStream.rangeClosed(-3, 0));
	}

	public Settings getDimensionSettings() {
		return this.settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((TestBiomeProvider) this.biomeSource).getBiomeRegistry();
	}
	
	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion region, IChunk chunk) {
		BlockState bedrock = Blocks.BEDROCK.defaultBlockState();
		BlockState stone = Blocks.STONE.defaultBlockState();
		ChunkPos chunkpos = chunk.getPos();

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				chunk.setBlockState(new BlockPos(x, 0, z), bedrock, false);
			}
		}
		// int noise = (int) (65.0 + Math.sin(realx / 10.0) * 16.0 + Math.cos(realz /
		// 10.0) * 16.0);
		// int noise = (int) (75.0 + Math.sin(realx / 100.0) * 32.0 + Math.cos(realz /
		// 100.0) * 32.0); -> first good world
		// int noise = (int) (75.0 + Math.sin(realx / 500.0) * 16.0 + Math.cos(realz /
		// 500.0) * 16.0); -> second good world
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int worldX = chunkpos.x * 16 + x; 
				int worldZ = chunkpos.z * 16 + z; 
/*				int noise =(int) (75.0 + Math.sin(worldX / 64.0) * 16.0 + Math.sin(worldZ / 64.0) * 16.0);*/
				// 65 -> height
				// 10.0 (1) -> sin stretch
				// 10.0 (2) -> cos stretch
				// 16.0 (1) -> sin height
				// 16.0 (2) -> sin height
				// f(x) = 65+sin(x/10)*16+cos(x/10)*16
				double noise = this.noise.getSurfaceNoiseValue(worldX * 0.0625, worldZ * 0.0625, 0.0625, worldX * 0.0625) * 16;
				for (int y = 1; y < 10 + noise; y++) {
					chunk.setBlockState(new BlockPos(x, y, z), stone, false);
				}
			}
		}
//		this.buildBedrock(chunk);
//		this.buildSurface(chunk);
	}
	
	protected void buildSurface(IChunk chunk) {
		ChunkPos chunkPos = chunk.getPos();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int worldX = chunkPos.x * 16 + x;
				int worldZ = chunkPos.z * 16 + z;
				int noise = (int) (65 + Math.sin(worldX / 20.0) * 10 + Math.cos(worldZ / 20.0) * 10);
				for (int y = 0; y < noise; y++) {
					chunk.setBlockState(new BlockPos(x, z, y), Blocks.STONE.defaultBlockState(), false);
				}
			}
		}
	}
	
	protected void buildBedrock(IChunk chunk) {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 128; y++) {
				for (int z = 0; z < 16; z++) {
					if (y <= this.rng.nextInt(5)) {
						chunk.setBlockState(new BlockPos(x, y, z), Blocks.BEDROCK.defaultBlockState(), false);
					}
				}
			}
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
