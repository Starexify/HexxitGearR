package net.nova.hexxit_gear;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.model.*;

import java.util.function.Supplier;

public class HGClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    // Layer Definitions
    ModelLayerRegistry.registerModelLayer(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel::createLayer);
    ModelLayerRegistry.registerModelLayer(TribalSkullModel.LAYER_LOCATION, TribalSkullModel::createLayer);
    ModelLayerRegistry.registerModelLayer(ThiefHoodModel.LAYER_LOCATION, ThiefHoodModel::createLayer);
    ModelLayerRegistry.registerModelLayer(SageHoodModel.LAYER_LOCATION, SageHoodModel::createLayer);

    // Custom Armor Renderer
    registerAutomaticArmorRenderer(HGItems.SCALE_HELMET.getFirst().value(),
        () -> new ScaleHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ScaleHelmetModel.LAYER_LOCATION)), ScaleHelmetModel.TEXTURE);
    registerAutomaticArmorRenderer(HGItems.TRIBAL_SKULL.getFirst().value(),
        () -> new TribalSkullModel(Minecraft.getInstance().getEntityModels().bakeLayer(TribalSkullModel.LAYER_LOCATION)), TribalSkullModel.TEXTURE);
    registerAutomaticArmorRenderer(HGItems.THIEF_HOOD.getFirst().value(),
        () -> new ThiefHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(ThiefHoodModel.LAYER_LOCATION)), ThiefHoodModel.TEXTURE);
    registerAutomaticArmorRenderer(HGItems.SAGE_HOOD.getFirst().value(),
        () -> new SageHoodModel(Minecraft.getInstance().getEntityModels().bakeLayer(SageHoodModel.LAYER_LOCATION)), SageHoodModel.TEXTURE);
  }

  public static <T extends Model<HumanoidRenderState>> void registerAutomaticArmorRenderer(Item item, Supplier<T> modelSupplier, Identifier texture) {
    ArmorRenderer.register(new CachedModelArmorRenderer<>(modelSupplier, texture), item);
  }

  public static class CachedModelArmorRenderer<T extends Model<HumanoidRenderState>> implements ArmorRenderer {
    public final Supplier<T> modelSupplier;
    public final Identifier texture;
    public T cachedModel;

    public CachedModelArmorRenderer(Supplier<T> modelSupplier, Identifier texture) {
      this.modelSupplier = modelSupplier;
      this.texture = texture;
    }

    @Override
    public void render(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, ItemStack stack, HumanoidRenderState humanoidRenderState, EquipmentSlot slot, int light, HumanoidModel<HumanoidRenderState> contextModel) {
      if (cachedModel == null) cachedModel = modelSupplier.get();
      RenderType renderType = RenderTypes.armorCutoutNoCull(texture);
      ArmorRenderer.submitTransformCopyingModel(
          contextModel, humanoidRenderState,
          cachedModel, humanoidRenderState,
          true, submitNodeCollector, poseStack, renderType, light, OverlayTexture.NO_OVERLAY, 0, null
      );
    }
  }
}
