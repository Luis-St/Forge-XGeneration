package net.luis.industry.common.recipe.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.luis.industry.api.recipe.IModRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.api.util.exception.AlreadyRegisteredException;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper implements IModRecipeHelper<MilestoneRecipe> {
	
	private final List<MilestoneRecipe> milestoneRecipes = new ArrayList<MilestoneRecipe>();
	
	@Override
	public void createRecipeList() {
		this.registerRecipe(
				new MilestoneRecipe(
						new VarArgs<ItemStack>(new ItemStack(Items.GRASS_BLOCK)), 
						new VarArgs<ResultItemStack>(new ResultItemStack(new ItemStack(Items.DIRT), 100)), 
						0));
	}
	
	@Override
	public void registerRecipe(MilestoneRecipe recipe) {
		
		if (this.isRecipeRegistered(recipe)) {
			
			throw new AlreadyRegisteredException();
			
		} else {
			
			this.milestoneRecipes.add(recipe);
			
		}
		
	}
	
	@Override
	public boolean isRecipeRegistered(MilestoneRecipe recipe) {
		return this.milestoneRecipes.contains(recipe);
	}

	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}

	@Override
	public List<MilestoneRecipe> getRecipes() {
		return this.milestoneRecipes;
	}

	@Override
	public boolean hasRecipe(ItemStack stack) {
		
		List<MilestoneRecipe> recipes = this.getRecipes();
		recipes.removeIf(milestoneRecipe -> !milestoneRecipe.containsRecipeItem(stack));
		
		return recipes.size() > 0;
		
	}

	@Override
	public List<ItemStack> getItemsForRecipe(MilestoneRecipe recipe) {
		
		if (this.isRecipeRegistered(recipe)) {
			
			return recipe.getRecipeItems();
			
		}
		
		return null;
		
	}
	
	@Override
	@Nullable
	public MilestoneRecipe getRecipeForItems(ItemStack... itemStacks) {
		
		List<MilestoneRecipe> registeredRecipes = this.getRecipes();
		List<MilestoneRecipe> milestoneRecipes = new ArrayList<MilestoneRecipe>();
		
		for (MilestoneRecipe recipe : registeredRecipes) {
			
			if (recipe.getRecipeItems().size() == itemStacks.length) {
				
				if (this.recipesEqual(recipe.getRecipeItems(), new ArrayList<ItemStack>(Arrays.asList(itemStacks)))) {
					
					milestoneRecipes.add(recipe);
					
				}
				
			}
			
		}
		
		if (!milestoneRecipes.isEmpty()) {
			
			if (milestoneRecipes.size() > 1) {
				
				return milestoneRecipes.get(new Random().nextInt(milestoneRecipes.size()));
				
			}
			
			return milestoneRecipes.get(0);
			
		}
		
		return null;
		
	}
	
	public boolean recipesEqual(List<ItemStack> milestoneItemStacks, List<ItemStack> itemStacks) {
		
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

}
