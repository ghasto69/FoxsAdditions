package io.github.ghasto69.foxs_additions.content.jetpack

import io.github.ghasto69.foxs_additions.ModNetworkingConstants
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.client.MinecraftClient
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.text.Text
import net.minecraft.world.World

class JetpackItem(material: ArmorMaterial, type: Type, settings: Settings) : ArmorItem(material, type, settings) {
    var ticks = 20
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if(slot != PlayerInventory.ARMOR_SLOTS[2]) return

        if(world.isClient) {
            if(MinecraftClient.getInstance().options.jumpKey.isPressed) {
                ClientPlayNetworking.send(ModNetworkingConstants.JETPACK_GO_UP, PacketByteBufs.empty())
            }
        }
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        val nbt = stack.nbt ?: return
        val fuel = nbt.getInt("Fuel")
        tooltip.add(Text.literal("Fuel: $fuel"))
    }
}