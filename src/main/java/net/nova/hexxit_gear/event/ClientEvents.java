package net.nova.hexxit_gear.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nova.hexxit_gear.client.model.SageHoodModel;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.client.model.ThiefHoodModel;
import net.nova.hexxit_gear.client.model.TribalSkullModel;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ScaleHelmetModel.LAYER_LOCATION, ScaleHelmetModel::createLayer);
        event.registerLayerDefinition(TribalSkullModel.LAYER_LOCATION, TribalSkullModel::createLayer);
        event.registerLayerDefinition(ThiefHoodModel.LAYER_LOCATION, ThiefHoodModel::createLayer);
        event.registerLayerDefinition(SageHoodModel.LAYER_LOCATION, SageHoodModel::createLayer);
    }
}
