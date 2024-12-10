package net.nova.hexxit_gear.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.data.loot.HGLootTableProvider;
import net.nova.hexxit_gear.data.recipe.HGRecipeProvider;
import net.nova.hexxit_gear.data.tags.HGBlockTagsProvider;
import net.nova.hexxit_gear.data.tags.HGItemTagsProvider;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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

            generator.addProvider(true, new HGLootTableProvider(output));

            generator.addProvider(true, new HGRecipeProvider(output));

            generator.addProvider(true, new DatapackProvider(output, lookupProvider));

        } catch (RuntimeException e) {
            HexxitGearR.logger.error("Cosmicore failed to gather data", e);
        }
    }
}
