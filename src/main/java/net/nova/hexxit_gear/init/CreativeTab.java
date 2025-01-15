package net.nova.hexxit_gear.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class CreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static String HEXXIT_GEAR_TAB_TITLE = MODID + ".creativetab";

    public static final Supplier<CreativeModeTab> HEXXIT_GEAR_TAB = CREATIVE_TAB.register("hexxit_gear_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(HGItems.HEXICAL_DIAMOND.get()))
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
}
