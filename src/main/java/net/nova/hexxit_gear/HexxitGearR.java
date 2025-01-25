package net.nova.hexxit_gear;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexxitGearR implements ModInitializer {
    public static final String MODID = "hexxit_gear";
    public static final Logger LOGGER = LoggerFactory.getLogger(HexxitGearR.class);

    @Override
    public void onInitialize() {
        HGItems.initialize();
        HGBlocks.initialize();
        CreativeTab.initialize();
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void addEffect(LivingEntity livingEntity, Holder<MobEffect> effect, int duration, int amplifier) {
        livingEntity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false, false));
    }
}
