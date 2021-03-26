package net.luis.industry.api.recipe.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.luis.industry.api.recipe.IModRecipe;

public class RecipeList<T extends IModRecipe> {
	
	private List<T> recipes;
	
	public RecipeList() {
		
		this.recipes = new ArrayList<T>();
		
	}
	
	public void add(T recipe) {
		
		this.recipes.add(recipe);
		
	}
	
	public void remove(int index) {
		
		this.recipes.remove(index);
		
	}
	
	public void remove(T recipe) {
		
		Iterator<T> iterator = recipes.iterator();
		
		if (recipes.contains(recipe)) {
			
			while (iterator.hasNext()) {
				
				if (iterator.next() == recipe) {
					
					iterator.remove();
					break;
				}
				
			}
			
		}
		
		this.recipes.clear();
		iterator.forEachRemaining(this.recipes::add);
		
	}
	
	public T getRecipe(int index) {
		
		return recipes.get(index);
		
	}
	
}
