package net.nova.hexxit_gear.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nova.hexxit_gear.HexxitGearR;

public class TribalArmor extends ArmorItem {
    public TribalArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    // Armor Effects
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (pEntity instanceof LivingEntity livingEntity) {
            boolean isWearingFullSet = true;
            int index = 0;

            for (ItemStack armorStack : livingEntity.getArmorSlots()) {
                if (!(armorStack.getItem() instanceof TribalArmor)) {
                    isWearingFullSet = false;
                }
            }

            if (isWearingFullSet) {
                addFullSetEffects(livingEntity);
            }
        }
    }

    public void addFullSetEffects(LivingEntity livingEntity) {
        HexxitGearR.addEffect(livingEntity, MobEffects.NIGHT_VISION, 300, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.DAMAGE_BOOST, 1, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.JUMP, 1, 1);
    }
}
