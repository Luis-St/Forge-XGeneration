package net.luis.nero.common.recipe;

import com.google.gson.JsonObject;

import net.luis.nero.api.recipe.IModRecipe;
import net.luis.nero.api.recipe.item.ResultItemStack;
import net.luis.nero.api.util.VarArgs;
import net.luis.nero.init.block.item.ModBlockItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class MilestoneRecipe implements IModRecipe<Inventory> {
	
	private final ResourceLocation id;
	private final VarArgs<ItemStack> input;
	private final VarArgs<ResultItemStack> result;
	
	public MilestoneRecipe(ResourceLocation id, VarArgs<ItemStack> input, VarArgs<ResultItemStack> result) {
		this.id = id;
		this.input = input;
		this.result = result;
	}

	@Override
	public boolean matches(Inventory inventory, World world) {
		return false;
	}

	@Override
	public ItemStack assemble(Inventory inventory) {
		return null;
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
	public IRecipeSerializer<?> getSerializer() {
		return null;
	}

	@Override
	public IRecipeType<?> getType() {
		return null;
	}
	
	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ModBlockItems.MILESTONE.get());
	}
	
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<MilestoneRecipe> {

		@Override
		public MilestoneRecipe fromJson(ResourceLocation id, JsonObject jsonObject) {
			return null;
		}

		@Override
		public MilestoneRecipe fromNetwork(ResourceLocation id, PacketBuffer packetBuffer) {
			return null;
		}

		@Override
		public void toNetwork(PacketBuffer id, MilestoneRecipe recipe) {
			
		}
		
	}

}
