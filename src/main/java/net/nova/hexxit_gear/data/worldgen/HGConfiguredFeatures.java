package net.nova.hexxit_gear.data.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.init.HGBlocks;

public class HGConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HEXBISCUS = registerKey("hexbiscus");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(
                context, HEXBISCUS,
                Feature.FLOWER,
                new RandomPatchConfiguration(
                        4, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HGBlocks.HEXBISCUS.get())))
                ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, HexxitGearR.rl(name));
    }
}
