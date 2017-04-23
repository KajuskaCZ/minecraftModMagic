package kaja.magic.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentFireAspect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FireOpalSword extends ItemSword {
	
	private float weaponDamage;

	public FireOpalSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("fireOpalSword");
		func_111206_d("magic:FireOpalSword");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		par3List.add((2341 - par1ItemStack.getItemDamage()) + ":2341 uses");
		par3List.add("Fire Aspect I");
		par3List.add("10% chance to damage boost");
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		 Random random = new Random();
	     par1ItemStack.damageItem(1, par3EntityLivingBase);
	     par2EntityLivingBase.setFire(10);
	     if(random.nextInt(1000) < 10)
	    	 par3EntityLivingBase.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 60, 0));
	     return true;
	}
}
