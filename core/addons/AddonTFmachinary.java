package mod_TFmaterials.core.addons;

import java.util.logging.Level;

import mod_TFmaterials.core.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.AchievementPage;

import cpw.mods.fml.common.Loader;

public class AddonTFmachinary {

    public static Achievement RubyAchieve = null;
    public static Achievement RubyPickAchieve = null;
    public static AchievementPage TFmaterialsPage1 = null;
    public static EntityPlayer entityplayer;

    public static void initWorld() {

        if (Loader.isModLoaded("TFmachinary")) {
            try {
            	RubyAchieve = (Achievement) Class.forName("mod_TFmaterials.Addons.TFmachinary").getField("RubyAchieve").get(null);
                RubyPickAchieve = (Achievement) Class.forName("mod_TFmaterials.Addons.TFmachinary").getField("RubyPickAchieve").get(null);
            	TFmaterialsPage1 = (AchievementPage) Class.forName("mod_TFmaterials.Addons.TFmachinary").getField("TFmaterialsPage1").get(null);
            	
                LogHelper.log(Level.INFO, "Loaded TFmachinary Addon!");
            }
            catch (Exception e) {
                LogHelper.log(Level.SEVERE, "Could not load TFmachinary Addon (Error Code: 1)");
                e.printStackTrace(System.err);
            }
        }
    }

}







