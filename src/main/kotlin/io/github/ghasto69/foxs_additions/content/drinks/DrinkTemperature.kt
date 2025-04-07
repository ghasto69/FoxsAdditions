package io.github.ghasto69.foxs_additions.content.drinks

import com.mojang.serialization.Codec
import net.minecraft.util.StringIdentifiable

enum class DrinkTemperature : StringIdentifiable {
    COLD,
    NORMAL,
    HOT;

    override fun asString() = name.lowercase()
    companion object {
        val CODEC: Codec<DrinkTemperature> = StringIdentifiable.createCodec { entries.toTypedArray() }
    }
}