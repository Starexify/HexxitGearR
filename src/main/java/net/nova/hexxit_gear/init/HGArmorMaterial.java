package net.nova.hexxit_gear.init;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class HGArmorMaterial {
    public static ArmorMaterial SCALE = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 8);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 11);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.15F, HGTags.ItemTag.REPAIRS_SCALE_ARMOR, HGEquipmentAssets.SCALE);

    public static ArmorMaterial TRIBAL = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 8);
        map.put(ArmorType.HELMET, 2);
        map.put(ArmorType.BODY, 10);
    }), 18, SoundEvents.ARMOR_EQUIP_IRON, 1F, 0F, HGTags.ItemTag.REPAIRS_TRIBAL_ARMOR, HGEquipmentAssets.TRIBAL);

    public static ArmorMaterial THIEF = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 2);
        map.put(ArmorType.BODY, 7);
    }), 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, 0F, HGTags.ItemTag.REPAIRS_THIEF_ARMOR, HGEquipmentAssets.THIEF);

    public static ArmorMaterial SAGE = new ArmorMaterial(29, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 7);
        map.put(ArmorType.HELMET, 2);
        map.put(ArmorType.BODY, 7);
    }), 22, SoundEvents.ARMOR_EQUIP_GENERIC, 0F, 0F, HGTags.ItemTag.REPAIRS_SAGE_ARMOR, HGEquipmentAssets.SAGE);
}
