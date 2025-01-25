package net.nova.hexxit_gear;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;
import net.nova.hexxit_gear.worldgen.HGPlacedFeatures;
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

        // Biome Modifications
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.VEGETAL_DECORATION, HGPlacedFeatures.HEXBISCUS_PLACED);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void addEffect(LivingEntity livingEntity, Holder<MobEffect> effect, int duration, int amplifier) {
        livingEntity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false, false));
    }
}
