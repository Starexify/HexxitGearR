package net.nova.hexxit_gear.item;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nova.hexxit_gear.HexxitGearR;
import org.jetbrains.annotations.Nullable;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class ThiefArmor extends Item {
    public ResourceLocation SPEED_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(MODID, "thief_speed_modifier");
    public ResourceLocation STEP_MODIFIER_ID = ResourceLocation.fromNamespaceAndPath(MODID, "thief_step_modifier");

    public ThiefArmor(Properties properties) {
        super(properties);
    }

    // Armor Effects
    @Override
    public void inventoryTick(ItemStack stack, ServerLevel serverLevel, Entity entity, @Nullable EquipmentSlot slotId) {
        super.inventoryTick(stack, serverLevel, entity, slotId);
        if (entity instanceof LivingEntity livingEntity) {
            boolean isWearingFullSet = true;
            for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET})
                if (!(livingEntity.getItemBySlot(slot).getItem() instanceof ThiefArmor)) isWearingFullSet = false;

            applyOrRemoveModifier(livingEntity, Attributes.MOVEMENT_SPEED, SPEED_MODIFIER_ID, 0.15F, isWearingFullSet);
            applyOrRemoveModifier(livingEntity, Attributes.STEP_HEIGHT, STEP_MODIFIER_ID, 0.4F, isWearingFullSet);
            if (isWearingFullSet) addFullSetEffects(livingEntity);
        }
    }

    public void addFullSetEffects(LivingEntity livingEntity) {
        HexxitGearR.addEffect(livingEntity, MobEffects.NIGHT_VISION, 300, 0);
        HexxitGearR.addEffect(livingEntity, MobEffects.STRENGTH, 1, 0);
    }

    public void applyOrRemoveModifier(LivingEntity entity, Holder<Attribute> attribute, ResourceLocation modifierId, float value, boolean shouldApply) {
        AttributeInstance attributeInstance = entity.getAttributes().getInstance(attribute);
        if (attributeInstance == null) return;

        boolean hasModifier = attributeInstance.hasModifier(modifierId);

        if (shouldApply && !hasModifier) attributeInstance.addOrUpdateTransientModifier(new AttributeModifier(modifierId, value, AttributeModifier.Operation.ADD_VALUE));
        else if (!shouldApply && hasModifier) attributeInstance.removeModifier(modifierId);
    }

}
