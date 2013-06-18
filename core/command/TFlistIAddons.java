package mod_TFmaterials.core.command;

import java.util.logging.Level;

import cpw.mods.fml.common.Loader;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import mod_TFmaterials.core.lib.*;
import mod_TFmaterials.core.util.LogHelper;

public class TFlistIAddons extends CommandBase{

@Override
public String getCommandName()
{
	return "TFlAddons"; //Name of the command e.g "/Test", "/Command"
}

@Override
public void processCommand(ICommandSender icommandsender, String[] astring)
{
        
        if (Loader.isModLoaded("TFmachinary")) {
            try {
                if(icommandsender instanceof EntityPlayer)
                {
                        EntityPlayer player = (EntityPlayer)icommandsender;

                        player.addChatMessage("Installed Addons: None"); //Just send a simple message to player
                }
            }
            catch (Exception e) {
                EntityPlayer player = (EntityPlayer)icommandsender;
                player.addChatMessage("There are no Addons installed."); //Just send a simple message to player
            }
        }

}

}