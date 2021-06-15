package net.luis.nero.common.util;

import net.luis.nero.api.capability.interfaces.IPortalCapability;
import net.luis.nero.api.util.annotation.NotTested;
import net.luis.nero.init.capability.ModCapabilities;
import net.minecraft.block.Blocks;
import net.minecraft.block.PortalInfo;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

@NotTested
@Deprecated
public class DeepslateDimensionTeleporter implements ITeleporter {
	
	public static final PortalInfo EMPTY_PORTAL_INFO = new PortalInfo(Vector3d.ZERO, Vector3d.ZERO, 0, 0);
	
	public PortalInfo findOverworldTeleportPosition(ServerPlayerEntity serverPlayer) {
		if (serverPlayer.getLevel().dimension().location().equals(IPortalCapability.DEEPSLATE)) {
			IPortalCapability portalHandler = serverPlayer.getLevel().getCapability(ModCapabilities.PORTAL, null).orElseThrow(NullPointerException::new);
			BlockPos playerPos = new BlockPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
			PortalInfo nextPortalInfo = portalHandler.getNext(IPortalCapability.OVERWORLD, playerPos);
			if (nextPortalInfo == null) {
				Vector3d portalInfoPos = new Vector3d(playerPos.getX(), playerPos.getY(), playerPos.getZ());
				PortalInfo portalInfo = new PortalInfo(portalInfoPos, Vector3d.ZERO, serverPlayer.yRot, serverPlayer.xRot);
				portalHandler.add(IPortalCapability.OVERWORLD, portalInfo);
				return portalInfo;
			}
			return nextPortalInfo;
		}
		return EMPTY_PORTAL_INFO;
	}
	
	public PortalInfo findDeepslateTeleportPosition(ServerPlayerEntity serverPlayer) {
		if (serverPlayer.getLevel().dimension().location().equals(IPortalCapability.OVERWORLD)) {
			IPortalCapability portalHandler = serverPlayer.getLevel().getCapability(ModCapabilities.PORTAL, null).orElseThrow(NullPointerException::new);
			BlockPos playerPos = new BlockPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
			PortalInfo nextPortalInfo = portalHandler.getNext(IPortalCapability.DEEPSLATE, playerPos);
			if (nextPortalInfo == null) {
				Vector3d portalInfoPos = new Vector3d(playerPos.getX(), playerPos.getY(), playerPos.getZ());
				PortalInfo portalInfo = new PortalInfo(portalInfoPos, Vector3d.ZERO, serverPlayer.yRot, serverPlayer.xRot);
				portalHandler.add(IPortalCapability.DEEPSLATE, portalInfo);
				return portalInfo;
			}
			return nextPortalInfo;
		}
		return EMPTY_PORTAL_INFO;
	}
	
	public void createPortalRoom(ServerWorld currentWorld, ServerWorld travelWorld, ServerPlayerEntity serverPlayer, PortalInfo portalInfo) {
		if (currentWorld.dimension().location().equals(IPortalCapability.DEEPSLATE)) {
			if (travelWorld.dimension().location().equals(IPortalCapability.OVERWORLD)) {
				this.createOverworldPortalRoom(currentWorld, travelWorld, serverPlayer, portalInfo);
			}
		} else if (currentWorld.dimension().location().equals(IPortalCapability.OVERWORLD)) {
			if (travelWorld.dimension().location().equals(IPortalCapability.DEEPSLATE)) {
				this.createDeepslatePortalRoom(currentWorld, travelWorld, serverPlayer, portalInfo);
			}
		}
	}
	
	protected void createOverworldPortalRoom(ServerWorld deepslate, ServerWorld overworld, ServerPlayerEntity serverPlayer, PortalInfo portalInfo) {
		BlockPos pos = new BlockPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
		BlockPos roomPos = new BlockPos(portalInfo.pos);
		for (int x = roomPos.getX() - 1; x <= roomPos.getX() + 1; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = roomPos.getZ() - 1; z <= roomPos.getY() + 1; z++) {
					deepslate.setBlock(new BlockPos(x, y, z), Blocks.CAVE_AIR.defaultBlockState(), 3);
				}
			}
		}
	}
	
	protected void createDeepslatePortalRoom(ServerWorld overworld, ServerWorld deepslate, ServerPlayerEntity serverPlayer, PortalInfo portalInfo) {
		BlockPos pos = new BlockPos(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ());
		BlockPos roomPos = new BlockPos(portalInfo.pos);
		for (int x = roomPos.getX() - 1; x <= roomPos.getX() + 1; x++) {
			for (int y = pos.getY() - 1; y <= pos.getY() + 1; y++) {
				for (int z = roomPos.getZ() - 1; z <= roomPos.getY() + 1; z++) {
					deepslate.setBlock(new BlockPos(x, y, z), Blocks.CAVE_AIR.defaultBlockState(), 3);
				}
			}
		}
	}
	
	@Override
	public boolean isVanilla() {
		return false;
	}
	
}
