package net.luis.industry.data;

import static net.luis.industry.Industry.MOD_ID;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper fileHelper) {
		super(generator, blockTagsProvider, MOD_ID, fileHelper);
	}

}
