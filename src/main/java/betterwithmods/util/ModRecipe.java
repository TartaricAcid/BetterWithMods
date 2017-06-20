package betterwithmods.util;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

/**
 * Created by primetoxinz on 6/20/17.
 */
public abstract class ModRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    public ModRecipe(ResourceLocation res) {
        RecipeUtils.addRecipe(res, this);
    }

}