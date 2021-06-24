package net.luis.nero.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.luis.nero.Nero;
import net.luis.nero.api.config.ConfigUtil;
import net.luis.nero.api.config.value.ConfigBooleanValue;
import net.luis.nero.api.config.value.ConfigDoubleRangeValue;
import net.luis.nero.api.config.value.ConfigDoubleValue;
import net.luis.nero.api.config.value.ConfigIntegerRangeValue;
import net.luis.nero.api.config.value.ConfigIntegerValue;
import net.luis.nero.api.config.value.ConfigStringValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.config.ModConfig;

public class ModServerConfig {
	
	public static ForgeConfigSpec buildConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("This is a working default config\nChanges of the default values can lead problems");
		builder.push("Nero Server Config");
		for (Class<?> configClass : ConfigUtil.getConfigClassesForType(ModConfig.Type.SERVER)) {
			for (Field configField : ConfigUtil.getSortedConfigValues(configClass)) {
				configField.setAccessible(true);
				if (!Modifier.isStatic(configField.getModifiers())) {
					Nero.LOGGER.warn("The config Field {}, must be static", configField.getName());
					continue;
				}
				try {
					buildConfigValue(builder, configField);
				} catch (IllegalArgumentException e) {
					Nero.LOGGER.warn("Can't define Config Value {}, in {} Config", configField.getName(), "Server");
					Nero.LOGGER.warn("Something went wrong when build the config ", e);
				} catch (IllegalAccessException e) {
					Nero.LOGGER.warn("Can't define Config Value {}, in {} Config", configField.getName(), "Server");
					Nero.LOGGER.warn("Something went wrong when build the config ", e);
				}
			}
		}
		builder.pop();
		return builder.build();
	}
	
	protected static void buildConfigValue(ForgeConfigSpec.Builder builder, Field configField) throws IllegalArgumentException, IllegalAccessException {
		if (configField.isAnnotationPresent(ConfigBooleanValue.class)) {
			ConfigBooleanValue annotation = configField.getAnnotation(ConfigBooleanValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Boolean> booleanValue = builder.define(annotation.name(), annotation.value());
			configField.set(null, booleanValue);
		} else if (configField.isAnnotationPresent(ConfigDoubleValue.class)) {
			ConfigDoubleValue annotation = configField.getAnnotation(ConfigDoubleValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			builder.comment(annotation.comment());
			
			ConfigValue<Double> doubleValue = builder.define(annotation.name(), annotation.value());
			configField.set(null, doubleValue);
		} else if (configField.isAnnotationPresent(ConfigIntegerValue.class)) {
			ConfigIntegerValue annotation = configField.getAnnotation(ConfigIntegerValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Integer> integerValue = builder.define(annotation.name(), annotation.value());
			configField.set(ConfigValue.class.getClass(), integerValue);
		} else if (configField.isAnnotationPresent(ConfigStringValue.class)) {
			ConfigStringValue annotation = configField.getAnnotation(ConfigStringValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<String> stringValue = builder.define(annotation.name(), annotation.value());
			configField.set(null, stringValue);
		} else if (configField.isAnnotationPresent(ConfigDoubleRangeValue.class)) {
			ConfigDoubleRangeValue annotation = configField.getAnnotation(ConfigDoubleRangeValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Double> doubleValue = builder.defineInRange(annotation.name(), annotation.defaultValue(), annotation.minValue(), 
					annotation.maxValue());
			configField.set(null, doubleValue);
		} else if (configField.isAnnotationPresent(ConfigIntegerRangeValue.class)) {
			ConfigIntegerRangeValue annotation = configField.getAnnotation(ConfigIntegerRangeValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Integer> integerValue =  builder.defineInRange(annotation.name(), annotation.defaultValue(), annotation.minValue(), 
					annotation.maxValue());
			configField.set(null, integerValue);
		}
	}

}