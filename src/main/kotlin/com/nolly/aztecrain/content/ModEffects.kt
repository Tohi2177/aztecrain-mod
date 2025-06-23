package com.nolly.aztecrain.content

import com.nolly.aztecrain.AztecRain
import com.nolly.aztecrain.content.effects.GraceEffect
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier

object ModEffects {
    lateinit var GRACE: StatusEffect
    lateinit var GRACE_ENTRY: RegistryEntry<StatusEffect>

    fun registerAll() {
        GRACE = register("grace", GraceEffect())
        GRACE_ENTRY = Registries.STATUS_EFFECT.getEntry(GRACE)
    }

    private fun register(id: String, effect: StatusEffect): StatusEffect {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(AztecRain.MOD_ID, id), effect)
    }
}