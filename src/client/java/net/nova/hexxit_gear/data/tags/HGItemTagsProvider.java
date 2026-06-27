package net.nova.hexxit_gear.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.init.HGTags;

import java.util.concurrent.CompletableFuture;

public class HGItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
  public HGItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    builder(ItemTags.HEAD_ARMOR).add(HGItems.SCALE_HELMET.getSecond(), HGItems.TRIBAL_SKULL.getSecond(), HGItems.THIEF_HOOD.getSecond(), HGItems.SAGE_HOOD.getSecond());
    builder(ItemTags.CHEST_ARMOR).add(HGItems.SCALE_CHESTGUARD.getSecond(), HGItems.TRIBAL_TUNIC.getSecond(), HGItems.THIEF_TUNIC.getSecond(), HGItems.SAGE_ROBE.getSecond());
    builder(ItemTags.LEG_ARMOR).add(HGItems.SCALE_LEGGINGS.getSecond(), HGItems.TRIBAL_LEGGINGS.getSecond(), HGItems.THIEF_TROUSERS.getSecond(), HGItems.SAGE_PANTS.getSecond());
    builder(ItemTags.FOOT_ARMOR).add(HGItems.SCALE_BOOTS.getSecond(), HGItems.TRIBAL_WARBOOTS.getSecond(), HGItems.THIEF_TURNSHOES.getSecond(), HGItems.SAGE_WALKERS.getSecond());
    builder(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND.getSecond());
    builder(HGTags.ItemTag.REPAIRS_TRIBAL_ARMOR).add(HGItems.HEXICAL_DIAMOND.getSecond());
    builder(HGTags.ItemTag.REPAIRS_THIEF_ARMOR).add(HGItems.HEXICAL_DIAMOND.getSecond());
    builder(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND.getSecond());
  }
}
