package kaja.magic.blocks;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockRedOrchid extends BlockFlower {

	public BlockRedOrchid(int id, Material material) {
		super(id, material);
		

		setUnlocalizedName("redOrchid");
		float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.6F + f, 0.7F, 0.6F + f);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundGrassFootstep);
		func_111022_d("magic:RedOrchid");
	}
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
	        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Magic.goldenGrass.blockID || par1 == Magic.darkGrass.blockID;
	}

}
