package kaja.magic.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockPalmTreeWood extends Block {
	Icon side, top, bottom;

	public BlockPalmTreeWood(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("palmWood");
		setCreativeTab(CreativeTabs.tabBlock);
		
		func_111022_d("magic:PalmWoodSide");
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

		bottom = par1IconRegister.registerIcon("Magic:PalmWood");
		top = par1IconRegister.registerIcon("Magic:PalmWood");
		side = par1IconRegister.registerIcon("Magic:PalmWoodSide");

	}

}
