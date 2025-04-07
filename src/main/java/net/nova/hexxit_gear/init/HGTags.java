package net.nova.hexxit_gear.init;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nova.hexxit_gear.HexxitGearR;

public class HGTags {
    public interface ItemTag {
        TagKey<Item> REPAIRS_SCALE_ARMOR = itemTag("repairs_scale_armor");
        TagKey<Item> REPAIRS_TRIBAL_ARMOR = itemTag("repairs_tribal_armor");
        TagKey<Item> REPAIRS_THIEF_ARMOR = itemTag("repairs_thief_armor");
        TagKey<Item> REPAIRS_SAGE_ARMOR = itemTag("repairs_sage_armor");
    }

    // Registers
    public static TagKey<Item> itemTag(String name) {
        return ItemTags.create(HexxitGearR.rl(name));
    }
}
