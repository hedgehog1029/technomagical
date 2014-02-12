package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MagicTapTileEntity extends TileEntity {

	public MagicTapTileEntity() {
		
	}
	public TileEntity createTileEntity(World world, int metadata)
	{
	   return new MagicTapTileEntity();
	}

}
