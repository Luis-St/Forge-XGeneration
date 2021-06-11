package net.luis.nero.config;

import java.lang.reflect.Field;

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

public class ModCommonConfig {

	public static ForgeConfigSpec buildConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("This is a working default config\nChanges of the default values can lead problems");
		builder.push("Nero Common Config");
		for (Class<?> configClass : ConfigUtil.getConfigClassesForType(ModConfig.Type.COMMON)) {
			for (Field configField : configClass.getDeclaredFields()) {
				configField.setAccessible(true);
				try {
					if (configField.isAnnotationPresent(ConfigBooleanValue.class)) {
						ConfigBooleanValue annotation = configField.getAnnotation(ConfigBooleanValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<Boolean> booleanValue = builder.define(annotation.name(), annotation.value());
						configField.set(booleanValue, booleanValue);
					} else if (configField.isAnnotationPresent(ConfigDoubleValue.class)) {
						ConfigDoubleValue annotation = configField.getAnnotation(ConfigDoubleValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<Double> doubleValue = builder.define(annotation.name(), annotation.value());
						configField.set(doubleValue, doubleValue);
					} else if (configField.isAnnotationPresent(ConfigIntegerValue.class)) {
						ConfigIntegerValue annotation = configField.getAnnotation(ConfigIntegerValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<Integer> integerValue = builder.define(annotation.name(), annotation.value());
						configField.set(integerValue, integerValue);
					} else if (configField.isAnnotationPresent(ConfigStringValue.class)) {
						ConfigStringValue annotation = configField.getAnnotation(ConfigStringValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<String> stringValue = builder.define(annotation.name(), annotation.value());
						configField.set(stringValue, stringValue);
					} else if (configField.isAnnotationPresent(ConfigDoubleRangeValue.class)) {
						ConfigDoubleRangeValue annotation = configField.getAnnotation(ConfigDoubleRangeValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<Double> doubleValue = builder.defineInRange(annotation.name(), annotation.defaultValue(), annotation.minValue(), annotation.maxValue());
						configField.set(doubleValue, doubleValue);
					} else if (configField.isAnnotationPresent(ConfigIntegerRangeValue.class)) {
						ConfigIntegerRangeValue annotation = configField.getAnnotation(ConfigIntegerRangeValue.class);
						builder.comment(annotation.comment());
						
						ConfigValue<Integer> integerValue =  builder.defineInRange(annotation.name(), annotation.defaultValue(), annotation.minValue(), annotation.maxValue());
						configField.set(integerValue, integerValue);
					}
				} catch (IllegalArgumentException e) {
					Nero.LOGGER.warn("Can't define Config Value " + configField.getName(), e);
				} catch (IllegalAccessException e) {
					Nero.LOGGER.warn("Can't define Config Value" + configField.getName(), e);
				}
			}
		}
		builder.pop();
		return builder.build();
	}

}
