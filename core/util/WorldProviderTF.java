package mod_TFmaterials.core.util;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderTF extends WorldProvider
{	
public void registerWorldChunkManager()
{
this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.8F, 0.1F);
this.dimensionId = mod_TFmaterials.mod_TFmaterials.dimension;
}

public String getDimensionName()
{
return "The Realm";
}

public boolean canRespawnHere()
{
return true;
}

public String getSaveFolder()
{
return "TheRealm";
}
}