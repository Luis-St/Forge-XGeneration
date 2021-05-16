package net.luis.industry.common.world.dimension;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.luis.industry.Industry;
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
	
	// TODO : modify the dimension.json (better settings)
	
	private static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("base").forGetter(Settings::getBaseHeight),
					Codec.FLOAT.fieldOf("verticalvariance").forGetter(Settings::getVerticalVariance),
					Codec.FLOAT.fieldOf("horizontalvariance").forGetter(Settings::getHorizontalVariance))
			.apply(instance, Settings::new));

	public static final Codec<DeepslateChunkGenerator> CODEC = RecordCodecBuilder.create(instance -> instance
			.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY)
					.forGetter(DeepslateChunkGenerator::getBiomeRegistry),
					SETTINGS_CODEC.fieldOf("settings").forGetter(DeepslateChunkGenerator::getDeepslateDimensionSettings))
			.apply(instance, DeepslateChunkGenerator::new));

	private final Settings settings;

	public DeepslateChunkGenerator(Registry<Biome> registry, Settings settings) {
		super(new DeepslateBiomeProvider(registry), new DimensionStructuresSettings(false));
		this.settings = settings;
		Industry.LOGGER.info("Chunk generator settings: " + settings.getBaseHeight() + ", " 
		+ settings.getHorizontalVariance() + ", " + settings.getVerticalVariance());
	}

	public Settings getDeepslateDimensionSettings() {
		return settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((DeepslateBiomeProvider) biomeSource).getBiomeRegistry();
	}

	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion region, IChunk chunk) {
		ChunkPos chunkpos = chunk.getPos();
		int chunkX = chunkpos.x;
		int chunkY = chunkpos.z;
		SharedSeedRandom seedRng = new SharedSeedRandom();
		seedRng.setBaseChunkSeed(chunkX, chunkY);
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
					if (y > 253) {
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
		return new DeepslateChunkGenerator(getBiomeRegistry(), this.settings);
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
		return 256;
	}

	@Override
	public IBlockReader getBaseColumn(int x, int z) {
		return new Blockreader(new BlockState[0]);
	}

	private static class Settings {
		private final int baseHeight;
		private final float verticalVariance;
		private final float horizontalVariance;

		public Settings(int baseHeight, float verticalVariance, float horizontalVariance) {
			this.baseHeight = baseHeight;
			this.verticalVariance = verticalVariance;
			this.horizontalVariance = horizontalVariance;
		}

		public float getVerticalVariance() {
			return verticalVariance;
		}

		public int getBaseHeight() {
			return baseHeight;
		}

		public float getHorizontalVariance() {
			return horizontalVariance;
		}
	}
}
