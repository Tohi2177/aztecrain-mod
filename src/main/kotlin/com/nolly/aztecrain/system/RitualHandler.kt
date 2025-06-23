package com.nolly.aztecrain.system

import com.nolly.aztecrain.content.ModCriteria
import com.nolly.aztecrain.content.ModEffects
import com.nolly.aztecrain.content.ModItems
import com.nolly.aztecrain.content.ModSounds
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.ItemStack
import net.minecraft.particle.ParticleTypes
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object RitualHandler {
    private const val GRACE_DURATION_TICKS = 20 * 60 * 3

    fun tryTriggerRitual(world: World, killer: LivingEntity?, victim: LivingEntity, weapon: ItemStack) {
        if (killer == null || killer.isSpectator || killer == victim) return
        if (world !is ServerWorld) return
        if (weapon.item != ModItems.CEREMONIAL_KNIFE) return

        val altarPos = victim.blockPos
        if (!RitualPlatformDetector.isValidAltar(world, altarPos)) return

        world.playSound(null, altarPos, ModSounds.RITUAL_START, SoundCategory.PLAYERS, 1.0f, 1.0f)

        @Suppress("UNCHECKED_CAST") val alreadyHasGrace =
            killer.hasStatusEffect(ModEffects.GRACE as RegistryEntry<StatusEffect>)
        val weather = world.levelProperties

        if (alreadyHasGrace) {
            weather.isRaining = true
            world.setWeather(0, 6000, true, true)
            broadcastRitual(world, altarPos, "${killer.name} summoned a thunderstorm!")
        } else {
            if (world.isRaining) {
                world.setWeather(0, 6000, false, false)
                broadcastRitual(world, altarPos, "${killer.name} cleared the skies.")
            } else {
                world.setWeather(0, 6000, true, false)
                broadcastRitual(world, altarPos, "${killer.name} called the rain.")
            }

            @Suppress("UNCHECKED_CAST") killer.addStatusEffect(
                StatusEffectInstance(
                    ModEffects.GRACE as RegistryEntry<StatusEffect>, GRACE_DURATION_TICKS, 0, false, true, true
                )
            )
        }

        world.playSound(null, altarPos, ModSounds.RITUAL_SUCCESS, SoundCategory.PLAYERS, 1.0f, 1.0f)
        spawnRitualParticles(world, altarPos)

        if (killer is ServerPlayerEntity) {
            when {
                alreadyHasGrace -> ModCriteria.CALLED_THUNDER.trigger(killer)
                world.isRaining -> ModCriteria.CALLED_CLEAR.trigger(killer)
                else -> ModCriteria.CALLED_RAIN.trigger(killer)
            }
        }
    }

    private fun broadcastRitual(world: ServerWorld, center: BlockPos, message: String) {
        val radius = 32.0
        world.players.filter { it.squaredDistanceTo(center.toCenterPos()) <= radius * radius }
            .forEach { it.sendMessage(Text.literal(message).formatted(Formatting.GOLD), false) }
    }

    private fun spawnRitualParticles(world: ServerWorld, center: BlockPos) {
        val basePos = center.toCenterPos().add(0.0, 0.25, 0.0)

        repeat(20) {
            world.spawnParticles(
                ParticleTypes.SOUL, basePos.x, basePos.y, basePos.z, 1, 0.5, 0.1, 0.5, 0.01
            )
            world.spawnParticles(
                ParticleTypes.ENCHANT, basePos.x, basePos.y + 0.5, basePos.z, 1, 0.5, 0.1, 0.5, 0.15
            )
        }
    }
}