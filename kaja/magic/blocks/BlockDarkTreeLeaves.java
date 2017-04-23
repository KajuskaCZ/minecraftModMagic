package kaja.magic.blocks;

import java.util.ArrayList;
import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockDarkTreeLeaves extends BlockLeavesBase implements IShearable {

	public BlockDarkTreeLeaves(int id, Material material) {
		super(id, material, false);
		
		setHardness(0.2F);
		setLightOpacity(1);
		this.setUnlocalizedName("darkTreeLeaves");
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("darkTreeLeaves");
		setCreativeTab(CreativeTabs.tabDecorations);
		func_111022_d("magic:DarkTreeLeaves");
	}
	
	@Override
	public boolean isOpaqueCube()
	{
	    return false;
	}

	@Override
	public int idDropped(int par1, Random random, int par3) {
		if(random.nextInt(20) == 1) {
			return Item.appleGold.itemID;
		}
		else if(random.nextInt(20) == 1) {
			return Magic.goldenTreeSapling.blockID;
		
		}
		return 0;
		
	}

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList();
		ret.add(new ItemStack(this, 1, 0));
		return ret;
	}

}
