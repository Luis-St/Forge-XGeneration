package net.luis.industry.init.items;

import static net.luis.industry.Industry.INDUSTRY;
import static net.luis.industry.Industry.MOD_ID;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
	
	public static final RegistryObject<Item> BLACK_GLASS_SHARD = ITEMS.register("black_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> BLUE_GLASS_SHARD = ITEMS.register("blue_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> BROWN_GLASS_SHARD = ITEMS.register("brown_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> CYAN_GLASS_SHARD = ITEMS.register("cyan_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> GLASS_SHARD = ITEMS.register("glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> GRAY_GLASS_SHARD = ITEMS.register("gray_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> GREEN_GLASS_SHARD = ITEMS.register("green_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> LIGHT_BLUE_GLASS_SHARD = ITEMS.register("light_blue_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> LIGHT_GRAY_GLASS_SHARD = ITEMS.register("light_gray_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> LIME_GLASS_SHARD = ITEMS.register("lime_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> MAGENTA_GLASS_SHARD = ITEMS.register("magenta_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> ORANGE_GLASS_SHARD = ITEMS.register("orange_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> PINK_GLASS_SHARD = ITEMS.register("pink_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> RED_GLASS_SHARD = ITEMS.register("red_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> WHITE_GLASS_SHARD = ITEMS.register("white_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> YELLOW_GLASS_SHARD = ITEMS.register("yellow_glass_shard", ModItems::creatGlassShardItem);
	public static final RegistryObject<Item> PURPLE_GLASS_SHARD = ITEMS.register("purple_glass_shard", ModItems::creatGlassShardItem);
	
	private static Item creatGlassShardItem() {
		return new Item(new Item.Properties().tab(INDUSTRY));
	}
	
}
