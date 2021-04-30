package net.luis.industry.data;

import java.util.function.Consumer;

import net.luis.industry.init.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		super.buildShapelessRecipes(consumer);
		this.makeGlassShardRecipe(ModItems.BLACK_GLASS_SHARD.get(), Items.BLACK_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.BLUE_GLASS_SHARD.get(), Items.BLUE_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.BROWN_GLASS_SHARD.get(), Items.BROWN_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.CYAN_GLASS_SHARD.get(), Items.CYAN_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.GLASS_SHARD.get(), Items.GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.GRAY_GLASS_SHARD.get(), Items.GRAY_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.GREEN_GLASS_SHARD.get(), Items.GREEN_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.LIGHT_BLUE_GLASS_SHARD.get(), Items.LIGHT_BLUE_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.LIGHT_GRAY_GLASS_SHARD.get(), Items.LIGHT_GRAY_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.LIME_GLASS_SHARD.get(), Items.LIME_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.MAGENTA_GLASS_SHARD.get(), Items.MAGENTA_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.ORANGE_GLASS_SHARD.get(), Items.ORANGE_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.PINK_GLASS_SHARD.get(), Items.PINK_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.PURPLE_GLASS_SHARD.get(), Items.PURPLE_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.RED_GLASS_SHARD.get(), Items.RED_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.WHITE_GLASS_SHARD.get(), Items.WHITE_STAINED_GLASS, consumer);
		this.makeGlassShardRecipe(ModItems.YELLOW_GLASS_SHARD.get(), Items.YELLOW_STAINED_GLASS, consumer);
	}
	
	private void makeGlassShardRecipe(Item glassShard, Item glassBlock, Consumer<IFinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(glassBlock).define('#', glassShard).pattern("##").pattern("##").group("").save(consumer);
	}

}
