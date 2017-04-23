package kaja.magic.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FireOpalChestplate extends ItemArmor {

	public FireOpalChestplate(int par1,
			EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		
		setUnlocalizedName("fireOpalChestPlate");
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		par3List.add("Fire resistant");
		par3List.add("1% chance to heal");
		par3List.add("Full set: resistance II");
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("magic:FireOpalChestplate");
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "magic:textures/models/armor/FireOpalArmor1.png";
	}

}