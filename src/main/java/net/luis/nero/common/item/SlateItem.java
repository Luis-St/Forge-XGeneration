package net.luis.nero.common.item;

import net.luis.nero.init.items.ModItems;
import net.minecraft.item.Item;

public class SlateItem extends Item {
	
	private final int slateLevel;
	
	public SlateItem(int slateLevel, Properties properties) {
		super(properties);
		this.slateLevel = slateLevel;
	}

	public int getSlateLevel() {
		return this.slateLevel;
	}
	
	public static SlateItem getSlateBySlate(int level) {
		switch (level) {
		case 1: {
			return ModItems.REINFORCED_SLATE.get();
		}
		case 2: {
			return ModItems.INFUSED_SLATE.get();
		}
		case 3: {
			return ModItems.DEMON_SLATE.get();
		}
		default: {
			return ModItems.SLATE.get();
		}
		}
	}
	
	public static SlateItem getNextSlate(SlateItem slateItem) {
		int level = slateItem.getSlateLevel() + 1;
		if (level > 3) {
			return ModItems.DEMON_SLATE.get();
		} else  {
			return getSlateBySlate(level);
		}
	}

}