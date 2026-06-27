package net.nova.hexxit_gear.data;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import java.util.concurrent.CompletableFuture;

public class LangProvider extends FabricLanguageProvider {
  public LangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(dataOutput, registryLookup);
  }

  @Override
  public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
    translationBuilder.add(HGBlocks.HEXBISCUS.getFirst().value(), "Hexbiscus");

    // Items
    translationBuilder.add(HGItems.HEXICAL_PETAL.getFirst().value(), "Hexical Petal");
    translationBuilder.add(HGItems.HEXICAL_ESSENCE.getFirst().value(), "Hexical Essence");
    translationBuilder.add(HGItems.HEXICAL_DIAMOND.getFirst().value(), "Hexical Diamond");

    translationBuilder.add(HGItems.SCALE_HELMET.getFirst().value(), "Scale Helmet");
    translationBuilder.add(HGItems.SCALE_CHESTGUARD.getFirst().value(), "Scale Chestguard");
    translationBuilder.add(HGItems.SCALE_LEGGINGS.getFirst().value(), "Scale Leggings");
    translationBuilder.add(HGItems.SCALE_BOOTS.getFirst().value(), "Scale Boots");

    translationBuilder.add(HGItems.TRIBAL_SKULL.getFirst().value(), "Tribal Skull");
    translationBuilder.add(HGItems.TRIBAL_TUNIC.getFirst().value(), "Tribal Tunic");
    translationBuilder.add(HGItems.TRIBAL_LEGGINGS.getFirst().value(), "Tribal Leggings");
    translationBuilder.add(HGItems.TRIBAL_WARBOOTS.getFirst().value(), "Tribal Warboots");

    translationBuilder.add(HGItems.THIEF_HOOD.getFirst().value(), "Thief Hood");
    translationBuilder.add(HGItems.THIEF_TUNIC.getFirst().value(), "Thief Tunic");
    translationBuilder.add(HGItems.THIEF_TROUSERS.getFirst().value(), "Thief Trousers");
    translationBuilder.add(HGItems.THIEF_TURNSHOES.getFirst().value(), "Thief Turnshoes");

    translationBuilder.add(HGItems.SAGE_HOOD.getFirst().value(), "Sage Hood");
    translationBuilder.add(HGItems.SAGE_ROBE.getFirst().value(), "Sage Robe");
    translationBuilder.add(HGItems.SAGE_PANTS.getFirst().value(), "Sage Pants");
    translationBuilder.add(HGItems.SAGE_WALKERS.getFirst().value(), "Sage Walkers");

    // Creative Tab
    translationBuilder.add(CreativeTab.HEXXIT_GEAR_TAB_TITLE, "Hexxit Gear R");
  }
}
