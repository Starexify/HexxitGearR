package net.nova.hexxit_gear;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@Mod(MODID)
public class HexxitGearR {
    public static final String MODID = "hexxit_gear";

    public HexxitGearR(IEventBus bus) {
        CreativeTab.CREATIVE_TAB.register(bus);
        HGItems.ITEMS.register(bus);
        HGBlocks.BLOCKS.register(bus);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void addEffect(LivingEntity livingEntity, Holder<MobEffect> effect, int duration, int amplifier) {
        livingEntity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false, false));
    }
}
