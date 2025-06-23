package com.nolly.aztecrain.system

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CandleBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object RitualPlatformDetector {
    fun isValidAltar(world: World, center: BlockPos): Boolean {
        var passed = true

        // Check platform
        for (x in -1..1) {
            for (z in -1..1) {
                val checkPos = center.add(x, -1, z)
                val state = world.getBlockState(checkPos)
                val valid = state.block == Blocks.SMOOTH_STONE

                if (!valid) passed = false
            }
        }

        // Check Corners
        val cornerOffsets = listOf(
            BlockPos(-1, 0, -1), BlockPos(-1, 0, 1), BlockPos(1, 0, -1), BlockPos(1, 0, 1)
        )

        for (offset in cornerOffsets) {
            val checkPos = center.add(offset)
            val state = world.getBlockState(checkPos)
            val valid = isCandle(state)

            if (!valid) passed = false
        }

        return passed
    }

    private fun isCandle(state: BlockState): Boolean {
        return state.block is CandleBlock && CandleBlock.isLitCandle(state)
    }
}