package net.catzgaming.theaddon.item.custom;

import net.catzgaming.theaddon.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class OreifyStickItem extends Item {
    private static final Map<Block, Block> OREIFY_MAP =
            Map.of(
                    ModBlocks.STRANGE_BLOCK.get(), ModBlocks.STRANGE_ORE.get(),
                    Blocks.IRON_BLOCK, Blocks.IRON_ORE,
                    Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE,
                    Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_ORE,
                    Blocks.REDSTONE_ORE, ModBlocks.STRANGE_ORE.get()
            );

    public OreifyStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(OREIFY_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), OREIFY_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
