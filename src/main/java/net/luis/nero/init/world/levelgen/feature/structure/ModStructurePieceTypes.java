package net.luis.nero.init.world.levelgen.feature.structure;

import net.luis.nero.Nero;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class ModStructurePieceTypes {
		
	@SuppressWarnings("unused")
	private static StructurePieceType register(StructurePieceType structurePieceType, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Nero.MOD_ID, name), structurePieceType);
	}
	
}
