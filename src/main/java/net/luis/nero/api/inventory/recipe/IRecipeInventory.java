package net.luis.nero.api.inventory.recipe;

import java.util.List;

import net.luis.nero.api.inventory.IModInventory;
import net.luis.nero.api.inventory.InventorySlot;
import net.luis.nero.api.recipe.IModRecipe;

public interface IRecipeInventory extends IModInventory {

	List<InventorySlot> hasItemsForRecipe(IModRecipe recipe);

	void extractRecipe(IModRecipe recipe);
	
}
