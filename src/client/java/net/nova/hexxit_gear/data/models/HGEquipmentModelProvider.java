package net.nova.hexxit_gear.data.models;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.init.HGEquipmentAssets;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class HGEquipmentModelProvider implements DataProvider {
    public final FabricDataOutput output;
    public final PackOutput.PathProvider pathResolver;

    public HGEquipmentModelProvider(FabricDataOutput output) {
        this.output = output;
        this.pathResolver = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    public static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(HGEquipmentAssets.SCALE, onlyHumanoid("scale"));
        output.accept(HGEquipmentAssets.TRIBAL, onlyHumanoid("tribal"));
        output.accept(HGEquipmentAssets.THIEF, onlyHumanoid("thief"));
        output.accept(HGEquipmentAssets.SAGE, onlyHumanoid("sage"));
    }

    public static EquipmentClientInfo onlyHumanoid(String string) {
        return EquipmentClientInfo.builder().addHumanoidLayers(HexxitGearR.rl(string)).build();
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> map = new HashMap();
        bootstrap((resourceKey, equipmentClientInfo) -> {
            if (map.putIfAbsent(resourceKey, equipmentClientInfo) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + resourceKey);
            }
        });
        return DataProvider.saveAll(cachedOutput,  EquipmentClientInfo.CODEC, this.pathResolver::json, map);
    }

    @Override
    public String getName() {
        return "HGR Equipment Model Generator";
    }
}
