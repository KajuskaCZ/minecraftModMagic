package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMediumRaspberryBush extends BlockContainer {

	public BlockMediumRaspberryBush(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setUnlocalizedName("mediumRaspberryBush");
		setStepSound(soundGrassFootstep);
        this.setBlockBounds(0.14F, 0.0F, 0.14F, 0.88F, 0.75F, 0.88F);
        this.setTickRandomly(true);
	}

	@Override
  	public void updateTick(World world, int x, int y, int z, Random random) {
  		//if(random.nextInt(1000) < 20) {
  			world.setBlock(x, y, z, Magic.raspberryBush.blockID);
  		//}	
  	}
 	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileMediumBush();
	}
	
	@Override
	public int getRenderType() {
		return 527;
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
		return Magic.raspberrySeeds.itemID;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1;
	}

}
