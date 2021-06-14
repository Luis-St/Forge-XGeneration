package net.luis.nero.api.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.objectweb.asm.Type;

import net.luis.nero.Nero;
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
	
}
