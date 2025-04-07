package io.github.ghasto69.foxs_additions

import io.github.ghasto69.foxs_additions.content.drinks.Drink
import io.github.ghasto69.foxs_additions.content.drinks.DrinkTemperature
import io.github.ghasto69.foxs_additions.datagen.DynamicRegistryObject
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.registry.Registerable

object ModDrinks : DynamicRegistryObject<Drink> {
    override val registry = ModRegistryKeys.DRINK

    val WATER = key("water")
    val LEMONADE = key("lemonade")
    val HOT_CHOCOLATE = key("hot_chocolate")

    override fun run(registerable: Registerable<Drink>) {
        registerable.register(WATER, Drink(DrinkTemperature.NORMAL))
        registerable.register(LEMONADE, Drink(DrinkTemperature.COLD, StatusEffectInstance(StatusEffects.HASTE, 1200)))
        registerable.register(HOT_CHOCOLATE, Drink(DrinkTemperature.HOT, StatusEffectInstance(StatusEffects.SATURATION, 1200)))
    }
}