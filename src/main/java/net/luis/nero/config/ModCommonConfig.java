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
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.BooleanValue.class,
								builder.define(annotation.name(), annotation.value()));
					} else if (configField.isAnnotationPresent(ConfigDoubleValue.class)) {
						ConfigDoubleValue annotation = configField.getAnnotation(ConfigDoubleValue.class);
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.DoubleValue.class,
								builder.define(annotation.name(), annotation.value()));
					} else if (configField.isAnnotationPresent(ConfigIntegerValue.class)) {
						ConfigIntegerValue annotation = configField.getAnnotation(ConfigIntegerValue.class);
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.IntValue.class,
								builder.define(annotation.name(), annotation.value()));
					} else if (configField.isAnnotationPresent(ConfigStringValue.class)) {
						ConfigStringValue annotation = configField.getAnnotation(ConfigStringValue.class);
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.ConfigValue.class,
								builder.define(annotation.name(), annotation.value()));
					} else if (configField.isAnnotationPresent(ConfigDoubleRangeValue.class)) {
						ConfigDoubleRangeValue annotation = configField.getAnnotation(ConfigDoubleRangeValue.class);
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.DoubleValue.class, builder.defineInRange(annotation.name(),
								annotation.defaultValue(), annotation.minValue(), annotation.maxValue()));
					} else if (configField.isAnnotationPresent(ConfigIntegerRangeValue.class)) {
						ConfigIntegerRangeValue annotation = configField.getAnnotation(ConfigIntegerRangeValue.class);
						if (!annotation.comment().isEmpty()) {
							builder.comment(annotation.comment());
						}
						configField.set(ForgeConfigSpec.IntValue.class, builder.defineInRange(annotation.name(),
								annotation.defaultValue(), annotation.minValue(), annotation.maxValue()));
					}
				} catch (IllegalArgumentException e) {
					Nero.LOGGER.warn("Can't define Config Value {},");
					builder.comment("\nCan't define Config Value");
				} catch (IllegalAccessException e) {
					Nero.LOGGER.warn("Can't define Config Value");
					builder.comment("\nCan't define Config Value");
				}
			}
		}
		builder.pop();
		return builder.build();
	}

}
