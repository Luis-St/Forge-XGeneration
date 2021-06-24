package net.luis.nero.config;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.luis.nero.Nero;
import net.luis.nero.api.config.ConfigUtil;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class ModServerConfig {
	
	private static final String CONFIG_TYPE_NAME = "Server";
	private static final ModConfig.Type CONFIG_TYPE = ModConfig.Type.SERVER;
	
	public static ForgeConfigSpec buildConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("This is a working default config\nChanges of the default values can lead problems");
		builder.push("Nero " + CONFIG_TYPE_NAME + " Config");
		for (Class<?> configClass : ConfigUtil.getConfigClassesForType(CONFIG_TYPE)) {
			for (Field configField : ConfigUtil.getSortedConfigValues(configClass)) {
				configField.setAccessible(true);
				if (!Modifier.isStatic(configField.getModifiers())) {
					Nero.LOGGER.warn("The Config Field {}, in {} Config, must be static!", configField.getName(), CONFIG_TYPE_NAME);
					continue;
				}
				try {
					ConfigUtil.buildConfigValue(builder, configField);
				} catch (IllegalArgumentException e) {
					Nero.LOGGER.warn("Can't define Config Value {}, in {} Config", configField.getName(), CONFIG_TYPE_NAME);
					Nero.LOGGER.warn("Something went wrong when build the config ", e);
				} catch (IllegalAccessException e) {
					Nero.LOGGER.warn("Can't define Config Value {}, in {} Config", configField.getName(), CONFIG_TYPE_NAME);
					Nero.LOGGER.warn("Something went wrong when build the config ", e);
				}
			}
		}
		builder.pop();
		return builder.build();
	}

}