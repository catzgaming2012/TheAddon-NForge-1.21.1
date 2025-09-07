package net.catzgaming.theaddon.datagen;

import net.catzgaming.theaddon.TheAddon;
import net.catzgaming.theaddon.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheAddon.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STRANGECLUMP.get());
        basicItem(ModItems.STRANGEINGOT.get());
        basicItem(ModItems.STRANGED_APPLE.get());
        basicItem(ModItems.STRANGE_COAL.get());
        basicItem(ModItems.INCOMPLETE_STRANGECLUMP.get());
        basicItem(ModItems.OREIFIERWAND.get());
    }
}
