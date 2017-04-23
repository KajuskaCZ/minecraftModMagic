package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FireOpalGem extends Item{

	public FireOpalGem(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("fireOpalGem");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:AnimatedFireOpalGem");
	}

}
