package com.example.necromod.datagen;

import com.example.necromod.Necromod;
import com.example.necromod.worldgen.CustomBiomeModifiers;
import com.example.necromod.worldgen.CustomConfiguredFeatures;
import com.example.necromod.worldgen.CustomPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CustomWorldProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER  = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CustomConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CustomPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, CustomBiomeModifiers::bootstrap);
    public CustomWorldProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries){
        super (output,registries,BUILDER, Set.of(Necromod.MODID));
    }
}
