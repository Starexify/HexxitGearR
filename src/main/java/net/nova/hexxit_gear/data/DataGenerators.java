package net.nova.hexxit_gear.data;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.nova.hexxit_gear.data.loot.HGLootTableProvider;
import net.nova.hexxit_gear.data.models.HGEquipmentModelProvider;
import net.nova.hexxit_gear.data.models.HGModelProvider;
import net.nova.hexxit_gear.data.recipe.HGRecipeProvider;
import net.nova.hexxit_gear.data.tags.HGBlockTagsProvider;
import net.nova.hexxit_gear.data.tags.HGItemTagsProvider;
import net.nova.hexxit_gear.data.worldgen.HGBiomeModifiers;
import net.nova.hexxit_gear.data.worldgen.HGConfiguredFeatures;
import net.nova.hexxit_gear.data.worldgen.HGPlacedFeatures;

import java.util.Set;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(LangProvider::new);
        event.createProvider(HGModelProvider::new);
        event.createProvider(HGEquipmentModelProvider::new);
        event.createBlockAndItemTags(HGBlockTagsProvider::new, HGItemTagsProvider::new);
        event.createProvider(HGLootTableProvider::new);
        event.createProvider(HGRecipeProvider.Runner::new);
        event.createDatapackRegistryObjects(new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, HGConfiguredFeatures::bootstrap)
                        .add(Registries.PLACED_FEATURE, HGPlacedFeatures::bootstrap)
                        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, HGBiomeModifiers::bootstrap),
                Set.of(MODID));
    }
}
