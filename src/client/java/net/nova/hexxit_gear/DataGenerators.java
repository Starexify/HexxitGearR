package net.nova.hexxit_gear;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.nova.hexxit_gear.data.LangProvider;
import net.nova.hexxit_gear.data.loot.BlockLootTables;
import net.nova.hexxit_gear.data.models.HGEquipmentModelProvider;
import net.nova.hexxit_gear.data.models.HGModelProvider;
import net.nova.hexxit_gear.data.recipe.HGRecipeProvider;
import net.nova.hexxit_gear.data.tags.HGBlockTagsProvider;
import net.nova.hexxit_gear.data.tags.HGItemTagsProvider;
import net.nova.hexxit_gear.data.worldgen.HGConfiguredFeatures;
import net.nova.hexxit_gear.data.worldgen.HGPlacedFeatures;

public class DataGenerators implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(LangProvider::new);

        pack.addProvider(HGModelProvider::new);
        pack.addProvider(HGEquipmentModelProvider::new);

        pack.addProvider(HGBlockTagsProvider::new);
        pack.addProvider(HGItemTagsProvider::new);

        pack.addProvider(BlockLootTables::new);

        pack.addProvider(HGRecipeProvider::new);

        //pack.addProvider(HGConfiguredFeatures::new);
        //pack.addProvider(HGPlacedFeatures::new);
    }
}
