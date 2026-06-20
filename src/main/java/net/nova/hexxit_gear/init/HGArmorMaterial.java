package net.nova.hexxit_gear.init;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

public interface HGArmorMaterial {
  ArmorMaterial SCALE = new ArmorMaterial(
      29, makeDefense(3, 6, 8, 3, 11), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.15F, HGTags.ItemTag.REPAIRS_SCALE_ARMOR, HGEquipmentAssets.SCALE
  );

  ArmorMaterial TRIBAL = new ArmorMaterial(
      29, makeDefense(3, 6, 8, 2, 10), 18, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, HGTags.ItemTag.REPAIRS_TRIBAL_ARMOR, HGEquipmentAssets.TRIBAL
  );

  ArmorMaterial THIEF = new ArmorMaterial(
      29, makeDefense(2, 6, 7, 2, 7), 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, HGTags.ItemTag.REPAIRS_THIEF_ARMOR, HGEquipmentAssets.THIEF
  );

  ArmorMaterial SAGE = new ArmorMaterial(
      29, makeDefense(2, 6, 7, 2, 7), 22, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, HGTags.ItemTag.REPAIRS_SAGE_ARMOR, HGEquipmentAssets.SAGE
  );

  private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
    return Maps.newEnumMap(
        Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
    );
  }
}
