package net.luis.nero.api.config;

import java.lang.reflect.Field;

import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ModConfigValue {
	
	protected final Class<?> conigClass;
	protected final Field configField;
	protected final ConfigValue<?> configValue;
	
	public ModConfigValue(Class<?> conigClass, Field configField, ConfigValue<?> configValue) {
		this.conigClass = conigClass;
		this.configField = configField;
		this.configValue = configValue;
	}
	
	public Class<?> getConigClass() {
		return this.conigClass;
	}
	
	public Field getConfigField() {
		return this.configField;
	}
	
	public ConfigValue<?> getConfigValue() {
		return this.configValue;
	}

}
