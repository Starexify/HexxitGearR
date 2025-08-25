package net.nova.hexxit_gear.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
    public static ResourceKey<CreativeModeTab> HEXXIT_GEAR_TAB_KEY =  ResourceKey.create(Registries.CREATIVE_MODE_TAB, HexxitGearR.rl("hexxit_gear_tab"));

    public static final CreativeModeTab HEXXIT_GEAR_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, HEXXIT_GEAR_TAB_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(HGItems.HEXICAL_DIAMOND))
                    .title(Component.translatable(HEXXIT_GEAR_TAB_TITLE))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Hexical
                        output.accept(HGBlocks.HEXBISCUS);
                        output.accept(HGItems.HEXICAL_PETAL);
                        output.accept(HGItems.HEXICAL_ESSENCE);
                        output.accept(HGItems.HEXICAL_DIAMOND);

                        // Scale
                        output.accept(HGItems.SCALE_HELMET);
                        output.accept(HGItems.SCALE_CHESTGUARD);
                        output.accept(HGItems.SCALE_LEGGINGS);
                        output.accept(HGItems.SCALE_BOOTS);

                        // Tribal
                        output.accept(HGItems.TRIBAL_SKULL);
                        output.accept(HGItems.TRIBAL_TUNIC);
                        output.accept(HGItems.TRIBAL_LEGGINGS);
                        output.accept(HGItems.TRIBAL_WARBOOTS);

                        // Thief
                        output.accept(HGItems.THIEF_HOOD);
                        output.accept(HGItems.THIEF_TUNIC);
                        output.accept(HGItems.THIEF_TROUSERS);
                        output.accept(HGItems.THIEF_TURNSHOES);

                        // Sage
                        output.accept(HGItems.SAGE_HOOD);
                        output.accept(HGItems.SAGE_ROBE);
                        output.accept(HGItems.SAGE_PANTS);
                        output.accept(HGItems.SAGE_WALKERS);
                    }).build()
    );

    public static void initialize() {
        HexxitGearR.LOGGER.info("Registering Creative Tab");
    }
}
