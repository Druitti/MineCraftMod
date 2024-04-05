package com.example.necromod.blocks;

import com.example.necromod.item.CustomItems;
import com.example.necromod.Necromod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CustomBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the "necromod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Necromod.MODID);

    public static final RegistryObject<Block> ETHERIUM_ORE = registerBlock("etherium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,7),
                    BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ETHERIUM_ORE = registerBlock("deepslate_etherium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,7),
                    BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ETHERIUM_BLOCK = registerBlock("etherium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2f).requiresCorrectToolForDrops()));

     //Register block and the itemBlock
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    //Register itemBlock called on registerBlock
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
    return CustomItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));

    }

    // Register the Deferred Register to the mod event bus so blocks get registered
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
