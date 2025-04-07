package io.github.ghasto69.foxs_additions

import io.github.ghasto69.foxs_additions.content.drinks.Drink
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

object ModRegistryKeys {
    val DRINK: RegistryKey<Registry<Drink>> = RegistryKey.ofRegistry(Identifier.of(FoxsAdditions.MOD_ID, "drink"))
}