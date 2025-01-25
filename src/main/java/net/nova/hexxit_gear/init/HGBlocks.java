package net.nova.hexxit_gear.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.nova.hexxit_gear.HexxitGearR;

import java.util.function.Function;

public class HGBlocks {

    public static final Block HEXBISCUS = registerBlock("hexbiscus", properties -> new FlowerBlock(MobEffects.DAMAGE_RESISTANCE, 5.0F, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(light -> 4));

    public static final Block POTTED_HEXBISCUS = registerBlock("potted_hexbiscus", properties -> new FlowerPotBlock(HEXBISCUS, properties), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));


    // Registers
    public static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = register(name, factory, properties);
        HGItems.registerItem(name, itemProperties -> new BlockItem(block, itemProperties.useBlockDescriptionPrefix()));
        return block;
    }

    public static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceKey.create(Registries.BLOCK, HexxitGearR.rl(name)), factory.apply(properties.setId(ResourceKey.create(Registries.BLOCK, HexxitGearR.rl(name)))));
    }

    public static void initialize() {
        HexxitGearR.LOGGER.info("Registering Blocks");
    }
}
