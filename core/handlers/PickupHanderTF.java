package mod_TFmaterials.core.handlers;

import mod_TFmaterials.mod_TFmaterials;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;
import mod_TFmaterials.mod_TFmaterials;

public class PickupHanderTF implements IPickupNotifier {
	
public void notifyPickup(EntityItem item, EntityPlayer player) {
	if (item.getEntityItem().itemID == mod_TFmaterials.RubyGem.itemID)
        //player.triggerAchievement(mod_TFmaterials.RubyAchieve);
		player.triggerAchievement(mod_TFmaterials.RubyAchieve);
}
}