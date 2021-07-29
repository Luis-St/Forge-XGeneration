package net.luis.nero.init.world.gen.feature.structure;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.feature.structure.DeepslateMineshaftStructurePiece;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;

public class ModStructurePieceTypes {
	
	public static final StructurePieceType DEEPSLATE_MINESHAFT = register(DeepslateMineshaftStructurePiece::new, "deepslate_mineshaft");
		
	private static StructurePieceType register(StructurePieceType structurePieceType, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Nero.MOD_ID, name), structurePieceType);
	}
	
}
