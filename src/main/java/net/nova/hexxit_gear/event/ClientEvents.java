package net.nova.hexxit_gear.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.nova.hexxit_gear.client.model.*;
import net.nova.hexxit_gear.init.HGItems;
import org.jspecify.annotations.Nullable;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID)
public class ClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel::createLayer);
        event.registerLayerDefinition(TribalSkullModel.LAYER_LOCATION, TribalSkullModel::createLayer);
        event.registerLayerDefinition(ThiefHoodModel.LAYER_LOCATION, ThiefHoodModel::createLayer);
        event.registerLayerDefinition(SageHoodModel.LAYER_LOCATION, SageHoodModel::createLayer);
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(createArmorExtensions(ScaleHelmetModel::new, ScaleHelmetModel.TEXTURE, ScaleHelmetModel.LAYER_LOCATION), HGItems.SCALE_HELMET);
        event.registerItem(createArmorExtensions(TribalSkullModel::new, TribalSkullModel.TEXTURE, TribalSkullModel.LAYER_LOCATION), HGItems.TRIBAL_SKULL);
        event.registerItem(createArmorExtensions(ThiefHoodModel::new, ThiefHoodModel.TEXTURE, ThiefHoodModel.LAYER_LOCATION), HGItems.THIEF_HOOD);
        event.registerItem(createArmorExtensions(SageHoodModel::new, SageHoodModel.TEXTURE, SageHoodModel.LAYER_LOCATION), HGItems.SAGE_HOOD);
    }

    @FunctionalInterface
    public interface ArmorModelSupplier<T extends Model<HumanoidRenderState>> {
        T create(
            ModelPart root
        );
    }

    public static <T extends BaseHelmetModel> IClientItemExtensions createArmorExtensions(ArmorModelSupplier<T> modelSupplier, Identifier texture, ModelLayerLocation layerLocation) {
        return new IClientItemExtensions() {
            private T armorModel;

            @Override
            public Model<HumanoidRenderState> getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                if (original instanceof HumanoidModel<?> humanoidModel) {
                    if (armorModel == null) {
                        armorModel = modelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(layerLocation));
                        return armorModel;
                    }
                    armorModel.helmet.loadPose(humanoidModel.getHead().storePose());
                }
                return armorModel;
            }

          @Override
          public @Nullable Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
            return texture;
          }
        };
    }
}
