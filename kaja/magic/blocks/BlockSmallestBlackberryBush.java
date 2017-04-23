package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSmallestBlackberryBush extends BlockContainer {

	public BlockSmallestBlackberryBush(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setUnlocalizedName("smallestBlackberryBush");
		setStepSound(soundGrassFootstep);
        this.setBlockBounds(0.35F, 0.0F, 0.35F, 0.65F, 0.25F, 0.65F);
        this.setTickRandomly(true);
	}

	@Override
  	public void updateTick(World world, int x, int y, int z, Random random) {
  		//if(random.nextInt(1000) < 20) {
  			world.setBlock(x, y, z, Magic.smallBlackberryBush.blockID);
  		//}	
  	}
 	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileSmallestBush();
	}
	
	@Override
	public int getRenderType() {
		return 523;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Magic.blackberrySeeds.itemID;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1;
	}

}
