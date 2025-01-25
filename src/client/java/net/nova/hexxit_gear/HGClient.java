package net.nova.hexxit_gear;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.renderer.RenderType;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.model.SageHoodModel;
import net.nova.hexxit_gear.model.ScaleHelmetModel;
import net.nova.hexxit_gear.model.ThiefHoodModel;
import net.nova.hexxit_gear.model.TribalSkullModel;

public class HGClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // RenderLayers
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.HEXBISCUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.POTTED_HEXBISCUS, RenderType.cutout());

        // Layer Definitions
        LayerDefinitions.createRoots().put(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel.createLayer());
        LayerDefinitions.createRoots().put(TribalSkullModel.LAYER_LOCATION, TribalSkullModel.createLayer());
        LayerDefinitions.createRoots().put(ThiefHoodModel.LAYER_LOCATION, ThiefHoodModel.createLayer());
        LayerDefinitions.createRoots().put(SageHoodModel.LAYER_LOCATION, SageHoodModel.createLayer());
    }
}
