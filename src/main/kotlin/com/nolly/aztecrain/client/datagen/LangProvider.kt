package com.nolly.aztecrain.client.datagen

import com.nolly.aztecrain.content.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class LangProvider(output: FabricDataOutput, registries: CompletableFuture<RegistryWrapper.WrapperLookup>) :
    FabricLanguageProvider(output, "en_us", registries) {
    override fun generateTranslations(registryLookup: RegistryWrapper.WrapperLookup, builder: TranslationBuilder) {
        // Items
        builder.add(ModItems.CEREMONIAL_KNIFE, "Ceremonial Knife")

        // Effects
        builder.add("effect.aztecrain.grace", "Grace")

        // Subtitles
        builder.add("subtitles.aztecrain.ritual_start", "Ritual begins...")
        builder.add("subtitles.aztecrain.ritual_success", "The skies respond")

        // Advancements
        builder.add("advancement.aztecrain.root.title", "Echoes of the Sky")
        builder.add("advancement.aztecrain.root.description", "Begin your journey into Aztec ritual magic.")
        builder.add("advancement.aztecrain.knife.title", "Ceremonial Tools")
        builder.add("advancement.aztecrain.knife.description", "Craft the ceremonial knife.")
        builder.add("advancement.aztecrain.firstritual.title", "The First Skyfall")
        builder.add("advancement.aztecrain.firstritual.description", "Perform your first weather ritual.")
        builder.add("advancement.aztecrain.stormmaster.title", "Master of Storms")
        builder.add("advancement.aztecrain.stormmaster.description", "Perform all three ritual outcomes: rain, clear, and thunder.")
    }
}