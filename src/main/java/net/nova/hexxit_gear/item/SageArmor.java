package net.nova.hexxit_gear.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nova.hexxit_gear.HexxitGearR;
import org.jetbrains.annotations.Nullable;

public class SageArmor extends Item {
    public SageArmor(Properties properties) {
        super(properties);
    }

    // Armor Effects
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel serverLevel, Entity entity, @Nullable EquipmentSlot slotId) {
        super.inventoryTick(stack, serverLevel, entity, slotId);
        if (entity instanceof LivingEntity livingEntity) {
            boolean isWearingFullSet = true;
            for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET})
                if (!(livingEntity.getItemBySlot(slot).getItem() instanceof SageArmor)) isWearingFullSet = false;

            if (isWearingFullSet) addFullSetEffects(livingEntity);
        }
    }

    public void addFullSetEffects(LivingEntity livingEntity) {
        HexxitGearR.addEffect(livingEntity, MobEffects.WATER_BREATHING, 1, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.NIGHT_VISION, 300, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.FIRE_RESISTANCE, 1, 0);
    }
}
