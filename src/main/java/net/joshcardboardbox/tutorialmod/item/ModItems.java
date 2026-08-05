package net.joshcardboardbox.tutorialmod.item;

import net.joshcardboardbox.tutorialmod.TutorialMod;
import net.joshcardboardbox.tutorialmod.item.food.ModFoods;
import net.joshcardboardbox.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

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
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE))
            {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.tutorialmod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            }
    );

    //fuels
    public static final DeferredItem<Item> END_FIRE_STARTER = ITEMS.registerItem("end_fire_starter",
            properties -> new Item(properties.stacksTo(32))); //Item::new if no properties

            //note, unfortunately this needs an actual texture, else error w/ data gen
    public static final DeferredItem<Item> TEXTURELESS_SWORD = ITEMS.registerItem("textureless_sword",
            properties -> new Item(properties.axe(ToolMaterial.WOOD, 4.758f, -2.3f)
                    .rarity(Rarity.EPIC))
            {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.literal("I'm not translæeting this."));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            }
            );


    //complex items
    public static final DeferredItem<Item> METAL_DETECTOR =
            ITEMS.registerItem("metal_detector",
                    properties -> new MetalDetectorItem(properties.durability(64)));

    /* END OF CUSTOM ITEMS */
}
