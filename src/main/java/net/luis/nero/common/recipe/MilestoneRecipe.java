package net.luis.nero.common.recipe;

import com.google.gson.JsonObject;

import net.luis.nero.api.common.recipe.IModRecipe;
import net.luis.nero.api.common.recipe.item.ResultItemStack;
import net.luis.nero.api.util.VarArgs;
import net.luis.nero.init.block.item.ModBlockItems;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;

// TODO: finish & custom IModRecipe

public class MilestoneRecipe implements IModRecipe<SimpleContainer> {
	
	private final ResourceLocation id;
	private final VarArgs<ItemStack> input;
	private final VarArgs<ResultItemStack> result;
	
	public MilestoneRecipe(ResourceLocation id, VarArgs<ItemStack> input, VarArgs<ResultItemStack> result) {
		this.id = id;
		this.input = input;
		this.result = result;
	}

	@Override
	public boolean matches(SimpleContainer inventory, Level world) {
		return false;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public NonNullList<ItemStack> getInput() {
		return NonNullList.of(ItemStack.EMPTY, this.input.asArray());
	}

	@Override
	public NonNullList<ResultItemStack> getResult() {
		return NonNullList.of(ResultItemStack.EMPTY, this.result.asArray());
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public RecipeType<?> getType() {
		return null;
	}
	
	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlockItems.MILESTONE.get());
	}
	
	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<MilestoneRecipe> {

		@Override
		public MilestoneRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
			return new MilestoneRecipe(id, null, null);
		}

		@Override
		public MilestoneRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf packetBuffer) {
			return new MilestoneRecipe(id, null, null);
		}

		@Override
		public void toNetwork(FriendlyByteBuf id, MilestoneRecipe recipe) {
			
		}
		
	}

}
