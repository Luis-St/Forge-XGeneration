package net.luis.nero.api.recipe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import net.luis.nero.Nero;
import net.luis.nero.api.inventory.ItemStackList;
import net.luis.nero.api.util.annotation.Recipe;
import net.luis.nero.api.util.exception.AlreadyRegisteredException;
import net.luis.nero.api.util.exception.NotRegisteredException;
import net.minecraft.item.ItemStack;

public abstract class AbstractRecipeHelper<T extends IModRecipe> implements IModRecipeHelper<T> {
	
	protected final List<T> recipes = new ArrayList<T>();
	
	@Override
	public void createRecipeList() {
		this.recipes.clear();
		this.recipeRegistration();
	}
	
	@Override
	public void registerRecipe(T recipe) {
		if (this.isRecipeRegistered(recipe)) {
			throw new AlreadyRegisteredException("This recipe with id: " + recipe.getId() + ", has already been registered");
		} else {
			if (this.existsId(recipe)) {
				throw new AlreadyRegisteredException(recipe.getId());
			} else {
				this.recipes.add(recipe);
			}
		}
	}
	
	@SuppressWarnings({"unchecked"})
	private void recipeRegistration() {
		try {
			for (Method method : this.getClass().getDeclaredMethods()) {
				if (method.isAnnotationPresent(Recipe.class)) {
					Recipe recipe = method.getAnnotation(Recipe.class);
					method.setAccessible(true);
					Object object = method.invoke(this, recipe.time(), UUID.fromString(recipe.id()));
					if (object instanceof IModRecipe) {
						IModRecipe modRecipe = (IModRecipe) object;
						this.registerRecipe((T) modRecipe);
					}
				}
			}
		} catch (IllegalAccessException e) {
			Nero.LOGGER.warn("There was an error registering a recipe", e);
		} catch (IllegalArgumentException e) {
			Nero.LOGGER.warn("A registration method does not have the required parameters", e);
		} catch (InvocationTargetException e) {
			Nero.LOGGER.warn("There was an error registering a recipe", e);
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
	public T getRecipeFromId(UUID id) {
		T returnRecipe = null;
		for (T milestoneRecipe : this.recipes) {
			if (milestoneRecipe.getId().equals(id)) {
				returnRecipe = milestoneRecipe;
			}
		}
		if (returnRecipe == null) {
			throw new NotRegisteredException(id);
		}
		return returnRecipe;
	}
	
}
