package net.nova.hexxit_gear.data.models;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGModelProvider extends ModelProvider {
    public HGModelProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Block Models
        blockModels.createPlantWithDefaultItem(HGBlocks.HEXBISCUS.get(), HGBlocks.POTTED_HEXBISCUS.get(), BlockModelGenerators.PlantType.EMISSIVE_NOT_TINTED);

        // Item Models
        itemModels.generateFlatItem(HGItems.HEXICAL_PETAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.HEXICAL_ESSENCE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.HEXICAL_DIAMOND.get(), ModelTemplates.FLAT_ITEM);

        // Scale
        itemModels.generateFlatItem(HGItems.SCALE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_CHESTGUARD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        // Tribal
        itemModels.generateFlatItem(HGItems.TRIBAL_SKULL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_TUNIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_WARBOOTS.get(), ModelTemplates.FLAT_ITEM);

        // Thief
        itemModels.generateFlatItem(HGItems.THIEF_HOOD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TUNIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TROUSERS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TURNSHOES.get(), ModelTemplates.FLAT_ITEM);

        // Sage
        itemModels.generateFlatItem(HGItems.SAGE_HOOD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_ROBE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_PANTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_WALKERS.get(), ModelTemplates.FLAT_ITEM);
    }
}
