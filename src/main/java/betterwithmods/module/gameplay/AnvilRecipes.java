package betterwithmods.module.gameplay;

import betterwithmods.common.BWMBlocks;
import betterwithmods.common.BWMItems;
import betterwithmods.common.blocks.mini.BlockMini;
import betterwithmods.common.items.ItemMaterial;
import betterwithmods.module.Feature;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by tyler on 5/16/17.
 */
public class AnvilRecipes extends Feature {
    public AnvilRecipes() {
        canDisable = false;
    }

    public static void addSteelShapedRecipe(ItemStack output, Object... input) {
//        SteelCraftingManager.getInstance().addRecipe(output, input);
    }

    public static void addSteelShapedOreRecipe(ItemStack output, Object... input) {
//        return SteelCraftingManager.getInstance().addSteelShapedOreRecipe(output, input);
    }

    public static void addSteelShapelessRecipe(ItemStack output, Object... input) {
//        SteelCraftingManager.getInstance().addShapelessRecipe(output, input);
    }

    public static void addShapelessOreRecipe(ItemStack output, Object... input) {
//        SteelCraftingManager.getInstance().addShapelessOreRecipe(output, input);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.BLOCK_DISPENSER), "MMMM", "MUUM", "STTS", "SRRS", 'M', Blocks.MOSSY_COBBLESTONE, 'U', new ItemStack(BWMBlocks.URN, 1, 8), 'S', "stone", 'R', "dustRedstone", 'T', Blocks.REDSTONE_TORCH);
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.BUDDY_BLOCK), "SSLS", "LTTS", "STTL", "SLSS", 'S', "stone", 'T', Blocks.REDSTONE_TORCH, 'L', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.POLISHED_LAPIS));
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.DETECTOR), "CCCC", "LTTL", "SRRS", "SRRS", 'C', "cobblestone", 'L', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.POLISHED_LAPIS), 'T', Blocks.REDSTONE_TORCH, 'S', "stone", 'R', "dustRedstone");
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_HELMET), "SSSS", "S  S", "S  S", " PP ", 'P', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.ARMOR_PLATE), 'S', "ingotSoulforgedSteel");
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_CHEST), "P  P", "SSSS", "SSSS", "SSSS", 'P', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.ARMOR_PLATE), 'S', "ingotSoulforgedSteel");
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_PANTS), "SSSS", "PSSP", "P  P", "P  P", 'P', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.ARMOR_PLATE), 'S', "ingotSoulforgedSteel");
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_BOOTS), " SS ", " SS ", "SPPS", 'P', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.ARMOR_PLATE), 'S', "ingotSoulforgedSteel");
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.POLISHED_LAPIS, 2), "LLL", "LLL", "GGG", " R ", 'L', "gemLapis", 'R', "dustRedstone", 'G', "nuggetGold");
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_AXE), "XX", "XH", " H", " H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_HOE), "XX", " H", " H", " H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_PICKAXE), "XXX", " H ", " H ", " H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_SHOVEL), "X", "H", "H", "H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_SWORD), "X", "X", "X", "H", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_BATTLEAXE), "XXX", "XHX", " H ", " H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(new ItemStack(BWMItems.STEEL_MATTOCK), " XXX", "X H ", "  H ", "  H ", 'X', "ingotSoulforgedSteel", 'H', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.HAFT));
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.ARMOR_PLATE), "BSPB", 'B', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.LEATHER_STRAP), 'S', "ingotSoulforgedSteel", 'P', ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.PADDING));
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.BROADHEAD, 6), " N ", " N ", "NNN", " N ", 'N', "nuggetSoulforgedSteel");
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.AESTHETIC, 1, 2), "XXXX", "XXXX", "XXXX", "XXXX", 'X', "ingotSoulforgedSteel");
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.AESTHETIC, 6, 0), "X  X", "XXXX", 'X', "stone");
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.CHAIN_MAIL, 2), "N N ", " N N", "N N ", " N N", 'N', "nuggetIron");
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.STEEL_GEAR)," NN ","NIIN","NIIN"," NN ",'N',"nuggetSoulforgedSteel",'I',"ingotSoulforgedSteel");
        addSteelShapedOreRecipe(ItemMaterial.getMaterial(ItemMaterial.EnumMaterial.STEEL_SPRING),"NNN","NNN","NNN","NNN",'N',"nuggetSoulforgedSteel");
        for (BlockMini.EnumType type : BlockMini.EnumType.values()) {
            addSteelShapedRecipe(new ItemStack(BWMBlocks.STONE_SIDING, 8, type.getMetadata()), "XXXX", 'X', type.getBlock());
            addSteelShapedRecipe(new ItemStack(BWMBlocks.STONE_MOULDING, 8, type.getMetadata()), "XXXX", 'X', new ItemStack(BWMBlocks.STONE_SIDING, 1, type.getMetadata()));
            addSteelShapedRecipe(new ItemStack(BWMBlocks.STONE_CORNER, 8, type.getMetadata()), "XXXX", 'X', new ItemStack(BWMBlocks.STONE_MOULDING, 1, type.getMetadata()));
        }
        addSteelShapedOreRecipe(new ItemStack(BWMBlocks.IRON_WALL, 8, 0), "XXXX", "XXXX", "XXXX", "XXXX", 'X', new ItemStack(Blocks.IRON_BARS));
    }
}
