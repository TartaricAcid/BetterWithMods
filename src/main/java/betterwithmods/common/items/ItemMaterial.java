package betterwithmods.common.items;

import betterwithmods.api.IMultiLocations;
import betterwithmods.client.BWCreativeTabs;
import betterwithmods.common.BWMItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemMaterial extends Item implements IMultiLocations {
    public ItemMaterial() {
        super();
        this.setCreativeTab(BWCreativeTabs.BWTAB);
        this.setHasSubtypes(true);
    }

    public static ItemStack getMaterial(EnumMaterial material) {
        return getMaterial(material, 1);
    }

    public static ItemStack getMaterial(EnumMaterial material, int count) {
        return new ItemStack(BWMItems.MATERIAL, count, material.getMetadata());
    }

    @Override
    public String[] getLocations() {
        List<String> names = new ArrayList<>();
        for (EnumMaterial material : EnumMaterial.values()) {
            names.add(material.getName());
        }
        return names.toArray(new String[EnumMaterial.values().length]);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumMaterial material : EnumMaterial.values()) {
            if (!material.getName().equalsIgnoreCase("unused"))
                items.add(getMaterial(material));
        }
    }


    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumMaterial.values()[stack.getMetadata()].getName();
    }


    public enum EnumMaterial {
        GEAR,
        NETHERCOAL,
        HEMP,
        HEMP_FIBERS,
        HEMP_CLOTH,
        DUNG,
        TANNED_LEATHER,
        SCOURED_LEATHER,
        LEATHER_STRAP,
        LEATHER_BELT,
        WOOD_BLADE,
        WINDMILL_BLADE,
        GLUE,
        TALLOW,
        INGOT_STEEL,
        GROUND_NETHERRACK,
        HELLFIRE_DUST,
        CONCENTRATED_HELLFIRE,
        COAL_DUST,
        FILAMENT,
        POLISHED_LAPIS,
        POTASH,
        SAWDUST,
        SOUL_DUST,
        SCREW,
        BRIMSTONE,
        NITER,
        ELEMENT,
        FUSE,
        BLASTING_OIL,
        NUGGET_IRON,
        NUGGET_STEEL,
        LEATHER_CUT,
        TANNED_LEATHER_CUT,
        SCOURED_LEATHER_CUT,
        REDSTONE_LATCH,
        NETHER_SLUDGE,
        UNUSED,
        HAFT,
        CHARCOAL_DUST,
        SHARPENING_STONE,
        UNUSED2,
        SOUL_FLUX,
        ENDER_SLAG,
        ENDER_OCULAR,
        PADDING,
        ARMOR_PLATE,
        BROADHEAD,
        COCOA_POWDER,
        DIAMOND_INGOT,
        DIAMOND_NUGGET,
        CHAIN_MAIL,
        STEEL_GEAR,
        STEEL_SPRING,
        SOAP;

        int getMetadata() {
            return this.ordinal();
        }

        String getName() {
            return this.name().toLowerCase();
        }
    }
}
