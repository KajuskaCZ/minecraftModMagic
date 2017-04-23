package kaja.magic.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class EmeraldDiamondPickaxe extends ItemPickaxe {

	public EmeraldDiamondPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("emeraldDiamondPickaxe");
		func_111206_d("magic:AnimatedEmeraldDiamondPickaxe");
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
			par3List.add((2061 - par1ItemStack.getItemDamage()) + ":2061 uses");
			par3List.add("Mining speed +1");
	}
}
