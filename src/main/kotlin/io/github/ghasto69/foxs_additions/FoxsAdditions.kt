package io.github.ghasto69.foxs_additions

import io.github.ghasto69.foxs_additions.content.drinks.Drink
import io.github.ghasto69.foxs_additions.content.jetpack.JetpackGoUpPacketHandler
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents
import net.fabricmc.fabric.api.event.registry.DynamicRegistries
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.item.Item
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.Vec3d
import org.slf4j.LoggerFactory

@Suppress("unused")
object FoxsAdditions : ModInitializer {
	const val MOD_ID = "foxs_additions"
    private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModItems
		DynamicRegistries.register(ModRegistryKeys.DRINK, Drink.CODEC)
		ServerPlayNetworking.registerGlobalReceiver(ModNetworkingConstants.JETPACK_GO_UP, JetpackGoUpPacketHandler)
	}
}