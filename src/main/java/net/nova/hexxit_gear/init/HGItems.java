package net.nova.hexxit_gear.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nova.hexxit_gear.client.model.SageHoodModel;
import net.nova.hexxit_gear.client.model.ScaleHelmetModel;
import net.nova.hexxit_gear.client.model.ThiefHoodModel;
import net.nova.hexxit_gear.client.model.TribalSkullModel;
import net.nova.hexxit_gear.client.renderer.ISTERProvider;
import net.nova.hexxit_gear.item.SageArmor;
import net.nova.hexxit_gear.item.ScaleArmor;
import net.nova.hexxit_gear.item.ThiefArmor;
import net.nova.hexxit_gear.item.TribalArmor;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public class HGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Hexbiscus
    public static RegistryObject<Item> HEXICAL_PETAL = ITEMS.register("hexical_petal", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> HEXICAL_ESSENCE = ITEMS.register("hexical_essence", () -> new Item(new Item.Properties()));
    public static RegistryObject<Item> HEXICAL_DIAMOND = ITEMS.register("hexical_diamond", () -> new Item(new Item.Properties()));

    // Scale
    public static RegistryObject<Item> SCALE_HELMET = ITEMS.register("scale_helmet", () -> new ScaleArmor(HGArmorMaterials.SCALE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()) {
        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return ScaleHelmetModel.TEXTURE;
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(ISTERProvider.scaleHelmet());
        }
    });
    public static RegistryObject<Item> SCALE_CHESTGUARD = ITEMS.register("scale_chestguard", () -> new ScaleArmor(HGArmorMaterials.SCALE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> SCALE_LEGGINGS = ITEMS.register("scale_leggings", () -> new ScaleArmor(HGArmorMaterials.SCALE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> SCALE_BOOTS = ITEMS.register("scale_boots", () -> new ScaleArmor(HGArmorMaterials.SCALE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // Tribal
    public static RegistryObject<Item> TRIBAL_SKULL = ITEMS.register("tribal_skull", () -> new TribalArmor(HGArmorMaterials.TRIBAL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()) {
        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return TribalSkullModel.TEXTURE;
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(ISTERProvider.tribalSkull());
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.BONE_BLOCK_PLACE;
        }
    });
    public static RegistryObject<Item> TRIBAL_TUNIC = ITEMS.register("tribal_tunic", () -> new TribalArmor(HGArmorMaterials.TRIBAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> TRIBAL_LEGGINGS = ITEMS.register("tribal_leggings", () -> new TribalArmor(HGArmorMaterials.TRIBAL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> TRIBAL_WARBOOTS = ITEMS.register("tribal_warboots", () -> new TribalArmor(HGArmorMaterials.TRIBAL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // Thief
    public static RegistryObject<Item> THIEF_HOOD = ITEMS.register("thief_hood", () -> new ThiefArmor(HGArmorMaterials.THIEF, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()) {
        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return ThiefHoodModel.TEXTURE;
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(ISTERProvider.thiefHood());
        }
    });
    public static RegistryObject<Item> THIEF_TUNIC = ITEMS.register("thief_tunic", () -> new ThiefArmor(HGArmorMaterials.THIEF, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> THIEF_TROUSERS = ITEMS.register("thief_trousers", () -> new ThiefArmor(HGArmorMaterials.THIEF, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> THIEF_TURNSHOES = ITEMS.register("thief_turnshoes", () -> new ThiefArmor(HGArmorMaterials.THIEF, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    // Sage
    public static RegistryObject<Item> SAGE_HOOD = ITEMS.register("sage_hood", () -> new SageArmor(HGArmorMaterials.SAGE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()) {
        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return SageHoodModel.TEXTURE;
        }

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(ISTERProvider.sageHood());
        }
    });
    public static RegistryObject<Item> SAGE_ROBE = ITEMS.register("sage_robe", () -> new SageArmor(HGArmorMaterials.SAGE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> SAGE_PANTS = ITEMS.register("sage_pants", () -> new SageArmor(HGArmorMaterials.SAGE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static RegistryObject<Item> SAGE_WALKERS = ITEMS.register("sage_walkers", () -> new SageArmor(HGArmorMaterials.SAGE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
}
