package com.example.necromod.item;

import com.example.necromod.Necromod;
import com.example.necromod.blocks.CustomBlocks;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Necromod.MODID);
    public static final RegistryObject<Item> ETHERIUM = ITEMS.register("etherium",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SHADOW_DAGGER = ITEMS.register("shadow_dagger",
            ()-> new SwordItem(new ForgeTier(10,3500,20.0F,8.0F,
                    100, TagKey.create(CustomBlocks.BLOCKS.getRegistryKey(),ETHERIUM.getId()),
                    () -> {return Ingredient.of(new ItemLike[]{ETHERIUM.get()});}),
            10,5f,new Item.Properties().stacksTo(1)));

    // Register the Deferred Register to the mod event bus so items get registered
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
