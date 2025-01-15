package net.nova.hexxit_gear.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void addItemProperty(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(HGBlocks.HEXBISCUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(HGBlocks.POTTED_HEXBISCUS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel::createLayer);
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(scaleHelmet(), HGItems.SCALE_HELMET);
    }

    public static IClientItemExtensions scaleHelmet() {
        return new IClientItemExtensions() {
            public static ScaleHelmetModel scaleHelmet;

            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                if (original instanceof HumanoidModel<?> humanoidModel) {
                    if (scaleHelmet == null) {
                        scaleHelmet = new ScaleHelmetModel(Minecraft.getInstance().getEntityModels().bakeLayer(ScaleHelmetModel.LAYER_LOCATION));
                        return scaleHelmet;
                    }
                    scaleHelmet.helmet.copyFrom(humanoidModel.getHead());
                }
                return scaleHelmet;
            }

            @Override
            public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
                return ScaleHelmetModel.TEXTURE;
            }
        };
    }

}
