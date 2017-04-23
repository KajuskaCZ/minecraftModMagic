package kaja.magic.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockDarkWood extends Block {
	Icon side, top, bottom;

	public BlockDarkWood(int id, Material material) {
		super(id, material);

		setHardness(2.0F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("darkWood");
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
	@Override
	public Icon getIcon(int i, int j) {

		switch (i) {
		case 0:
			return bottom;
		case 1:
			return top;
		default:
			return side;
		}

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {

		bottom = par1IconRegister.registerIcon("Magic:DarkWood");
		top = par1IconRegister.registerIcon("Magic:DarkWood");
		side = par1IconRegister.registerIcon("Magic:DarkWoodSide");

	}

}
