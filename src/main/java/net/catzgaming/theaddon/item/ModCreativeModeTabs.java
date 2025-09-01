package net.catzgaming.theaddon.item;

import net.catzgaming.theaddon.TheAddon;
import net.catzgaming.theaddon.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheAddon.MODID);

    public static final Supplier<CreativeModeTab> THEADD_ITIONS = CREATIVE_MODE_TAB.register("theadd_itions",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STRANGEINGOT.get()))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(TheAddon.MODID, "Insert previous creative tab registry name here"))
                    .title(Component.translatable("creativetab.theaddonlol.theadd_itions"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STRANGEINGOT);
                        output.accept(ModItems.STRANGECLUMP);
                        output.accept(ModItems.STRANGED_APPLE);
                        output.accept(ModBlocks.STRANGE_BLOCK);
                        output.accept(ModBlocks.STRANGE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_STRANGE_ORE);
                        output.accept(ModItems.STRANGE_COAL);
                        output.accept(ModItems.OREIFIERWAND);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
