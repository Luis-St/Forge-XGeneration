package net.luis.nero.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.luis.nero.common.world.levelgen.OverworldChunkGenerator;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;

public class NoiseCommand {
	
	public static void register(CommandDispatcher<CommandSourceStack> commandDispatcher) {
		commandDispatcher.register(Commands.literal("noise").requires(source -> {
			return source.hasPermission(2);
		}).executes(source -> {
			return getNoise(source.getSource(), source.getSource().getLevel(), new BlockPos(source.getSource().getPosition()));
		}).then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(source -> {
			return getNoise(source.getSource(), source.getSource().getLevel(), BlockPosArgument.getLoadedBlockPos(source, "pos"));
		}))	);
	}
	
	private static int getNoise(CommandSourceStack source, ServerLevel serverLevel, BlockPos pos) throws CommandSyntaxException {
		ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();
		if (chunkGenerator instanceof OverworldChunkGenerator overworldChunkGenerator) {
			source.sendSuccess(new TextComponent("Noise at X: " + pos.getX() + ", Y: " + pos.getY() +  ", Z: " + pos.getZ() + " has value " + overworldChunkGenerator.getWorldNoise(pos)), false);
			return 1;
		} else {
			source.sendFailure(new TextComponent("Failed to get Noise at X: "+ pos.getX() + ", Y: " + pos.getY() +  ", Z: " + pos.getZ()));
			return 0;
		}
	}
	
}
