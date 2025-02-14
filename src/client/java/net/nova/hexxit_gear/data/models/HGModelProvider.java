package net.nova.hexxit_gear.data.models;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

public class HGModelProvider extends FabricModelProvider {
    public HGModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        // Block Models
        blockModelGenerators.createPlantWithDefaultItem(HGBlocks.HEXBISCUS, HGBlocks.POTTED_HEXBISCUS, BlockModelGenerators.PlantType.EMISSIVE_NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModels) {
        // Item Models
        itemModels.generateFlatItem(HGItems.HEXICAL_PETAL, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.HEXICAL_ESSENCE, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.HEXICAL_DIAMOND, ModelTemplates.FLAT_ITEM);

        // Scale
        itemModels.generateFlatItem(HGItems.SCALE_HELMET, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_CHESTGUARD, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SCALE_BOOTS, ModelTemplates.FLAT_ITEM);

        // Tribal
        itemModels.generateFlatItem(HGItems.TRIBAL_SKULL, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_TUNIC, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.TRIBAL_WARBOOTS, ModelTemplates.FLAT_ITEM);

        // Thief
        itemModels.generateFlatItem(HGItems.THIEF_HOOD, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TUNIC, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TROUSERS, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.THIEF_TURNSHOES, ModelTemplates.FLAT_ITEM);

        // Sage
        itemModels.generateFlatItem(HGItems.SAGE_HOOD, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_ROBE, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_PANTS, ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(HGItems.SAGE_WALKERS, ModelTemplates.FLAT_ITEM);
    }
}
