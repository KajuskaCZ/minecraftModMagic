package kaja.magic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SapphireGem extends Item {

	public SapphireGem(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("sapphireGem");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:AnimatedSapphireGem");
	}

}
