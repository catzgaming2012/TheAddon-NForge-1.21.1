package net.catzgaming.theaddon.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.catzgaming.theaddon.TheAddon;
import net.catzgaming.theaddon.item.custom.FuelItem;
import net.catzgaming.theaddon.item.custom.OreifyStickItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheAddon.MODID);

    public static final DeferredItem<SequencedAssemblyItem> INCOMPLETE_STRANGECLUMP = ITEMS.register("incomplete_strangeclump",
            () -> new SequencedAssemblyItem(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theaddonlol.sequenced_assembly_item_1"));
                    tooltipComponents.add(Component.translatable("tooltip.theaddonlol.sequenced_assembly_item_2"));
                    tooltipComponents.add(Component.translatable("tooltip.theaddonlol.sequenced_assembly_item_3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
            );
    public static final DeferredItem<Item> STRANGECLUMP = ITEMS.register("strangeclump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRANGEINGOT = ITEMS.register("strangeingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OREIFIERWAND = ITEMS.register("oreify_wand",
            () -> new OreifyStickItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> STRANGED_APPLE = ITEMS.register("stranged_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.STRANGED_APPLE)) {
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.theaddonlol.stranged_apple"));
                    if(Screen.hasShiftDown()) {
                        tooltipComponents.add(Component.translatable("tooltip.theaddonlol.stranged_apple.shift_down"));
                    } else {
                        tooltipComponents.add(Component.translatable("tooltip.theaddonlol.shift_info"));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
            );

    public static final DeferredItem<Item> STRANGE_COAL = ITEMS.register("strange_coal",
            () -> new FuelItem(new Item.Properties(),1000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
