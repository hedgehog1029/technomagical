package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.item.Item;

public class ItemGeneralIngot extends Item {

	public ItemGeneralIngot(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(Technomagical.tabTechnomagical);
		setUnlocalizedName("generalIngot");
		setTextureName("technomagical:generalIngot");
	}

}
