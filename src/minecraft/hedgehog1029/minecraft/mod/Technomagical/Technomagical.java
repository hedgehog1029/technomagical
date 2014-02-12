package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="hedgehog1029-Technomagical", name="Technomagical", version="0.0.1")
@NetworkMod(clientSideRequired=true)
public class Technomagical {

		//Register items
		public static Item itemMagicEssence;
		public static Item basicWand;
		public static Item magicIngot;
		public static Item speedDemon;
		public static Item craftAmulet;
		public static Item speedAmulet;
		
		//Register blocks
		public static Block magicOre;
		public static Block blockMagicSource;
		public static Block blockMagicTap;
		public static Block blockMagicTapOn;
		
        // The instance of your mod that Forge uses.
        @Instance(value = "hedgehog1029-Technomagical")
        public static Technomagical instance;
       
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="hedgehog1029.classes.client.ClientProxy", serverSide="hedgehog1029.minecraft.mod.Technomagical.CommonProxy")
        public static CommonProxy proxy;
       
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
                //Register blocks and items
        		itemMagicEssence = new ItemMagicEssence(5002);
        		blockMagicSource = new BlockMagicSource(501, Material.ground).setBlockUnbreakable();
        		magicOre = new GeneralOre(502, Material.rock).setTextureName("technomagical:magicOre").setUnlocalizedName("magicOre");
        		basicWand = new BasicItem(5001).setUnlocalizedName("basicWand").setTextureName("technomagical:basicWand");
        		magicIngot = new ItemGeneralIngot(5003).setUnlocalizedName("itemMagicIngot").setTextureName("technomagical:magicIngot");
        		blockMagicTap = new BlockMagicTap(503, Material.rock);
        		blockMagicTapOn = new BlockMagicTapOn(504, Material.rock);
        		speedDemon = new ItemSpeedDemon(5004);
        		speedAmulet = new ItemGeneralIngot(5005).setUnlocalizedName("speedAm").setTextureName("technomagical:speedAmulet");
        		craftAmulet = new ItemGeneralIngot(5006).setUnlocalizedName("craftAm").setTextureName("technomagical:craftAmulet");
        }
       
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                //Register blocks
                GameRegistry.registerBlock(blockMagicSource, "magicSource");
                GameRegistry.registerBlock(magicOre, "generalOre");
                GameRegistry.registerBlock(blockMagicTap, "magicTap");
                //Magic tap ON not registered because unobtainable
                
                //Register world generators
                GameRegistry.registerWorldGenerator(new OreGenerator());
                GameRegistry.registerWorldGenerator(new MagicSourceGenerator());
                
                //Register tile entities
                //GameRegistry.registerTileEntity(MagicTapTileEntity.class, "magicTapTile");
                
                //Add human-readable names
                LanguageRegistry.addName(blockMagicSource, "Magic Source Block");
                LanguageRegistry.addName(magicOre, "Transmagical Ore");
        		LanguageRegistry.addName(itemMagicEssence, "Magic Essence");
        		LanguageRegistry.addName(magicIngot, "Magic Ingot");
        		LanguageRegistry.addName(basicWand, "Basic Wand");
        		LanguageRegistry.addName(blockMagicTap, "Magical Tap");
        		LanguageRegistry.addName(speedDemon, "Speed Demon");
        		LanguageRegistry.addName(speedAmulet, "Amulet of Speed");
        		LanguageRegistry.addName(craftAmulet, "Amulet Core");
        		
        		//Creative tabs human-readable names
        		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTechnomagical", "en_US", "Technomagical Ores/Ingots/etc.");
        		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTechnomagicalMagic", "en_US", "Technomagical Magic");
        		
        		//Harvest levels
        		MinecraftForge.setBlockHarvestLevel(blockMagicSource, "pickaxe", 0);
        		MinecraftForge.setBlockHarvestLevel(magicOre, "pickaxe", 2);
        		MinecraftForge.setBlockHarvestLevel(blockMagicTap, "pickaxe", 2);
        		MinecraftForge.setBlockHarvestLevel(blockMagicTapOn, "pickaxe", 2);
        		
        		//Crafting
        		ItemStack ironStack = new ItemStack(magicIngot);
        		ItemStack woodStack = new ItemStack(Block.planks);
        		ItemStack goldStack = new ItemStack(Item.ingotGold);
        		ItemStack magicEssence = new ItemStack(itemMagicEssence, 2);
        		ItemStack wand = new ItemStack(basicWand, 1);
        		ItemStack tap = new ItemStack(blockMagicTap, 1);
        		ItemStack speed = new ItemStack(speedDemon, 1);
        		ItemStack speedAm = new ItemStack(speedAmulet, 1);
        		ItemStack craftAm = new ItemStack(craftAmulet, 1);

        		GameRegistry.addRecipe(magicEssence, "xy", "yy",
        		        'x', ironStack, 'y', woodStack);
        		GameRegistry.addRecipe(tap, "xxx", "y y", "xxx", 'x', goldStack, 'y', ironStack);
        		GameRegistry.addRecipe(wand, "x", "y", 'x', magicEssence, 'y', new ItemStack(Item.stick));
        		GameRegistry.addRecipe(speed, "x x", "yzy", "xax", 'x', magicEssence, 'y', ironStack, 'z', speedAm, 'a', goldStack);
        		GameRegistry.addRecipe(craftAm, "xsx", "xyx", "xzx", 'x', magicEssence, 's', new ItemStack(Item.silk), 'y', goldStack, 'z', ironStack);
        		GameRegistry.addRecipe(speedAm, "xxx", "xyx", "zaz", 'x', new ItemStack(Item.sugar), 'y', craftAm, 'z', ironStack, 'a', new ItemStack(Item.diamond));
        		
        		GameRegistry.addSmelting(magicOre.blockID, new ItemStack(magicIngot), 0.1f);
        		
        		//Ore dictionary
        		proxy.registerOre();
        }
        
        public static CreativeTabs tabTechnomagical = new CreativeTabs("tabTechnomagical") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(itemMagicEssence, 1, 0);
            }
        };
        public static CreativeTabs tabTechnomagicalMagic = new CreativeTabs("tabTechnomagicalMagic") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(basicWand, 1, 0);
            }
        };
       
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}