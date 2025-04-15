package net.nova.hexxit_gear;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
        ArmorRenderer.register(new CachedModelArmorRenderer<>(modelSupplier, texture), item);
    }

    public static class CachedModelArmorRenderer<T extends Model> implements ArmorRenderer {
        public final Supplier<T> modelSupplier;
        public final ResourceLocation texture;
        public T cachedModel;

        public CachedModelArmorRenderer(Supplier<T> modelSupplier, ResourceLocation texture) {
            this.modelSupplier = modelSupplier;
            this.texture = texture;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, ItemStack itemStack, HumanoidRenderState humanoidRenderState, EquipmentSlot equipmentSlot, int i, HumanoidModel<HumanoidRenderState> humanoidModel) {
            if (cachedModel == null) cachedModel = modelSupplier.get();
            if (cachedModel instanceof BaseHelmetModel helmetModel) helmetModel.helmet.copyFrom(humanoidModel.head);
            ArmorRenderer.renderPart(poseStack, multiBufferSource, i, itemStack, cachedModel, texture);
        }
    }
}
