package hedgehog1029.minecraft.mod.Technomagical;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMagicTapOn extends Block {
	
	public int chargeCapacity = 50000;
	public int charge = 0;
	
	public static int x = 0;
	public static int y = 0;
	public static int z = 0;
	
	public static int isConnected = 0;

	public BlockMagicTapOn(int par1, Material par2Material) {
		super(par1, par2Material);
		setUnlocalizedName("magicTapOn");
		setTextureName("technomagical:magicalTapOn");
		setHardness(1F);
	}
	public int idDropped(int par1, Random random, int zero) {
        return Technomagical.blockMagicTap.blockID;
	}
}
