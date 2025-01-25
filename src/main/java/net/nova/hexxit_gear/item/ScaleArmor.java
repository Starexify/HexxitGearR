package net.nova.hexxit_gear.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;
import net.nova.hexxit_gear.HexxitGearR;

public class ScaleArmor extends ArmorItem {
    public ScaleArmor(ArmorMaterial material, ArmorType armorType, Properties properties) {
        super(material, armorType, properties);
    }

    // Armor Effects
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (entity instanceof LivingEntity livingEntity) {
            boolean isWearingFullSet = true;
            for (ItemStack armorStack : livingEntity.getArmorSlots()) {
                if (!(armorStack.getItem() instanceof ScaleArmor)) {
                    isWearingFullSet = false;
                }
            }

            if (isWearingFullSet) {
                addFullSetEffects(livingEntity);
            }
        }
    }

    public void addFullSetEffects(LivingEntity livingEntity) {
        HexxitGearR.addEffect(livingEntity, MobEffects.DAMAGE_BOOST, 1, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.DAMAGE_RESISTANCE, 1, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.FIRE_RESISTANCE, 1, 1);
    }
}
