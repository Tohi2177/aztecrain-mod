package com.nolly.aztecrain.content.effects

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class GraceEffect : StatusEffect(StatusEffectCategory.BENEFICIAL, 0x5e99ff) {
    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean = false
}