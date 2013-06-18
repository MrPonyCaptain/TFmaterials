package mod_TFmaterials.core.util;

import java.util.Random;

import mod_TFmaterials.mod_TFmaterials;
import mod_TFmaterials.Blocks.BlockAmethystOre;
import mod_TFmaterials.Blocks.BlockAquamarineOre;
import mod_TFmaterials.Blocks.BlockBronzeOre;
import mod_TFmaterials.Blocks.BlockChrystalOre;
import mod_TFmaterials.Blocks.BlockCopperOre;
import mod_TFmaterials.Blocks.BlockItadtalOre;
import mod_TFmaterials.Blocks.BlockPlatinumOre;
import mod_TFmaterials.Blocks.BlockPlutoniumOre;
import mod_TFmaterials.Blocks.BlockRubyOre;
import mod_TFmaterials.Blocks.BlockSapphireOre;
import mod_TFmaterials.Blocks.BlockSilverOre;
import mod_TFmaterials.Blocks.BlockSteelOre;
import mod_TFmaterials.Blocks.BlockTinOre;
import mod_TFmaterials.Blocks.BlockUraniumOre;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorTF implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        
		switch(world.provider.dimensionId){
            case 1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case -1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16); 
            case 568:
                generateTheRealm(world, random, chunkX * 16, chunkZ * 16);
                break;
		}
		
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
	
	private void generateTheRealm(World world, Random rand, int chunkX, int chunkZ)
	{
		for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(256);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.ChrystalOre.blockID, 11)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }	
	   
	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(40)+25;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.RubyOre.blockID, 8)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }

	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(30)+15;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.SapphireOre.blockID, 9)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }

	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(256);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.CopperOre.blockID, 10)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	 	   
	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(1)+30;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.UraniumOre.blockID, 5)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }

	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(256);
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.TinOre.blockID, 9)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	 	   
	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(100)+57;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.SilverOre.blockID, 8)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	 	   
	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(1)+40;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.PlatinumOre.blockID, 7)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	 	   
	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(1)+20;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.PlutoniumOre.blockID, 4)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	 	   
	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(100)+20;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.AquamarineOre.blockID, 11)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }

	 	   for(int k = 0; k < 10; k++){
        	int firstBlockXCoord = chunkX + rand.nextInt(16);
        	int firstBlockYCoord = rand.nextInt(100)+10;
        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
        	(new WorldGenMinable(mod_TFmaterials.AmethystOre.blockID, 10)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	   }
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) 
	{
		   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(256);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.ChrystalOre.blockID, 11)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }	
		   
		   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(40)+25;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.RubyOre.blockID, 8)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }

		   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(30)+15;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.SapphireOre.blockID, 9)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }

		   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(256);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.CopperOre.blockID, 10)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
 	 	   
 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(1)+30;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.UraniumOre.blockID, 5)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }

 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(256);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.TinOre.blockID, 9)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
 	 	   
 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(100)+57;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.SilverOre.blockID, 8)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
 	 	   
 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(1)+40;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.PlatinumOre.blockID, 7)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
 	 	   
 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(1)+20;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.PlutoniumOre.blockID, 4)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
 	 	   
 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(100)+20;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.AquamarineOre.blockID, 11)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }

 	 	   for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(100)+10;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.AmethystOre.blockID, 10)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
	}

	/*private void generateNether(World world, Random rand, int chunkX, int chunkZ) 
	{
 	 	   for(int k = 0; k < 20; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(40)+25;
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.ItadtalOre.blockID, 1, 12)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
	}*/
	
	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
	 	   for(int j = 1; j < 11; j++){
	        	int firstBlockXCoord = chunkX + random.nextInt(16);
	        	int firstBlockYCoord = random.nextInt(256);
	        	int firstBlockZCoord = chunkZ + random.nextInt(16);
	        	(new WorldGenMinable(mod_TFmaterials.ItadtalOre.blockID, 12)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		   }
	}
}