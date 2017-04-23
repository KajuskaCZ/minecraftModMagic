package kaja.magic.items;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EmeraldGem extends Item {

	public EmeraldGem(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("emeraldGem");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:AnimatedEmeraldGem");
	}
}
