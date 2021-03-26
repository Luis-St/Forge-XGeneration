package net.luis.industry.api.tileentities;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.util.RecipeList;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class RecipeTileEntity extends TileEntity implements IRecipeProvider<IModRecipe>, ITickableTileEntity {

	public RecipeTileEntity(TileEntityType<?> type, IModRecipe recipe, IModRecipeHelper<IModRecipe> recipeHelper) {
		
		super(type);
		
	}

	@Override
	public void tick() {
		
		
		
	}

	@Override
	public RecipeList<IModRecipe> getRecipeList() {
		
		return null;
		
	}

	@Override
	public IModRecipeHelper<IModRecipe> getRecipeHelper() {
		
		return null;
		
	}

}
