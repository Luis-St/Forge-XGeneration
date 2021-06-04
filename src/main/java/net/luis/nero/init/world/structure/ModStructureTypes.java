package net.luis.nero.init.world.structure;

import net.luis.nero.common.world.structure.DeepslateMineshaftPiece;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class ModStructureTypes {
	
	public static final IStructurePieceType DEEPSLATE_MINESHAFT = IStructurePieceType.setPieceId(DeepslateMineshaftPiece::new, "deepslate_mineshaft");

}
