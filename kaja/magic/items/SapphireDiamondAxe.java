package kaja.magic.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class SapphireDiamondAxe extends ItemAxe {

	public SapphireDiamondAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("sapphireDiamondAxe");
		func_111206_d("magic:AnimatedSapphireDiamondAxe");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add((1961 - par1ItemStack.getItemDamage()) + ":1961 uses");
		par3List.add("Cutting speed +2");
	}

}
