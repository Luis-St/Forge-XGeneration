package net.luis.nero.init.world.gen.feature.structure;

import net.luis.nero.Nero;
import net.luis.nero.common.world.gen.feature.structure.DeepslateMineshaftStructurePiece;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class ModStructurePieceTypes {
	
	public static final IStructurePieceType DEEPSLATE_MINESHAFT = register(DeepslateMineshaftStructurePiece::new, "deepslate_mineshaft");
		
	private static IStructurePieceType register(IStructurePieceType structurePieceType, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Nero.MOD_ID, name), structurePieceType);
	}
	
}
