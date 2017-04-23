package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Sapphire extends Item {

	public Sapphire(int id) {
		super(id);

		maxStackSize = 64;
		setUnlocalizedName("dapphire");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:Sapphire");
	}

}
