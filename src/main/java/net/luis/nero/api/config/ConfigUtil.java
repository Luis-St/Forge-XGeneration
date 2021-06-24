package net.luis.nero.api.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.objectweb.asm.Type;

import net.luis.nero.Nero;
import net.luis.nero.api.config.value.ConfigBooleanValue;
import net.luis.nero.api.config.value.ConfigDoubleRangeValue;
import net.luis.nero.api.config.value.ConfigDoubleValue;
import net.luis.nero.api.config.value.ConfigIntegerRangeValue;
import net.luis.nero.api.config.value.ConfigIntegerValue;
import net.luis.nero.api.config.value.ConfigStringValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.forgespi.language.ModFileScanData.AnnotationData;

public class ConfigUtil {
	
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
	
	public static List<Class<?>> getConfigClasses(ClassLoader classLoader) {
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
				}
			} else {
				Nero.LOGGER.warn("The Annotation can't add to the Type {}", annotationData.getAnnotationType());
			}
		}
		return configClasses;
	}
	
	public static List<Field> getSortedConfigValues(Class<?> configClass) {
		List<Field> configFields = new ArrayList<>();
		for (ConfigValueType valueType : ConfigValueType.values()) {
			configFields.addAll(getConfigValuesForType(configClass, valueType));
		}
		return configFields;
	}
	
	public static List<Field> getConfigValuesForType(Class<?> configClass, ConfigValueType configValueType) {
		List<Field> configFields = new ArrayList<>();
		for (Field configField : configClass.getDeclaredFields()) {
			ConfigValueType fieldValueType = getConfigValueType(configField);
			if (fieldValueType == configValueType) {
				configFields.add(configField);
			}
		}
		return configFields;
	}
	
	public static ConfigValueType getConfigValueType(Field configField) {
		if (configField.isAnnotationPresent(ConfigBooleanValue.class)) {
			ConfigBooleanValue annotation = configField.getAnnotation(ConfigBooleanValue.class);
			return annotation.valueType();
		} else if (configField.isAnnotationPresent(ConfigDoubleValue.class)) {
			ConfigDoubleValue annotation = configField.getAnnotation(ConfigDoubleValue.class);
			return annotation.valueType();
		} else if (configField.isAnnotationPresent(ConfigIntegerValue.class)) {
			ConfigIntegerValue annotation = configField.getAnnotation(ConfigIntegerValue.class);
			return annotation.valueType();
		} else if (configField.isAnnotationPresent(ConfigStringValue.class)) {
			ConfigStringValue annotation = configField.getAnnotation(ConfigStringValue.class);
			return annotation.valueType();
		} else if (configField.isAnnotationPresent(ConfigDoubleRangeValue.class)) {
			ConfigDoubleRangeValue annotation = configField.getAnnotation(ConfigDoubleRangeValue.class);
			return annotation.valueType();
		} else if (configField.isAnnotationPresent(ConfigIntegerRangeValue.class)) {
			ConfigIntegerRangeValue annotation = configField.getAnnotation(ConfigIntegerRangeValue.class);
			return annotation.valueType();
		}
		return null;
	}
	
	public static void buildConfigValue(ForgeConfigSpec.Builder builder, Field configField)
			throws IllegalArgumentException, IllegalAccessException {
		if (configField.isAnnotationPresent(ConfigBooleanValue.class)) {
			ConfigBooleanValue annotation = configField.getAnnotation(ConfigBooleanValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Boolean> booleanValue = builder.define(getValueName(configField), annotation.value());
			configField.set(null, booleanValue);
		} else if (configField.isAnnotationPresent(ConfigDoubleValue.class)) {
			ConfigDoubleValue annotation = configField.getAnnotation(ConfigDoubleValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			builder.comment(annotation.comment());

			ConfigValue<Double> doubleValue = builder.define(getValueName(configField), annotation.value());
			configField.set(null, doubleValue);
		} else if (configField.isAnnotationPresent(ConfigIntegerValue.class)) {
			ConfigIntegerValue annotation = configField.getAnnotation(ConfigIntegerValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Integer> integerValue = builder.define(getValueName(configField), annotation.value());
			configField.set(ConfigValue.class.getClass(), integerValue);
		} else if (configField.isAnnotationPresent(ConfigStringValue.class)) {
			ConfigStringValue annotation = configField.getAnnotation(ConfigStringValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<String> stringValue = builder.define(getValueName(configField), annotation.value());
			configField.set(null, stringValue);
		} else if (configField.isAnnotationPresent(ConfigDoubleRangeValue.class)) {
			ConfigDoubleRangeValue annotation = configField.getAnnotation(ConfigDoubleRangeValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Double> doubleValue = builder.defineInRange(getValueName(configField), annotation.defaultValue(),
					annotation.minValue(), annotation.maxValue());
			configField.set(null, doubleValue);
		} else if (configField.isAnnotationPresent(ConfigIntegerRangeValue.class)) {
			ConfigIntegerRangeValue annotation = configField.getAnnotation(ConfigIntegerRangeValue.class);
			if (!annotation.comment().isEmpty()) {
				builder.comment(annotation.comment());
			}
			ConfigValue<Integer> integerValue = builder.defineInRange(getValueName(configField), annotation.defaultValue(),
					annotation.minValue(), annotation.maxValue());
			configField.set(null, integerValue);
		}
	}
	
	protected static String getValueName(Field field) {
		String[] fieldName = field.getName().split("_");
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
	
}
