package mod_TFmaterials.core.util.method;

import net.minecraft.util.ChunkCoordinates;

public class PortalPositionTF extends ChunkCoordinates
{
public long field_85087_d;
final TeleporterTF field_85088_e;
public PortalPositionTF(TeleporterTF TeleporterTF, int par2, int par3, int par4, long par5)
{
super(par2, par3, par4);
this.field_85088_e = TeleporterTF;
this.field_85087_d = par5;
}
}