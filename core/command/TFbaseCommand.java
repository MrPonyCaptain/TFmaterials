package mod_TFmaterials.core.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import mod_TFmaterials.core.lib.*;

public class TFbaseCommand extends CommandBase{

@Override
public String getCommandName()
{
	return "TFi"; //Name of the command e.g "/Test", "/Command"
}

@Override
public void processCommand(ICommandSender icommandsender, String[] astring)
{

        if(icommandsender instanceof EntityPlayer)
        {
                EntityPlayer player = (EntityPlayer)icommandsender;

                player.addChatMessage("Version: " + mod_TFmaterials.core.lib.ModInfo.Version); //Just send a simple message to player
                player.addChatMessage("Outhor: " + mod_TFmaterials.core.lib.ModInfo.Outhor); //Just send a simple message to player
                player.addChatMessage("Minecraft: " + mod_TFmaterials.core.lib.ModInfo.ForMCVersion); //Just send a simple message to player
                player.addChatMessage("Release Date: " + mod_TFmaterials.core.lib.ModInfo.ReleaseDate); //Just send a simple message to player
        }

}

}