package net.nova.hexxit_gear.init;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<FlowerBlock> HEXBISCUS = registerBlockWithItem("hexbiscus", properties -> new FlowerBlock(MobEffects.DAMAGE_RESISTANCE, 5.0F, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(light -> 4));

    public static final DeferredBlock<Block> POTTED_HEXBISCUS = registerBlockWithItem("potted_hexbiscus", properties -> new FlowerPotBlock(null, HEXBISCUS, properties), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));

    // Registers
    public static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> blockCreator, BlockBehaviour.Properties properties) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, blockCreator, properties);
        HGItems.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }
}
