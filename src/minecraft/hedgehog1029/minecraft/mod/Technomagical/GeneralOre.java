package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GeneralOre extends Block {

	public GeneralOre(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(2.5F); // hard-ish
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("genOre");
		setCreativeTab(Technomagical.tabTechnomagical);
	}

}
