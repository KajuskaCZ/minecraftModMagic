package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSapphireOre extends Block {

	public BlockSapphireOre(int id, Material material) {
		super(id, material);
		
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName("sapphireOre");
		setCreativeTab(CreativeTabs.tabBlock);
		func_111022_d("magic:AnimatedSapphireOre");
		setLightValue(0.625F);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Magic.sapphire.itemID;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1 + fortune;
	}
}
