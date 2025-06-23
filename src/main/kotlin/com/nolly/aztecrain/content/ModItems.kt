package com.nolly.aztecrain.content

import com.nolly.aztecrain.AztecRain
import com.nolly.aztecrain.content.items.CeremonialKnife
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {
    val CEREMONIAL_KNIFE = register("ceremonial_knife", CeremonialKnife)

    fun registerAll() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register { it.add(CEREMONIAL_KNIFE) }
    }

    private fun register(id: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier.of(AztecRain.MOD_ID, id), item)
    }
}