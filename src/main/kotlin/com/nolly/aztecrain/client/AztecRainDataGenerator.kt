package com.nolly.aztecrain.client

import com.nolly.aztecrain.client.datagen.AdvancementProvider
import com.nolly.aztecrain.client.datagen.LangProvider
import com.nolly.aztecrain.client.datagen.ModelProvider
import com.nolly.aztecrain.client.datagen.RecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class AztecRainDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()
        pack.addProvider(::LangProvider)
        pack.addProvider(::RecipeProvider)
        pack.addProvider(::ModelProvider)
        pack.addProvider(::AdvancementProvider)
    }
}
