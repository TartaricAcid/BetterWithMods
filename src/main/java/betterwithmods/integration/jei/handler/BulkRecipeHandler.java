package betterwithmods.integration.jei.handler;

import betterwithmods.craft.bulk.BulkRecipe;
import betterwithmods.integration.jei.BWMJEIPlugin;
import betterwithmods.integration.jei.wrapper.bulk.CauldronRecipeWrapper;
import betterwithmods.integration.jei.wrapper.bulk.CrucibleRecipeWrapper;
import betterwithmods.integration.jei.wrapper.bulk.MillRecipeWrapper;
import betterwithmods.integration.jei.wrapper.bulk.StokedCauldronRecipeWrapper;
import betterwithmods.integration.jei.wrapper.bulk.StokedCrucibleRecipeWrapper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;
import java.util.List;

public class BulkRecipeHandler implements IRecipeHandler<BulkRecipe> {

    @Nonnull
    @Override
    public Class<BulkRecipe> getRecipeClass() {
        return BulkRecipe.class;
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull BulkRecipe recipe) {
        IJeiHelpers helper = BWMJEIPlugin.helper;
        switch(recipe.getType()) {
            case "mill": return new MillRecipeWrapper(helper, recipe);
            case "cauldron": return new CauldronRecipeWrapper(helper, recipe);
            case "cauldronStoked": return new StokedCauldronRecipeWrapper(helper, recipe);
            case "crucible": return new CrucibleRecipeWrapper(helper, recipe);
            default: return new StokedCrucibleRecipeWrapper(helper, recipe);
        }
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid() {
        return "bwm.bulk";
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull BulkRecipe recipe) {
        String type = recipe.getType();
        if (type.contains("Stoked")) {
            type = type.substring(0, type.lastIndexOf("S")) + ".stoked";
        }
        return "bwm." + type;
    }

    @Override
    public boolean isRecipeValid(@Nonnull BulkRecipe recipe) {
        if (recipe.getOutput() == null)
            return false;
        int inputCount = 0;
        for (Object input : recipe.getInput()) {
            if (input instanceof List) {
                if (((List<?>) input).isEmpty())
                    return false;
            }
            inputCount++;
        }
        return inputCount > 0;
    }
}
