package net.luis.industry.common.world.dimension;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

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
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

public class DeepslateChunkGenerator extends ChunkGenerator {
	
	// TODO: more biome
	// TODO: biome sufacebuilder
	
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

	public DeepslateChunkGenerator(Registry<Biome> registry, Settings settings) {
		super(new DeepslateBiomeProvider(registry), new DimensionStructuresSettings(false));
		this.settings = settings;
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
		SharedSeedRandom seedRng = new SharedSeedRandom();
		seedRng.setBaseChunkSeed(chunkpos.x, chunkpos.z);
		this.buildDeepslate(chunk);
		this.buildBedrock(chunk, seedRng);
	}
	
	protected void buildDeepslate(IChunk chunk) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 256; y++) {
					this.setDeepSlate(chunk, x, y, z);
				}
			}
		}
	}

	private void setDeepSlate(IChunk chunk, int x, int y, int z) {
		chunk.setBlockState(new BlockPos(x, y, z), ModBlocks.DEEPSLATE.get().defaultBlockState(), false);
	}

	protected void buildBedrock(IChunk chunk, Random rng) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 256; y++) {
					if (y > this.getDimensionSettings().getBedrockTopLayer() - this.getDimensionSettings().getBedrockTopLayerSize() - 1) {
						this.setBedrock(chunk, x, y, z);
					} else if (y <= rng.nextInt(5)) {
						this.setBedrock(chunk, x, y, z);
					}
				}
			}
		}
	}

	private void setBedrock(IChunk chunk, int x, int y, int z) {
		chunk.setBlockState(new BlockPos(x, y, z), Blocks.BEDROCK.defaultBlockState(), false);
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
		return 256;
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
