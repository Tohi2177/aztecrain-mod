package com.nolly.aztecrain.content.items

import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.passive.PigEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterials

object CeremonialKnife : SwordItem(ToolMaterials.IRON, Settings()) {
    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        if (target.world.isClient) return super.postHit(stack, target, attacker)
        if (target !is PigEntity) return super.postHit(stack, target, attacker)

        val hasArmor = EquipmentSlot.entries.any { slot ->
            (slot.type == EquipmentSlot.Type.HUMANOID_ARMOR || slot.type == EquipmentSlot.Type.ANIMAL_ARMOR) && !target.getEquippedStack(
                slot
            ).isEmpty
        }

        if (!hasArmor) target.damage(target.damageSources.generic(), 20.0f)
        else target.damage(target.damageSources.generic(), 0.0f)

        return super.postHit(stack, target, attacker)
    }
}