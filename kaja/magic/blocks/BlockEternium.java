package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEternium extends Block {
	
	public BlockEternium(int id, Material material) {
		super(id, material);
		
		setHardness(5.0F);
		setResistance(7.0F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName("eternium");
		setCreativeTab(CreativeTabs.tabBlock);
		func_111022_d("magic:Eternium");
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Magic.eterniumPowder.itemID;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 3 + fortune;
	}

}

