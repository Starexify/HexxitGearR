package net.nova.hexxit_gear.init;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
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
  public static Pair<Holder<Item>, ResourceKey<Item>> HEXICAL_PETAL = registerItem("hexical_petal", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> HEXICAL_ESSENCE = registerItem("hexical_essence", Item::new);
  public static Pair<Holder<Item>, ResourceKey<Item>> HEXICAL_DIAMOND = registerItem("hexical_diamond", Item::new);

  // Scale
  // Scale
  public static Pair<Holder<Item>, ResourceKey<Item>> SCALE_HELMET = registerItem("scale_helmet", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.HELMET).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SCALE_CHESTGUARD = registerItem("scale_chestguard", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.CHESTPLATE).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SCALE_LEGGINGS = registerItem("scale_leggings", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.LEGGINGS).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SCALE_BOOTS = registerItem("scale_boots", properties -> new ScaleArmor(properties.humanoidArmor(HGArmorMaterial.SCALE, ArmorType.BOOTS).fireResistant()));

  // Tribal
  public static Pair<Holder<Item>, ResourceKey<Item>> TRIBAL_SKULL = registerItem("tribal_skull", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.HELMET).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> TRIBAL_TUNIC = registerItem("tribal_tunic", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.CHESTPLATE).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> TRIBAL_LEGGINGS = registerItem("tribal_leggings", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.LEGGINGS).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> TRIBAL_WARBOOTS = registerItem("tribal_warboots", properties -> new TribalArmor(properties.humanoidArmor(HGArmorMaterial.TRIBAL, ArmorType.BOOTS).fireResistant()));

  // Thief
  public static Pair<Holder<Item>, ResourceKey<Item>> THIEF_HOOD = registerItem("thief_hood", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.HELMET).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> THIEF_TUNIC = registerItem("thief_tunic", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.CHESTPLATE).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> THIEF_TROUSERS = registerItem("thief_trousers", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.LEGGINGS).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> THIEF_TURNSHOES = registerItem("thief_turnshoes", properties -> new ThiefArmor(properties.humanoidArmor(HGArmorMaterial.THIEF, ArmorType.BOOTS).fireResistant()));

  // Sage
  public static Pair<Holder<Item>, ResourceKey<Item>> SAGE_HOOD = registerItem("sage_hood", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.HELMET).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SAGE_ROBE = registerItem("sage_robe", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.CHESTPLATE).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SAGE_PANTS = registerItem("sage_pants", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.LEGGINGS).fireResistant()));
  public static Pair<Holder<Item>, ResourceKey<Item>> SAGE_WALKERS = registerItem("sage_walkers", properties -> new SageArmor(properties.humanoidArmor(HGArmorMaterial.SAGE, ArmorType.BOOTS).fireResistant()));

  public static <T extends Item> Pair<Holder<T>, ResourceKey<Item>> registerItem(String name, Function<Item.Properties, T> function) {
    return register(name, function, new Item.Properties());
  }

  public static <T extends Item> Pair<Holder<T>, ResourceKey<Item>> register(String name, Function<Item.Properties, T> function, Item.Properties properties) {
    ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, HexxitGearR.rl(name));
    return Pair.of(Registry.registerForHolder(BuiltInRegistries.ITEM, key, function.apply(properties.setId(key))), key);
  }

  public static void initialize() {
    HexxitGearR.LOGGER.info("Registering Items");
  }
}
