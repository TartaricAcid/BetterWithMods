package betterwithmods.blocks.tile;

import betterwithmods.BWMItems;
import betterwithmods.craft.bulk.CraftingManagerBulk;
import betterwithmods.craft.bulk.CraftingManagerCauldron;
import betterwithmods.craft.bulk.CraftingManagerCauldronStoked;
import betterwithmods.items.ItemMaterial;
import betterwithmods.util.InvUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import static betterwithmods.items.ItemMaterial.EnumMaterial;

public class TileEntityCauldron extends TileEntityCookingPot {
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        if (tag.hasKey("CauldronCookTime"))
            this.cookCounter = tag.getInteger("CauldronCookTime");
        if (tag.hasKey("RenderCooldown"))
            this.stokedCooldownCounter = tag.getInteger("RenderCooldown");
        if (tag.hasKey("ContainsValidIngredients"))
            this.containsValidIngredients = tag.getBoolean("ContainsValidIngredients");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        NBTTagCompound t = super.writeToNBT(tag);
        t.setInteger("CauldronCookTime", this.cookCounter);
        t.setInteger("RenderCooldown", this.stokedCooldownCounter);
        t.setBoolean("ContainsValidIngredients", this.containsValidIngredients);
        return t;
    }

    @Override
    public void validateContents() {
        this.containsValidIngredients = false;

        if (this.fireIntensity > 0 && this.fireIntensity < 5) {
            if (InvUtils.getFirstOccupiedStackOfItem(inventory, ItemMaterial.getMaterial(EnumMaterial.DUNG)) > -1 && hasNonFoulFood()) {
                this.containsValidIngredients = true;
            } else if (CraftingManagerCauldron.getInstance().getCraftingResult(inventory) != null)
                this.containsValidIngredients = true;
        } else if (this.fireIntensity > 5) {
            if (containsExplosives())
                this.containsValidIngredients = true;
            else if (CraftingManagerCauldronStoked.getInstance().getCraftingResult(inventory) != null)
                this.containsValidIngredients = true;
        }
    }

    @Override
    protected CraftingManagerBulk getCraftingManager(boolean stoked) {
        if (stoked)
            return CraftingManagerCauldronStoked.getInstance();
        else
            return CraftingManagerCauldron.getInstance();
    }

    @Override
    protected boolean attemptToCookNormal() {
        int dung = InvUtils.getFirstOccupiedStackOfItem(inventory, ItemMaterial.getMaterial(EnumMaterial.DUNG));
        if (dung > -1 && this.hasNonFoulFood()) {
            return spoilFood();
        } else
            return super.attemptToCookNormal();
    }

    private boolean hasNonFoulFood() {
        for (int i = 0; i < 27; i++) {
            if (this.inventory.getStackInSlot(i) != null) {
                Item item = this.inventory.getStackInSlot(i).getItem();
                if (item != null) {
                    if (item instanceof ItemFood) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean spoilFood() {
        boolean foodSpoiled = false;
        for (int i = 0; i < 27; i++) {
            if (this.inventory.getStackInSlot(i) != null) {
                Item item = this.inventory.getStackInSlot(i).getItem();
                if (item != null) {
                    if (item != BWMItems.FERTILIZER && item instanceof ItemFood) {
                        int stackSize = this.inventory.getStackInSlot(i).stackSize;
                        ItemStack spoiled = new ItemStack(BWMItems.FERTILIZER, stackSize);
                        this.inventory.setStackInSlot(i, spoiled);
                        foodSpoiled = true;
                    }
                }
            }
        }
        return foodSpoiled;
    }


    @Override
    public String getName() {
        return "inv.cauldron.name";
    }

}
