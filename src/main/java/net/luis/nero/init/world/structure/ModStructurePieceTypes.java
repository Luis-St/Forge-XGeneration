package net.luis.nero.init.world.structure;

import net.luis.nero.common.world.gen.feature.structure.DeepslatePortalStructurePiece;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class ModStructurePieceTypes {
	
	public static final IStructurePieceType DEEPSLATE_PORTAL = IStructurePieceType.setPieceId(DeepslatePortalStructurePiece::new, "DP");

}
