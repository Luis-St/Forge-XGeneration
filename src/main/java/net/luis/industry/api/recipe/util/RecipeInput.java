package net.luis.industry.api.recipe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.luis.industry.api.recipe.item.RecipeInputItem;

public class RecipeInput {

	private List<RecipeInputItem> inputList = new ArrayList<RecipeInputItem>();
	
	public RecipeInput(RecipeInputItem... inputList) {
		
		this.inputList.addAll(Arrays.asList(inputList));
		
	}
	
	public RecipeInput(List<RecipeInputItem> inputList) {
		
		this.inputList = inputList;
		
	}

	public List<RecipeInputItem> getInputList() {
		
		return inputList;
		
	}

	public void setInputList(List<RecipeInputItem> inputList) {
		
		this.inputList = inputList;
		
	}
	
}
