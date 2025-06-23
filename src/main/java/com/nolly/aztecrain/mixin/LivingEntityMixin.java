package com.nolly.aztecrain.mixin;

import com.nolly.aztecrain.system.RitualHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void aztecrain$onDeath(DamageSource source, CallbackInfo ci) {
        if (!(source.getAttacker() instanceof LivingEntity killer)) return;

        LivingEntity victim = (LivingEntity) (Object) this;
        World world = victim.getWorld();
        ItemStack weapon = killer.getStackInHand(Hand.MAIN_HAND);

        RitualHandler.INSTANCE.tryTriggerRitual(world, killer, victim, weapon);
    }
}