package net.nova.hexxit_gear.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static net.nova.hexxit_gear.HexxitGearR.MODID;

public enum HGArmorMaterials implements ArmorMaterial {
    SCALE("scale", 29, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.15F, () -> Ingredient.of(HGItems.HEXICAL_DIAMOND.get())),
    TRIBAL("tribal", 29, new int[]{3, 8, 6, 2}, 18,
            SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(HGItems.HEXICAL_DIAMOND.get())),
    THIEF("thief", 29, new int[]{2, 7, 6, 2}, 20,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> Ingredient.of(HGItems.HEXICAL_DIAMOND.get())),
    SAGE("sage", 29, new int[]{2, 7, 6, 2}, 22,
            SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> Ingredient.of(HGItems.HEXICAL_DIAMOND.get()))
    ;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    HGArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
