package net.luis.nero.common.recipe;

import net.minecraft.item.Item;

public class BloodAltarRecipe {
	
	protected final Item input;
	protected final Item output;
	protected final int time;
	protected final int blood;
	
	public BloodAltarRecipe(Item input, Item output, int time, int blood) {
		this.input = input;
		this.output = output;
		this.time = time;
		this.blood = blood;
	}
	
	public Item getInput() {
		return this.input;
	}
	
	public Item getOutput() {
		return this.output;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getBlood() {
		return this.blood;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof BloodAltarRecipe) {
			BloodAltarRecipe recipe = (BloodAltarRecipe) object;
			return recipe.input == this.input && recipe.output == this.output && recipe.time == this.time && recipe.blood == this.blood;
		}
		return super.equals(object);
	}

}
