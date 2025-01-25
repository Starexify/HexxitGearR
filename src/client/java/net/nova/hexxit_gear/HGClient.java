package net.nova.hexxit_gear;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.nova.hexxit_gear.init.HGBlocks;

public class HGClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // RenderLayers
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.HEXBISCUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.POTTED_HEXBISCUS, RenderType.cutout());


    }
}
