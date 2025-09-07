package net.catzgaming.theaddon.datagen;

import com.supermartijn642.fusion.api.model.DefaultModelTypes;
import com.supermartijn642.fusion.api.model.ModelInstance;
import com.supermartijn642.fusion.api.model.data.ConnectingModelDataBuilder;
import com.supermartijn642.fusion.api.predicate.DefaultConnectionPredicates;
import com.supermartijn642.fusion.api.provider.FusionModelProvider;
import net.catzgaming.theaddon.TheAddon;
import net.minecraft.data.PackOutput;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockFusionModelProvider extends FusionModelProvider {
    public ModBlockFusionModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(TheAddon.MODID, output, existingFileHelper);
    }

    @Override
    protected void generate() {
        var modelData = ConnectingModelDataBuilder.builder()
                .parent(ResourceLocation.withDefaultNamespace("block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath("theaddonlol", "block/strange_block"))
                .connection(DefaultConnectionPredicates.isSameBlock())
                .build();
        var modelInstance = ModelInstance.of(DefaultModelTypes.CONNECTING, modelData);
        this.addModel(ResourceLocation.fromNamespaceAndPath("theaddonlol", "block/strange_block"), modelInstance);
    }
}