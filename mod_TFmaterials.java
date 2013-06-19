package mod_TFmaterials;

import mod_TFmaterials.Armor.BronzeArmor;
import mod_TFmaterials.Armor.ChrystalArmor;
import mod_TFmaterials.Armor.CopperArmor;
import mod_TFmaterials.Armor.ItadtalArmor;
import mod_TFmaterials.Armor.PlatinumArmor;
import mod_TFmaterials.Armor.PlutoniumArmor;
import mod_TFmaterials.Armor.RubyArmor;
import mod_TFmaterials.Armor.SapphireArmor;
import mod_TFmaterials.Armor.SilverArmor;
import mod_TFmaterials.Armor.SteelArmor;
import mod_TFmaterials.Armor.TinArmor;
import mod_TFmaterials.Armor.UraniumArmor;
import mod_TFmaterials.Blocks.BlockAmethystOre;
import mod_TFmaterials.Blocks.BlockAquamarineOre;
import mod_TFmaterials.Blocks.BlockChrystalOre;
import mod_TFmaterials.Blocks.BlockCopperOre;
import mod_TFmaterials.Blocks.BlockFireTF;
import mod_TFmaterials.Blocks.BlockItadtalOre;
import mod_TFmaterials.Blocks.BlockPlatinumOre;
import mod_TFmaterials.Blocks.BlockPlutoniumOre;
import mod_TFmaterials.Blocks.BlockRubyOre;
import mod_TFmaterials.Blocks.BlockSapphireOre;
import mod_TFmaterials.Blocks.BlockSilverOre;
import mod_TFmaterials.Blocks.BlockTFportal;
import mod_TFmaterials.Blocks.BlockTinOre;
import mod_TFmaterials.Blocks.BlockUraniumOre;
import mod_TFmaterials.Blocks.Compressor;
import mod_TFmaterials.Blocks.NuclearLamp;
import mod_TFmaterials.Items.ItemAmethystGem;
import mod_TFmaterials.Items.ItemAquamarineGem;
import mod_TFmaterials.Items.ItemAxe;
import mod_TFmaterials.Items.ItemBronzeIngot;
import mod_TFmaterials.Items.ItemChrystalGem;
import mod_TFmaterials.Items.ItemCopperIngot;
import mod_TFmaterials.Items.ItemFlintAndSteelTF;
import mod_TFmaterials.Items.ItemHoe;
import mod_TFmaterials.Items.ItemIronStick;
import mod_TFmaterials.Items.ItemItadtalGem;
import mod_TFmaterials.Items.ItemPickaxe;
import mod_TFmaterials.Items.ItemPlatinumIngot;
import mod_TFmaterials.Items.ItemPlutoniumIngot;
import mod_TFmaterials.Items.ItemPortalPlacerTF;
import mod_TFmaterials.Items.ItemRubyGem;
import mod_TFmaterials.Items.ItemSapphireGem;
import mod_TFmaterials.Items.ItemShovel;
import mod_TFmaterials.Items.ItemSilverIngot;
import mod_TFmaterials.Items.ItemSteelIngot;
import mod_TFmaterials.Items.ItemSteelStick;
import mod_TFmaterials.Items.ItemTinIngot;
import mod_TFmaterials.Items.ItemUraniumIngot;
import mod_TFmaterials.client.gui.tileentity.TileEntityCompressor;
import mod_TFmaterials.client.gui.tileentity.TileEntityNuclearFurnace;
import mod_TFmaterials.client.gui.tileentity.TileEntityNuclearLamp;
import mod_TFmaterials.core.command.TFbaseCommand;
import mod_TFmaterials.core.command.TFlistIAddons;
import mod_TFmaterials.core.handlers.AddonHandler;
import mod_TFmaterials.core.handlers.CraftingHandlerTF;
import mod_TFmaterials.core.handlers.FuelHandlerTF;
import mod_TFmaterials.core.handlers.GuiHandler;
import mod_TFmaterials.core.proxy.CommonProxy;
import mod_TFmaterials.core.util.LogHelper;
import mod_TFmaterials.core.util.WorldGeneratorTF;
import mod_TFmaterials.core.util.WorldProviderTF;
import net.minecraft.block.Block;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mod_TFmaterials.Blocks.*;

@Mod(modid="TFmaterials", name="TFmaterials", version="2.0.1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class mod_TFmaterials{

        // The instance of your mod that Forge uses.
        @Instance("TFmaterials")
        public static mod_TFmaterials instance;
        
        private GuiHandler guihandler = new GuiHandler();
        public static CraftingHandlerTF craftHandlerTF = new CraftingHandlerTF();
        
        public static int dimension = 568;

        public static EnumArmorMaterial enumru = EnumHelper.addArmorMaterial("RUBYARMOR", 30, new int[] {2, 7, 5, 3}, 9);
        public static EnumArmorMaterial enumcopp = EnumHelper.addArmorMaterial("COPPERARMOR", 30, new int[] {2, 7, 5, 3}, 9);
        public static EnumArmorMaterial enumsa = EnumHelper.addArmorMaterial("SAPPHIREARMOR", 30, new int[] {1, 5, 4, 3}, 9);
        public static EnumArmorMaterial enumuran = EnumHelper.addArmorMaterial("URANIUMARMOR", 30, new int[] {2, 6, 6, 2}, 9);
        public static EnumArmorMaterial enumtin = EnumHelper.addArmorMaterial("TINARMOR", 30, new int[] {2, 7, 5, 3}, 9);
        public static EnumArmorMaterial enumsilv = EnumHelper.addArmorMaterial("SILVERARMOR", 30, new int[] {1, 6, 4, 2}, 9);
        public static EnumArmorMaterial enumbronze = EnumHelper.addArmorMaterial("BRONZEARMOR", 30, new int[] {2, 5, 5, 1}, 9);
        public static EnumArmorMaterial enumupla = EnumHelper.addArmorMaterial("PLATINUMMARMOR", 30, new int[] {2, 4, 5, 2}, 9);
        public static EnumArmorMaterial enumplu = EnumHelper.addArmorMaterial("PLUTONIUMARMOR", 30, new int[] {1, 4, 5, 2}, 9);
        public static EnumArmorMaterial enumchrys = EnumHelper.addArmorMaterial("CHRYSTALARMOR", 30, new int[] {3, 6, 4, 4}, 9);
        public static EnumArmorMaterial enumsteel = EnumHelper.addArmorMaterial("STEELARMOR", 30, new int[] {2, 5, 3, 2}, 9);
        public static EnumArmorMaterial enumitadtal = EnumHelper.addArmorMaterial("ITADTALARMOR", 30, new int[] {3, 7, 3, 4}, 9); 
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="mod_TFmaterials.core.proxy.ClientProxy", serverSide="mod_TFmaterials.core.proxy.CommonProxy")
        public static CommonProxy proxy;
       
        public static CreativeTabs tabmod_TFmaterials = new CreativeTabs("TFmaterials") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(ChrystalGem, 1, 0);
            }
        };
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
            LogHelper.init();
        }
        
        @ServerStarting
        public void serverStart(FMLServerStartingEvent event)
        {
        	MinecraftServer server = MinecraftServer.getServer(); //Gets current server
        	ICommandManager command = server.getCommandManager(); //Gets the command manager to use for server
        	ServerCommandManager serverCommand = ((ServerCommandManager) command); //Turns it into another form to use
      	    
        	serverCommand.registerCommand(new TFbaseCommand());
        	serverCommand.registerCommand(new TFlistIAddons());
        } 
        
        @Init
        public void load(FMLInitializationEvent event){
               proxy.registerRenderers();
               
               LanguageRegistry.instance().addStringLocalization("itemGroup.TFmaterials", "en_US", "TFmaterials");
               
               LanguageRegistry.instance().addStringLocalization("achievement.RubyAchieve", "en_US", "Got Ruby Achieve!");
               LanguageRegistry.instance().addStringLocalization("achievement.RubyAchieve.desc", "en_US", "You mined a Ruby Gem!");
               LanguageRegistry.instance().addStringLocalization("achievement.RubyPickAchieve", "en_US", "Got Ruby Miner Achieve!");
               LanguageRegistry.instance().addStringLocalization("achievement.RubyPickAchieve.desc", "en_US", "You are a Ruby Miner!");
               
               this.smeltingRecipes();
        	   this.craftingRecipes();
               
         	   GameRegistry.registerBlock(ChrystalOre);
         	   GameRegistry.registerBlock(RubyOre);
         	   GameRegistry.registerBlock(SapphireOre);
         	   GameRegistry.registerBlock(CopperOre);
         	   GameRegistry.registerBlock(UraniumOre);
         	   GameRegistry.registerBlock(TinOre);
         	   GameRegistry.registerBlock(SilverOre);
         	   GameRegistry.registerBlock(PlatinumOre);
         	   GameRegistry.registerBlock(PlutoniumOre);
         	   GameRegistry.registerBlock(AquamarineOre);
         	   GameRegistry.registerBlock(AmethystOre);
         	   GameRegistry.registerBlock(ItadtalOre);
         	   GameRegistry.registerBlock(NuclearFurnaceIdle);
         	   GameRegistry.registerBlock(NuclearFurnaceBurning);
         	   
         	   //GameRegistry.registerBlock(NuclearLampIdle);
         	   
         	   GameRegistry.registerBlock(CompressorIdle);
         	   GameRegistry.registerBlock(CompressorBurning);
         	   
         	   GameRegistry.registerTileEntity(TileEntityNuclearFurnace.class, "tileentitynuclear");
         	   GameRegistry.registerTileEntity(TileEntityCompressor.class, "tileentitycompressor");
         	   GameRegistry.registerTileEntity(TileEntityNuclearLamp.class, "tileentitynuclearlamp");
         	   GameRegistry.registerFuelHandler(new FuelHandlerTF());
         	   
         	   NetworkRegistry.instance().registerGuiHandler(this, guihandler);
         	   
         	   DimensionManager.registerProviderType(dimension, WorldProviderTF.class, false);
         	   DimensionManager.registerDimension(dimension, dimension);
         	   
         	   GameRegistry.registerCraftingHandler(craftHandlerTF);
         	   GameRegistry.registerWorldGenerator(new WorldGeneratorTF());
         	   
         	   AchievementPage.registerAchievementPage(TFmaterialsPage1);

         	   MinecraftForge.setBlockHarvestLevel(ChrystalOre, "pickaxe", 0);
         	   MinecraftForge.setBlockHarvestLevel(RubyOre, "pickaxe", 0);
         	   MinecraftForge.setBlockHarvestLevel(SapphireOre, "pickaxe", 0);
         	   MinecraftForge.setBlockHarvestLevel(CopperOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(UraniumOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(TinOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(SilverOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(PlutoniumOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(PlutoniumOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(ItadtalOre, "pickaxe", 3);
         	   MinecraftForge.setBlockHarvestLevel(NuclearFurnaceIdle, "pickaxe", 0);
         	   MinecraftForge.setBlockHarvestLevel(NuclearFurnaceBurning, "pickaxe", 0);

         	   LanguageRegistry.addName(TFportal, "TFportal");
         	   LanguageRegistry.addName(SapphireOre, "Sapphire Ore");
         	   LanguageRegistry.addName(SapphireGem, "Sapphire Gem");
         	   LanguageRegistry.addName(ChrystalOre, "Chrystal Ore");
         	   LanguageRegistry.addName(ChrystalGem, "Chrystal Gem");
         	   LanguageRegistry.addName(CopperOre, "Copper Ore");
         	   LanguageRegistry.addName(CopperIngot, "Copper Ingot");
         	   LanguageRegistry.addName(RubyOre, "Ruby Ore");
         	   LanguageRegistry.addName(RubyGem, "Ruby Gem");
         	   LanguageRegistry.addName(RubyHelmet, "Ruby Armor Helmet");
         	   LanguageRegistry.addName(RubyBody, "Ruby Armor Chestplate");
         	   LanguageRegistry.addName(RubyLegs, "Ruby Armor Leggings");
         	   LanguageRegistry.addName(RubyBoots, "Ruby Armor Boots");
         	   LanguageRegistry.addName(SapphireHelmet, "Sapphire Armor Helmet");
         	   LanguageRegistry.addName(SapphireBody, "Sapphire Armor Chestplate");
         	   LanguageRegistry.addName(SapphireLegs, "Sapphire Armor Leggings");
         	   LanguageRegistry.addName(SapphireBoots, "Sapphire Armor Boots");
         	   LanguageRegistry.addName(RubyAxe, "Ruby Axe");
         	   LanguageRegistry.addName(RubySword, "Ruby Sword");
         	   LanguageRegistry.addName(RubyHoe, "Ruby Hoe");
         	   LanguageRegistry.addName(RubyShovel, "Ruby Shovel");
         	   LanguageRegistry.addName(RubyPickaxe, "Ruby Pickaxe");
         	   LanguageRegistry.addName(SapphireAxe, "Sapphire Axe");
         	   LanguageRegistry.addName(SapphireSword, "Sapphire Sword");
         	   LanguageRegistry.addName(SapphireHoe, "Sapphire Hoe");
         	   LanguageRegistry.addName(SapphireShovel, "Sapphire Shovel");
         	   LanguageRegistry.addName(SapphirePickaxe, "Sapphire Pickaxe");
         	   LanguageRegistry.addName(CopperHelmet, "Copper Helmet");
         	   LanguageRegistry.addName(CopperBody, "Copper Body");
         	   LanguageRegistry.addName(CopperLegs, "Copper Leggings");
         	   LanguageRegistry.addName(CopperBoots, "Copper Chestplate");
         	   LanguageRegistry.addName(UraniumOre, "Uranium Ore");
         	   LanguageRegistry.addName(TinOre, "Tin Ore");
         	   LanguageRegistry.addName(SilverOre, "Silver Ore");
         	   //LanguageRegistry.addName(BronzeOre, "Bronze Ore");
         	   LanguageRegistry.addName(PlatinumOre, "Platinum Ore");
         	   //LanguageRegistry.addName(SteelOre, "Steel Ore");
         	   LanguageRegistry.addName(PlutoniumOre, "Plutonium Ore");
         	   LanguageRegistry.addName(UraniumIngot, "Uranium Ingot");
         	   LanguageRegistry.addName(TinIngot, "Tin Ingot");
         	   LanguageRegistry.addName(SilverIngot, "Silver Ingot");
         	   LanguageRegistry.addName(BronzeIngot, "Bronze Ingot");
         	   LanguageRegistry.addName(PlatinumIngot, "Platinum Ingot");
         	   LanguageRegistry.addName(SteelIngot, "Steel Ingot");
         	   LanguageRegistry.addName(PlutoniumIngot, "Plutonium Ingot");
         	   LanguageRegistry.addName(IronStick, "Iron Stick");
         	   LanguageRegistry.addName(SteelStick, "Steel Stick");
         	   //LanguageRegistry.addName(BlockRuby, "Ruby Block");
         	   //LanguageRegistry.addName(BlockCopper, "Copper Block");
         	   LanguageRegistry.addName(UraniumHelmet, "Uranium Armor Helmet");
                LanguageRegistry.addName(UraniumBody, "Uranium Armor Chestplate");
                LanguageRegistry.addName(UraniumLegs, "Uranium Armor Leggings");
                LanguageRegistry.addName(UraniumBoots, "Uranium Armor Boots");
                LanguageRegistry.addName(CopperAxe, "Copper Axe");
         	   LanguageRegistry.addName(CopperSword, "Copper Sword");
         	   LanguageRegistry.addName(CopperHoe, "Copper Hoe");
         	   LanguageRegistry.addName(CopperShovel, "Copper Shovel");
         	   LanguageRegistry.addName(CopperPickaxe, "Copper Pickaxe");
         	   LanguageRegistry.addName(UraniumAxe, "Uranium Axe");
                LanguageRegistry.addName(UraniumSword, "Uranium Sword");
                LanguageRegistry.addName(UraniumHoe, "Uranium Hoe");
                LanguageRegistry.addName(UraniumShovel, "Uranium Shovel");
                LanguageRegistry.addName(UraniumPickaxe, "Uranium Pickaxe");
                LanguageRegistry.addName(TinAxe, "Tin Axe");
                LanguageRegistry.addName(TinSword, "Tin Sword");
                LanguageRegistry.addName(TinHoe, "Tin Hoe");
                LanguageRegistry.addName(TinShovel, "Tin Shovel");
                LanguageRegistry.addName(TinPickaxe, "Tin Pickaxe");
                LanguageRegistry.addName(SilverAxe, "Silver Axe");
                LanguageRegistry.addName(SilverSword, "Silver Sword");
                LanguageRegistry.addName(SilverHoe, "Silver Hoe");
                LanguageRegistry.addName(SilverShovel, "Silver Shovel");
                LanguageRegistry.addName(SilverPickaxe, "Silver Pickaxe");
                LanguageRegistry.addName(BronzeAxe, "Bronze Axe");
                LanguageRegistry.addName(BronzeSword, "Bronze Sword");
                LanguageRegistry.addName(BronzeHoe, "Bronze Hoe");
                LanguageRegistry.addName(BronzeShovel, "Bronze Shovel");
                LanguageRegistry.addName(BronzePickaxe, "Bronze Pickaxe");
                LanguageRegistry.addName(PlatinumAxe, "Platinum Axe");
                LanguageRegistry.addName(PlatinumSword, "Platinum Sword");
                LanguageRegistry.addName(PlatinumHoe, "Platinum Hoe");
                LanguageRegistry.addName(PlatinumShovel, "Platinum Shovel");
                LanguageRegistry.addName(PlatinumPickaxe, "Platinum Pickaxe");
                LanguageRegistry.addName(SteelAxe, "Steel Axe");
                LanguageRegistry.addName(SteelSword, "Steel Sword");
                LanguageRegistry.addName(SteelHoe, "Steel Hoe");
                LanguageRegistry.addName(SteelShovel, "Steel Shovel");
                LanguageRegistry.addName(SteelPickaxe, "Steel Pickaxe");
                LanguageRegistry.addName(PlutoniumAxe, "Plutonium Axe");
                LanguageRegistry.addName(PlutoniumSword, "Plutonium Sword");
                LanguageRegistry.addName(PlutoniumHoe, "Plutonium Hoe");
                LanguageRegistry.addName(PlutoniumShovel, "Plutonium Shovel");
                LanguageRegistry.addName(PlutoniumPickaxe, "Plutonium Pickaxe");
                LanguageRegistry.addName(ChrystalAxe, "Chrystal Axe");
                LanguageRegistry.addName(ChrystalSword, "Chrystal Sword");
                LanguageRegistry.addName(ChrystalHoe, "Chrystal Hoe");
                LanguageRegistry.addName(ChrystalShovel, "Chrystal Shovel");
                LanguageRegistry.addName(ChrystalPickaxe, "Chrystal Pickaxe");
                LanguageRegistry.addName(TinHelmet, "Tin Armor Helmet");
                LanguageRegistry.addName(TinBody, "Tin Armor Chestplate");
                LanguageRegistry.addName(TinLegs, "Tin Armor Leggings");
                LanguageRegistry.addName(TinBoots, "Tin Armor Boots");
                LanguageRegistry.addName(SilverHelmet, "Silver Armor Helmet");
                LanguageRegistry.addName(SilverBody, "Silver Armor Chestplate");
                LanguageRegistry.addName(SilverLegs, "Silver Armor Leggings");
                LanguageRegistry.addName(SilverBoots, "Silver Armor Boots");
                LanguageRegistry.addName(BronzeHelmet, "Bronze Armor Helmet");
                LanguageRegistry.addName(BronzeBody, "Bronze Armor Chestplate");
                LanguageRegistry.addName(BronzeLegs, "Bronze Armor Leggings");
                LanguageRegistry.addName(BronzeBoots, "Bronze Armor Boots");
                LanguageRegistry.addName(PlatinumHelmet, "Platinum Armor Helmet");
                LanguageRegistry.addName(PlatinumBody, "Platinum Armor Chestplate");
                LanguageRegistry.addName(PlatinumLegs, "Platinum Armor Leggings");
                LanguageRegistry.addName(PlatinumBoots, "Platinum Armor Boots");
                LanguageRegistry.addName(PlutoniumHelmet, "Plutonium Armor Helmet");
                LanguageRegistry.addName(PlutoniumBody, "Plutonium Armor Chestplate");
                LanguageRegistry.addName(PlutoniumLegs, "Plutonium Armor Leggings");
                LanguageRegistry.addName(PlutoniumBoots, "Plutonium Armor Boots");
                LanguageRegistry.addName(ChrystalHelmet, "Chrystal Armor Helmet");
                LanguageRegistry.addName(ChrystalBody, "Chrystal Armor Chestplate");
                LanguageRegistry.addName(ChrystalLegs, "Chrystal Armor Leggings");
                LanguageRegistry.addName(ChrystalBoots, "Chrystal Armor Boots");
                LanguageRegistry.addName(SteelHelmet, "Steel Armor Helmet");
                LanguageRegistry.addName(SteelBody, "Steel Armor Chestplate");
                LanguageRegistry.addName(SteelLegs, "Steel Armor Leggings");
                LanguageRegistry.addName(SteelBoots, "Steel Armor Boots");
                
                LanguageRegistry.addName(AquamarineOre, "Aquamarine Ore");
         	    LanguageRegistry.addName(AquamarineGem, "Aquamarine Gem");
         	    LanguageRegistry.addName(AmethystOre, "Amethyst Ore");
         	    LanguageRegistry.addName(AmethystGem, "Amethyst Gem");
         	    LanguageRegistry.addName(AquamarineAxe, "Aquamarine Axe");
                LanguageRegistry.addName(AquamarineSword, "Aquamarine Sword");
                LanguageRegistry.addName(AquamarineHoe, "Aquamarine Hoe");
                LanguageRegistry.addName(AquamarineShovel, "Aquamarine Shovel");
                LanguageRegistry.addName(AquamarinePickaxe, "Aquamarine Pickaxe");
                LanguageRegistry.addName(AmethystAxe, "Amethyst Axe");
                LanguageRegistry.addName(AmethystSword, "Amethyst Sword");
                LanguageRegistry.addName(AmethystHoe, "Amethyst Hoe");
                LanguageRegistry.addName(AmethystShovel, "Amethyst Shovel");
                LanguageRegistry.addName(AmethystPickaxe, "Amethyst Pickaxe");
                
                LanguageRegistry.addName(recordWhatIFound, "What I Found - Disc");
                LanguageRegistry.addName(recordSurrealism, "Surrealism - Disc");
                LanguageRegistry.addName(recordFLchan, "FLchan - Disc");
                LanguageRegistry.addName(recordHangingOn, "Hanging On - Disc");
                
                LanguageRegistry.addName(FlintAndSteelTF, "Magic - Flint And Steel");
                
                LanguageRegistry.addName(NuclearFurnaceIdle, "Nuclear Furnace");
                LanguageRegistry.addName(NuclearFurnaceBurning, "Nuclear Furnace");
                
                LanguageRegistry.addName(ItadtalAxe, "Itadtal Axe");
                LanguageRegistry.addName(ItadtalSword, "Itadtal Sword");
                LanguageRegistry.addName(ItadtalHoe, "Itadtal Hoe");
                LanguageRegistry.addName(ItadtalShovel, "Itadtal Shovel");
                LanguageRegistry.addName(ItadtalPickaxe, "Itadtal Pickaxe");
                
                LanguageRegistry.addName(ItadtalHelmet, "Itadtal Helmet");
                LanguageRegistry.addName(ItadtalBody, "Itadtal Chestplate");
                LanguageRegistry.addName(ItadtalLegs, "Itadtal Leggings");
                LanguageRegistry.addName(ItadtalBoots, "Itadtal Boots");
                
                LanguageRegistry.addName(ItadtalOre, "Itadtal Ore");
                LanguageRegistry.addName(ItadtalGem, "Itadtal Gem");
                
                LanguageRegistry.addName(NuclearLampIdle, "Test Lamp");
                
                LanguageRegistry.addName(CompressorIdle, "Compressor");
                LanguageRegistry.addName(CompressorBurning, "Compressor");
                
                LanguageRegistry.addName(PortalPlacerTF, "Portal Placer - The Realm");
                
         	   MinecraftForge.setToolClass(RubyAxe, "axe", 5);
         	   MinecraftForge.setToolClass(RubySword, "sword", 5);
         	   MinecraftForge.setToolClass(RubyHoe, "hoe", 5);
         	   MinecraftForge.setToolClass(RubyShovel, "shovel", 5);
         	   MinecraftForge.setToolClass(RubyPickaxe, "pickaxe", 5);
         	   MinecraftForge.setToolClass(SapphireAxe, "axe", 5);
         	   MinecraftForge.setToolClass(SapphireSword, "sword", 5);
         	   MinecraftForge.setToolClass(SapphireHoe, "hoe", 5);
         	   MinecraftForge.setToolClass(SapphireShovel, "shovel", 5);
         	   MinecraftForge.setToolClass(SapphirePickaxe, "pickaxe", 5);
         	   MinecraftForge.setToolClass(CopperAxe, "axe", 5);
         	   MinecraftForge.setToolClass(CopperSword, "sword", 5);
         	   MinecraftForge.setToolClass(CopperHoe, "hoe", 5);
         	   MinecraftForge.setToolClass(CopperShovel, "shovel", 5);
         	   MinecraftForge.setToolClass(CopperPickaxe, "pickaxe", 5);
         	   MinecraftForge.setToolClass(UraniumAxe, "axe", 5);
                MinecraftForge.setToolClass(UraniumSword, "sword", 5);
                MinecraftForge.setToolClass(UraniumHoe, "hoe", 5);
                MinecraftForge.setToolClass(UraniumShovel, "shovel", 5);
                MinecraftForge.setToolClass(UraniumPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(TinAxe, "axe", 5);
                MinecraftForge.setToolClass(TinSword, "sword", 5);
                MinecraftForge.setToolClass(TinHoe, "hoe", 5);
                MinecraftForge.setToolClass(TinShovel, "shovel", 5);
                MinecraftForge.setToolClass(TinPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(SilverAxe, "axe", 5);
                MinecraftForge.setToolClass(SilverSword, "sword", 5);
                MinecraftForge.setToolClass(SilverHoe, "hoe", 5);
                MinecraftForge.setToolClass(SilverShovel, "shovel", 5);
                MinecraftForge.setToolClass(SilverPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(BronzeAxe, "axe", 5);
                MinecraftForge.setToolClass(BronzeSword, "sword", 5);
                MinecraftForge.setToolClass(BronzeHoe, "hoe", 5);
                MinecraftForge.setToolClass(BronzeShovel, "shovel", 5);
                MinecraftForge.setToolClass(BronzePickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(PlatinumAxe, "axe", 5);
                MinecraftForge.setToolClass(PlatinumSword, "sword", 5);
                MinecraftForge.setToolClass(PlatinumHoe, "hoe", 5);
                MinecraftForge.setToolClass(PlatinumShovel, "shovel", 5);
                MinecraftForge.setToolClass(PlatinumPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(SteelAxe, "axe", 5);
                MinecraftForge.setToolClass(SteelSword, "sword", 5);
                MinecraftForge.setToolClass(SteelHoe, "hoe", 5);
                MinecraftForge.setToolClass(SteelShovel, "shovel", 5);
                MinecraftForge.setToolClass(SteelPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(PlutoniumAxe, "axe", 5);
                MinecraftForge.setToolClass(PlutoniumSword, "sword", 5);
                MinecraftForge.setToolClass(PlutoniumHoe, "hoe", 5);
                MinecraftForge.setToolClass(PlutoniumShovel, "shovel", 5);
                MinecraftForge.setToolClass(PlutoniumPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(ChrystalAxe, "axe", 5);
                MinecraftForge.setToolClass(ChrystalSword, "sword", 5);
                MinecraftForge.setToolClass(ChrystalHoe, "hoe", 5);
                MinecraftForge.setToolClass(ChrystalShovel, "shovel", 5);
                MinecraftForge.setToolClass(ChrystalPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(AquamarineAxe, "axe", 5);
                MinecraftForge.setToolClass(AquamarineSword, "sword", 5);
                MinecraftForge.setToolClass(AquamarineHoe, "hoe", 5);
                MinecraftForge.setToolClass(AquamarineShovel, "shovel", 5);
                MinecraftForge.setToolClass(AquamarinePickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(AmethystAxe, "axe", 5);
                MinecraftForge.setToolClass(AmethystSword, "sword", 5);
                MinecraftForge.setToolClass(AmethystHoe, "hoe", 5);
                MinecraftForge.setToolClass(AmethystShovel, "shovel", 5);
                MinecraftForge.setToolClass(AmethystPickaxe, "pickaxe", 5);
                MinecraftForge.setToolClass(ItadtalAxe, "axe", 5);
                MinecraftForge.setToolClass(ItadtalSword, "sword", 5);
                MinecraftForge.setToolClass(ItadtalHoe, "hoe", 5);
                MinecraftForge.setToolClass(ItadtalShovel, "shovel", 5);
                MinecraftForge.setToolClass(ItadtalPickaxe, "pickaxe", 5);
        }    
       
        @PostInit
        public void modsLoaded(FMLPostInitializationEvent event) {
            AddonHandler.init();
        }
        
 	   public static Item ChrystalGem = (new ItemChrystalGem(1000).setUnlocalizedName("ChrystalGem").setCreativeTab(tabmod_TFmaterials));
 	   public static Item RubyGem = (new ItemRubyGem(1001).setUnlocalizedName("RubyGem").setCreativeTab(tabmod_TFmaterials));
 	   public static Item SapphireGem = (new ItemSapphireGem(1002).setUnlocalizedName("SapphireGem").setCreativeTab(tabmod_TFmaterials));
 	   public static Item AquamarineGem = (new ItemAquamarineGem(1130).setUnlocalizedName("AquamarineGem").setCreativeTab(tabmod_TFmaterials));
 	   public static Item AmethystGem = (new ItemAmethystGem(1129).setUnlocalizedName("AmathystGem").setCreativeTab(tabmod_TFmaterials));
 	   public static Item ItadtalGem = (new ItemItadtalGem(1151).setUnlocalizedName("ItadtalGem").setCreativeTab(tabmod_TFmaterials));
        
               public static final Block TFportal = (new BlockTFportal(1145).setUnlocalizedName("Block TFportal"));
               public static final BlockFireTF FireTF = (BlockFireTF)(new BlockFireTF(1146)).setHardness(0.0F).setLightValue(1.0F).setUnlocalizedName("main:FireTF");

               public static final Block ChrystalOre = (new BlockChrystalOre(1003, ChrystalGem.itemID).setHardness(2.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("ChrystalOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block RubyOre = (new BlockRubyOre(1004, RubyGem.itemID).setHardness(5.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("RubyOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block SapphireOre = (new BlockSapphireOre(1005, SapphireGem.itemID).setHardness(5.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("SapphireOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block CopperOre = (new BlockCopperOre(1033).setHardness(4F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("CopperOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block UraniumOre = (new BlockUraniumOre(1034).setHardness(4F).setResistance(10.0F).setLightValue(0.5F).setUnlocalizedName("UraniumOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block TinOre = (new BlockTinOre(1035).setHardness(3.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("TinOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block SilverOre = (new BlockSilverOre(1036).setHardness(4.7F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("SilverOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               //public static final Block BronzeOre = (new BlockBronzeOre(1037).setHardness(4F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("BronzeOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block PlatinumOre = (new BlockPlatinumOre(1038).setHardness(5.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("PlatinumOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               //public static final Block SteelOre = (new BlockSteelOre(1039).setHardness(4.9F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("SteelOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block PlutoniumOre = (new BlockPlutoniumOre(1040).setHardness(5F).setResistance(10.0F).setLightValue(0.8F).setUnlocalizedName("PlutoniumOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               //public static final Block BlockRuby = (new BlockRuby(1047).setHardness(6F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("BlockRuby").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               //public static final Block BlockCopper = (new BlockCopper(1048).setHardness(7F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("BlockCopper").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block AquamarineOre = (new BlockAquamarineOre(1128, AquamarineGem.itemID).setHardness(3F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("AquamarineOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block AmethystOre = (new BlockAmethystOre(1127, AmethystGem.itemID).setHardness(2.5F).setResistance(10.0F).setLightValue(0.0F).setUnlocalizedName("AmethystOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));
               public static final Block ItadtalOre = (new BlockItadtalOre(1150, ItadtalGem.itemID).setHardness(5.5F).setResistance(5.0F).setLightValue(0.0F).setUnlocalizedName("ItadtalOre").setLightOpacity(0).setStepSound(Block.soundStoneFootstep).setCreativeTab(tabmod_TFmaterials));

        	   public static final Block NuclearFurnaceIdle = (new NuclearFurnace(1148, false)).setHardness(3.5F).setUnlocalizedName("Nuclear Furnace Idle").setCreativeTab(mod_TFmaterials.tabmod_TFmaterials);
               public static final Block NuclearFurnaceBurning = (new NuclearFurnace(1149, true)).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("Nuclear Furnace Burning");

               public static final Block NuclearLampIdle = (new NuclearLamp(1185, false)).setHardness(0.3F).setUnlocalizedName("NuclearLampIdle").setCreativeTab(mod_TFmaterials.tabmod_TFmaterials);
               public static final Block NuclearLampActive = (new NuclearLamp(1186, true)).setHardness(0.3F).setUnlocalizedName("NuclearLampBurning");
        
               public static final Block CompressorIdle = new Compressor(1583, false).setHardness(3.5F).setUnlocalizedName("CompressorIdle").setCreativeTab(mod_TFmaterials.tabmod_TFmaterials);
               public static final Block CompressorBurning = new Compressor(1584, true).setHardness(3.5F).setUnlocalizedName("CompressorBurning");
               
        	   //public static Item ChrystalGem = (new ItemChrystalGem(1000).setUnlocalizedName("ChrystalGem").setCreativeTab(tabmod_TFmaterials));
        	   //public static Item RubyGem = (new ItemRubyGem(1001).setUnlocalizedName("RubyGem").setCreativeTab(tabmod_TFmaterials));
        	   //public static Item SapphireGem = (new ItemSapphireGem(1002).setUnlocalizedName("SapphireGem").setCreativeTab(tabmod_TFmaterials));
        	   public static Item CopperIngot = (new ItemCopperIngot(1025).setUnlocalizedName("CopperIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item UraniumIngot = (new ItemUraniumIngot(1026).setUnlocalizedName("UraniumIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item TinIngot = (new ItemTinIngot(1027).setUnlocalizedName("TinIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item SilverIngot = (new ItemSilverIngot(1028).setUnlocalizedName("SilverIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item BronzeIngot = (new ItemBronzeIngot(1029).setUnlocalizedName("BronzeIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item PlatinumIngot = (new ItemPlatinumIngot(1030).setUnlocalizedName("PlatinumIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item SteelIngot = (new ItemSteelIngot(1031).setUnlocalizedName("SteelIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item PlutoniumIngot = (new ItemPlutoniumIngot(1032).setUnlocalizedName("PlutoniumIngot").setCreativeTab(tabmod_TFmaterials));
        	   public static Item IronStick = (new ItemIronStick(1045).setUnlocalizedName("IronStick").setCreativeTab(tabmod_TFmaterials));
        	   public static Item SteelStick = (new ItemSteelStick(1046).setUnlocalizedName("SteelStick").setCreativeTab(tabmod_TFmaterials));
        	   //public static Item AquamarineGem = (new ItemAquamarineGem(1130).setUnlocalizedName("AquamarineGem").setCreativeTab(tabmod_TFmaterials));
        	   //public static Item AmethystGem = (new ItemAmethystGem(1129).setUnlocalizedName("AmathystGem").setCreativeTab(tabmod_TFmaterials));
        	   //public static Item ItadtalGem = (new ItemItadtalGem(1151).setUnlocalizedName("ItadtalGem").setCreativeTab(tabmod_TFmaterials));
        	   public static Item recordWhatIFound = (new ItemRecord(1141, "Whatifound").setUnlocalizedName("WhatIFound - Disc").setCreativeTab(tabmod_TFmaterials));
        	   public static Item recordSurrealism = (new ItemRecord(1142, "Surrealism").setUnlocalizedName("Surrealism - Disc").setCreativeTab(tabmod_TFmaterials));
        	   public static Item recordFLchan = (new ItemRecord(1143, "FLchan").setUnlocalizedName("FLchan - Disc").setCreativeTab(tabmod_TFmaterials));
        	   public static Item recordHangingOn = (new ItemRecord(1144, "Hangingon").setUnlocalizedName("HangingOn - Disc").setCreativeTab(tabmod_TFmaterials));
        	   
        	   public static Item RubyHelmet = new RubyArmor(1006, enumru, 3, 0).setUnlocalizedName("RubyHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyBody = new RubyArmor(1007, enumru, 3, 1).setUnlocalizedName("RubyBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyLegs = new RubyArmor(1008, enumru, 3, 2).setUnlocalizedName("RubyLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyBoots = new RubyArmor(1009, enumru, 3, 3).setUnlocalizedName("RubyBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireHelmet = new SapphireArmor(1010, enumsa, 3, 0).setUnlocalizedName("SapphireHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireBody = new SapphireArmor(1011, enumsa, 3, 1).setUnlocalizedName("SapphireBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireLegs = new SapphireArmor(1012, enumsa, 3, 2).setUnlocalizedName("SapphireLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireBoots = new SapphireArmor(1013, enumsa, 3, 3).setUnlocalizedName("SapphireBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperHelmet = new CopperArmor(1044, enumcopp, 3, 0).setUnlocalizedName("CopperHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperBody = new CopperArmor(1041, enumcopp, 3, 1).setUnlocalizedName("CopperBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperLegs = new CopperArmor(1042, enumcopp, 3, 2).setUnlocalizedName("CopperLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperBoots = new CopperArmor(1043, enumcopp, 3, 3).setUnlocalizedName("CopperBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumHelmet = new UraniumArmor(1049, enumuran, 3, 0).setUnlocalizedName("UraniumHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumBody = new UraniumArmor(1050, enumuran, 3, 1).setUnlocalizedName("UraniumBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumLegs = new UraniumArmor(1051, enumuran, 3, 2).setUnlocalizedName("UraniumLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumBoots = new UraniumArmor(1052, enumuran, 3, 3).setUnlocalizedName("UraniumBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinHelmet = new TinArmor(1099, enumtin, 3, 0).setUnlocalizedName("TinHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinBody = new TinArmor(1100, enumtin, 3, 1).setUnlocalizedName("TinBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinLegs = new TinArmor(1101, enumtin, 3, 2).setUnlocalizedName("TinLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinBoots = new TinArmor(1102, enumtin, 3, 3).setUnlocalizedName("TinBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverHelmet = new SilverArmor(1103, enumsilv, 3, 0).setUnlocalizedName("SilverHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverBody = new SilverArmor(1104, enumsilv, 3, 1).setUnlocalizedName("SilverBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverLegs = new SilverArmor(1105, enumsilv, 3, 2).setUnlocalizedName("SilverLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverBoots = new SilverArmor(1106, enumsilv, 3, 3).setUnlocalizedName("SilverBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeHelmet = new BronzeArmor(1107, enumbronze, 3, 0).setUnlocalizedName("BronzeHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeBody = new BronzeArmor(1108, enumbronze, 3, 1).setUnlocalizedName("BronzeBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeLegs = new BronzeArmor(1109, enumbronze, 3, 2).setUnlocalizedName("BronzeLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeBoots = new BronzeArmor(1110, enumbronze, 3, 3).setUnlocalizedName("BronzeBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumHelmet = new PlatinumArmor(1111, enumupla, 3, 0).setUnlocalizedName("PlatinumHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumBody = new PlatinumArmor(1112, enumupla, 3, 1).setUnlocalizedName("PlatinumBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumLegs = new PlatinumArmor(1113, enumupla, 3, 2).setUnlocalizedName("PlatinumLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumBoots = new PlatinumArmor(1114, enumupla, 3, 3).setUnlocalizedName("PlatinumBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumHelmet = new PlutoniumArmor(1115, enumplu, 3, 0).setUnlocalizedName("PlutoniumHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumBody = new PlutoniumArmor(1116, enumplu, 3, 1).setUnlocalizedName("PlutoniumBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumLegs = new PlutoniumArmor(1117, enumplu, 3, 2).setUnlocalizedName("PlutoniumLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumBoots = new PlutoniumArmor(1118, enumplu, 3, 3).setUnlocalizedName("PlutoniumBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalHelmet = new ChrystalArmor(1119, enumchrys, 3, 0).setUnlocalizedName("ChrystalHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalBody = new ChrystalArmor(1120, enumchrys, 3, 1).setUnlocalizedName("ChrystalBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalLegs = new ChrystalArmor(1121, enumchrys, 3, 2).setUnlocalizedName("ChrystalLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalBoots = new ChrystalArmor(1122, enumchrys, 3, 3).setUnlocalizedName("ChrystalBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelHelmet = new SteelArmor(1123, enumsteel, 3, 0).setUnlocalizedName("SteelHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelBody = new SteelArmor(1124, enumsteel, 3, 1).setUnlocalizedName("SteelBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelLegs = new SteelArmor(1125, enumsteel, 3, 2).setUnlocalizedName("SteelLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelBoots = new SteelArmor(1126, enumsteel, 3, 3).setUnlocalizedName("SteelBoots").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalHelmet = new ItadtalArmor(1152, enumitadtal, 3, 0).setUnlocalizedName("ItadtalHelmet").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalBody = new ItadtalArmor(1153, enumitadtal, 3, 1).setUnlocalizedName("ItadtalBody").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalLegs = new ItadtalArmor(1154, enumitadtal, 3, 2).setUnlocalizedName("ItadtalLegs").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalBoots = new ItadtalArmor(1155, enumitadtal, 3, 3).setUnlocalizedName("ItadtalBoots").setCreativeTab(tabmod_TFmaterials);
        	   
        	   public static Item RubyAxe = (new ItemAxe(1014, EnumToolMaterialTF.RUBY)).setUnlocalizedName("RubyAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubySword = (new ItemSword(1015, EnumToolMaterialTF.RUBY)).setUnlocalizedName("RubySword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyHoe = (new ItemHoe(1016, EnumToolMaterialTF.RUBY)).setUnlocalizedName("RubyHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyShovel = (new ItemShovel(1017, EnumToolMaterialTF.RUBY)).setUnlocalizedName("RubyShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item RubyPickaxe = (new ItemPickaxe(1018, EnumToolMaterialTF.RUBY)).setUnlocalizedName("RubyPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireAxe = (new ItemAxe(1019, EnumToolMaterialTF.SAPPHIRE)).setUnlocalizedName("SapphireAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireSword = (new ItemSword(1020, EnumToolMaterialTF.SAPPHIRE)).setUnlocalizedName("SapphireSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireHoe = (new ItemHoe(1021, EnumToolMaterialTF.SAPPHIRE)).setUnlocalizedName("SapphireHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphireShovel = (new ItemShovel(1022, EnumToolMaterialTF.SAPPHIRE)).setUnlocalizedName("SapphireShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SapphirePickaxe = (new ItemPickaxe(1023, EnumToolMaterialTF.SAPPHIRE)).setUnlocalizedName("SapphirePickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperAxe = (new ItemAxe(1053, EnumToolMaterialTF.COPPER)).setUnlocalizedName("CopperAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperSword = (new ItemSword(1054, EnumToolMaterialTF.COPPER)).setUnlocalizedName("CopperSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperHoe = (new ItemHoe(1055, EnumToolMaterialTF.COPPER)).setUnlocalizedName("CopperHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperShovel = (new ItemShovel(1056, EnumToolMaterialTF.COPPER)).setUnlocalizedName("CopperShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item CopperPickaxe = (new ItemPickaxe(1057, EnumToolMaterialTF.COPPER)).setUnlocalizedName("CopperPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumAxe = (new ItemAxe(1058, EnumToolMaterialTF.URANIUM)).setUnlocalizedName("UraniumAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumSword = (new ItemSword(1059, EnumToolMaterialTF.URANIUM)).setUnlocalizedName("UraniumSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumHoe = (new ItemHoe(1060, EnumToolMaterialTF.URANIUM)).setUnlocalizedName("UraniumHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumShovel = (new ItemShovel(1061, EnumToolMaterialTF.URANIUM)).setUnlocalizedName("UraniumShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item UraniumPickaxe = (new ItemPickaxe(1062, EnumToolMaterialTF.URANIUM)).setUnlocalizedName("UraniumPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinAxe = (new ItemAxe(1063, EnumToolMaterialTF.TIN)).setUnlocalizedName("TinAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinSword = (new ItemSword(1064, EnumToolMaterialTF.TIN)).setUnlocalizedName("TinSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinHoe = (new ItemHoe(1065, EnumToolMaterialTF.TIN)).setUnlocalizedName("TinHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinShovel = (new ItemShovel(1066, EnumToolMaterialTF.TIN)).setUnlocalizedName("TinShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item TinPickaxe = (new ItemPickaxe(1067, EnumToolMaterialTF.TIN)).setUnlocalizedName("TinPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverAxe = (new ItemAxe(1068, EnumToolMaterialTF.SILVER)).setUnlocalizedName("SilverAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverSword = (new ItemSword(1069, EnumToolMaterialTF.SILVER)).setUnlocalizedName("SilverSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverHoe = (new ItemHoe(1070, EnumToolMaterialTF.SILVER)).setUnlocalizedName("SilverHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverShovel = (new ItemShovel(1071, EnumToolMaterialTF.SILVER)).setUnlocalizedName("SilverShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SilverPickaxe = (new ItemPickaxe(1072, EnumToolMaterialTF.SILVER)).setUnlocalizedName("SilverPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeAxe = (new ItemAxe(1073, EnumToolMaterialTF.BRONZE)).setUnlocalizedName("BronzeAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeSword = (new ItemSword(1074, EnumToolMaterialTF.BRONZE)).setUnlocalizedName("BronzeSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeHoe = (new ItemHoe(1075, EnumToolMaterialTF.BRONZE)).setUnlocalizedName("BronzeHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzeShovel = (new ItemShovel(1076, EnumToolMaterialTF.BRONZE)).setUnlocalizedName("BronzeShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item BronzePickaxe = (new ItemPickaxe(1077, EnumToolMaterialTF.BRONZE)).setUnlocalizedName("BronzePickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumAxe = (new ItemAxe(1078, EnumToolMaterialTF.PLATINUM)).setUnlocalizedName("PlatinumAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumSword = (new ItemSword(1079, EnumToolMaterialTF.PLATINUM)).setUnlocalizedName("PlatinumSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumHoe = (new ItemHoe(1080, EnumToolMaterialTF.PLATINUM)).setUnlocalizedName("PlatinumHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumShovel = (new ItemShovel(1081, EnumToolMaterialTF.PLATINUM)).setUnlocalizedName("PlatinumShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlatinumPickaxe = (new ItemPickaxe(1082, EnumToolMaterialTF.PLATINUM)).setUnlocalizedName("PlatinumPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelAxe = (new ItemAxe(1083, EnumToolMaterialTF.STEEL)).setUnlocalizedName("SteelAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelSword = (new ItemSword(1084, EnumToolMaterialTF.STEEL)).setUnlocalizedName("SteelSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelHoe = (new ItemHoe(1085, EnumToolMaterialTF.STEEL)).setUnlocalizedName("SteelHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelShovel = (new ItemShovel(1086, EnumToolMaterialTF.STEEL)).setUnlocalizedName("SteelShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item SteelPickaxe = (new ItemPickaxe(1087, EnumToolMaterialTF.STEEL)).setUnlocalizedName("SteelPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumAxe = (new ItemAxe(1089, EnumToolMaterialTF.PLUTONIUM)).setUnlocalizedName("PlutoniumAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumSword = (new ItemSword(1090, EnumToolMaterialTF.PLUTONIUM)).setUnlocalizedName("PlutoniumSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumHoe = (new ItemHoe(1091, EnumToolMaterialTF.PLUTONIUM)).setUnlocalizedName("PlutoniumHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumShovel = (new ItemShovel(1092, EnumToolMaterialTF.PLUTONIUM)).setUnlocalizedName("PlutoniumShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item PlutoniumPickaxe = (new ItemPickaxe(1093, EnumToolMaterialTF.PLUTONIUM)).setUnlocalizedName("PlutoniumPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalAxe = (new ItemAxe(1094, EnumToolMaterialTF.CHRYSTAL)).setUnlocalizedName("ChrystalAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalSword = (new ItemSword(1095, EnumToolMaterialTF.CHRYSTAL)).setUnlocalizedName("ChrystalSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalHoe = (new ItemHoe(1096, EnumToolMaterialTF.CHRYSTAL)).setUnlocalizedName("ChrystalHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalShovel = (new ItemShovel(1097, EnumToolMaterialTF.CHRYSTAL)).setUnlocalizedName("ChrystalShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ChrystalPickaxe = (new ItemPickaxe(1098, EnumToolMaterialTF.CHRYSTAL)).setUnlocalizedName("ChrystalPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AquamarineAxe = (new ItemAxe(1131, EnumToolMaterialTF.AQUAMARINE)).setUnlocalizedName("AquamarineAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AquamarineSword = (new ItemSword(1132, EnumToolMaterialTF.AQUAMARINE)).setUnlocalizedName("AquamarineSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AquamarineHoe = (new ItemHoe(1133, EnumToolMaterialTF.AQUAMARINE)).setUnlocalizedName("AquamarineHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AquamarineShovel = (new ItemShovel(1134, EnumToolMaterialTF.AQUAMARINE)).setUnlocalizedName("AquamarineShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AquamarinePickaxe = (new ItemPickaxe(1135, EnumToolMaterialTF.AQUAMARINE)).setUnlocalizedName("AquamarinePickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AmethystAxe = (new ItemAxe(1136, EnumToolMaterialTF.AMETHYST)).setUnlocalizedName("AmethystAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AmethystSword = (new ItemSword(1137, EnumToolMaterialTF.AMETHYST)).setUnlocalizedName("AmethystSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AmethystHoe = (new ItemHoe(1138, EnumToolMaterialTF.AMETHYST)).setUnlocalizedName("AmethystHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AmethystShovel = (new ItemShovel(1139, EnumToolMaterialTF.AMETHYST)).setUnlocalizedName("AmethystShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item AmethystPickaxe = (new ItemPickaxe(1140, EnumToolMaterialTF.AMETHYST)).setUnlocalizedName("AmethystPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalAxe = (new ItemAxe(1156, EnumToolMaterialTF.ITADTAL)).setUnlocalizedName("AmethystAxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalSword = (new ItemSword(1157, EnumToolMaterialTF.ITADTAL)).setUnlocalizedName("ItadtalSword").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalHoe = (new ItemHoe(1158, EnumToolMaterialTF.ITADTAL)).setUnlocalizedName("ItadtalHoe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalShovel = (new ItemShovel(1159, EnumToolMaterialTF.ITADTAL)).setUnlocalizedName("ItadtalShovel").setCreativeTab(tabmod_TFmaterials);
        	   public static Item ItadtalPickaxe = (new ItemPickaxe(1160, EnumToolMaterialTF.ITADTAL)).setUnlocalizedName("ItadtalPickaxe").setCreativeTab(tabmod_TFmaterials);
        	   public static Item FlintAndSteelTF = (new ItemFlintAndSteelTF(1161)).setUnlocalizedName("Magic - Flint And Steel").setCreativeTab(tabmod_TFmaterials);
        	   
        	   public static final Achievement RubyAchieve = new Achievement(1187, "RubyAchieve", 1, -2, mod_TFmaterials.RubyGem, null).registerAchievement();
               public static final Achievement RubyPickAchieve = new Achievement(1188, "RubyPickAchieve", -2, -2, mod_TFmaterials.RubyPickaxe, RubyAchieve).registerAchievement();
        	   public static AchievementPage TFmaterialsPage1 = new AchievementPage("TFmaterials", RubyAchieve, RubyPickAchieve);
        	   
        	   public static Item PortalPlacerTF = (new ItemPortalPlacerTF(1189, EnumToolMaterialTF.PORTALPLACER)).setUnlocalizedName("PortalPlacerTF").setCreativeTab(tabmod_TFmaterials);
        	   
        	   //Crafting Recipes//
        		
        	   public void craftingRecipes(){
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyHelmet, 1), new Object[]{
        	 		      "XXX", "X X", 'X', mod_TFmaterials.RubyGem
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyBody, 1), new Object[]{
        	 			  "X X", "XXX", "XXX", 'X', mod_TFmaterials.RubyGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyLegs, 1), new Object[]{
        	 			  "XXX", "X X", "X X", 'X', mod_TFmaterials.RubyGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyBoots, 1), new Object[]{
        	 			  "X X", "X X", 'X', mod_TFmaterials.RubyGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireHelmet, 1), new Object[]{
        	 		      "XXX", "X X", 'X', mod_TFmaterials.SapphireGem
        	 	       });
        	 	 
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireBody, 1), new Object[]{
        	 			  "X X", "XXX", "XXX", 'X', mod_TFmaterials.SapphireGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireLegs, 1), new Object[]{
        	 			  "XXX", "X X", "X X", 'X', mod_TFmaterials.SapphireGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireBoots, 1), new Object[]{
        	 			  "X X", "X X", 'X', mod_TFmaterials.SapphireGem
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyAxe, 1), new Object[]{
        	 			" XX", " 1X", " 1 ", 'X', mod_TFmaterials.RubyGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubySword, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.RubyGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyHoe, 1), new Object[]{
        	 			"XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.RubyGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyShovel, 1), new Object[]{
        	 		 	" X ", " 1 ", " 1 ", 'X', mod_TFmaterials.RubyGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.RubyPickaxe, 1), new Object[]{
        	 			"XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.RubyGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireAxe, 1), new Object[]{
        	 		 	" XX", " 1X", " 1 ", 'X', mod_TFmaterials.SapphireGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireSword, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.SapphireGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireHoe, 1), new Object[]{
        	 			"XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.SapphireGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphireShovel, 1), new Object[]{
        	 			" X ", " 1 ", " 1 ", 'X', mod_TFmaterials.SapphireGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SapphirePickaxe, 1), new Object[]{
        	 			"XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.SapphireGem, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperHelmet, 1), new Object[]{
        	 		    "XXX", "X X", 'X', mod_TFmaterials.CopperIngot
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperBody, 1), new Object[]{
        	 			"X X", "XXX", "XXX", 'X', mod_TFmaterials.CopperIngot
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperLegs, 1), new Object[]{
        	 			"XXX", "X X", "X X", 'X', mod_TFmaterials.CopperIngot
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperBoots, 1), new Object[]{
        	 		    "X X", "X X", 'X', mod_TFmaterials.CopperIngot
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelStick, 1), new Object[]{
        	 			" X ", " X ", 'X', mod_TFmaterials.SteelIngot
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.IronStick, 1), new Object[]{
        	 		    " X ", " X ", 'X', Item.ingotIron
        	 		   });
        	 	   
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperAxe, 1), new Object[]{
        	 			" XX", " 1X", " 1 ", 'X', mod_TFmaterials.CopperIngot, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperSword, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.CopperIngot, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperHoe, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.CopperIngot, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperShovel, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.CopperIngot, '1', Item.stick
        	 		   });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CopperPickaxe, 1), new Object[]{
        	 			" X ", " X ", " 1 ", 'X', mod_TFmaterials.CopperIngot, '1', Item.stick
        	 		   });
        	 	   
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.UraniumAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.UraniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.UraniumSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.UraniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.UraniumHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.UraniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.UraniumShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.UraniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.UraniumPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.UraniumIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.TinIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.TinIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.TinIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.TinIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.TinIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.SilverIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.SilverIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.SilverIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.SilverIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.SilverIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.BronzeIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.BronzeIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.BronzeIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.BronzeIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzePickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.BronzeIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.PlatinumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.PlatinumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.PlatinumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.PlatinumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.PlatinumIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.SteelIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.SteelIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.SteelIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.SteelIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.SteelIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.PlutoniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.PlutoniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.PlutoniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.PlutoniumIngot, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.PlutoniumIngot, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.ChrystalGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.ChrystalGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.ChrystalGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.ChrystalGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.ChrystalGem, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.TinIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.TinIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.TinIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.TinBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.TinIngot
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.SilverIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.SilverIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.SilverIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SilverBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.SilverIngot
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.BronzeIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.BronzeIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.BronzeIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.BronzeBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.BronzeIngot
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.PlatinumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.PlatinumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.PlatinumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlatinumBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.PlatinumIngot
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.PlutoniumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.PlutoniumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.PlutoniumIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PlutoniumBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.PlutoniumIngot
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.ChrystalGem
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.ChrystalGem
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.ChrystalGem
        	 	     });
        	 	  
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ChrystalBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.ChrystalGem
        	 	     });
        	 	     
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelHelmet, 1), new Object[]{
        	 	        "XXX", "X X", 'X', mod_TFmaterials.SteelIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelBody, 1), new Object[]{
        	 	        "X X", "XXX", "XXX", 'X', mod_TFmaterials.SteelIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelLegs, 1), new Object[]{
        	 	        "XXX", "X X", "X X", 'X', mod_TFmaterials.SteelIngot
        	 	     });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.SteelBoots, 1), new Object[]{
        	 	        "X X", "X X", 'X', mod_TFmaterials.SteelIngot
        	 	     });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AmethystAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.AmethystGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AmethystSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.AmethystGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AmethystHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.AmethystGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AmethystShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.AmethystGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AmethystPickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.AmethystGem, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AquamarineAxe, 1), new Object[]{
        	 	        " XX", " 1X", " 1 ", 'X', mod_TFmaterials.AquamarineGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AquamarineSword, 1), new Object[]{
        	 	        " X ", " X ", " 1 ", 'X', mod_TFmaterials.AquamarineGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AquamarineHoe, 1), new Object[]{
        	 	        "XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.AquamarineGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AquamarineShovel, 1), new Object[]{
        	 	        " X ", " 1 ", " 1 ", 'X', mod_TFmaterials.AquamarineGem, '1', Item.stick
        	 	       });

        	 	    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.AquamarinePickaxe, 1), new Object[]{
        	 	        "XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.AquamarineGem, '1', Item.stick
        	 	       });
        	 	    
        	 	    GameRegistry.addShapelessRecipe(new ItemStack(mod_TFmaterials.SteelIngot, 1), new Object[]{
        		       Item.ingotIron,
        		       Item.coal
        		    });
        	 	    
        	 	    GameRegistry.addShapelessRecipe(new ItemStack(mod_TFmaterials.BronzeIngot, 1), new Object[]{
        		       mod_TFmaterials.CopperIngot,
        		       mod_TFmaterials.TinIngot
        		    });
        	 	    
        	 	   GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalHelmet, 1), new Object[]{
        		        "XXX", "X X", 'X', mod_TFmaterials.ItadtalGem
        		     });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalBody, 1), new Object[]{
        		        "X X", "XXX", "XXX", 'X', mod_TFmaterials.ItadtalGem
        		     });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalLegs, 1), new Object[]{
        		        "XXX", "X X", "X X", 'X', mod_TFmaterials.ItadtalGem
        		     });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalBoots, 1), new Object[]{
        		        "X X", "X X", 'X', mod_TFmaterials.ItadtalGem
        		     });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalAxe, 1), new Object[]{
        				" XX", " 1X", " 1 ", 'X', mod_TFmaterials.ItadtalGem, '1', Item.stick
        			   });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalSword, 1), new Object[]{
        				" X ", " X ", " 1 ", 'X', mod_TFmaterials.ItadtalGem, '1', Item.stick
        			   });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalHoe, 1), new Object[]{
        				"XX ", " 1 ", " 1 ", 'X', mod_TFmaterials.ItadtalGem, '1', Item.stick
        			   });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalShovel, 1), new Object[]{
        			 	" X ", " 1 ", " 1 ", 'X', mod_TFmaterials.ItadtalGem, '1', Item.stick
        			   });

        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.ItadtalPickaxe, 1), new Object[]{
        				"XXX", " 1 ", " 1 ", 'X', mod_TFmaterials.ItadtalGem, '1', Item.stick
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.NuclearFurnaceIdle, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', mod_TFmaterials.PlutoniumIngot, '1', Block.furnaceIdle
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.CompressorIdle, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', Item.coal, '1', Block.furnaceIdle
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.recordFLchan, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', Item.coal, '1', Block.stone
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.recordHangingOn, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', mod_TFmaterials.AmethystGem, '1', Block.stone
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.recordSurrealism, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', mod_TFmaterials.ChrystalGem, '1', Block.stone
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.recordWhatIFound, 1), new Object[]{
        				"XXX", "X1X", "XXX", 'X', mod_TFmaterials.RubyGem, '1', Block.stone
        			   });
        		    
        		    GameRegistry.addRecipe(new ItemStack(mod_TFmaterials.PortalPlacerTF, 1), new Object[]{
        				"XXX", "X1X", " 2 ", 'X', Block.blockDiamond, '1', mod_TFmaterials.SteelStick, '2', mod_TFmaterials.IronStick
        			   });
        		    
        	 	    GameRegistry.addShapelessRecipe(new ItemStack(mod_TFmaterials.FlintAndSteelTF, 1), new Object[]{
         		       mod_TFmaterials.CopperIngot,
         		       mod_TFmaterials.CopperIngot,
         		       mod_TFmaterials.TinIngot,
         		       Item.ingotGold,
         		       Item.ingotGold,
         		       Item.flintAndSteel
         		    });
        	    }
        	   
        	 	//Smelting Recipes//
        	 	public void smeltingRecipes(){
        	 		   GameRegistry.addSmelting(this.CopperOre.blockID, new ItemStack(this.CopperIngot), 1);
        	 		   GameRegistry.addSmelting(this.UraniumOre.blockID, new ItemStack(this.UraniumIngot), 1);
        	 		   GameRegistry.addSmelting(this.TinOre.blockID, new ItemStack(this.TinIngot), 1);
        	 		   GameRegistry.addSmelting(this.SilverOre.blockID, new ItemStack(this.SilverIngot), 1);
        	 		   GameRegistry.addSmelting(this.PlatinumOre.blockID, new ItemStack(this.PlatinumIngot), 1);
        	 		   GameRegistry.addSmelting(this.PlutoniumOre.blockID, new ItemStack(this.PlutoniumIngot), 1);
        	 	}
}
