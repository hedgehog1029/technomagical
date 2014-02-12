package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(int par1) {
		super(par1);
		setMaxStackSize(64);
		setCreativeTab(Technomagical.tabTechnomagicalMagic);
	}

}
