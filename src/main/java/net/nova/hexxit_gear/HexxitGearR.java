package net.nova.hexxit_gear;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.nova.hexxit_gear.data.DataGenerators;
import net.nova.hexxit_gear.init.CreativeTab;
import net.nova.hexxit_gear.init.HGArmorMaterial;
import net.nova.hexxit_gear.init.HGBlocks;
import net.nova.hexxit_gear.init.HGItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

@Mod(MODID)
public class HexxitGearR {
    public static final String MODID = "hexxit_gear";
    public static final Logger logger = LoggerFactory.getLogger(HexxitGearR.class);

    public HexxitGearR(IEventBus bus) {
        HGArmorMaterial.ARMOR_MATERIALS.register(bus);
        CreativeTab.CREATIVE_TAB.register(bus);
        HGItems.ITEMS.register(bus);
        HGBlocks.BLOCKS.register(bus);

        bus.addListener(DataGenerators::gatherData);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static void addEffect(LivingEntity livingEntity, Holder<MobEffect> effect, int duration, int amplifier) {
        livingEntity.addEffect(new MobEffectInstance(effect, duration, amplifier, false, false, false));
    }
}
