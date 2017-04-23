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

public class SapphireDiamondChestplate extends ItemArmor{

	public SapphireDiamondChestplate(int par1,
			EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		
		setUnlocalizedName("sapphireDiamondChestplate");
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		par3List.add("Water Breathing");
		par3List.add("Full set: resistance I");
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("magic:SapphireChestplate");
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "magic:textures/models/armor/SapphireArmor1.png";
	}

}
