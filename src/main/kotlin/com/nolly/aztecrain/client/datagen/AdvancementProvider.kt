package com.nolly.aztecrain.client.datagen

import com.nolly.aztecrain.AztecRain
import com.nolly.aztecrain.content.ModCriteria
import com.nolly.aztecrain.content.ModEffects
import com.nolly.aztecrain.content.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.EffectsChangedCriterion
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.item.Items
import net.minecraft.predicate.entity.EntityEffectPredicate
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementProvider(output: FabricDataOutput, registries: CompletableFuture<RegistryWrapper.WrapperLookup>) :
    FabricAdvancementProvider(output, registries) {
    override fun generateAdvancement(
        registryLookup: RegistryWrapper.WrapperLookup, consumer: Consumer<AdvancementEntry>
    ) {
        val root = Advancement.Builder.create().display(
            ModItems.CEREMONIAL_KNIFE,
            Text.translatable("advancement.aztecrain.root.title"),
            Text.translatable("advancement.aztecrain.root.description"),
            Identifier.of("minecraft:textures/gui/advancements/backgrounds/adventure.png"),
            AdvancementFrame.TASK,
            true,
            true,
            false
        ).criterion("has_copper", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
            .build(consumer, "${AztecRain.MOD_ID}:root")

        val craftKnife = Advancement.Builder.create().parent(root).display(
            ModItems.CEREMONIAL_KNIFE,
            Text.translatable("advancement.aztecrain.knife.title"),
            Text.translatable("advancement.aztecrain.knife.description"),
            null,
            AdvancementFrame.TASK,
            true,
            true,
            false
        ).criterion("has_knife", InventoryChangedCriterion.Conditions.items(ModItems.CEREMONIAL_KNIFE))
            .build(consumer, "${AztecRain.MOD_ID}:craft_knife")

        val firstRitual = Advancement.Builder.create().parent(craftKnife).display(
            Items.LIGHTNING_ROD,
            Text.translatable("advancement.aztecrain.firstritual.title"),
            Text.translatable("advancement.aztecrain.firstritual.description"),
            null,
            AdvancementFrame.CHALLENGE,
            true,
            true,
            false
        ).criterion(
            "grace_effect", EffectsChangedCriterion.Conditions.create(
                EntityEffectPredicate.Builder.create().addEffect(ModEffects.GRACE_ENTRY)
            )
        ).build(consumer, "${AztecRain.MOD_ID}:first_ritual")

        val stormMaster = Advancement.Builder.create().parent(firstRitual).display(
            Items.NETHER_STAR,
            Text.translatable("advancement.aztecrain.stormmaster.title"),
            Text.translatable("advancement.aztecrain.stormmaster.description"),
            null,
            AdvancementFrame.CHALLENGE,
            true,
            true,
            true
        ).criterion("called_clear", ModCriteria.CALLED_CLEAR.create())
            .criterion("called_rain", ModCriteria.CALLED_RAIN.create())
            .criterion("called_thunder", ModCriteria.CALLED_THUNDER.create())
            .build(consumer, "${AztecRain.MOD_ID}:storm_master")
    }
}