/*
package net.catzgaming.theaddon.scrapped;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class StrangeDecorativeBlock extends Block {
    public static final IntegerProperty DECO_NUM = IntegerProperty.create("deco_num", 0, 4);

    public StrangeDecorativeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(DECO_NUM, 0));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            int currentState = state.getValue(DECO_NUM);
            level.setBlockAndUpdate(pos, state.setValue(DECO_NUM, (currentState + 1) % 5));
            // Modulus Operator: if currentState + 1 = 5 { nuh uh, it actually equals 0}
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DECO_NUM);
    }
}

ah yes, blockstate logic. lovely */