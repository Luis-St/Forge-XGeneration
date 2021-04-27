package net.luis.industry.common.enums;

import javax.annotation.Nullable;

import net.luis.industry.api.recipe.IModRecipe;
import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.common.recipe.helper.MilestoneRecipeHelper;

public enum ModRecipeType {
	
	MILESTONE("milestone", 0, new MilestoneRecipeHelper());
	
	private final String name;
	private final int id;
	private final IModRecipeHelper<? extends IModRecipe> recipeHelper;
	
	private ModRecipeType(String name, int id, IModRecipeHelper<? extends IModRecipe> recipeHelper) {
		this.name = name;
		this.id = id;
		this.recipeHelper = recipeHelper;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public IModRecipeHelper<? extends IModRecipe> getRecipeHelper() {
		return recipeHelper;
	}
	
	@Nullable
	public static ModRecipeType byId(int id) {
		ModRecipeType[] recipeTypes = values();
		for (ModRecipeType modRecipeType : recipeTypes) {
			if (modRecipeType.getId() == id) {
				return modRecipeType;
			}
		}
		return null;
	}

}
