package net.nova.hexxit_gear.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.nova.hexxit_gear.init.HGBlocks;

import java.util.concurrent.CompletableFuture;

public class HGBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public HGBlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(BlockTags.FLOWERS).add(HGBlocks.HEXBISCUS);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(HGBlocks.POTTED_HEXBISCUS);
    }
}
