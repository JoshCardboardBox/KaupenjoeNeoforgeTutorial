package net.joshcardboardbox.tutorialmod.block.custom;

import net.joshcardboardbox.tutorialmod.item.ModItems;
import net.joshcardboardbox.tutorialmod.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        //spawn particle (called on ONLY client)
        level.addParticle(ParticleTypes.END_ROD, pos.getX()+0.5, pos.getY()+1, pos.getZ() + 0.5, 0, 1, 0);

        //play sound (called on client & server)
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 2f, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        if (entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300));
        }

        if (entity instanceof ItemEntity itemEntity) {
            //only certain items are valid
            if (isValidItem(itemEntity.getItem()))
            {
                //in each item stack, turn x things into x diamonds
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));

                //play sound
                level.playSound(null, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1f, 2f);
            }
        }

        super.stepOn(level, pos, onState, entity);
    }


    /** Check if this is one of the items that can be converted by this block */
    private boolean isValidItem(ItemStack item) {
        //return item.is(Items.REDSTONE) || item.is(ModItems.AZURITE);
        return item.is(ModTags.Items.MAGIC_TRANSFORMABLES);
    }

    /** This literally makes the block disappear lol. */
    /*@Override
    protected boolean skipRendering(BlockState state, BlockState neighborState, Direction direction) {
        return true;
    }*/


}
