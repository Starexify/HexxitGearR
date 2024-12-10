package net.nova.hexxit_gear.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;

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
                output.accept(HGBlocks.HEXBISCUS.get());
                output.accept(HGItems.HEXICAL_PETAL.get());
                output.accept(HGItems.HEXICAL_ESSENCE.get());
                output.accept(HGItems.HEXICAL_DIAMOND.get());

                // Scale
                output.accept(HGItems.SCALE_HELMET.get());
                output.accept(HGItems.SCALE_CHESTGUARD.get());
                output.accept(HGItems.SCALE_LEGGINGS.get());
                output.accept(HGItems.SCALE_BOOTS.get());

                // Tribal
                output.accept(HGItems.TRIBAL_SKULL.get());
                output.accept(HGItems.TRIBAL_TUNIC.get());
                output.accept(HGItems.TRIBAL_LEGGINGS.get());
                output.accept(HGItems.TRIBAL_WARBOOTS.get());

                // Thief
                output.accept(HGItems.THIEF_HOOD.get());
                output.accept(HGItems.THIEF_TUNIC.get());
                output.accept(HGItems.THIEF_TROUSERS.get());
                output.accept(HGItems.THIEF_TURNSHOES.get());

                // Sage
                output.accept(HGItems.SAGE_HOOD.get());
                output.accept(HGItems.SAGE_ROBE.get());
                output.accept(HGItems.SAGE_PANTS.get());
                output.accept(HGItems.SAGE_WALKERS.get());
            }).build()
    );
}
