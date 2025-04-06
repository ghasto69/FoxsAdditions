package io.github.ghasto69.foxs_additions

import net.fabricmc.api.ModInitializer
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

@Suppress("unused")
object FoxsAdditions : ModInitializer {
	const val MOD_ID = "foxs_additions"
    private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	val ITEM = Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "test_item"), Item(Item.Settings()))

	override fun onInitialize() {

	}
}