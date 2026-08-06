package net.joshcardboardbox.tutorialmod.datagen;

import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.joshcardboardbox.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.MAGIC_TRANSFORMABLES)
                .add(Items.IRON_INGOT)
                .add(ModItems.AZURITE.get())
                .add(Items.REDSTONE)
        ;
    }
}
