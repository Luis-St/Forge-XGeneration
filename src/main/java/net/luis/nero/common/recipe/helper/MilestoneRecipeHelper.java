package net.luis.nero.common.recipe.helper;

import java.util.Random;
import java.util.UUID;

import net.luis.nero.api.recipe.AbstractRecipeHelper;
import net.luis.nero.api.recipe.ModRecipeHelper;
import net.luis.nero.api.recipe.item.ResultItemStack;
import net.luis.nero.api.util.VarArgs;
import net.luis.nero.api.util.annotation.Recipe;
import net.luis.nero.common.enums.ModRecipeType;
import net.luis.nero.common.recipe.MilestoneRecipe;
import net.luis.nero.init.block.item.ModBlockItems;
import net.luis.nero.init.items.ModItems;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

// TODO: new recipe regstration -> world/tileentity capability
public class MilestoneRecipeHelper extends AbstractRecipeHelper<MilestoneRecipe> {
	
	/* Stone: 20
	 * Ore: 25
	 * Sand/Gravel: 10
	 * Wood, glass: 15
	 * Obsidian: 40
	 * Flower: 5
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
	public void createRecipeList() {
		super.createRecipeList();
		int colorCount = DyeColor.values().length;
		for (int i = 0; i < colorCount; i++) {
			DyeColor color = DyeColor.byId(i);
			Random rng = new Random(i);
			this.createColoredGlassBlockRecipe(color, 15, new UUID(rng.nextLong(), rng.nextLong() * -1));
		} 
		for (int i = colorCount; i < colorCount + colorCount; i++) {
			DyeColor color = DyeColor.byId(i - colorCount);
			Random rng = new Random(i);
			this.createColoredGlassPaneRecipe(color, 15, new UUID(rng.nextLong(), rng.nextLong() * -1));
		}
		this.createDeadCoralRecipe(Items.DEAD_TUBE_CORAL_BLOCK, UUID.fromString("5f7c85d4-1876-43f9-afc2-5b8147787be9"));
		this.createDeadCoralRecipe(Items.DEAD_BRAIN_CORAL_BLOCK, UUID.fromString("ba322431-30c8-4bb5-9080-2903fba40a15"));
		this.createDeadCoralRecipe(Items.DEAD_BUBBLE_CORAL_BLOCK, UUID.fromString("dda9d9dd-ce6f-4eee-b9f1-1c71b798f897"));
		this.createDeadCoralRecipe(Items.DEAD_FIRE_CORAL_BLOCK, UUID.fromString("9836054b-a87b-4353-85fb-379f6b485789"));
		this.createDeadCoralRecipe(Items.DEAD_HORN_CORAL_BLOCK, UUID.fromString("bcd28cf0-3e49-4504-9b3e-cc383353f266"));
		this.createCoralRecipe(Items.TUBE_CORAL_BLOCK, Items.BLUE_DYE, UUID.fromString("74a6f802-a796-4776-be8c-da58acb7eb8f"));
		this.createCoralRecipe(Items.BRAIN_CORAL_BLOCK, Items.MAGENTA_DYE, UUID.fromString("5c2b1804-fda8-4330-b331-fc504240389a"));
		this.createCoralRecipe(Items.BUBBLE_CORAL_BLOCK, Items.PURPLE_DYE, UUID.fromString("0b3348eb-7e6b-431e-b1ca-8687bf5e19da"));
		this.createCoralRecipe(Items.FIRE_CORAL_BLOCK, Items.RED_DYE, UUID.fromString("00f0cc47-06d7-4bce-86b5-f547c3c5521a"));
		this.createCoralRecipe(Items.HORN_CORAL_BLOCK, Items.YELLOW_DYE, UUID.fromString("c5b9d43c-69e7-426e-85a7-40b8811c7f0d"));
		
		this.createDeadCoralRecipe(Items.DEAD_TUBE_CORAL, UUID.fromString("04b82a6c-4b46-46e6-81d5-297e9ffff71c"));
		this.createDeadCoralRecipe(Items.DEAD_BRAIN_CORAL, UUID.fromString("ce71d5b2-0572-455f-adf2-13f64103e92c"));
		this.createDeadCoralRecipe(Items.DEAD_BUBBLE_CORAL, UUID.fromString("249f878c-6ab8-497f-8126-a4460d4c1e24"));
		this.createDeadCoralRecipe(Items.DEAD_FIRE_CORAL, UUID.fromString("8409e052-fb7e-402b-8da4-fb3e2aa1f5ad"));
		this.createDeadCoralRecipe(Items.DEAD_HORN_CORAL, UUID.fromString("a6142ada-6835-4ceb-8fab-b5a1fe89ad89"));
		this.createCoralRecipe(Items.TUBE_CORAL, Items.BLUE_DYE, UUID.fromString("2ab53817-74c9-4603-9b18-eb72d1f9d26a"));
		this.createCoralRecipe(Items.BRAIN_CORAL, Items.MAGENTA_DYE, UUID.fromString("47364d94-7d4d-466b-b276-0ea39cc9e2f0"));
		this.createCoralRecipe(Items.BUBBLE_CORAL, Items.PURPLE_DYE, UUID.fromString("8c007f6b-4e4e-49a2-a8e8-62f80cceae84"));
		this.createCoralRecipe(Items.FIRE_CORAL, Items.RED_DYE, UUID.fromString("a8a5093d-4f41-469c-b909-f5f009c35597"));
		this.createCoralRecipe(Items.HORN_CORAL, Items.YELLOW_DYE, UUID.fromString("79f41717-901a-4757-a6d3-7cde600cc7e3"));
		
		this.createDeadCoralRecipe(Items.DEAD_TUBE_CORAL_FAN, UUID.fromString("8508c609-210d-49aa-8c04-7a4a009be060"));
		this.createDeadCoralRecipe(Items.DEAD_BRAIN_CORAL_FAN, UUID.fromString("c9e6681c-0f5f-4689-9b12-accb29d79c23"));
		this.createDeadCoralRecipe(Items.DEAD_BUBBLE_CORAL_FAN, UUID.fromString("e21c8fb4-fc35-4343-8876-ddee3de4e5e4"));
		this.createDeadCoralRecipe(Items.DEAD_FIRE_CORAL_FAN, UUID.fromString("f18f1d0b-66ee-47da-9802-41f74981d83b"));
		this.createDeadCoralRecipe(Items.DEAD_HORN_CORAL_FAN, UUID.fromString("efdd949f-0978-4f54-a200-4ae5637c8237"));
		this.createCoralRecipe(Items.TUBE_CORAL_FAN, Items.BLUE_DYE, UUID.fromString("671043ba-70bf-4f05-979c-ca2d1b55a68f"));
		this.createCoralRecipe(Items.BRAIN_CORAL_FAN, Items.MAGENTA_DYE, UUID.fromString("34ec99b6-6a00-4c34-b5a1-7b598f40e976"));
		this.createCoralRecipe(Items.BUBBLE_CORAL_FAN, Items.PURPLE_DYE, UUID.fromString("3e70b628-59f7-4604-b9e9-7230bbde8a5d"));
		this.createCoralRecipe(Items.FIRE_CORAL_FAN, Items.RED_DYE, UUID.fromString("2765a387-1ba3-4008-8c92-56abd603e224"));
		this.createCoralRecipe(Items.HORN_CORAL_FAN, Items.YELLOW_DYE, UUID.fromString("3377f9ab-afc9-40a1-8638-7116f0e88f15"));
		
		this.createFlowerRecipe(Items.DANDELION, Items.YELLOW_DYE, UUID.fromString("02420d4e-adca-4955-8e2b-126c93f87c16"));
		this.createFlowerRecipe(Items.POPPY, Items.RED_DYE, UUID.fromString("1d635115-5087-4df0-a9f1-cbbe0ce66420"));
		this.createFlowerRecipe(Items.BLUE_ORCHID, Items.LIGHT_BLUE_DYE, UUID.fromString("d292fa44-2c5b-4009-b9bb-f51a32266f88"));
		this.createFlowerRecipe(Items.ALLIUM, Items.MAGENTA_DYE, UUID.fromString("649fadf3-bd3d-4c2f-b463-641c51bb7cfb"));
		this.createFlowerRecipe(Items.AZURE_BLUET, Items.LIGHT_GRAY_DYE, UUID.fromString("b1214083-d4a3-4d82-ac58-31e0354a3973"));
		this.createFlowerRecipe(Items.RED_TULIP, Items.RED_DYE, UUID.fromString("b04f216b-82c8-4987-afaf-7a09296671d9"));
		this.createFlowerRecipe(Items.ORANGE_TULIP, Items.ORANGE_DYE, UUID.fromString("d32aa9c5-d748-4059-9611-58339ce0d26a"));
		this.createFlowerRecipe(Items.WHITE_TULIP, Items.LIGHT_GRAY_DYE, UUID.fromString("2174f3b2-eaf3-4519-8e8e-c85a39e8faf1"));
		this.createFlowerRecipe(Items.PINK_TULIP, Items.PINK_DYE, UUID.fromString("96b82302-8906-403f-a59c-7a8643e76274"));
		this.createFlowerRecipe(Items.OXEYE_DAISY, Items.LIGHT_GRAY_DYE, UUID.fromString("5b216add-5043-4574-a6a5-e2bb311ed736"));
		this.createFlowerRecipe(Items.CORNFLOWER, Items.BLUE_DYE, UUID.fromString("ed578cef-bedf-40d9-9f5a-78f97dec5b46"));
		this.createFlowerRecipe(Items.LILY_OF_THE_VALLEY, Items.WHITE_DYE, UUID.fromString("d640ecf8-3d03-4228-bb53-b09b222b69cd"));
		this.createFlowerRecipe(Items.WITHER_ROSE, Items.BLACK_DYE, UUID.fromString("b334da52-e2d2-4e28-80e4-7a125d514ab6"));
		this.createFlowerRecipe(Items.SUNFLOWER, Items.YELLOW_DYE, UUID.fromString("06e9e945-fe7c-4ebf-9946-53444f1415d2"));
		this.createFlowerRecipe(Items.LILAC, Items.MAGENTA_DYE, UUID.fromString("6e0226b1-a4aa-49fb-aa80-7301ee9c7f00"));
		this.createFlowerRecipe(Items.ROSE_BUSH, Items.RED_DYE, UUID.fromString("89a03eb3-74b8-4c65-8584-73dd74caf922"));
		this.createFlowerRecipe(Items.PEONY, Items.PINK_DYE, UUID.fromString("7f92377b-c763-41c2-9e1e-e32597a275b4"));
	}
	
	@Override
	public ModRecipeType getRecipeType() {
		return ModRecipeType.MILESTONE;
	}
	
	@Recipe(time = 5, id = "aba52d0d-dbea-40cd-bd38-595bdfb00323")
	protected MilestoneRecipe createLilyPadRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.LILY_PAD));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GREEN_DYE, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 5, id = "1c136db7-6c18-4f2a-8a58-d3213046a2ec")
	protected MilestoneRecipe createVinesRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.VINE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GREEN_DYE, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected void createColoredGlassPaneRecipe(DyeColor color, int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(ModRecipeHelper.glassPaneFromColor(color)));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModRecipeHelper.glassShardFromColor(color), 1, 2, 100));
		this.registerRecipe(new MilestoneRecipe(input, result, progressTime, id));
	}
	
	@Recipe(time = 15, id = "05ae6ec1-dd41-4308-8fbb-8c986de65029")
	protected MilestoneRecipe createGlassPaneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GLASS_PANE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModItems.GLASS_SHARD.get(), 1, 2, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "7547fa40-c07d-4745-bfea-deb2d22776d9")
	protected MilestoneRecipe createChainRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CHAIN));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.IRON_NUGGET, 1, 4, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "9e078041-17c6-4116-8575-82118e6a8659")
	protected MilestoneRecipe createIronBarsRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.IRON_BARS));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.IRON_INGOT, 1, 2, 100));
		result.add(new ResultItemStack(Items.IRON_INGOT, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "d5803492-099c-4a73-b177-3893038593fb")
	protected MilestoneRecipe createCactusRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CACTUS));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.GREEN_DYE, 2, 100));
		result.add(new ResultItemStack(Items.GREEN_DYE, 25));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 5, id = "38a050f0-9401-4f19-82a5-9369511239af")
	protected MilestoneRecipe createBambooRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.BAMBOO));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.STICK, 80));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 5, id = "a7cc7b8f-07fb-4567-8f80-f12fd69d1a34")
	protected MilestoneRecipe createSugarCaneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.SUGAR_CANE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.SUGAR, 100));
		result.add(new ResultItemStack(Items.SUGAR, 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	// TODO: cancle place event of 2 block flowers
	protected void createFlowerRecipe(Item flower, Item dye, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(flower));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(dye, 2, 100));
		result.add(new ResultItemStack(dye, 25));
		this.registerRecipe(new MilestoneRecipe(input, result, 5, id));
	}
	
	@Recipe(time = 40, id = "526d4b3c-9276-4a3b-813d-7af31c634489")
	protected MilestoneRecipe createCryingObsidianRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.CRYING_OBSIDIAN));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.OBSIDIAN, 100));
		result.add(new ResultItemStack(ModItems.OBSIDIAN_POWDER.get(), 50));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 40, id = "fdf44ee6-e1b5-4080-a354-0b9c46fe7d8b")
	protected MilestoneRecipe createAncientDebrisRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.ANCIENT_DEBRIS));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.NETHERITE_SCRAP, 100));
		result.add(new ResultItemStack(Items.NETHERITE_SCRAP, 5));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected void createCoralRecipe(Item coral, Item dye, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(coral));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(dye, 100));
		result.add(new ResultItemStack(Items.BONE_MEAL, 100));
		result.add(new ResultItemStack(Items.BONE_MEAL, 50));
		this.registerRecipe(new MilestoneRecipe(input, result, 20, id));
	}
	
	protected void createDeadCoralRecipe(Item coral, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(coral));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.BONE_MEAL, 100));
		result.add(new ResultItemStack(Items.BONE_MEAL, 50));
		this.registerRecipe(new MilestoneRecipe(input, result, 20, id));
	}
	
	@Recipe(time = 20, id = "8f937ea7-9046-49a0-9f70-9e72a7f5cda7")
	protected MilestoneRecipe createBoneBlockRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.BONE_BLOCK));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.BONE, 3, 9, 100));
		result.add(new ResultItemStack(Items.BONE_MEAL, 1, 3, 75));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	@Recipe(time = 20, id = "f3f8c1be-0051-4d4e-807a-1e6ab17a6d27")
	protected MilestoneRecipe createRedSandstoneRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.RED_SANDSTONE));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(Items.RED_SAND, 1, 4, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
	}
	
	protected void createColoredGlassBlockRecipe(DyeColor color, int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(ModRecipeHelper.glassBlockFromColor(color)));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModRecipeHelper.glassShardFromColor(color), 1, 4, 100));
		this.registerRecipe(new MilestoneRecipe(input, result, progressTime, id));
	}
	
	@Recipe(time = 15, id = "8987e9fa-0dcf-4405-8232-e265a64d1df0")
	protected MilestoneRecipe createGlassBlockRecipe(int progressTime, UUID id) {
		VarArgs<ItemStack> input = new VarArgs<ItemStack>();
		input.add(new ItemStack(Items.GLASS));
		VarArgs<ResultItemStack> result = new VarArgs<ResultItemStack>();
		result.add(new ResultItemStack(ModItems.GLASS_SHARD.get(), 1, 4, 100));
		return new MilestoneRecipe(input, result, progressTime, id);
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
