package net.luis.industry.init.items;

import net.luis.industry.Industry;
import net.luis.industry.common.enums.OrbType;
import net.luis.industry.common.item.GlassShardItem;
import net.luis.industry.common.item.OrbItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Industry.MOD_ID);
	
	public static final RegistryObject<GlassShardItem> BLACK_GLASS_SHARD = ITEMS.register("black_glass_shard", 
			() -> new GlassShardItem(DyeColor.BLACK));
	public static final RegistryObject<GlassShardItem> BLUE_GLASS_SHARD = ITEMS.register("blue_glass_shard", 
			() -> new GlassShardItem(DyeColor.BLUE));
	public static final RegistryObject<GlassShardItem> BROWN_GLASS_SHARD = ITEMS.register("brown_glass_shard", 
			() -> new GlassShardItem(DyeColor.BROWN));
	public static final RegistryObject<GlassShardItem> CYAN_GLASS_SHARD = ITEMS.register("cyan_glass_shard", 
			() -> new GlassShardItem(DyeColor.CYAN));
	public static final RegistryObject<GlassShardItem> GLASS_SHARD = ITEMS.register("glass_shard", 
			() -> new GlassShardItem(null));
	public static final RegistryObject<GlassShardItem> GRAY_GLASS_SHARD = ITEMS.register("gray_glass_shard", 
			() -> new GlassShardItem(DyeColor.GRAY));
	public static final RegistryObject<GlassShardItem> GREEN_GLASS_SHARD = ITEMS.register("green_glass_shard", 
			() -> new GlassShardItem(DyeColor.GREEN));
	public static final RegistryObject<GlassShardItem> LIGHT_BLUE_GLASS_SHARD = ITEMS.register("light_blue_glass_shard", 
			() -> new GlassShardItem(DyeColor.LIGHT_BLUE));
	public static final RegistryObject<GlassShardItem> LIGHT_GRAY_GLASS_SHARD = ITEMS.register("light_gray_glass_shard", 
			() -> new GlassShardItem(DyeColor.LIGHT_GRAY));
	public static final RegistryObject<GlassShardItem> LIME_GLASS_SHARD = ITEMS.register("lime_glass_shard", 
			() -> new GlassShardItem(DyeColor.LIME));
	public static final RegistryObject<GlassShardItem> MAGENTA_GLASS_SHARD = ITEMS.register("magenta_glass_shard", 
			() -> new GlassShardItem(DyeColor.MAGENTA));
	public static final RegistryObject<GlassShardItem> ORANGE_GLASS_SHARD = ITEMS.register("orange_glass_shard", 
			() -> new GlassShardItem(DyeColor.ORANGE));
	public static final RegistryObject<GlassShardItem> PINK_GLASS_SHARD = ITEMS.register("pink_glass_shard", 
			() -> new GlassShardItem(DyeColor.PINK));
	public static final RegistryObject<GlassShardItem> RED_GLASS_SHARD = ITEMS.register("red_glass_shard", 
			() -> new GlassShardItem(DyeColor.RED));
	public static final RegistryObject<GlassShardItem> PURPLE_GLASS_SHARD = ITEMS.register("purple_glass_shard", 
			() -> new GlassShardItem(DyeColor.PURPLE));
	public static final RegistryObject<GlassShardItem> WHITE_GLASS_SHARD = ITEMS.register("white_glass_shard", 
			() -> new GlassShardItem(DyeColor.WHITE));
	public static final RegistryObject<GlassShardItem> YELLOW_GLASS_SHARD = ITEMS.register("yellow_glass_shard", 
			() -> new GlassShardItem(DyeColor.YELLOW));
	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> CRUSHED_COPPER_ORE = ITEMS.register("crushed_copper_ore", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> CRUSHED_IRON_ORE = ITEMS.register("crushed_iron_ore", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> CRUSHED_GOLD_ORE = ITEMS.register("crushed_gold_ore", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> OBSIDIAN_POWDER = ITEMS.register("obsidian_powder", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> ICE_SHARD = ITEMS.register("ice_shard", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> ANCIENT_TOME = ITEMS.register("ancient_tome", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> HEATED_OBSIDIAN_POWDER = ITEMS.register("heated_obsidian_powder", 
			() -> new Item(new Item.Properties().tab(Industry.MISC)));
	public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket", 
			() -> new Item(new Item.Properties().tab(Industry.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> DAGGER = ITEMS.register("dagger", 
			() -> new Item(new Item.Properties().tab(Industry.BLOOD_MACIC).stacksTo(1).setNoRepair().durability(236)));
	public static final RegistryObject<Item> APPRENTICE_BLOOD_ORB = ITEMS.register("apprentice_blood_orb", 
			() -> new OrbItem(OrbType.APPRENTICE, new Item.Properties().tab(Industry.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> MAGICIAN_BLOOD_ORB = ITEMS.register("magician_blood_orb", 
			() -> new OrbItem(OrbType.MAGICIAN, new Item.Properties().tab(Industry.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> MASTER_BLOOD_ORB = ITEMS.register("master_blood_orb",
			() -> new OrbItem(OrbType.MASTER, new Item.Properties().tab(Industry.BLOOD_MACIC).stacksTo(1)));
	
}
