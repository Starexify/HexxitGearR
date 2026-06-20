package net.nova.hexxit_gear.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.nova.hexxit_gear.init.HGBlocks;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGBlockTagsProvider extends BlockTagsProvider {
  public HGBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
    super(output, lookupProvider, MODID);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    tag(BlockTags.FLOWERS).add(HGBlocks.HEXBISCUS.getKey());
    tag(BlockTags.FLOWER_POTS).add(HGBlocks.POTTED_HEXBISCUS.getKey());
  }
}
