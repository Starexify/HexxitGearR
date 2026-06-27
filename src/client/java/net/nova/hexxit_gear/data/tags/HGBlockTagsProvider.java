package net.nova.hexxit_gear.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.nova.hexxit_gear.init.HGBlocks;

import java.util.concurrent.CompletableFuture;

public class HGBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
  public HGBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(BlockTags.FLOWERS).add(HGBlocks.HEXBISCUS.getSecond());
    builder(BlockTags.FLOWER_POTS).add(HGBlocks.POTTED_HEXBISCUS.getSecond());
  }
}
