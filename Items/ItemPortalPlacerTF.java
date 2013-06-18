package mod_TFmaterials.Items;

import mod_TFmaterials.EnumToolMaterialTF;
import mod_TFmaterials.mod_TFmaterials;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemPortalPlacerTF extends ItemToolTF
{
    /** an array of the blocks this spade is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
    
public ItemPortalPlacerTF(int par1, EnumToolMaterialTF par2EnumToolMaterialTF)
{
super(par1, 1, par2EnumToolMaterialTF, blocksEffectiveAgainst);
setCreativeTab(CreativeTabs.tabTools);
}
public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int X, int Y, int Z, int par7, float par8, float par9, float par10)
{
if (!par3World.isRemote)
{
int direction = MathHelper.floor_double(par2EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
if ((direction == 1) || (direction == 3))
{
for (int y = 1; y < 5; y++)
{
         for (int z = -1; z < 2; z++)
         {
         if (par3World.getBlockId(X, Y + y, Z + z) != 0)
         {
         par2EntityPlayer.addChatMessage("No room for a portal.");
                 return false;
         }
         }
}
par3World.setBlock(X, Y + 1, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 1, Y + 1, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 2, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 1, Y + 2, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 2, Y + 2, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 1, Y + 2, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 3, Y + 3, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 3, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 3, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 3, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 3, Y + 4, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 4, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 4, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 4, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 3, Y + 5, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 5, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 5, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 5, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 2, Y + 6, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 1, Y + 6, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 7, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 1, Y + 7, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 6, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 1, Y + 6, Z, Block.blockDiamond.blockID);
par3World.setBlock(X, Y + 3, Z, mod_TFmaterials.FireTF.blockID);
}
else
{
for (int y = 1; y < 5; y++)
{
         for (int x = -1; x < 2; x++)
         {
         if (par3World.getBlockId(X + x, Y + y, Z) != 0)
         {
         par2EntityPlayer.addChatMessage("No room for a portal.");
         return false;
         }
         }
}
par3World.setBlock(X, Y + 1, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 1, Y + 1, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 2, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 1, Y + 2, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 2, Y + 2, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 1, Y + 2, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 3, Y + 3, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 3, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 3, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 3, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 3, Y + 4, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 4, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 4, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 4, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 3, Y + 5, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 2, Y + 5, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 2, Y + 5, Z, Block.blockDiamond.blockID);
par3World.setBlock(X - 1, Y + 5, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 2, Y + 6, Z, Block.oreDiamond.blockID);
par3World.setBlock(X - 1, Y + 6, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 7, Z, Block.oreDiamond.blockID);
par3World.setBlock(X + 1, Y + 7, Z, Block.oreDiamond.blockID);
par3World.setBlock(X, Y + 6, Z, Block.blockDiamond.blockID);
par3World.setBlock(X + 1, Y + 6, Z, Block.blockDiamond.blockID);
par3World.setBlock(X, Y + 3, Z, mod_TFmaterials.FireTF.blockID);
}
return true;
}
return true;
}
public void registerIcons(IconRegister iconRegister)
{
	itemIcon = iconRegister.registerIcon("TFmaterials:PortalPlacer");
}
}