package net.luis.nero.init.items;

import net.luis.nero.Nero;
import net.luis.nero.common.enums.OrbType;
import net.luis.nero.common.item.GlassShardItem;
import net.luis.nero.common.item.OrbItem;
import net.luis.nero.common.item.SlateItem;
import net.luis.nero.common.item.rune.AirRuneItem;
import net.luis.nero.common.item.rune.RuneItem;
import net.luis.nero.common.item.rune.WaterRuneItem;
import net.luis.nero.common.item.rune.WindRuneItem;
import net.luis.nero.init.util.ModItemGroups;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nero.MOD_ID);
	
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
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> CRUSHED_COPPER_ORE = ITEMS.register("crushed_copper_ore", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> CRUSHED_IRON_ORE = ITEMS.register("crushed_iron_ore", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> CRUSHED_GOLD_ORE = ITEMS.register("crushed_gold_ore", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> OBSIDIAN_POWDER = ITEMS.register("obsidian_powder", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> MITHRIL = ITEMS.register("mithril", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> ICE_SHARD = ITEMS.register("ice_shard", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> ANCIENT_TOME = ITEMS.register("ancient_tome", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> HEATED_OBSIDIAN_POWDER = ITEMS.register("heated_obsidian_powder", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.MISC)));
	public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> DAGGER = ITEMS.register("dagger", 
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1).setNoRepair().durability(236)));
	public static final RegistryObject<OrbItem> APPRENTICE_BLOOD_ORB = ITEMS.register("apprentice_blood_orb", 
			() -> new OrbItem(OrbType.APPRENTICE, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<OrbItem> MAGICIAN_BLOOD_ORB = ITEMS.register("magician_blood_orb", 
			() -> new OrbItem(OrbType.MAGICIAN, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<OrbItem> MASTER_BLOOD_ORB = ITEMS.register("master_blood_orb",
			() -> new OrbItem(OrbType.MASTER, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<SlateItem> SLATE = ITEMS.register("slate",
			() -> new SlateItem(0, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<SlateItem> REINFORCED_SLATE = ITEMS.register("reinforced_slate",
			() -> new SlateItem(1, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<SlateItem> INFUSED_SLATE = ITEMS.register("infused_slate",
			() -> new SlateItem(2, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<SlateItem> DEMON_SLATE = ITEMS.register("demon_slate",
			() -> new SlateItem(3, new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<RuneItem> RUNE = ITEMS.register("rune",
			() -> new RuneItem(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	
	public static final RegistryObject<WaterRuneItem> WATER_RUNE = ITEMS.register("water_rune",
			() -> new WaterRuneItem(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> BRIDGE_RUNE = ITEMS.register("bridge_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<WindRuneItem> WIND_RUNE = ITEMS.register("wind_rune",
			() -> new WindRuneItem(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> LAVA_RUNE = ITEMS.register("lava_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> DEATH_RUNE = ITEMS.register("death_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> GROWTH_RUNE = ITEMS.register("growth_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> HASTE_RUNE = ITEMS.register("haste_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> VOID_RUNE = ITEMS.register("void_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<AirRuneItem> AIR_RUNE = ITEMS.register("air_rune",
			() -> new AirRuneItem(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1)));
	public static final RegistryObject<Item> ICE_RUNE = ITEMS.register("ice_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> WARRIOR_RUNE = ITEMS.register("warrior_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect 
	public static final RegistryObject<Item> MINING_RUNE = ITEMS.register("mining_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> NIGHT_RUNE = ITEMS.register("night_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> ELEMENTAL_RUNE = ITEMS.register("elemental_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	public static final RegistryObject<Item> HARVEST_RUNE = ITEMS.register("harvest_rune",
			() -> new Item(new Item.Properties().tab(ModItemGroups.BLOOD_MACIC).stacksTo(1))); // TODO: rune item and effect
	
}
