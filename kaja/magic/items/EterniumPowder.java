package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EterniumPowder extends Item {
	
	public EterniumPowder(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("eterniumPowder");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:EterniumPowder");
	}		

}
