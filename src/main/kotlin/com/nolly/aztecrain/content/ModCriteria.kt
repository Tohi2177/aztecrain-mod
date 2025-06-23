package com.nolly.aztecrain.content

import com.nolly.aztecrain.AztecRain
import com.nolly.aztecrain.content.criteria.CalledClearCriterion
import com.nolly.aztecrain.content.criteria.CalledRainCriterion
import com.nolly.aztecrain.content.criteria.CalledThunderCriterion
import net.minecraft.advancement.criterion.Criteria

object ModCriteria {
    val CALLED_CLEAR: CalledClearCriterion = Criteria.register("${AztecRain.MOD_ID}:called_clear", CalledClearCriterion)
    val CALLED_RAIN: CalledRainCriterion = Criteria.register("${AztecRain.MOD_ID}:called_rain", CalledRainCriterion)
    val CALLED_THUNDER: CalledThunderCriterion = Criteria.register("${AztecRain.MOD_ID}:called_thunder", CalledThunderCriterion)

    fun init() {}
}