package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FireOpal extends Item {

	public FireOpal(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("fireOpal");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:FireOpal");
	}

}
