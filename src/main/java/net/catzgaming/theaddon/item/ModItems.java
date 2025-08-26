package net.catzgaming.theaddon.item;

import net.catzgaming.theaddon.TheAddon;
import net.catzgaming.theaddon.item.custom.OreifyStickItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheAddon.MODID);

    public static final DeferredItem<Item> STRANGECLUMP = ITEMS.register("strangeclump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRANGEINGOT = ITEMS.register("strangeingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OREIFIERWAND = ITEMS.register("oreify_wand",
            () -> new OreifyStickItem(new Item.Properties().durability(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
