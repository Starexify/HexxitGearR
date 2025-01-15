package net.nova.hexxit_gear.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.hexxit_gear.init.HGItems;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItemModelProvider extends ItemModelProvider {
    public HGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Hexical
        basicItem(HGItems.HEXICAL_PETAL.get());
        basicItem(HGItems.HEXICAL_ESSENCE.get());
        basicItem(HGItems.HEXICAL_DIAMOND.get());

        // Scale
        basicItem(HGItems.SCALE_HELMET.get());
        basicItem(HGItems.SCALE_CHESTGUARD.get());
        basicItem(HGItems.SCALE_LEGGINGS.get());
        basicItem(HGItems.SCALE_BOOTS.get());

        // Tribal
        basicItem(HGItems.TRIBAL_SKULL.get());
        basicItem(HGItems.TRIBAL_TUNIC.get());
        basicItem(HGItems.TRIBAL_LEGGINGS.get());
        basicItem(HGItems.TRIBAL_WARBOOTS.get());

        // Thief
        basicItem(HGItems.THIEF_HOOD.get());
        basicItem(HGItems.THIEF_TUNIC.get());
        basicItem(HGItems.THIEF_TROUSERS.get());
        basicItem(HGItems.THIEF_TURNSHOES.get());

        // Sage
        basicItem(HGItems.SAGE_HOOD.get());
        basicItem(HGItems.SAGE_ROBE.get());
        basicItem(HGItems.SAGE_PANTS.get());
        basicItem(HGItems.SAGE_WALKERS.get());
    }
}
