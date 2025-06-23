package com.nolly.aztecrain.client.datagen

import com.nolly.aztecrain.content.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class RecipeProvider(output: FabricDataOutput, registries: CompletableFuture<RegistryWrapper.WrapperLookup>) :
    FabricRecipeProvider(output, registries) {
    override fun generate(exporter: RecipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CEREMONIAL_KNIFE)
            .pattern("CL ")
            .pattern(" C ")
            .pattern(" S ")
            .input('C', Items.COPPER_INGOT)
            .input('L', Items.LAPIS_LAZULI)
            .input('S', Items.STICK)
            .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
            .offerTo(exporter)
    }
}