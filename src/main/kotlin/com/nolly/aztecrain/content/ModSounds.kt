package com.nolly.aztecrain.content

import com.nolly.aztecrain.AztecRain
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {
    lateinit var RITUAL_START: SoundEvent
    lateinit var RITUAL_SUCCESS: SoundEvent

    fun registerAll() {
        RITUAL_START = register("ritual_start")
        RITUAL_SUCCESS = register("ritual_success")
    }

    private fun register(id: String): SoundEvent {
        val identifier = Identifier.of(AztecRain.MOD_ID, id)
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier))
    }
}