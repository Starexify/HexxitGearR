package net.nova.hexxit_gear.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.init.HGTags;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItemTagsProvider extends BlockTagCopyingItemTagProvider {
  public HGItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
    super(output, lookupProvider, blockTags, MODID);
  }

  @Override
  protected void addTags(HolderLookup.Provider pProvider) {
    tag(ItemTags.HEAD_ARMOR).add(HGItems.SCALE_HELMET.getKey(), HGItems.TRIBAL_SKULL.getKey(), HGItems.THIEF_HOOD.getKey(), HGItems.SAGE_HOOD.getKey());
    tag(ItemTags.CHEST_ARMOR).add(HGItems.SCALE_CHESTGUARD.getKey(), HGItems.TRIBAL_TUNIC.getKey(), HGItems.THIEF_TUNIC.getKey(), HGItems.SAGE_ROBE.getKey());
    tag(ItemTags.LEG_ARMOR).add(HGItems.SCALE_LEGGINGS.getKey(), HGItems.TRIBAL_LEGGINGS.getKey(), HGItems.THIEF_TROUSERS.getKey(), HGItems.SAGE_PANTS.getKey());
    tag(ItemTags.FOOT_ARMOR).add(HGItems.SCALE_BOOTS.getKey(), HGItems.TRIBAL_WARBOOTS.getKey(), HGItems.THIEF_TURNSHOES.getKey(), HGItems.SAGE_WALKERS.getKey());
    tag(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND.getKey());
    tag(HGTags.ItemTag.REPAIRS_TRIBAL_ARMOR).add(HGItems.HEXICAL_DIAMOND.getKey());
    tag(HGTags.ItemTag.REPAIRS_THIEF_ARMOR).add(HGItems.HEXICAL_DIAMOND.getKey());
    tag(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND.getKey());
  }
}
