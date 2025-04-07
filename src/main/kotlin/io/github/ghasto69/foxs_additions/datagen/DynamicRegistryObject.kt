package io.github.ghasto69.foxs_additions.datagen

import io.github.ghasto69.foxs_additions.FoxsAdditions
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryBuilder.BootstrapFunction
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

interface DynamicRegistryObject<T> : BootstrapFunction<T> {
    val registry: RegistryKey<Registry<T>>
    fun key(name: String) = RegistryKey.of(registry, Identifier.of(FoxsAdditions.MOD_ID, name))!!
    // Remember to register this one
}