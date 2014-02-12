package hedgehog1029.minecraft.mod.Technomagical;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMagicEssence extends Item {

	public ItemMagicEssence(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(Technomagical.tabTechnomagical);
		setUnlocalizedName("magicEssence");
		setTextureName("technomagical:magicessence");
	}

}