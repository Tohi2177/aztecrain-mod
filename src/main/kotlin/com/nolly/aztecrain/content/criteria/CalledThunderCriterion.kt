package com.nolly.aztecrain.content.criteria

import com.mojang.serialization.Codec
import net.minecraft.advancement.AdvancementCriterion
import net.minecraft.advancement.criterion.AbstractCriterion
import net.minecraft.predicate.entity.EntityPredicate
import net.minecraft.predicate.entity.LootContextPredicate
import net.minecraft.server.network.ServerPlayerEntity
import java.util.*

object CalledThunderCriterion : AbstractCriterion<CalledThunderCriterion.Conditions>() {
    override fun getConditionsCodec(): Codec<Conditions> = Conditions.CODEC

    fun trigger(player: ServerPlayerEntity) {
        trigger(player) { true }
    }

    data class Conditions(val player: Optional<LootContextPredicate>) : AbstractCriterion.Conditions {
        companion object {
            val CODEC: Codec<Conditions> =
                EntityPredicate.LOOT_CONTEXT_PREDICATE_CODEC.optionalFieldOf("player").xmap(::Conditions) { it.player }
                    .codec()
        }

        override fun player(): Optional<LootContextPredicate> = player
    }

    fun create(): AdvancementCriterion<Conditions> = create(Conditions(Optional.empty()))
}