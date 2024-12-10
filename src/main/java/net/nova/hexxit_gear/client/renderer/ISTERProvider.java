package net.nova.hexxit_gear.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.nova.hexxit_gear.client.model.SageHoodModel;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.client.model.ThiefHoodModel;
import net.nova.hexxit_gear.client.model.TribalSkullModel;

import java.util.Collections;
import java.util.Map;

public class ISTERProvider {
    private static HumanoidModel<?> createHumanoidModel(ModelPart headModel) {
        return new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of(
                "head", headModel,
                "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())
        )));
    }

    public static IClientItemExtensions scaleHelmet() {
        return new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel original) {
                HumanoidModel armorModel = createHumanoidModel(new ScaleHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ScaleHelmetModel.LAYER_LOCATION)).root);
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        };
    }

    public static IClientItemExtensions tribalSkull() {
        return new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel original) {
                HumanoidModel armorModel = createHumanoidModel(new TribalSkullModel(Minecraft.getInstance().getEntityModels().bakeLayer(TribalSkullModel.LAYER_LOCATION)).root);
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        };
    }

    public static IClientItemExtensions thiefHood() {
        return new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel original) {
                HumanoidModel armorModel = createHumanoidModel(new ThiefHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(ThiefHoodModel.LAYER_LOCATION)).root);
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        };
    }

    public static IClientItemExtensions sageHood() {
        return new IClientItemExtensions() {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel original) {
                HumanoidModel armorModel = createHumanoidModel(new SageHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(SageHoodModel.LAYER_LOCATION)).root);
                armorModel.crouching = livingEntity.isShiftKeyDown();
                armorModel.riding = original.riding;
                armorModel.young = livingEntity.isBaby();
                return armorModel;
            }
        };
    }
}

