package net.joshcardboardbox.tutorialmod.item;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.item.food.ModFoods;
import net.joshcardboardbox.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    /* CUSTOM ITEMS */
    //simple items
    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");

    //foods
    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE)));

    //complex items
    public static final DeferredItem<Item> METAL_DETECTOR =
            ITEMS.registerItem("metal_detector",
                    properties -> new MetalDetectorItem(properties.durability(64)));

    /* END OF CUSTOM ITEMS */
}
