package kaja.magic.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class FireOpalShovel extends ItemSpade{

	public FireOpalShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);

		this.setUnlocalizedName("fireOpalShovell");
		func_111206_d("magic:FireOpalShovel");
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
			par3List.add((2341 - par1ItemStack.getItemDamage()) + ":2341 uses");
			par3List.add("Digging speed +4");
	}

}
