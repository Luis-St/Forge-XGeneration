package net.luis.industry.common.recipe.helper;

import java.util.UUID;

import net.luis.industry.api.recipe.AbstractRecipeHelper;
import net.luis.industry.api.recipe.item.ResultItemStack;
import net.luis.industry.api.util.VarArgs;
import net.luis.industry.api.util.annotation.Recipe;
import net.luis.industry.common.enums.ModRecipeType;
import net.luis.industry.common.recipe.MilestoneRecipe;
import net.luis.industry.init.block.item.ModBlockItems;
import net.luis.industry.init.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	/* Stone: 20
	 * Ore: 25
	 * Sand/Gravel: 10
	 * Wood: 15
	 * Obsidian: 40
	 */
	
//	@NotTested
//	@Recipe(time = 20, id = "")
//	protected MilestoneRecipe createRecipe(int progressTime, UUID id) {
//		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
//		input.add(new ItemStack(null));
//		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
//		result.add(new ResultItemStack(null, 100));
//		return new MilestoneRecipe(input, result, progressTime, id);
//	}
	
	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}
	
	@Recipe(time = 20, id = "553af932-cf26-400c-b410-22b90d9bc24a")
	protected MilestoneRecipe createSeaLenternRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.SEA_LANTERN));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.PRISMARINE_CRYSTALS, 1, 3, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "36cbadd4-3339-479b-b9bf-a826d8d3470d")
	protected MilestoneRecipe createDarkPrismarineRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.DARK_PRISMARINE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.PRISMARINE_SHARD, 1, 2, 100));
		result.add(new ResultItemStack(ModItems.MITHRIL.get(), 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "ab681786-c7eb-4f17-91e0-bcbae9536c61")
	protected MilestoneRecipe createPrismarineBricksRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.PRISMARINE_BRICKS));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.PRISMARINE_SHARD, 1, 2, 100));
		result.add(new ResultItemStack(Items.PRISMARINE_CRYSTALS, 50));
		result.add(new ResultItemStack(ModItems.MITHRIL.get(), 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "c03674ea-ee8f-4216-932b-dcef0e0c77b4")
	protected MilestoneRecipe createPrismarineRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.PRISMARINE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.PRISMARINE_SHARD, 1, 2, 100));;
		result.add(new ResultItemStack(Items.PRISMARINE_CRYSTALS, 50));
		result.add(new ResultItemStack(ModItems.MITHRIL.get(), 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "53dddb1b-accd-43bf-a1a0-d09ecef53810")
	protected MilestoneRecipe createTerrocottaRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.TERRACOTTA));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.RED_SAND, 100));
		result.add(new ResultItemStack(Items.RED_SAND, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "8df2bc3b-5ea7-475e-9afd-7116b3310626")
	protected MilestoneRecipe createNetherQuartzOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.NETHER_QUARTZ_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.QUARTZ, 1, 3, 100));
		result.add(new ResultItemStack(Items.NETHERRACK, 75));
		result.add(new ResultItemStack(Items.QUARTZ, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "74acd642-ab87-429d-a157-8a46b4c6596e")
	protected MilestoneRecipe createEmeraldOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.EMERALD_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.EMERALD, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(Items.EMERALD, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "2ba3eba4-99f1-45f3-ad0f-dc27c9bdcf55")
	protected MilestoneRecipe createGlowstoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GLOWSTONE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GLOWSTONE_DUST, 1, 4, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 10, id = "4a048c07-97e3-4b99-97ce-37f1af99bf38")
	protected MilestoneRecipe createClayRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CLAY));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.CLAY_BALL, 2, 4, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "6fde5bf4-b5a3-4a16-9459-d2fbde77bbaf")
	protected MilestoneRecipe createRedstoneOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.REDSTONE_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.REDSTONE, 1, 4, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(Items.REDSTONE, 1, 2, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "ecd3ea22-f93b-46c0-b5b9-0e8a8654e31e")
	protected MilestoneRecipe createDiamondOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.DIAMOND_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.DIAMOND, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(Items.DIAMOND, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 40, id = "09d48990-1b5f-490b-942b-840a086f0a0a")
	protected MilestoneRecipe createObsidianRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.OBSIDIAN));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModItems.OBSIDIAN_POWDER.get(), 100));
		result.add(new ResultItemStack(Items.OBSIDIAN, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "22d2edca-6679-4dce-9160-b612fdf2674c")
	protected MilestoneRecipe createMossyCobblestoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.MOSSY_COBBLESTONE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "15c70d49-1bc0-4f3c-8e98-a09359041c66")
	protected MilestoneRecipe createSandstoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.SANDSTONE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.SAND, 1, 4, 100));
		result.add(new ResultItemStack(Items.SAND, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "dac21df4-8d48-4762-a19d-d98f7eb2a6ff")
	protected MilestoneRecipe createLapisOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.LAPIS_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 1, 2, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "6ad364a3-a70a-4ead-9121-727fc465f859")
	protected MilestoneRecipe createCrimsonStemRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CRIMSON_STEM));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.CRIMSON_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "b09bb158-e45d-418c-b5fc-89690c875031")
	protected MilestoneRecipe createWarpedStemRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.WARPED_STEM));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.WARPED_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "b072981e-30ed-4995-b6f7-d537da59fd6d")
	protected MilestoneRecipe createDarkOakLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.DARK_OAK_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.DARK_OAK_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "3b5ca931-fc65-44b5-a325-f4305e21a0c3")
	protected MilestoneRecipe createAcaciaLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.ACACIA_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.ACACIA_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "6e6bbbdd-0ff5-4627-b308-c0b58cb562ba")
	protected MilestoneRecipe createJungleLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.JUNGLE_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.JUNGLE_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "7bf33157-192b-4655-a617-b5f2a8a5e221")
	protected MilestoneRecipe createBirchLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.BIRCH_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.BIRCH_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "c832289c-126c-4426-9fc4-ade462d71a8c")
	protected MilestoneRecipe createSpruceLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.SPRUCE_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.SPRUCE_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 15, id = "e93311c7-d6c6-4f4b-8299-026c69c41b4f")
	protected MilestoneRecipe createOakLogRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.OAK_LOG));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.OAK_PLANKS, 3, 4, 100));
		result.add(new ResultItemStack(Items.STICK, 1, 2, 60));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "1e0e6ce1-d2ab-4765-82c8-d1937ebf9d78")
	protected MilestoneRecipe createNetherGoldOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.NETHER_GOLD_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GOLD_NUGGET, 2, 5, 100));
		result.add(new ResultItemStack(Items.NETHERRACK, 75));
		result.add(new ResultItemStack(Items.GOLD_NUGGET, 1, 3, 25));
		result.add(new ResultItemStack(ModItems.CRUSHED_GOLD_ORE.get(), 5));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "fdc27837-a838-4106-a88a-8d1b65c7d361")
	protected MilestoneRecipe createCoalOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.COAL_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COAL, 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(Items.COAL, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "36917b1d-53a9-43fc-85d4-ba2decc83832")
	protected MilestoneRecipe createIronOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.IRON_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModItems.CRUSHED_IRON_ORE.get(), 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(ModItems.CRUSHED_IRON_ORE.get(), 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 25, id = "5417b157-44f3-4e4a-aefc-64e945766488")
	protected MilestoneRecipe createGoldOreRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GOLD_ORE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModItems.CRUSHED_GOLD_ORE.get(), 100));
		result.add(new ResultItemStack(Items.COBBLESTONE, 75));
		result.add(new ResultItemStack(ModItems.CRUSHED_GOLD_ORE.get(), 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 10, id = "f3a61ddb-6ffc-45bf-aced-5686b73de3e0")
	protected MilestoneRecipe createGravelRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GRAVEL));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.FLINT, 75));
		result.add(new ResultItemStack(Items.CLAY, 50));
		result.add(new ResultItemStack(Items.COAL, 40));
		result.add(new ResultItemStack(ModBlockItems.COPPER_ORE.get(), 30));
		result.add(new ResultItemStack(Items.IRON_ORE, 20));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 10, id = "53481212-1639-4bbb-a86d-0f7fa82cdffa")
	protected MilestoneRecipe createRedSandRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.RED_SAND));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.CLAY, 100));
		result.add(new ResultItemStack(Items.CLAY, 50));
		result.add(new ResultItemStack(Items.GOLD_NUGGET, 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 10, id = "17a1af7d-bbfe-40d6-8e7d-8d314290ced8")
	protected MilestoneRecipe createSandRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.SAND));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.CLAY, 100));
		result.add(new ResultItemStack(Items.CLAY, 50));
		result.add(new ResultItemStack(Items.IRON_NUGGET, 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "62e3446a-d12f-4f71-98b1-d07ff1b00971")
	protected MilestoneRecipe createCobblestoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.COBBLESTONE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GRAVEL, 100));
		result.add(new ResultItemStack(Items.GRAVEL, 50));
		result.add(new ResultItemStack(Items.COAL, 50));
		result.add(new ResultItemStack(ModBlockItems.COPPER_ORE.get(), 40));
		result.add(new ResultItemStack(Items.IRON_ORE, 30));
		result.add(new ResultItemStack(Items.GOLD_ORE, 20));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "1ca553c6-ab69-48c2-9b21-0ce1f3b106f1")
	protected MilestoneRecipe createAndesiteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.ANDESITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.DIORITE, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "859d9005-ab14-4756-97ec-c89b1f823257")
	protected MilestoneRecipe createDioriteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.DIORITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.QUARTZ, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "34e980f8-f095-45f3-a0e4-fac64ddb79e5")
	protected MilestoneRecipe createGraniteRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GRANITE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.DIORITE, 50));
		result.add(new ResultItemStack(Items.QUARTZ, 25));
		result.add(new ResultItemStack(Items.REDSTONE, 1, 10));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "f9e17662-bdb7-4735-8e9a-ca256b60b0ac")
	protected MilestoneRecipe createStoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.STONE, 1));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.COBBLESTONE, 100));
		result.add(new ResultItemStack(Items.COAL, 60));
		result.add(new ResultItemStack(ModBlockItems.COPPER_ORE.get(), 50));
		result.add(new ResultItemStack(Items.IRON_ORE, 40));
		result.add(new ResultItemStack(Items.GOLD_ORE, 30));
		result.add(new ResultItemStack(Items.LAPIS_LAZULI, 2, 4, 20));
		result.add(new ResultItemStack(Items.REDSTONE, 2, 3, 10));
		result.add(new ResultItemStack(Items.DIAMOND, 5));
		result.add(new ResultItemStack(Items.EMERALD, 2));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
}
