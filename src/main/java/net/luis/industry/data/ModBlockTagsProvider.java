package net.luis.industry.data;

import static net.luis.industry.Industry.MOD_ID;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
		super(generator, MOD_ID, fileHelper);
	}
	
}
