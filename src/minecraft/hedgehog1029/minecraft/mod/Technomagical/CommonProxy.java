package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {

    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics or entities!
    }
    public void registerOre(){ //Ore dictionary
    	OreDictionary.registerOre("ingotMagic", Technomagical.magicIngot);
    }
}