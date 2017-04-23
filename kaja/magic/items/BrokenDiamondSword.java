package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BrokenDiamondSword extends Item{
	
	public BrokenDiamondSword(int id) {
		super(id);
		
		maxStackSize = 16;
		setUnlocalizedName("brokenDiamondSword");
		setCreativeTab(CreativeTabs.tabCombat);
		func_111206_d("magic:BrokenDiamondSword");
		
	}

}
