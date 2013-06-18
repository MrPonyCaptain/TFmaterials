package mod_TFmaterials.core.handlers;

import mod_TFmaterials.mod_TFmaterials;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandlerTF implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		int var1 = fuel.itemID;

		if(var1 == mod_TFmaterials.PlutoniumIngot.itemID){
			return 500;
		}else if(var1 == mod_TFmaterials.UraniumIngot.itemID){
			return 100;
		}else{
			return 0;
		}
	}
	
}