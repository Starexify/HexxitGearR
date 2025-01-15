package net.nova.hexxit_gear.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.data.loot.HGLootTableProvider;
import net.nova.hexxit_gear.data.recipe.HGRecipeProvider;
import net.nova.hexxit_gear.data.tags.HGBlockTagsProvider;
import net.nova.hexxit_gear.data.tags.HGItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

            generator.addProvider(true, new LangProvider(output));

            generator.addProvider(true, new BlockStateAndModelProvider(output, existingFileHelper));
            generator.addProvider(true, new HGItemModelProvider(output, existingFileHelper));

            HGBlockTagsProvider modBlockTagsProvider = new HGBlockTagsProvider(output, lookupProvider, existingFileHelper);
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, new HGItemTagsProvider(output, lookupProvider, modBlockTagsProvider, existingFileHelper));

            generator.addProvider(true, new HGLootTableProvider(output, lookupProvider));

            generator.addProvider(true, new HGRecipeProvider(output, lookupProvider));

            generator.addProvider(true, new DatapackProvider(output, lookupProvider));

        } catch (RuntimeException e) {
            HexxitGearR.logger.error("Cosmicore failed to gather data", e);
        }
    }
}
