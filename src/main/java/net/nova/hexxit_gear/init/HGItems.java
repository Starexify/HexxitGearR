package net.nova.hexxit_gear.init;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.hexxit_gear.item.SageArmor;
import net.nova.hexxit_gear.item.ScaleArmor;
import net.nova.hexxit_gear.item.ThiefArmor;
import net.nova.hexxit_gear.item.TribalArmor;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Hexbiscus
    public static DeferredItem<Item> HEXICAL_PETAL = ITEMS.registerSimpleItem("hexical_petal");
    public static DeferredItem<Item> HEXICAL_ESSENCE = ITEMS.registerSimpleItem("hexical_essence");
    public static DeferredItem<Item> HEXICAL_DIAMOND = ITEMS.registerSimpleItem("hexical_diamond");

    // Scale
    public static DeferredItem<Item> SCALE_HELMET = ITEMS.registerItem("scale_helmet", properties -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorType.HELMET, properties.fireResistant()));
    public static DeferredItem<Item> SCALE_CHESTGUARD = ITEMS.registerItem("scale_chestguard", properties -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorType.CHESTPLATE, properties.fireResistant()));
    public static DeferredItem<Item> SCALE_LEGGINGS = ITEMS.registerItem("scale_leggings", properties -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorType.LEGGINGS, properties.fireResistant()));
    public static DeferredItem<Item> SCALE_BOOTS = ITEMS.registerItem("scale_boots", properties -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorType.BOOTS, properties.fireResistant()));

    // Tribal
    public static DeferredItem<Item> TRIBAL_SKULL = ITEMS.registerItem("tribal_skull", properties -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorType.HELMET, properties.fireResistant()));
    public static DeferredItem<Item> TRIBAL_TUNIC = ITEMS.registerItem("tribal_tunic", properties -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorType.CHESTPLATE, properties.fireResistant()));
    public static DeferredItem<Item> TRIBAL_LEGGINGS = ITEMS.registerItem("tribal_leggings", properties -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorType.LEGGINGS, properties.fireResistant()));
    public static DeferredItem<Item> TRIBAL_WARBOOTS = ITEMS.registerItem("tribal_warboots", properties -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorType.BOOTS, properties.fireResistant()));

    // Thief
    public static DeferredItem<Item> THIEF_HOOD = ITEMS.registerItem("thief_hood", properties -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorType.HELMET, properties.fireResistant()));
    public static DeferredItem<Item> THIEF_TUNIC = ITEMS.registerItem("thief_tunic", properties -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorType.CHESTPLATE, properties.fireResistant()));
    public static DeferredItem<Item> THIEF_TROUSERS = ITEMS.registerItem("thief_trousers", properties -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorType.LEGGINGS, properties.fireResistant()));
    public static DeferredItem<Item> THIEF_TURNSHOES = ITEMS.registerItem("thief_turnshoes", properties -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorType.BOOTS, properties.fireResistant()));

    // Sage
    public static DeferredItem<Item> SAGE_HOOD = ITEMS.registerItem("sage_hood", properties -> new SageArmor(HGArmorMaterial.SAGE, ArmorType.HELMET, properties.fireResistant()));
    public static DeferredItem<Item> SAGE_ROBE = ITEMS.registerItem("sage_robe", properties -> new SageArmor(HGArmorMaterial.SAGE, ArmorType.CHESTPLATE, properties.fireResistant()));
    public static DeferredItem<Item> SAGE_PANTS = ITEMS.registerItem("sage_pants", properties -> new SageArmor(HGArmorMaterial.SAGE, ArmorType.LEGGINGS, properties.fireResistant()));
    public static DeferredItem<Item> SAGE_WALKERS = ITEMS.registerItem("sage_walkers", properties -> new SageArmor(HGArmorMaterial.SAGE, ArmorType.BOOTS, properties.fireResistant()));
}
