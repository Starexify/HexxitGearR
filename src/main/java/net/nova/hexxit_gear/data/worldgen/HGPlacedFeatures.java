package net.nova.hexxit_gear.data.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.nova.hexxit_gear.HexxitGearR;

public class HGPlacedFeatures {
  public static final ResourceKey<PlacedFeature> HEXBISCUS_PLACED = registerKey("hexbiscus_placed");

  public static void bootstrap(BootstrapContext<PlacedFeature> context) {
    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
    Holder<ConfiguredFeature<?, ?>> hexbiscusHolder = configuredFeatures.getOrThrow(HGConfiguredFeatures.HEXBISCUS);

    PlacementUtils.register(context, HEXBISCUS_PLACED, hexbiscusHolder,
        RarityFilter.onAverageOnceEvery(124),
        InSquarePlacement.spread(),
        PlacementUtils.HEIGHTMAP,
        BiomeFilter.biome(),
        CountPlacement.of(1),
        RandomOffsetPlacement.ofTriangle(1, 1),
        BlockPredicateFilter.forPredicate(
            BlockPredicate.allOf(
                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), Blocks.GRASS_BLOCK)
            )
        )
    );
  }

  public static ResourceKey<PlacedFeature> registerKey(String name) {
    return ResourceKey.create(Registries.PLACED_FEATURE, HexxitGearR.rl(name));
  }
}
