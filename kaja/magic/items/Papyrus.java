package kaja.magic.items;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Papyrus extends Item {
	public Papyrus(int id) {
		super(id);
		
		maxStackSize = 64;
		setUnlocalizedName("papyrus");
		setCreativeTab(CreativeTabs.tabMisc);
		func_111206_d("magic:Papyrus");
	}
}
