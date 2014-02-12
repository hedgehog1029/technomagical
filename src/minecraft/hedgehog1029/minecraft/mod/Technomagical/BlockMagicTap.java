package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMagicTap extends Block {
	
	public static int isConnected = 0;

	public BlockMagicTap(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("magicTap");
		setTextureName("technomagical:magicalTap");
		setCreativeTab(Technomagical.tabTechnomagicalMagic);
		setHardness(1F);
	}
	
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		//System.out.println("Ooooh, something happened!");
	}
}
