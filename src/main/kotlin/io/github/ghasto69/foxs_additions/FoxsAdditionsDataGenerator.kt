package io.github.ghasto69.foxs_additions

import io.github.ghasto69.foxs_additions.datagen.ModDynamicRegistryProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryBuilder

object FoxsAdditionsDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(generator: FabricDataGenerator) {
		val pack = generator.createPack()
		pack.addProvider(::ModDynamicRegistryProvider)
	}

	override fun buildRegistry(registryBuilder: RegistryBuilder) {
		registryBuilder.addRegistry(ModDrinks.registry, ModDrinks)
	}
}