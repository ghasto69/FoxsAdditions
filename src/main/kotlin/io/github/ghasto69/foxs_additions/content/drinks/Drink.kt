package io.github.ghasto69.foxs_additions.content.drinks

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.nbt.NbtCompound

data class Drink(val temperature: DrinkTemperature, val effects: List<StatusEffectInstance>) {
    constructor(temperature: DrinkTemperature, vararg effects: StatusEffectInstance) : this(
        temperature,
        effects.toList()
    )

    companion object {
        val CODEC: Codec<Drink> = RecordCodecBuilder.create { instance ->
            instance.group(
                DrinkTemperature.CODEC.fieldOf("temperature").forGetter(Drink::temperature),
                NbtCompound.CODEC.listOf().fieldOf("effects").forGetter { drink ->
                    drink.effects.map { effect ->
                        effect.writeNbt(
                            NbtCompound()
                        )
                    }
                }
            ).apply(instance) { temperature, effects ->
                Drink(
                    temperature,
                    effects.map { nbt -> StatusEffectInstance.fromNbt(nbt)!! })
            }
        }
    }
}
