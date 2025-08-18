package net.nova.hexxit_gear.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
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

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(HEXBISCUS, new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, new RandomPatchConfiguration(1, 1, 1,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(HGBlocks.HEXBISCUS)))
        )));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, HexxitGearR.rl(name));
    }
}
