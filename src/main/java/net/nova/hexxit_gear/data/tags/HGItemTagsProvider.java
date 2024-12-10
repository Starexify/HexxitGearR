package net.nova.hexxit_gear.data.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItemTagsProvider extends ItemTagsProvider {
    public HGItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, HGBlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.TRIMMABLE_ARMOR).add(
                HGItems.SCALE_HELMET.get(), HGItems.TRIBAL_SKULL.get(), HGItems.THIEF_HOOD.get(), HGItems.SAGE_HOOD.get(),
                HGItems.SCALE_CHESTGUARD.get(), HGItems.TRIBAL_TUNIC.get(), HGItems.THIEF_TUNIC.get(), HGItems.SAGE_ROBE.get(),
                HGItems.SCALE_LEGGINGS.get(), HGItems.TRIBAL_LEGGINGS.get(), HGItems.THIEF_TROUSERS.get(), HGItems.SAGE_PANTS.get(),
                HGItems.SCALE_BOOTS.get(), HGItems.TRIBAL_WARBOOTS.get(), HGItems.THIEF_TURNSHOES.get(), HGItems.SAGE_WALKERS.get()
        );
    }
}
