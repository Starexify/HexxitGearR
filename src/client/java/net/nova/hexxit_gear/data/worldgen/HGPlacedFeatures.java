package net.nova.hexxit_gear.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.nova.hexxit_gear.HexxitGearR;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HGPlacedFeatures extends FabricDynamicRegistryProvider {
    public static final ResourceKey<PlacedFeature> HEXBISCUS_PLACED = registerKey("hexbiscus_placed");

    public HGPlacedFeatures(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = entries.getLookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder = holdergetter.getOrThrow(HGConfiguredFeatures.HEXBISCUS);

        register(entries, HEXBISCUS_PLACED, holder, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }

    public static void register(Entries entries, ResourceKey<PlacedFeature> resourceKey, Holder<ConfiguredFeature<?, ?>> holder, PlacementModifier... placementModifiers) {
        entries.add(resourceKey, new PlacedFeature(holder, List.of(placementModifiers)));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, HexxitGearR.rl(name));
    }

    @Override
    public String getName() {
        return "HGR Placed Features Generator";
    }
}
