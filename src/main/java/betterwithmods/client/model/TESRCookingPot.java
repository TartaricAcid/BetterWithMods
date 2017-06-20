package betterwithmods.client.model;

import betterwithmods.BWMod;
import betterwithmods.client.model.render.RenderUtils;
import betterwithmods.common.blocks.tile.TileEntityCauldron;
import betterwithmods.common.blocks.tile.TileEntityCookingPot;
import betterwithmods.common.blocks.tile.TileEntityCrucible;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 3/20/17
 */
public class TESRCookingPot extends TileEntitySpecialRenderer<TileEntityCookingPot> {
    private int occupiedStacks;

    @Override
    public void renderTileEntityFast(TileEntityCookingPot tile, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {
        if (tile != null) {
            if (occupiedStacks != tile.filledSlots())
                occupiedStacks = tile.filledSlots();
            if (occupiedStacks != 0) {
                float fillOffset = 0.75F * occupationMod(tile);
                RenderUtils.renderFill(getResource(tile), tile.getPos(), x, y, z, 0.123D, 0.125D, 0.123D, 0.877D, 0.248D + fillOffset, 0.877D);
            }
        }
    }

    private ResourceLocation getResource(TileEntityCookingPot tile) {
        if (tile instanceof TileEntityCauldron) {
            return new ResourceLocation(BWMod.MODID, "blocks/cauldron_contents");
        } else if (tile instanceof TileEntityCrucible) {
            return new ResourceLocation("minecraft", "blocks/gravel");
        }
        return null;
    }

    private float occupationMod(TileEntityCookingPot tile) {
        float visibleSlots = (float) tile.getMaxVisibleSlots();
        return (float) occupiedStacks / visibleSlots;
    }

}
