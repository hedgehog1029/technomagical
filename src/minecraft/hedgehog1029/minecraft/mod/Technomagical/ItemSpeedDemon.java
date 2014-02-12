package hedgehog1029.minecraft.mod.Technomagical;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSpeedDemon extends Item {

	public int MaxChargeLvl = 20000;
	public int ToolCharge = MaxChargeLvl;
	
	public ItemSpeedDemon(int par1) {
		super(par1);
		setMaxStackSize(1);
		setCreativeTab(Technomagical.tabTechnomagicalMagic);
		setUnlocalizedName("speedDemon");
		setMaxDamage(MaxChargeLvl);
		setTextureName("technomagical:speedDemon");
	}
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
		EntityPlayer Player = (EntityPlayer) entity;
		if(Player.getCurrentEquippedItem() !=null && Player.getCurrentEquippedItem().itemID == this.itemID && Player.getCurrentEquippedItem().getItemDamage() != MaxChargeLvl)
		{
			Player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 0, 4)));
			Player.getCurrentEquippedItem().damageItem(1, Player);
			//System.out.println(itemstack.getItemDamage()); //debugginess
		}else{
			Player.curePotionEffects(itemstack);
		}
	}

}
