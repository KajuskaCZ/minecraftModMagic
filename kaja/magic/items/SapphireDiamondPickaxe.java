package kaja.magic.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class SapphireDiamondPickaxe extends ItemPickaxe {

	public SapphireDiamondPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("sapphireDiamondPickaxe");
		func_111206_d("magic:AnimatedSapphireDiamondPickaxe");
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
			par3List.add((1961 - par1ItemStack.getItemDamage()) + ":1961 uses");
			par3List.add("Mining speed +2");
	}
}
