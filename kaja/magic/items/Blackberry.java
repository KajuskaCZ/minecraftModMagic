package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Blackberry extends ItemFood{
	
	public Blackberry(int id, int hunger, float saturation, boolean wolfFood) {
		super(id, hunger, saturation, wolfFood);
		
		maxStackSize = 64;
		setUnlocalizedName("blackberrz");
		setCreativeTab(CreativeTabs.tabFood);
		func_111206_d("magic:Blackberry");
	}

}
