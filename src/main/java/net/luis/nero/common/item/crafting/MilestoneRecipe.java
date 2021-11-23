package net.luis.nero.common.item.crafting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.luis.nero.common.inventory.ModItemStackHandler;
import net.luis.nero.common.util.Chance;
import net.luis.nero.common.util.exception.NetworkReadingException;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.recipe.ModRecipeSerializer;
import net.luis.nero.init.recipe.ModRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class MilestoneRecipe implements IModRecipe {
	
	private final ResourceLocation id;
	private final List<ItemStack> input;
	private final List<ResultItem> result;
	
	public MilestoneRecipe(ResourceLocation id, List<ItemStack> input, List<ResultItem> result) {
		this.id = id;
		this.input = input;
		this.result = result;
	}

	@Override
	public boolean matches(ModItemStackHandler inventory, Level level) {
		return inventory.hasItems(this.input);
	}

	@Override
	public NonNullList<ItemStack> getInput() {
		return NonNullList.of(ItemStack.EMPTY, this.input.toArray(ItemStack[]::new));
	}

	@Override
	public NonNullList<ResultItem> getResult() {
		return NonNullList.of(ResultItem.EMPTY, this.result.toArray(ResultItem[]::new));
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<MilestoneRecipe> getSerializer() {
		return ModRecipeSerializer.MILESTONE.get();
	}

	@Override
	public RecipeType<MilestoneRecipe> getType() {
		return ModRecipeTypes.MILESTONE;
	}
	
	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlockItems.MILESTONE.get());
	}
	
	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<MilestoneRecipe> {

		@Override
		public MilestoneRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
			List<Item> inputItems = new ArrayList<>();
			JsonArray inputArray = GsonHelper.getAsJsonArray(jsonObject, "input");
			for (int i = 0; i < inputArray.size(); i++) {
				inputItems.add(this.getItem(inputArray.get(i).getAsJsonObject()));
			}
			List<ResultItem> resultItems = new ArrayList<>();
			JsonArray resultArray = GsonHelper.getAsJsonArray(jsonObject, "result");
			for (int i = 0; i < resultArray.size(); i++) {
				JsonObject resultObject = resultArray.get(i).getAsJsonObject();
				Item item = this.getItem(jsonObject);
				int chance = GsonHelper.getAsInt(resultObject, "chance");
				if (resultObject.has("min") && resultObject.has("max")) {
					int min = GsonHelper.getAsInt(resultObject, "min");
					int max = GsonHelper.getAsInt(resultObject, "max");
					resultItems.add(new ResultItem(item, min, max, chance));
				} else {
					int count = GsonHelper.getAsInt(resultObject, "count");
					resultItems.add(new ResultItem(item, count, chance));
				}
			}
			return new MilestoneRecipe(id, inputItems.stream().map(ItemStack::new).collect(Collectors.toList()), resultItems);
		}
		
		@SuppressWarnings("deprecation")
		protected Item getItem(JsonObject jsonObject) {
			String string = GsonHelper.getAsString(jsonObject, "item");
			return Registry.ITEM.getOptional(new ResourceLocation(string)).orElseThrow(() -> {
				return new JsonParseException("The given Item " + string + "does not exist");
			});
		}

		@Override
		public MilestoneRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
			List<ItemStack> input = buffer.readList(FriendlyByteBuf::readItem);
			List<Item> resultItem = buffer.readList(FriendlyByteBuf::readItem).stream().map(ItemStack::getItem).collect(Collectors.toList());
			List<Chance> resultChance = buffer.readList(FriendlyByteBuf::readInt).stream().map(Chance::new).collect(Collectors.toList());
			List<Integer> resultMin = buffer.readList(FriendlyByteBuf::readInt).stream().collect(Collectors.toList());
			List<Integer> resultMax = buffer.readList(FriendlyByteBuf::readInt).stream().collect(Collectors.toList());
			List<ResultItem> result = new ArrayList<>();
			if (!(resultItem.size() == resultChance.size() && resultChance.size() == resultMin.size() && resultMin.size() == resultMax.size())) {
				throw new NetworkReadingException("Something went wrong when reading the MilestoneRecipe from Network");
			}
			for (int i = 0; i < resultItem.size(); i++) {
				result.add(new ResultItem(resultItem.get(i), resultMin.get(i), resultMax.get(i), resultChance.get(i)));
			}
			return new MilestoneRecipe(id, input, result);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, MilestoneRecipe recipe) {
			buffer.writeCollection(recipe.input, FriendlyByteBuf::writeItem);
			buffer.writeCollection(recipe.result.stream().map(ResultItem::getItem).map(ItemStack::new).collect(Collectors.toList()), FriendlyByteBuf::writeItem);
			buffer.writeCollection(recipe.result.stream().map(ResultItem::getChance).map(Chance::getValue).collect(Collectors.toList()), FriendlyByteBuf::writeInt);
			buffer.writeCollection(recipe.result.stream().map(ResultItem::getMin).collect(Collectors.toList()), FriendlyByteBuf::writeInt);
			buffer.writeCollection(recipe.result.stream().map(ResultItem::getMax).collect(Collectors.toList()), FriendlyByteBuf::writeInt);
		}
		
	}

}
