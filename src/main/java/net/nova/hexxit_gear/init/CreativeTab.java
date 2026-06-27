package net.nova.hexxit_gear.init;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.nova.hexxit_gear.HexxitGearR;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class CreativeTab {
  public static String HEXXIT_GEAR_TAB_TITLE = MODID + ".creativetab";
  public static ResourceKey<CreativeModeTab> HEXXIT_GEAR_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, HexxitGearR.rl("hexxit_gear_tab"));

  public static final CreativeModeTab HEXXIT_GEAR_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HEXXIT_GEAR_TAB_KEY,
      FabricCreativeModeTab.builder()
          .icon(() -> new ItemStack(HGItems.HEXICAL_DIAMOND.getFirst()))
          .title(Component.translatable(HEXXIT_GEAR_TAB_TITLE))
          .displayItems((itemDisplayParameters, output) -> {
            // Hexical
            output.accept(HGBlocks.HEXBISCUS.getFirst().value());
            output.accept(HGItems.HEXICAL_PETAL.getFirst().value());
            output.accept(HGItems.HEXICAL_ESSENCE.getFirst().value());
            output.accept(HGItems.HEXICAL_DIAMOND.getFirst().value());

            // Scale
            output.accept(HGItems.SCALE_HELMET.getFirst().value());
            output.accept(HGItems.SCALE_CHESTGUARD.getFirst().value());
            output.accept(HGItems.SCALE_LEGGINGS.getFirst().value());
            output.accept(HGItems.SCALE_BOOTS.getFirst().value());

            // Tribal
            output.accept(HGItems.TRIBAL_SKULL.getFirst().value());
            output.accept(HGItems.TRIBAL_TUNIC.getFirst().value());
            output.accept(HGItems.TRIBAL_LEGGINGS.getFirst().value());
            output.accept(HGItems.TRIBAL_WARBOOTS.getFirst().value());

            // Thief
            output.accept(HGItems.THIEF_HOOD.getFirst().value());
            output.accept(HGItems.THIEF_TUNIC.getFirst().value());
            output.accept(HGItems.THIEF_TROUSERS.getFirst().value());
            output.accept(HGItems.THIEF_TURNSHOES.getFirst().value());

            // Sage
            output.accept(HGItems.SAGE_HOOD.getFirst().value());
            output.accept(HGItems.SAGE_ROBE.getFirst().value());
            output.accept(HGItems.SAGE_PANTS.getFirst().value());
            output.accept(HGItems.SAGE_WALKERS.getFirst().value());
          }).build()
  );

  public static void initialize() {
    HexxitGearR.LOGGER.info("Registering Creative Tab");
  }
}
