package kaja.magic.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SapphireDiamondSword extends ItemSword {

	public SapphireDiamondSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		
		this.setUnlocalizedName("sapphireDiamondSword");
		func_111206_d("magic:AnimatedSapphirediamondSword");
		
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		par3List.add((1961 - par1ItemStack.getItemDamage()) + ":1961 uses");
		par3List.add("20% chance to slowdown mob");
	}
		
		@Override
		public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
			 Random random = new Random();
		     par1ItemStack.damageItem(1, par3EntityLivingBase);
		     if(random.nextInt(1000) < 20) {
		    	 par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 120, 0));
		     }
		     return true;
		}

}
