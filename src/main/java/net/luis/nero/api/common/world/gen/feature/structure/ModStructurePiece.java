package net.luis.nero.api.common.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public abstract class ModStructurePiece extends StructurePiece {

	protected final int width;
	protected final int height;
	protected final int depth;
	protected int heightPosition = -1;

	protected ModStructurePiece(IStructurePieceType pieceType, Random rng, int x, int y, int z, int width, int height, int depth) {
		super(pieceType, 0);
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.setOrientation(Direction.NORTH);
		if (this.getOrientation().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + width - 1, y + height - 1, z + depth - 1);
		} else {
			this.boundingBox = new MutableBoundingBox(x, y, z, x + depth - 1, y + height - 1, z + width - 1);
		}

	}

	protected ModStructurePiece(IStructurePieceType pieceType, CompoundNBT nbt) {
		super(pieceType, nbt);
		this.width = nbt.getInt("Width");
		this.height = nbt.getInt("Height");
		this.depth = nbt.getInt("Depth");
		this.heightPosition = nbt.getInt("HPos");
	}

	protected void addAdditionalSaveData(CompoundNBT nbt) {
		nbt.putInt("Width", this.width);
		nbt.putInt("Height", this.height);
		nbt.putInt("Depth", this.depth);
		nbt.putInt("HPos", this.heightPosition);
	}
	
	/*	protected final int xSize;
	protected final int ySize;
	protected final int zSize;
	protected int heightPosition = -1;*/

	/*	// TODO: fix
		protected ModStructurePiece(IStructurePieceType pieceType, Random rng, int x, int y,  int z, int xSize, int ySize, int zSize) {
			super(pieceType, 0);
			this.xSize = xSize;
			this.ySize = ySize;
			this.zSize = zSize;
			this.boundingBox = new MutableBoundingBox(x, y, z, x + xSize - 1, y + ySize - 1, z + zSize - 1);
		}
		
		protected ModStructurePiece(IStructurePieceType pieceType, TemplateManager templateManager, CompoundNBT nbt) {
			super(pieceType, nbt);
			this.xSize = nbt.getInt("xSize");
			this.ySize = nbt.getInt("ySize");
			this.zSize = nbt.getInt("zSize");
			this.heightPosition = nbt.getInt("heightPosition");
		}
		
		@Override
		protected void addAdditionalSaveData(CompoundNBT nbt) {
			nbt.putInt("xSize", this.xSize);
			nbt.putInt("ySize", this.ySize);
			nbt.putInt("zSize", this.zSize);
			nbt.putInt("heightPosition", this.heightPosition);
		}
		
		protected boolean updateAverageGroundHeight(IWorld world, MutableBoundingBox boundingBox, int yOffset) {
			if (this.heightPosition >= 0) {
				return true;
			} else {
				int i = 0;
				int j = 0;
				BlockPos.Mutable pos = new BlockPos.Mutable();
				for (int k = this.boundingBox.z0; k <= this.boundingBox.z1; ++k) {
					for (int l = this.boundingBox.x0; l <= this.boundingBox.x1; ++l) {
						pos.set(l, 64, k);
						if (boundingBox.isInside(pos)) {
							i += world.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos).getY();
							++j;
						}
					}
				}
				if (j == 0) {
					return false;
				} else {
					this.heightPosition = i / j;
					this.boundingBox.move(0, this.heightPosition - this.boundingBox.y0 + yOffset, 0);
					return true;
				}
			}
		}*/

}
