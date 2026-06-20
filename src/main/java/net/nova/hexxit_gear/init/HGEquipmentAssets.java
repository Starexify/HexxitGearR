package net.nova.hexxit_gear.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.nova.hexxit_gear.HexxitGearR;

public interface HGEquipmentAssets {
  ResourceKey<EquipmentAsset> SCALE = createId("scale");
  ResourceKey<EquipmentAsset> TRIBAL = createId("tribal");
  ResourceKey<EquipmentAsset> THIEF = createId("thief");
  ResourceKey<EquipmentAsset> SAGE = createId("sage");

  static ResourceKey<EquipmentAsset> createId(String name) {
    return ResourceKey.create(EquipmentAssets.ROOT_ID, HexxitGearR.rl(name));
  }
}
