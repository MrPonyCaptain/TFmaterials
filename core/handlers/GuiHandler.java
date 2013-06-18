package mod_TFmaterials.core.handlers;

import mod_TFmaterials.client.gui.GuiCompressor;
import mod_TFmaterials.client.gui.GuiFurnaceTF;
import mod_TFmaterials.client.gui.GuiNuclearLamp;
import mod_TFmaterials.client.gui.container.ContainerCompressor;
import mod_TFmaterials.client.gui.container.ContainerNuclearFurnace;
import mod_TFmaterials.client.gui.container.ContainerNuclearLamp;
import mod_TFmaterials.client.gui.tileentity.TileEntityCompressor;
import mod_TFmaterials.client.gui.tileentity.TileEntityNuclearFurnace;
import mod_TFmaterials.client.gui.tileentity.TileEntityNuclearLamp;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch (ID)
		{
		case 0: return new ContainerNuclearFurnace(player.inventory, (TileEntityNuclearFurnace) tile_entity);
		case 1:	return new ContainerCompressor(player.inventory, (TileEntityCompressor) tile_entity);
		case 2:	return new ContainerNuclearLamp(player.inventory, (TileEntityNuclearLamp) tile_entity);
		
		default: return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch (ID)
		{
		case 0: return new GuiFurnaceTF(player.inventory, (TileEntityNuclearFurnace) tile_entity);
		case 1:	return new GuiCompressor(player.inventory, (TileEntityCompressor) tile_entity);
		case 2:	return new GuiNuclearLamp(player.inventory, (TileEntityNuclearLamp) tile_entity);
		
		default: return null;
		}
	}

}
