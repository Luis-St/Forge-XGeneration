package net.luis.industry.api.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.ItemStackList;
import net.luis.industry.api.util.exception.AlreadyRegisteredException;
import net.luis.industry.api.util.exception.NotRegisteredException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class AbstractRecipeHelper<T extends IModRecipe> implements IModRecipeHelper<T> {
	
	protected final List<T> recipes = new ArrayList<T>();
	
	protected ResultItemStack creatResult(Item item, int chance) {
		return new ResultItemStack(this.creatStack(item), chance);
	} 
	
	protected ResultItemStack creatResult(ItemStack itemStack, int chance) {
		return new ResultItemStack(itemStack, chance);
	}
	
	protected ResultItemStack creatResult(Item item, int count, int chance) {
		return new ResultItemStack(this.creatStack(item, count), chance);
	}
	
	protected ItemStack creatStack(Item item) {
		return new ItemStack(item);
	}
	
	protected ItemStack creatStack(Item item, int count) {
		return new ItemStack(item, count);
	}
	
	@Override
	public void registerRecipe(T recipe) {
		if (this.isRecipeRegistered(recipe)) {
			throw new AlreadyRegisteredException("This recipe has already been registered");
		} else {
			if (this.existsId(recipe)) {
				throw new AlreadyRegisteredException(recipe.getId());
			} else {
				this.recipes.add(recipe);
			}
		}
	}
	
	@Override
	public boolean isRecipeRegistered(T recipe) {
		return this.recipes.contains(recipe);
	}
	
	public boolean existsId(T toCheck) {
		for (T recipe : this.getRecipes()) {
			if (recipe.equalsId(toCheck)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<T> getRecipes() {
		return this.recipes;
	}
	
	@Override
	public boolean hasRecipe(ItemStack stack) {
		List<T> recipes = this.getRecipes();
		recipes.removeIf(recipe -> !recipe.containsItemStack(stack, true));
		return recipes.size() > 0;
	}

	@Override
	public List<ItemStack> getItemsForRecipe(T recipe) {
		if (this.isRecipeRegistered(recipe)) {
			return recipe.getInput();
		}
		return null;
	}
	
	protected boolean recipesEqual(List<ItemStack> milestoneItemStacks, List<ItemStack> itemStacks) {
		int size = milestoneItemStacks.size();
		int equalItems = 0;
		for (int i = 0; i < size; i++) {
			ItemStack milestoneItemStack = milestoneItemStacks.get(i);
			ItemStack itemStack = itemStacks.get(i);
			if (milestoneItemStack.getItem() == itemStack.getItem()) {
				equalItems++;
			}
		}
		return equalItems == size;
	}
	
	@Nullable
	@Override
	public T getNextRecipe(ItemStackList inventory) {
		List<T> recipes = this.getRecipes();
		T returnRecipe = null;
		for (T recipe : recipes) {
			if (recipe.containsAll(inventory)) {
				returnRecipe = recipe;
				break;
			}
		}
		return returnRecipe;
	}
	
	@Nullable
	@Override
	public T getRandomRecipe(ItemStackList inventory) {
		List<T> recipes = this.getRecipes();
		List<T> availableRecipes = new ArrayList<T>();
		for (T recipe : recipes) {
			if (recipe.containsAll(inventory)) {
				availableRecipes.add(recipe);
			}
		}
		if (availableRecipes.isEmpty()) {
			return null;
		} else if (availableRecipes.size() > 1) {
			return availableRecipes.get(new Random().nextInt(availableRecipes.size()));
		}
		return availableRecipes.get(0);
	}
	
	@Override
	public T getRecipeFromId(int id) {
		T returnRecipe = null;
		for (T milestoneRecipe : this.recipes) {
			if (milestoneRecipe.getId() == id) {
				returnRecipe = milestoneRecipe;
			}
		}
		if (returnRecipe == null) {
			throw new NotRegisteredException(id);
		}
		return returnRecipe;
	}
	
}
