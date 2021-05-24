package net.luis.industry.api.inventory.recipe;

import java.util.List;

import net.luis.industry.api.inventory.IModInventory;
import net.luis.industry.api.inventory.InventorySlot;
import net.luis.industry.api.recipe.IModRecipe;

public interface IRecipeInventory extends IModInventory {

	List<InventorySlot> hasItemsForRecipe(IModRecipe recipe);

	void extractRecipe(IModRecipe recipe);
	
}
