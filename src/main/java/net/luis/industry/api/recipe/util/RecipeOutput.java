package net.luis.industry.api.recipe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.luis.industry.api.recipe.item.RecipeOutputItem;

public class RecipeOutput {

	private List<RecipeOutputItem> inputList = new ArrayList<RecipeOutputItem>();
	
	public RecipeOutput(RecipeOutputItem... inputList) {
		
		this.inputList.addAll(Arrays.asList(inputList));
		
	}
	
	public RecipeOutput(List<RecipeOutputItem> inputList) {
		
		this.inputList = inputList;
		
	}

	public List<RecipeOutputItem> getInputList() {
		
		return inputList;
		
	}

	public void setInputList(List<RecipeOutputItem> inputList) {
		
		this.inputList = inputList;
		
	}
	
}

