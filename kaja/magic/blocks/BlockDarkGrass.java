package kaja.magic.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockDarkGrass extends Block{
	Icon side, top, bottom;

	public BlockDarkGrass(int id, Material material) {
		super(id, material);
		
		setHardness(0.6F);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("DarkGrass");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return Block.dirt.idDropped(0, par2Random, par3);
	    }
	
	@Override
	public Icon getIcon(int i, int j) {
		switch(i){
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

		bottom = par1IconRegister.registerIcon("Magic:GoldenGrassBottom");
		top = par1IconRegister.registerIcon("Magic:DarkGrassTop");
		side = par1IconRegister.registerIcon("Magic:DarkGrassSide");

	}
	
}
