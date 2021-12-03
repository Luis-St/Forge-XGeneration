package net.luis.nero.common.world.biome;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class MobSpawnBuilder extends MobSpawnSettings.Builder {
	
	@Override
	public MobSpawnBuilder addSpawn(MobCategory mobCategory, MobSpawnSettings.SpawnerData spawnerData) {
		this.spawners.get(mobCategory).add(spawnerData);
		return this;
	}
	
	public void removeSpawn(MobCategory mobCategory, MobSpawnSettings.SpawnerData spawnerData) {
		this.spawners.get(mobCategory).removeIf(data -> {
			return data == spawnerData || (data.type == spawnerData.type && data.minCount == spawnerData.minCount && data.maxCount == spawnerData.maxCount && data.getWeight().asInt() == spawnerData.getWeight().asInt());
		});
	}
	
	@Override
	public MobSpawnBuilder addMobCharge(EntityType<?> entityType, double energyBudget, double charge) {
		this.mobSpawnCosts.put(entityType, mobSpawnCost(energyBudget, charge));
		return this;
	}
	
	protected static MobSpawnSettings.MobSpawnCost mobSpawnCost(double energyBudget, double charge) {
		try {
			Constructor<MobSpawnSettings.MobSpawnCost> constructor = ObfuscationReflectionHelper.findConstructor(MobSpawnSettings.MobSpawnCost.class, double.class, double.class);
			return constructor.newInstance(energyBudget, charge);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public MobSpawnBuilder creatureGenerationProbability(float creatureGenerationProbability) {
		this.creatureGenerationProbability = creatureGenerationProbability;
		return this;
	}
	
}
