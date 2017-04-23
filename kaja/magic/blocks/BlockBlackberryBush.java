package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockBlackberryBush extends Block {

	public BlockBlackberryBush(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setHardness(0.0F);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("blackberrzBush");
		setCreativeTab(CreativeTabs.tabDecorations);
		func_111022_d("magic:BlackberryBush");
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {
		world.setBlock(x, y, z, Magic.bigBlackberryBush.blockID);
	}
	 
	@Override
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Magic.blackberry.itemID;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1;
	}

}
