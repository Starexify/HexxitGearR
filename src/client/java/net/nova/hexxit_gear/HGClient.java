package net.nova.hexxit_gear;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.model.*;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class HGClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // RenderLayers
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.HEXBISCUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HGBlocks.POTTED_HEXBISCUS, RenderType.cutout());

        // Layer Definitions
        EntityModelLayerRegistry.registerModelLayer(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(TribalSkullModel.LAYER_LOCATION, TribalSkullModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(ThiefHoodModel.LAYER_LOCATION, ThiefHoodModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(SageHoodModel.LAYER_LOCATION, SageHoodModel::createLayer);

        // Custom Armor Renderer
        registerAutomaticArmorRenderer(HGItems.SCALE_HELMET, () -> new ScaleHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ScaleHelmetModel.LAYER_LOCATION)), ScaleHelmetModel.TEXTURE);
        registerAutomaticArmorRenderer(HGItems.TRIBAL_SKULL, () -> new TribalSkullModel(Minecraft.getInstance().getEntityModels().bakeLayer(TribalSkullModel.LAYER_LOCATION)), TribalSkullModel.TEXTURE);
        registerAutomaticArmorRenderer(HGItems.THIEF_HOOD, () -> new ThiefHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(ThiefHoodModel.LAYER_LOCATION)), ThiefHoodModel.TEXTURE);
        registerAutomaticArmorRenderer(HGItems.SAGE_HOOD, () -> new SageHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(SageHoodModel.LAYER_LOCATION)), SageHoodModel.TEXTURE);
    }

    public static <T extends Model> void registerAutomaticArmorRenderer(Item item, Supplier<T> modelSupplier, ResourceLocation texture) {
        AtomicReference<T> cachedModel = new AtomicReference<>();
        ArmorRenderer.register((matrices, vertexConsumers, stack, renderState, slot, light, humanoidModel) -> {
            T armorModel = cachedModel.updateAndGet(existing -> existing != null ? existing : modelSupplier.get());
            if (armorModel instanceof BaseHelmetModel helmetModel) {
                helmetModel.helmet.copyFrom(humanoidModel.head);
            }
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, armorModel, texture);
        }, item);
    }
}
