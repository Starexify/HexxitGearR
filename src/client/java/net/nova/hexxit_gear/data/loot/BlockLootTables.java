package net.nova.hexxit_gear.data.loot;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

public class BlockLootTables extends FabricBlockLootSubProvider {
  public BlockLootTables(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generate() {
    add(HGBlocks.HEXBISCUS.getFirst().value(), block -> this.createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(HGItems.HEXICAL_PETAL.getFirst().value()))));
    dropPottedContents(HGBlocks.POTTED_HEXBISCUS.getFirst().value());
  }
}
