package kaja.magic.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class SapphireDiamondShovel extends ItemSpade{

	public SapphireDiamondShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("sapphireDiamondShovel");
		func_111206_d("magic:AnimatedSapphireDiamodShovel");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add((1961 - par1ItemStack.getItemDamage()) + ":1961 uses");
		par3List.add("Digging speed +2");
	}

}
