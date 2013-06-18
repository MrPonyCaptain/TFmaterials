package mod_TFmaterials;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;

public class TabTFmaterials extends CreativeTabs
{
	private String tabName;

	TabTFmaterials(int par1, String par2Str)
    {
        super(par1, par2Str);
        this.tabName = par2Str;
    }

	@SideOnly(Side.CLIENT)

	public String getTranslatedTabLabel(){
		return this.tabName;
    }
}
