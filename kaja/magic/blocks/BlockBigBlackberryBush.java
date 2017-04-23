package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class BlockBigBlackberryBush extends Block {

	public BlockBigBlackberryBush(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setHardness(0.2F);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("bigBlackberryBush");
		setCreativeTab(CreativeTabs.tabDecorations);
		func_111022_d("magic:Bush");
	    this.setTickRandomly(true);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        int blockID = world.getBlockId(x, y - 1, z);
        if(blockID == Block.grass.blockID || blockID == Block.dirt.blockID || blockID == Block.tilledField.blockID || blockID == Magic.goldenGrass.blockID
				|| blockID == Magic.darkGrass.blockID || blockID == Magic.bigBlackberryBush.blockID || blockID == Magic.raspberryBush.blockID 
				|| blockID == Magic.blackberryBush.blockID || blockID == Magic.raspberryBush.blockID) {
        	return true;
        }
        else
         return false;
    }

	@Override
 	public void updateTick(World world, int x, int y, int z, Random random) {
 		//if(random.nextInt(1000) < 20) {
 			world.setBlock(x, y, z, Magic.blackberryBush.blockID);
 		//}	
 	}	

	@Override
	public boolean isOpaqueCube()
	{
	    return false;
	}
}
