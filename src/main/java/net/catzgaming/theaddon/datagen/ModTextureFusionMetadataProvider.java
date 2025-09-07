package net.catzgaming.theaddon.datagen;

import com.supermartijn642.fusion.api.provider.FusionTextureMetadataProvider;
import com.supermartijn642.fusion.api.texture.DefaultTextureTypes;
import com.supermartijn642.fusion.api.texture.data.ConnectingTextureData;
import com.supermartijn642.fusion.api.texture.data.ConnectingTextureLayout;
import com.supermartijn642.fusion.api.texture.data.RandomTextureData;
import net.catzgaming.theaddon.TheAddon;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ModTextureFusionMetadataProvider extends FusionTextureMetadataProvider {
    public ModTextureFusionMetadataProvider(PackOutput output) {
        super(TheAddon.MODID, output);
    }

    @Override
    protected void generate() {
        // Strange Block CTM
        var CTData = ConnectingTextureData.builder() /* just use this var again when you need ctm */
                .layout(ConnectingTextureLayout.FULL)
                .build();
        this.addTextureMetadata(
                ResourceLocation.fromNamespaceAndPath("theaddonlol","block/strange_block"),
                DefaultTextureTypes.CONNECTING,
                CTData
        );
    }
}
