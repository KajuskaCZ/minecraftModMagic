package kaja.magic.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockSandstoneHieroglyphs extends Block{
	Icon top, side, bottom;
	
	public BlockSandstoneHieroglyphs(int id, Material material) {
		super(id, material);
		
		setHardness(0.8F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName("sandstoneHieroglyphs");
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

		bottom = par1IconRegister.registerIcon("Magic:SandstoneHieroglyphs");
		top = par1IconRegister.registerIcon("Magic:SandstoneHieroglyphs");
		side = par1IconRegister.registerIcon("Magic:SandstoneHieroglyphsSide");

	}

}
