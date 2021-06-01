package net.luis.nero.init.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModServerConfig {
	
	 private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	 public static ForgeConfigSpec CONFIG;
	 
	 static {
		 BUILDER.push("Nero Server Config");
		 BUILDER.pop();
		 CONFIG = BUILDER.build();
	 }

}