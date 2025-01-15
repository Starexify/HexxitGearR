package net.nova.hexxit_gear.data.models;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nova.hexxit_gear.init.HGEquipmentAssets;

import java.util.function.BiConsumer;

public class HGEquipmentModelProvider extends EquipmentAssetProvider {
    public HGEquipmentModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(HGEquipmentAssets.SCALE, onlyHumanoid("hexxit_gear:scale"));
        output.accept(HGEquipmentAssets.TRIBAL, onlyHumanoid("hexxit_gear:tribal"));
        output.accept(HGEquipmentAssets.THIEF, onlyHumanoid("hexxit_gear:thief"));
        output.accept(HGEquipmentAssets.SAGE, onlyHumanoid("hexxit_gear:sage"));
    }
}
