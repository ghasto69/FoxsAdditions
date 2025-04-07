package io.github.ghasto69.foxs_additions.content.jetpack

import net.fabricmc.fabric.api.networking.v1.PacketSender
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.network.PacketByteBuf
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.math.Vec3d

object JetpackGoUpPacketHandler : ServerPlayNetworking.PlayChannelHandler {
    override fun receive(
        server: MinecraftServer,
        player: ServerPlayerEntity,
        handler: ServerPlayNetworkHandler,
        buf: PacketByteBuf,
        responseSender: PacketSender
    ) {
        val stack = player.inventory.getArmorStack(2)
        val item = stack.item
        if(item !is JetpackItem) return
        if(item.ticks > 0) item.ticks -= 1 else item.ticks = 20
        val nbt = stack.getOrCreateNbt()
        if(item.ticks == 0) nbt.putInt("Fuel", if(nbt.getInt("Fuel") == 0) 100 else nbt.getInt("Fuel") - 1)
        player.velocity = Vec3d(player.velocity.x, 0.4, player.velocity.z)
        responseSender.sendPacket(EntityVelocityUpdateS2CPacket(player))

    }
}