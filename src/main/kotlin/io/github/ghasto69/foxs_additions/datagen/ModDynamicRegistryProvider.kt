package io.github.ghasto69.foxs_additions.datagen

import io.github.ghasto69.foxs_additions.ModDrinks
import io.github.ghasto69.foxs_additions.ModRegistryKeys
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import java.util.concurrent.CompletableFuture

class ModDynamicRegistryProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<WrapperLookup>
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun getName() = "Dynamic Registries"

    override fun configure(wrapperLookup: WrapperLookup, entries: Entries) {
        entries.addAll(wrapperLookup.getWrapperOrThrow(ModDrinks.registry))
    }
}