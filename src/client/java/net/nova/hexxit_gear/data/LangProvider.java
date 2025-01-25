package net.nova.hexxit_gear.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

public class LangProvider extends FabricLanguageProvider {
    public LangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(HGBlocks.HEXBISCUS, "Hexbiscus");

        // Items
        translationBuilder.add(HGItems.HEXICAL_PETAL, "Hexical Petal");
        translationBuilder.add(HGItems.HEXICAL_ESSENCE, "Hexical Essence");
        translationBuilder.add(HGItems.HEXICAL_DIAMOND, "Hexical Diamond");

        translationBuilder.add(HGItems.SCALE_HELMET, "Scale Helmet");
        translationBuilder.add(HGItems.SCALE_CHESTGUARD, "Scale Chestguard");
        translationBuilder.add(HGItems.SCALE_LEGGINGS, "Scale Leggings");
        translationBuilder.add(HGItems.SCALE_BOOTS, "Scale Boots");

        translationBuilder.add(HGItems.TRIBAL_SKULL, "Tribal Skull");
        translationBuilder.add(HGItems.TRIBAL_TUNIC, "Tribal Tunic");
        translationBuilder.add(HGItems.TRIBAL_LEGGINGS, "Tribal Leggings");
        translationBuilder.add(HGItems.TRIBAL_WARBOOTS, "Tribal Warboots");

        translationBuilder.add(HGItems.THIEF_HOOD, "Thief Hood");
        translationBuilder.add(HGItems.THIEF_TUNIC, "Thief Tunic");
        translationBuilder.add(HGItems.THIEF_TROUSERS, "Thief Trousers");
        translationBuilder.add(HGItems.THIEF_TURNSHOES, "Thief Turnshoes");

        translationBuilder.add(HGItems.SAGE_HOOD, "Sage Hood");
        translationBuilder.add(HGItems.SAGE_ROBE, "Sage Robe");
        translationBuilder.add(HGItems.SAGE_PANTS, "Sage Pants");
        translationBuilder.add(HGItems.SAGE_WALKERS, "Sage Walkers");

        // Creative Tab
        translationBuilder.add(CreativeTab.HEXXIT_GEAR_TAB_TITLE, "Hexxit Gear R");
    }
}
