package net.nova.hexxit_gear.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nova.hexxit_gear.data.loot.HGLootTableProvider;
import net.nova.hexxit_gear.data.models.HGEquipmentModelProvider;
import net.nova.hexxit_gear.data.models.HGModelProvider;
import net.nova.hexxit_gear.data.recipe.HGRecipeProvider;
import net.nova.hexxit_gear.data.tags.HGBlockTagsProvider;
import net.nova.hexxit_gear.data.tags.HGItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new LangProvider(output));

        event.addProvider(new HGModelProvider(output));
        event.addProvider(new HGEquipmentModelProvider(output));

        HGBlockTagsProvider modBlockTagsProvider = new HGBlockTagsProvider(output, lookupProvider);
        event.addProvider(modBlockTagsProvider);
        event.addProvider(new HGItemTagsProvider(output, lookupProvider, modBlockTagsProvider));

        event.addProvider(new HGLootTableProvider(output, lookupProvider));

        event.addProvider(new HGRecipeProvider.Runner(output, lookupProvider));

        event.addProvider(new DatapackProvider(output, lookupProvider));
    }
}
