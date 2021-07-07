package net.luis.nero.event.fml;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

import net.luis.nero.Nero;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

//@@EventBusSubscriber(modid = Nero.MOD_ID, bus = Bus.MOD)
public class OnLoadCompleteEvent {
	
	@SubscribeEvent
	@SuppressWarnings("deprecation")
	public static void loadComplete(FMLLoadCompleteEvent event) {
		event.enqueueWork(() -> {
			try {
			File itemFile = new File(System.getProperty("user.home") + "\\Desktop\\Items.txt");
			File blockFile = new File(System.getProperty("user.home") + "\\Desktop\\Blocks.txt");
			itemFile.createNewFile();
			blockFile.createNewFile();
			FileWriter itemWriter = new FileWriter(itemFile);
			FileWriter blockWriter = new FileWriter(blockFile);
			
			List<Item> items = Registry.ITEM.stream()
					.filter(item -> item.getRegistryName() != null && item.getRegistryName().getNamespace().equals(Nero.MOD_ID)).collect(Collectors.toList());
			List<Block> blocks = Registry.BLOCK.stream()
					.filter(block -> block.getRegistryName() != null && block.getRegistryName().getNamespace().equals(Nero.MOD_ID)).collect(Collectors.toList());
			
			for (int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				String registryName = item.getRegistryName().toString();
				String namespace = registryName.split(":")[0];
				String name = registryName.split(":")[1]; 
				itemWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
			}
			
			itemWriter.flush();
			itemWriter.close();
			
			for (int i = 0; i < blocks.size(); i++) {
				Block block = blocks.get(i);
				String registryName = block.getRegistryName().toString();
				String namespace = registryName.split(":")[0];
				String name = registryName.split(":")[1]; 
				blockWriter.write("\tpublic static final ResourceLocation " + name.toUpperCase() + " = new ResourceLocation(\"" + namespace + "\", \"" + name + "\");\n");
			}
			
			blockWriter.flush();
			blockWriter.close();
			
		} catch (Exception e) {}
		});
	}

}
