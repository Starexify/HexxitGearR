package net.nova.hexxit_gear.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.init.HGBlocks;

import java.util.concurrent.CompletableFuture;

public class HGConfiguredFeatures extends FabricDynamicRegistryProvider {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEXBISCUS = registerKey("hexbiscus");

    public HGConfiguredFeatures(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        register(entries, HEXBISCUS,
                Feature.FLOWER,
                new RandomPatchConfiguration(4, 2, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HGBlocks.HEXBISCUS)))
                ));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(Entries entries, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, F feature, FC featureConfiguration) {
        entries.add(resourceKey, new ConfiguredFeature(feature, featureConfiguration));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, HexxitGearR.rl(name));
    }

    @Override
    public String getName() {
        return "HGR Configured Features Generator";
    }
}
