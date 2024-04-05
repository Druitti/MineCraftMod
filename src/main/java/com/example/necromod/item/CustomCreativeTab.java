package com.example.necromod.item;

import com.example.necromod.Necromod;
import com.example.necromod.blocks.CustomBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CustomCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Necromod.MODID);

//     Creates a creative tab with the id "necromod:item_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> ITEM_TAB = CREATIVE_MODE_TABS.register("item_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> CustomItems.SHADOW_DAGGER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CustomItems.SHADOW_DAGGER.get());
                output.accept(CustomItems.ETHERIUM.get());
                output.accept(CustomBlocks.ETHERIUM_ORE.get().asItem());
                output.accept(CustomBlocks.ETHERIUM_BLOCK.get().asItem());
                output.accept(CustomBlocks.DEEPSLATE_ETHERIUM_ORE.get().asItem());



                // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
