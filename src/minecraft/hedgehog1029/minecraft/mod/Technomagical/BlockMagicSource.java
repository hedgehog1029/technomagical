package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

public class BlockMagicSource extends Block {
	
	public int defaulBlockCharge = 100000;
	public int currentBlockCharge = 100000;

	public BlockMagicSource(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(3.0F);
		setStepSound(Block.soundStoneFootstep);
        setUnlocalizedName("magicSource");
        setCreativeTab(Technomagical.tabTechnomagical);
	}
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID;
    }
	
	//Function for activating blockMagicTap
	public void onNeighborBlockChange(World world, int i, int j, int k, int changedBlockId) {
		//System.out.println("Block changed!"); //spammy gen thingy
		if (world.getBlockId(i, j + 1, k) == 503){
		if (changedBlockId == Technomagical.blockMagicTap.blockID) {
			BlockMagicTap.isConnected = 0;
			System.out.println("Tap broken!");
			world.setBlock(i, j + 1, k, Technomagical.blockMagicTap.blockID, 0, 2);
		}else if (changedBlockId == Technomagical.blockMagicTapOn.blockID){
			//Do nothing! We want the magical tap to be destroyable.
		}else{
			BlockMagicTap.isConnected = 1;
			System.out.println("Tap placed!");
			world.setBlock(i, j + 1, k, Technomagical.blockMagicTapOn.blockID, 0, 2);
			BlockMagicTapOn.x = i;
			BlockMagicTapOn.y = j;
			BlockMagicTapOn.z = k;
		}
		}else {
			//ModLoader.getMinecraftInstance().thePlayer.addChatMessage("You must place a Magical Tap to collect Beta Energy!");
			//this can explode violently on a server
		}
	}

}
