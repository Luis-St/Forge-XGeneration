package net.luis.industry.common.recipe.helper;

import java.util.UUID;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	@Override
	public void createRecipeList() {
		super.createRecipeList();
		this.registerRecipe(this.createStoneRecipe(20, UUID.fromString("f9e17662-bdb7-4735-8e9a-ca256b60b0ac")));
		this.registerRecipe(this.createGraniteRecipe(20, UUID.fromString("34e980f8-f095-45f3-a0e4-fac64ddb79e5")));
		this.registerRecipe(this.createDioriteRecipe(20, UUID.fromString("859d9005-ab14-4756-97ec-c89b1f823257")));
		this.registerRecipe(this.createAndesiteRecipe(20, UUID.fromString("1ca553c6-ab69-48c2-9b21-0ce1f3b106f1")));
		this.registerRecipe(this.createCrimsonNyliumRecipe(20, UUID.fromString("1292fa0a-71cc-430a-ac10-efd2d9d94896")));
		this.registerRecipe(this.createWarpedNyliumRecipe(20, UUID.fromString("e20042f8-41b2-46ff-a7c9-caa52a10aaaa")));
	}

	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}
	
	protected MilestoneRecipe createWarpedNyliumRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.WARPED_NYLIUM, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.NETHERRACK, 100));
		result.add(new ResultItemStack(Items.WARPED_ROOTS, 50));
		result.add(new ResultItemStack(Items.NETHER_SPROUTS, 50));
		result.add(new ResultItemStack(Items.WARPED_FUNGUS, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected MilestoneRecipe createCrimsonNyliumRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CRIMSON_NYLIUM, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.NETHERRACK, 100));
		result.add(new ResultItemStack(Items.CRIMSON_ROOTS, 50));
		result.add(new ResultItemStack(Items.CRIMSON_FUNGUS, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected MilestoneRecipe createAndesiteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.ANDESITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.DIORITE, 50));
		result.add(new ResultItemStack(Items.IRON_ORE, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected MilestoneRecipe createDioriteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.DIORITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.QUARTZ, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected MilestoneRecipe createGraniteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GRANITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.DIORITE, 50));
		result.add(new ResultItemStack(Items.QUARTZ, 25));
		result.add(new ResultItemStack(Items.REDSTONE, 1, 2, 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected MilestoneRecipe createStoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.STONE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.COAL, 50));
		result.add(new ResultItemStack(Items.IRON_ORE, 40));
		result.add(new ResultItemStack(Items.GOLD_ORE, 30));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 20));
		result.add(new ResultItemStack(Items.REDSTONE, 2, 3, 15));
		result.add(new ResultItemStack(Items.DIAMOND, 5));
		result.add(new ResultItemStack(Items.EMERALD, 2));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
}
