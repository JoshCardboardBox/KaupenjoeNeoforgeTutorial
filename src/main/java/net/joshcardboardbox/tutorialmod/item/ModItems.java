package net.joshcardboardbox.tutorialmod.item;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    /* CUSTOM ITEMS */
    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");
    /* END OF CUSTOM ITEMS */

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
