package com.nolly.aztecrain

import com.nolly.aztecrain.content.ModCriteria
import com.nolly.aztecrain.content.ModEffects
import com.nolly.aztecrain.content.ModItems
import com.nolly.aztecrain.content.ModSounds
import com.nolly.aztecrain.system.RitualPlatformDetector
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.world.ServerWorld
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AztecRain : ModInitializer {
    companion object {
        const val MOD_ID = "aztecrain"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        LOGGER.info("Aztec Rain mod initialized!")
        ModCriteria.init()
        ModEffects.registerAll()
        ModSounds.registerAll()
        ModItems.registerAll()

        var tickCounter = 0
        ServerTickEvents.END_SERVER_TICK.register { it ->
            tickCounter++
            if (tickCounter % 20 != 0) return@register
            it.playerManager.playerList.forEach { player ->
                val position = player.blockPos
                if (RitualPlatformDetector.isValidAltar(player.world, position)) {
                    val center = position.toCenterPos().add(0.0, 0.5, 0.0)
                    (player.world as? ServerWorld)?.spawnParticles(
                        ParticleTypes.SOUL_FIRE_FLAME, center.x, center.y, center.z, 3, 0.3, 0.1, 0.3, 0.005
                    )
                }
            }
        }

        LOGGER.info("Aztec Rain mod loaded successfully!")
    }
}