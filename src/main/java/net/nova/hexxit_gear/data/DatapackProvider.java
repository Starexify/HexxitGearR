package net.nova.hexxit_gear.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.nova.hexxit_gear.data.worldgen.HGBiomeModifiers;
import net.nova.hexxit_gear.data.worldgen.HGConfiguredFeatures;
import net.nova.hexxit_gear.data.worldgen.HGPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class DatapackProvider extends DatapackBuiltinEntriesProvider {
    public DatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, HGConfiguredFeatures::bootstrap)
                        .add(Registries.PLACED_FEATURE, HGPlacedFeatures::bootstrap)
                        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, HGBiomeModifiers::bootstrap),
                Set.of(MODID));
    }
}
