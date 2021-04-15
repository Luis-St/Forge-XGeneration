package net.luis.industry.api.tileentity;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class RecipeTileEntity extends TileEntity implements ITickableTileEntity {

	public RecipeTileEntity(TileEntityType<?> type, IModRecipe recipe, IModRecipeHelper<IModRecipe> recipeHelper) {
		
		super(type);
		
	}

	@Override
	public void tick() {
		
		
		
	}

}
