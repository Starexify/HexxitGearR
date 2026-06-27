package net.nova.hexxit_gear.data.models;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

public class HGModelProvider extends FabricModelProvider {
  public HGModelProvider(FabricPackOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
    // Block Models
    blockModelGenerators.createPlantWithDefaultItem(HGBlocks.HEXBISCUS.getFirst().value(), HGBlocks.POTTED_HEXBISCUS.getFirst().value(), BlockModelGenerators.PlantType.EMISSIVE_NOT_TINTED);
  }

  @Override
  public void generateItemModels(ItemModelGenerators itemModels) {
    // Item Models
    itemModels.generateFlatItem(HGItems.HEXICAL_PETAL.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.HEXICAL_ESSENCE.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.HEXICAL_DIAMOND.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Scale
    itemModels.generateFlatItem(HGItems.SCALE_HELMET.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SCALE_CHESTGUARD.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SCALE_LEGGINGS.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SCALE_BOOTS.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Tribal
    itemModels.generateFlatItem(HGItems.TRIBAL_SKULL.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.TRIBAL_TUNIC.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.TRIBAL_LEGGINGS.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.TRIBAL_WARBOOTS.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Thief
    itemModels.generateFlatItem(HGItems.THIEF_HOOD.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.THIEF_TUNIC.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.THIEF_TROUSERS.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.THIEF_TURNSHOES.getFirst().value(), ModelTemplates.FLAT_ITEM);

    // Sage
    itemModels.generateFlatItem(HGItems.SAGE_HOOD.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SAGE_ROBE.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SAGE_PANTS.getFirst().value(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(HGItems.SAGE_WALKERS.getFirst().value(), ModelTemplates.FLAT_ITEM);
  }
}
