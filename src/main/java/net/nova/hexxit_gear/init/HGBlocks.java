package net.nova.hexxit_gear.init;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

  public static final DeferredBlock<FlowerBlock> HEXBISCUS = registerBlockWithItem("hexbiscus", p -> new FlowerBlock(MobEffects.RESISTANCE, 5.0F, p),
      BlockBehaviour.Properties.of()
          .mapColor(MapColor.PLANT)
          .noCollision()
          .instabreak()
          .sound(SoundType.GRASS)
          .offsetType(BlockBehaviour.OffsetType.XZ)
          .pushReaction(PushReaction.DESTROY)
          .lightLevel(statex -> 4));

  public static final DeferredBlock<FlowerPotBlock> POTTED_HEXBISCUS = BLOCKS.registerBlock("potted_hexbiscus", p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HEXBISCUS, p),
      () -> BlockBehaviour.Properties.of()
          .instabreak()
          .noOcclusion()
          .pushReaction(PushReaction.DESTROY)
  );

  static {
    FlowerPotBlock pot = (FlowerPotBlock)Blocks.FLOWER_POT;
    pot.addPlant(HEXBISCUS.getId(), POTTED_HEXBISCUS);
  }

  // Registers
  public static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> blockCreator, BlockBehaviour.Properties properties) {
    DeferredBlock<T> block = BLOCKS.registerBlock(name, blockCreator, () -> properties);
    HGItems.ITEMS.registerSimpleBlockItem(name, block);
    return block;
  }
}
