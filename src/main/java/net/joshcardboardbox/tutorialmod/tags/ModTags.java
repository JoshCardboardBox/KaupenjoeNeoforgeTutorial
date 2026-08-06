package net.joshcardboardbox.tutorialmod.tags;


import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks  {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(TutorialMod.MODID, name));
        }

        /* Custom block tags */
        public static final TagKey<Block> METAL_DETECTABLES = createTag("metal_detectables");
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(TutorialMod.MODID, name));
        }

        /* Custom item tags */
        public static final TagKey<Item> MAGIC_TRANSFORMABLES = createTag("magic_transformables");
    }

}
