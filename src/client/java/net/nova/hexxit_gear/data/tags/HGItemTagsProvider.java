package net.nova.hexxit_gear.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.init.HGTags;

import java.util.concurrent.CompletableFuture;

public class HGItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public HGItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(HGItems.SCALE_HELMET, HGItems.TRIBAL_SKULL, HGItems.THIEF_HOOD, HGItems.SAGE_HOOD);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(HGItems.SCALE_CHESTGUARD, HGItems.TRIBAL_TUNIC, HGItems.THIEF_TUNIC, HGItems.SAGE_ROBE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(HGItems.SCALE_LEGGINGS, HGItems.TRIBAL_LEGGINGS, HGItems.THIEF_TROUSERS, HGItems.SAGE_PANTS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(HGItems.SCALE_BOOTS, HGItems.TRIBAL_WARBOOTS, HGItems.THIEF_TURNSHOES, HGItems.SAGE_WALKERS);
        valueLookupBuilder(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND);
        valueLookupBuilder(HGTags.ItemTag.REPAIRS_TRIBAL_ARMOR).add(HGItems.HEXICAL_DIAMOND);
        valueLookupBuilder(HGTags.ItemTag.REPAIRS_THIEF_ARMOR).add(HGItems.HEXICAL_DIAMOND);
        valueLookupBuilder(HGTags.ItemTag.REPAIRS_SAGE_ARMOR).add(HGItems.HEXICAL_DIAMOND);
    }
}
