package io.github.ghasto69.foxs_additions.content.drinks.cup

import io.github.ghasto69.foxs_additions.ModDrinks
import io.github.ghasto69.foxs_additions.ModRegistryKeys
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtHelper
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Hand
import net.minecraft.util.Identifier
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class CupItem(settings: Settings) : Item(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        if(world.isClient)
            return super.use(world, user, hand)
        val nbt = user.getStackInHand(hand).nbt ?: return super.use(world, user, hand)
        val drink = nbt.get("Drink") ?: return super.use(world, user, hand)
        val key = RegistryKey.of(ModRegistryKeys.DRINK, Identifier.tryParse(drink.asString()))
        for (effect in world.registryManager.getWrapperOrThrow(ModRegistryKeys.DRINK).getOrThrow(key).value().effects) {
            user.addStatusEffect(effect)
        }
        return super.use(world, user, hand)
    }
}