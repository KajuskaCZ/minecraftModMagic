package kaja.magic.blocks;

import java.util.ArrayList;

import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockPalmTreeLeaves extends BlockLeavesBase implements IShearable {

	public BlockPalmTreeLeaves(int id, Material material) {
		super(id, material, false);
		
		setHardness(0.2F);
		setLightOpacity(1);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName("PalmLeaves");
		setCreativeTab(CreativeTabs.tabDecorations);
		func_111022_d("magic:PalmLeaves");
	}

	@Override
	public boolean isOpaqueCube()
	{
	    return false;
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
