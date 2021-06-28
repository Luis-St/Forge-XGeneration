package net.luis.nero.api.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.objectweb.asm.Type;

import com.google.common.collect.Lists;

import net.luis.nero.Nero;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.forgespi.language.ModFileScanData.AnnotationData;

public class ConfigUtil {
	
	protected static final List<ModConfigValue> CLIENT_VALUES = new ArrayList<>();
	protected static final List<ModConfigValue> COMMON_VALUES = new ArrayList<>();
	protected static final List<ModConfigValue> SERVER_VALUES = new ArrayList<>();
	
	public static List<Class<?>> getConfigClassesForType(ModConfig.Type configType) {
		List<Class<?>> configClasses = getConfigClasses(Nero.class.getClassLoader());
		List<Class<?>> configTypeClasses = new ArrayList<>();
		for (Class<?> configClass : configClasses) {
			if (configClass.isAnnotationPresent(Config.class)) {
				Config config = configClass.getAnnotation(Config.class);
				if (config.type() == configType) {
					configTypeClasses.add(configClass);
				}
			}
		}
		return configTypeClasses;
	}
	
	protected static List<Class<?>> getConfigClasses(ClassLoader classLoader) {
		List<Class<?>> configClasses = new ArrayList<>();
		Type configAnnotation = Type.getType(Config.class);
		ModFileScanData fileScanData = ModList.get().getModFileById(Nero.MOD_ID).getFile().getScanResult();
		Stream<AnnotationData> annotationDatas = fileScanData.getAnnotations().stream()
				.filter(annotation -> configAnnotation.equals(annotation.getAnnotationType()));
		for (AnnotationData annotationData : annotationDatas.collect(Collectors.toList())) {
			if (annotationData.getAnnotationType().equals(configAnnotation)) {
				try {
					configClasses.add(Class.forName(annotationData.getMemberName(), true, classLoader));
				} catch (ClassNotFoundException e) {
					Nero.LOGGER.warn("Can't find class {}", annotationData.getMemberName());
					Nero.LOGGER.warn("Something went wrong when build the config ", e);
				}
			} else {
				Nero.LOGGER.warn("The Annotation can't add to the Type {}", annotationData.getAnnotationType());
			}
		}
		return configClasses;
	}
	
	public static List<Field> getConfigValues(Class<?> configClass) {
		List<Field> configFields = Lists.newArrayList(configClass.getDeclaredFields());
		configFields.removeIf(configField -> !configField.isAnnotationPresent(net.luis.nero.api.config.value.ConfigValue.class));
		return configFields;
	}
	
	public static void buildConfigValue(ForgeConfigSpec.Builder builder, Class<?> configClass, Field configField) throws IllegalArgumentException, IllegalAccessException {
		if (configField.isAnnotationPresent(net.luis.nero.api.config.value.ConfigValue.class)) {
			net.luis.nero.api.config.value.ConfigValue annotation = configField.getAnnotation(net.luis.nero.api.config.value.ConfigValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment("", annotation.comment());
			} else {
				builder.comment("", getValueComment(configField));
			}
			ConfigValue<Object> value = builder.define(getValueName(configField), configField.get(null));
			if (configClass.getDeclaredAnnotation(Config.class).type() == ModConfig.Type.CLIENT) {
				CLIENT_VALUES.add(new ModConfigValue(configClass, configField, value));
			} else if (configClass.getDeclaredAnnotation(Config.class).type() == ModConfig.Type.SERVER) {
				SERVER_VALUES.add(new ModConfigValue(configClass, configField, value));
			} else {
				COMMON_VALUES.add(new ModConfigValue(configClass, configField, value));
			}
		}
	}
	
	protected static String getValueName(Field configField) {
		String[] fieldName = configField.getName().split("_");
		for (int i = 0; i < fieldName.length; i++) {
			String string = fieldName[i].toLowerCase();
			if (i == 0) {
				fieldName[i] = string;
			} else {
				fieldName[i] = string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
			}
		}
		return Arrays.toString(fieldName).replace("[", "").replace("]", "").replace(", ", "");
	}
	
	protected static String getValueComment(Field configField) throws IllegalArgumentException, IllegalAccessException {
		return "Default value of " + configField.getName().toLowerCase().replace("_", " ") + " is " + configField.get(null);
	}
	
	public static void setConfigValues() {
		for (ModConfigValue configValue : CLIENT_VALUES) {
			try {
				configValue.getConfigField().setAccessible(true);
				configValue.getConfigField().set(null, configValue.getConfigValue().get());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			} catch (IllegalAccessException e) {
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			}
		}
		for (ModConfigValue configValue : COMMON_VALUES) {
			try {
				configValue.getConfigField().setAccessible(true);
				configValue.getConfigField().set(null, configValue.getConfigValue().get());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			} catch (IllegalAccessException e) {
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			}
		}
		for (ModConfigValue configValue : SERVER_VALUES) {
			try {
				configValue.getConfigField().setAccessible(true);
				configValue.getConfigField().set(null, configValue.getConfigValue().get());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			} catch (IllegalAccessException e) {
				Nero.LOGGER.warn("Can't update the Field {}, in Class {}, to Value {}", configValue.getConfigField().getName(), configValue.getConigClass().getName(),
						configValue.getConfigValue().get());
				Nero.LOGGER.warn("Something went wrong when update the Config Fields ", e);
			}
		}
	}
	
}
