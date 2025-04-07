package io.github.ghasto69.foxs_additions

import io.github.ghasto69.foxs_additions.content.drinks.cup.CupItem
import io.github.ghasto69.foxs_additions.content.jetpack.JetpackItem
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.Item.Settings
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

@Suppress("unused")
object ModItems {
    val CUP = register("cup", ::CupItem)
    val JETPACK = register("jetpack", ::JetpackItem)


    fun <T : ArmorItem>
    fun <T : Item> register(name: String, factory: (Settings) -> T, settings: Settings = Settings()) =
        Registry.register(
            Registries.ITEM, Identifier.of(FoxsAdditions.MOD_ID, name), factory.invoke(settings)
        )!!
}