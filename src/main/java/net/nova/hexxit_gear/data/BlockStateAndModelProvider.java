package net.nova.hexxit_gear.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nova.hexxit_gear.init.HGBlocks;

import java.util.function.Consumer;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class BlockStateAndModelProvider extends BlockStateProvider {
    public BlockStateAndModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createPlant(HGBlocks.HEXBISCUS.get(), HGBlocks.POTTED_HEXBISCUS.get());
    }

    // Methods
    private void createPlant(Block plantBlock, Block pottedPlantBlock) {
        ResourceLocation texture = blockTexture(plantBlock);
        ModelFile pot = models().withExistingParent(name(pottedPlantBlock), "block/flower_pot_cross")
                .texture("plant", texture)
                .renderType("minecraft:cutout");
        ModelFile cross = models().withExistingParent(name(plantBlock), "block/tinted_cross")
                .texture("cross", texture)
                .renderType("minecraft:cutout");

        simpleBlock(plantBlock, cross);
        simpleBlock(pottedPlantBlock, pot);

        itemModels().withExistingParent(name(plantBlock), "item/generated")
                .texture("layer0", "block/" + name(plantBlock));
    }

    // Other stuff
    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
