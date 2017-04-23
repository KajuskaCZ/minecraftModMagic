package kaja.magic.blocks;

import java.util.ArrayList;
import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockDarkTallGrass  extends BlockFlower implements IShearable {

	public BlockDarkTallGrass(int id, Material material) {
		super(id, material);
		

		setUnlocalizedName("darkTallGrass");
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundGrassFootstep);
		func_111022_d("magic:DarkTallGrass");
	}
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Magic.goldenGrass.blockID || par1 == Magic.darkGrass.blockID;
    }
	
	public int idDropped(int par1, Random random, int par3) {
		if(random.nextInt(20) < 4)
		 	return Item.seeds.itemID;
		else return 0;  
	    }

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x,
			int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, 0));
		return ret;
	}

}
