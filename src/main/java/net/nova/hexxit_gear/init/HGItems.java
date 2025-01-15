package net.nova.hexxit_gear.init;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nova.hexxit_gear.client.model.SageHoodModel;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.client.model.ThiefHoodModel;
import net.nova.hexxit_gear.client.model.TribalSkullModel;
import net.nova.hexxit_gear.item.SageArmor;
import net.nova.hexxit_gear.item.ScaleArmor;
import net.nova.hexxit_gear.item.ThiefArmor;
import net.nova.hexxit_gear.item.TribalArmor;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Hexbiscus
    public static DeferredItem<Item> HEXICAL_PETAL = ITEMS.register("hexical_petal", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> HEXICAL_ESSENCE = ITEMS.register("hexical_essence", () -> new Item(new Item.Properties()));
    public static DeferredItem<Item> HEXICAL_DIAMOND = ITEMS.register("hexical_diamond", () -> new Item(new Item.Properties()));

    // Scale
    public static DeferredItem<Item> SCALE_HELMET = ITEMS.register("scale_helmet", () -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29)).fireResistant()) {
        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ScaleHelmetModel.TEXTURE;
        }
    });
    public static DeferredItem<Item> SCALE_CHESTGUARD = ITEMS.register("scale_chestguard", () -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> SCALE_LEGGINGS = ITEMS.register("scale_leggings", () -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> SCALE_BOOTS = ITEMS.register("scale_boots", () -> new ScaleArmor(HGArmorMaterial.SCALE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29)).fireResistant()));

    // Tribal
    public static DeferredItem<Item> TRIBAL_SKULL = ITEMS.register("tribal_skull", () -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29)).fireResistant()) {
        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return TribalSkullModel.TEXTURE;
        }

        @Override
        public Holder<SoundEvent> getEquipSound() {
            return BuiltInRegistries.SOUND_EVENT.getHolder(SoundEvents.BONE_BLOCK_PLACE.getLocation()).orElseThrow();
        }
    });
    public static DeferredItem<Item> TRIBAL_TUNIC = ITEMS.register("tribal_tunic", () -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> TRIBAL_LEGGINGS = ITEMS.register("tribal_leggings", () -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> TRIBAL_WARBOOTS = ITEMS.register("tribal_warboots", () -> new TribalArmor(HGArmorMaterial.TRIBAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29)).fireResistant()));

    // Thief
    public static DeferredItem<Item> THIEF_HOOD = ITEMS.register("thief_hood", () -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29)).fireResistant()) {
        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return ThiefHoodModel.TEXTURE;
        }
    });
    public static DeferredItem<Item> THIEF_TUNIC = ITEMS.register("thief_tunic", () -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> THIEF_TROUSERS = ITEMS.register("thief_trousers", () -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> THIEF_TURNSHOES = ITEMS.register("thief_turnshoes", () -> new ThiefArmor(HGArmorMaterial.THIEF, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29)).fireResistant()));

    // Sage
    public static DeferredItem<Item> SAGE_HOOD = ITEMS.register("sage_hood", () -> new SageArmor(HGArmorMaterial.SAGE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(29)).fireResistant()) {
        @Override
        public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
            return SageHoodModel.TEXTURE;
        }
    });
    public static DeferredItem<Item> SAGE_ROBE = ITEMS.register("sage_robe", () -> new SageArmor(HGArmorMaterial.SAGE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> SAGE_PANTS = ITEMS.register("sage_pants", () -> new SageArmor(HGArmorMaterial.SAGE, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(29)).fireResistant()));
    public static DeferredItem<Item> SAGE_WALKERS = ITEMS.register("sage_walkers", () -> new SageArmor(HGArmorMaterial.SAGE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(29)).fireResistant()));
}
