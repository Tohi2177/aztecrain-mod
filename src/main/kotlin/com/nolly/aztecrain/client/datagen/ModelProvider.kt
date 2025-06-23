package com.nolly.aztecrain.client.datagen

import com.nolly.aztecrain.content.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models

class ModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.CEREMONIAL_KNIFE, Models.HANDHELD)
    }

    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {}
}