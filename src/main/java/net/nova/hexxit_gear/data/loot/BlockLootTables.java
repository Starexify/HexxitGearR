package net.nova.hexxit_gear.data.loot;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
  public BlockLootTables(HolderLookup.Provider pProvider) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pProvider);
  }

  @Override
  protected void generate() {
    add(HGBlocks.HEXBISCUS.get(), block -> this.createSilkTouchOrShearsDispatchTable(block, (LootPoolEntryContainer.Builder<?>) this.applyExplosionCondition(block, LootItem.lootTableItem(HGItems.HEXICAL_PETAL))));
    dropPottedContents(HGBlocks.POTTED_HEXBISCUS.get());
  }

  @Override
  protected Iterable<Block> getKnownBlocks() {
    return HGBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
  }
}
