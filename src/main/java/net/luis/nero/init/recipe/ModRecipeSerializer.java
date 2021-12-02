package net.luis.nero.init.recipe;

import net.luis.nero.Nero;
import net.luis.nero.common.item.crafting.MilestoneRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {
	
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Nero.MOD_ID);
	
	public static final RegistryObject<MilestoneRecipe.Serializer> MILESTONE = RECIPE_SERIALIZERS.register("milestone", MilestoneRecipe.Serializer::new);
	
}
