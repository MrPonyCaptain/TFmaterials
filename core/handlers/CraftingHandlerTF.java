package mod_TFmaterials.core.handlers;

import mod_TFmaterials.mod_TFmaterials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandlerTF implements ICraftingHandler 
{
        //This is how you check if a player has crafted something that returns the block/item you want them to gain an achievement for
        @Override
        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
        {
                if (item.itemID == mod_TFmaterials.RubyPickaxe.itemID)
                {
                	//player.addStat(mod_TFmaterials.RubyPickAchieve, 1);
                	player.addStat(mod_TFmaterials.RubyPickAchieve, 1);
                }
        }

        
        //This is how you check if a player has smelted something that returns the block/item you want them to gain an achievement for
        @Override
        public void onSmelting(EntityPlayer player, ItemStack item) 
        {
                
        }
}
