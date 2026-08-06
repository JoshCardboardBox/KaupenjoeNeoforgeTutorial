package net.joshcardboardbox.tutorialmod.item.custom;

import net.joshcardboardbox.tutorialmod.block.ModBlocks;
import net.joshcardboardbox.tutorialmod.tags.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    //right click block = useOn
    //right click = use
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos positionClicked = context.getClickedPos();
        Player player = context.getPlayer();

        //Server, NOT client. Client is mainly for visuals
        if(!level.isClientSide()) {
            boolean foundBlock = false;
            int checkDepth = 64;

            for(int i = 0; i <= positionClicked.getY() + checkDepth; i++)
            {
                BlockState blockState = level.getBlockState(positionClicked.below(i));

                //if magic block, deny your search
                if (blockState.is(ModBlocks.MAGIC_BLOCK))
                {
                    // play sound (server)
                    level.playSound(null, positionClicked, SoundEvents.ALLAY_HURT,
                            SoundSource.MASTER, 1.2f, 0.5F);

                    player.addEffect(new MobEffectInstance(MobEffects.WITHER, 100));

                    break;
                }

                //look for ores
                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    // damage the item
                    context.getItemInHand().hurtAndBreak(1, player, context.getHand());
                    // play sound (server)
                    level.playSound(null, positionClicked, SoundEvents.ANVIL_LAND,
                            SoundSource.MASTER, 1.2f, 0.5F);
                    // spawn particles (server)
                    spawnFoundParticles(level, positionClicked, blockState);

                    break;
                }

            }


            if (!foundBlock) {
                outputNoValuablesFound(player);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void spawnFoundParticles(Level level, BlockPos positionClicked, BlockState blockState) {
        //spawn particles of block we right-clicked
        for (int i = 0; i < 20; i++) {
            ServerLevel serverLevel = (ServerLevel) level;
            //note, level.addParticles is local

            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d,
                    1,
                    Math.cos(i * 18) * 0.15d, 0.15d, Math.sin(i*18)*0.15d, 0.1);

        }

    }

    private boolean isValuableBlock(BlockState blockState)
    {
        /*return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE)
                || blockState.is(Blocks.GOLD_ORE) || blockState.is(Blocks.DEEPSLATE_GOLD_ORE)
                || blockState.is(Blocks.COPPER_ORE) || blockState.is(Blocks.DEEPSLATE_COPPER_ORE)
                || blockState.is(Blocks.ANCIENT_DEBRIS)
                ; */
        return blockState.is(ModTags.Blocks.METAL_DETECTABLES);
    }

    private void outputNoValuablesFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.tutorialmod.metal_detector.no_valuables"));;
    }

    private void outputValuableCoordinates(BlockPos position, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Metallic Ore ")
                .append(block.getName())
                .append(Component.literal(" at Y:("+position.getY()+")")));
    }


    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        //this is client side
        if(Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.tutorialmod.metal_detector.shift_down"));
        } else {
            builder.accept(Component.translatable("tooltip.tutorialmod.metal_detector"));
        }

        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
