package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;



public class Raspberry extends ItemFood{

	public Raspberry(int id, int hunger, float saturation, boolean wolfFood) {
		super(id, hunger, saturation, wolfFood);
		
		maxStackSize = 64;
		setUnlocalizedName("raspberry");
		setCreativeTab(CreativeTabs.tabFood);
		func_111206_d("magic:Raspberry");
	}



	
	

	
}
