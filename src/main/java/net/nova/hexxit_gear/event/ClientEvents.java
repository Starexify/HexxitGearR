package net.nova.hexxit_gear.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.nova.hexxit_gear.client.model.SageHoodModel;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.client.model.ThiefHoodModel;
import net.nova.hexxit_gear.client.model.TribalSkullModel;
import net.nova.hexxit_gear.client.renderer.ISTERProvider;
import net.nova.hexxit_gear.init.HGItems;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
        event.registerItem(ISTERProvider.scaleHelmet(), HGItems.SCALE_HELMET);
        event.registerItem(ISTERProvider.tribalSkull(), HGItems.TRIBAL_SKULL);
        event.registerItem(ISTERProvider.thiefHood(), HGItems.THIEF_HOOD);
        event.registerItem(ISTERProvider.sageHood(), HGItems.SAGE_HOOD);
    }
}
