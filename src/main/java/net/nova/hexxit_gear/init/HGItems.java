package net.nova.hexxit_gear.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.nova.hexxit_gear.HexxitGearR;
import net.nova.hexxit_gear.item.SageArmor;
import net.nova.hexxit_gear.item.ScaleArmor;
import net.nova.hexxit_gear.item.ThiefArmor;
import net.nova.hexxit_gear.item.TribalArmor;

import java.util.function.Function;

public class HGItems {
    // Hexbiscus
    public static Item HEXICAL_PETAL = registerSimpleItem("hexical_petal");
    public static Item HEXICAL_ESSENCE = registerSimpleItem("hexical_essence");
    public static Item HEXICAL_DIAMOND = registerSimpleItem("hexical_diamond");

    // Scale
    // Scale
    public static Item SCALE_HELMET = registerItem("scale_helmet", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.HELMET).fireResistant()));
    public static Item SCALE_CHESTGUARD = registerItem("scale_chestguard", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.CHESTPLATE).fireResistant()));
    public static Item SCALE_LEGGINGS = registerItem("scale_leggings", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.LEGGINGS).fireResistant()));
    public static Item SCALE_BOOTS = registerItem("scale_boots", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.BOOTS).fireResistant()));

    // Tribal
    public static Item TRIBAL_SKULL = registerItem("tribal_skull", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.HELMET).fireResistant()));
    public static Item TRIBAL_TUNIC = registerItem("tribal_tunic", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.CHESTPLATE).fireResistant()));
    public static Item TRIBAL_LEGGINGS = registerItem("tribal_leggings", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.LEGGINGS).fireResistant()));
    public static Item TRIBAL_WARBOOTS = registerItem("tribal_warboots", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.BOOTS).fireResistant()));

    // Thief
    public static Item THIEF_HOOD = registerItem("thief_hood", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.HELMET).fireResistant()));
    public static Item THIEF_TUNIC = registerItem("thief_tunic", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.CHESTPLATE).fireResistant()));
    public static Item THIEF_TROUSERS = registerItem("thief_trousers", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.LEGGINGS).fireResistant()));
    public static Item THIEF_TURNSHOES = registerItem("thief_turnshoes", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.BOOTS).fireResistant()));

    // Sage
    public static Item SAGE_HOOD = registerItem("sage_hood", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.HELMET).fireResistant()));
    public static Item SAGE_ROBE = registerItem("sage_robe", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.CHESTPLATE).fireResistant()));
    public static Item SAGE_PANTS = registerItem("sage_pants", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.LEGGINGS).fireResistant()));
    public static Item SAGE_WALKERS = registerItem("sage_walkers", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.BOOTS).fireResistant()));

    public static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        return register(name, factory, new Item.Properties());
    }

    public static Item registerSimpleItem(String string) {
        return registerItem(string, Item::new);
    }

    public static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, HexxitGearR.rl(name)), factory.apply(properties.setId(ResourceKey.create(Registries.ITEM, HexxitGearR.rl(name)))));
    }

    public static void initialize() {
        HexxitGearR.LOGGER.info("Registering Items");
    }
}
