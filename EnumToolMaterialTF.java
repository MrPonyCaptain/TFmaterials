package mod_TFmaterials;

import net.minecraft.block.Block;
import net.minecraft.item.*;

public enum EnumToolMaterialTF
{
    WOOD(0, 59, 2.0F, 0, 15),
    STONE(1, 131, 4.0F, 1, 5),
    IRON(2, 250, 6.0F, 2, 14),
    EMERALD(3, 1561, 8.0F, 3, 10),
    GOLD(0, 32, 12.0F, 0, 22),
    RUBY(3, 1301, 7.5F, 3, 3),
    SAPPHIRE(3, 1100, 7.5F, 2, 3),
    COPPER(2, 300, 6.5F, 2, 2),
    URANIUM(3, 350, 6.7F, 3, 3),
    TIN(2, 250, 6.3F, 2, 2),
    SILVER(2, 300, 6.5F, 2, 2),
    BRONZE(2, 400, 6.8F, 2, 2),
    PLATINUM(3, 350, 7.2F, 3, 3),
    STEEL(2, 300, 6.9F, 14, 3),
    PLUTONIUM(3, 863, 6.0F, 3, 3),
    CHRYSTAL(3, 400, 6.3F, 2, 2),
    AQUAMARINE(2, 100, 4.3F, 1, 2),
    AMETHYST(2, 89, 3.8F, 1, 2),
    ITADTAL(3, 1449, 7.5F, 4, 4),
    PORTALPLACER(0, 1, 2.0F, 0, 15);  
    
    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final int damageVsEntity;

    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;

    //Added by forge for custom Armor materials.
    public Item customCraftingMaterial = null;

    private EnumToolMaterialTF(int par3, int par4, float par5, int par6, int par7)
    {
        this.harvestLevel = par3;
        this.maxUses = par4;
        this.efficiencyOnProperMaterial = par5;
        this.damageVsEntity = par6;
        this.enchantability = par7;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public int getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        switch (this)
        {
            case WOOD:     return Block.planks.blockID;
            case STONE:    return Block.cobblestone.blockID;
            case GOLD:     return Item.ingotGold.itemID;
            case IRON:     return Item.ingotIron.itemID;
            case EMERALD:  return Item.diamond.itemID;
            case RUBY:     return mod_TFmaterials.RubyGem.itemID;
            case SAPPHIRE: return mod_TFmaterials.SapphireGem.itemID;
            case COPPER:   return mod_TFmaterials.CopperIngot.itemID;
            case URANIUM:  return mod_TFmaterials.UraniumIngot.itemID;
            case TIN:      return mod_TFmaterials.TinIngot.itemID;
            case SILVER:   return mod_TFmaterials.SilverIngot.itemID;
            case BRONZE:  return mod_TFmaterials.BronzeIngot.itemID;
            case PLATINUM:      return mod_TFmaterials.PlatinumIngot.itemID;
            case STEEL:   return mod_TFmaterials.SteelIngot.itemID;
            case PLUTONIUM:      return mod_TFmaterials.PlutoniumIngot.itemID;
            case CHRYSTAL:   return mod_TFmaterials.ChrystalGem.itemID;
            case AQUAMARINE:   return mod_TFmaterials.AquamarineGem.itemID;
            case AMETHYST:   return mod_TFmaterials.AmethystGem.itemID;
            case ITADTAL: return mod_TFmaterials.ItadtalGem.itemID;
            case PORTALPLACER: return mod_TFmaterials.PortalPlacerTF.itemID;
            default:       return (customCraftingMaterial == null ? 0 : customCraftingMaterial.itemID);
        }
    }
}
