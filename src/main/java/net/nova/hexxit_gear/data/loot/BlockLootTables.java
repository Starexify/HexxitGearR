package net.nova.hexxit_gear.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class BlockLootTables extends BlockLootSubProvider {
    protected BlockLootTables(HolderLookup.Provider pProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pProvider);
    }

    @Override
    protected void generate() {
        add(HGBlocks.HEXBISCUS.get(), block -> this.createSilkTouchOrShearsDispatchTable(block, (LootPoolEntryContainer.Builder<?>) this.applyExplosionCondition(block, LootItem.lootTableItem(HGItems.HEXICAL_PETAL))));
        dropPottedContents(HGBlocks.POTTED_HEXBISCUS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
