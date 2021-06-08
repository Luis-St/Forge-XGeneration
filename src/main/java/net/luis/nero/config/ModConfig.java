package net.luis.nero.config;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.objectweb.asm.Type;

import net.luis.nero.Nero;
import net.luis.nero.api.config.Config;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.forgespi.language.ModFileScanData.AnnotationData;

// TODO: move to other class
public class ModConfig {
	
	public final File confiFile;
	
	public ModConfig() {
		this.confiFile = new File(this.getConfigPath().resolve("config.toml").toString());
		this.confiFile.mkdirs();
	}
	
	private final Path getConfigPath() {
		return new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve(Nero.MOD_ID))).toPath();
	}
	
	public List<Class<?>> getConfigClasses() {
		List<Class<?>> modClasses = new ArrayList<>();
		Type configAnnotation = Type.getType(Config.class);
		ModFileScanData fileScanData = ModList.get().getModFileById(Nero.MOD_ID).getFile().getScanResult();
		Stream<AnnotationData> annotationDatas = fileScanData.getAnnotations().stream()
				.filter(annotation -> configAnnotation.equals(annotation.getAnnotationType()));
		for (AnnotationData annotationData : annotationDatas.collect(Collectors.toList())) {
			if (annotationData.getAnnotationType().equals(configAnnotation)) {
				try {
					modClasses.add(Class.forName(annotationData.getMemberName()));
				} catch (ClassNotFoundException e) {
					Nero.LOGGER.warn("Can't find class {}", annotationData.getMemberName());
				}
			} else {
				Nero.LOGGER.warn("The Annotation can't add to the Type {}", annotationData.getAnnotationType());
			}
		}
		return modClasses;
	}

}
