package net.nova.hexxit_gear.init;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
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
  public static final Pair<Holder<Block>, ResourceKey<Block>> HEXBISCUS = registerBlockWithItem("hexbiscus", properties -> new FlowerBlock(MobEffects.RESISTANCE, 5.0F, properties),
      BlockBehaviour.Properties.of()
          .mapColor(MapColor.PLANT)
          .noCollision()
          .instabreak()
          .sound(SoundType.GRASS)
          .offsetType(BlockBehaviour.OffsetType.XZ)
          .pushReaction(PushReaction.DESTROY)
          .lightLevel(light -> 4));

  public static final Pair<Holder<Block>, ResourceKey<Block>> POTTED_HEXBISCUS = registerBlock("potted_hexbiscus", properties -> new FlowerPotBlock(HEXBISCUS.getFirst().value(), properties), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));

  // Registers
  public static <T extends Block> Pair<Holder<T>, ResourceKey<Block>>  registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> function, BlockBehaviour.Properties properties) {
    Pair<Holder<T>, ResourceKey<Block>> block = registerBlock(name, function, properties);
    HGItems.registerItem(name, itemProperties -> new BlockItem(block.getFirst().value(), itemProperties.useBlockDescriptionPrefix()));
    return block;
  }

  public static <T extends Block> Pair<Holder<T>, ResourceKey<Block>> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, BlockBehaviour.Properties properties) {
    ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, HexxitGearR.rl(name));
    return Pair.of(Registry.registerForHolder(BuiltInRegistries.BLOCK, key, function.apply(properties.setId(key))), key);
  }

  public static void initialize() {
    HexxitGearR.LOGGER.info("Registering Blocks");
  }
}
