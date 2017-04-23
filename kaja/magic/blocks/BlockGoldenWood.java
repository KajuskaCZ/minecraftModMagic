package kaja.magic.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockGoldenWood extends Block {
	Icon side, top, bottom;
	
	public BlockGoldenWood(int id, Material material) {
		super(id, material);
		
		setHardness(2.0F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName("goldenWood");
		setCreativeTab(CreativeTabs.tabBlock);	
	}
	
	@Override
	public Icon getIcon(int i, int j) {

		switch (i) {
		case 0:
			return bottom;
		case 1:
			return top;
		default:
			return side;
		}

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {

		bottom = par1IconRegister.registerIcon("Magic:GoldenWood");
		top = par1IconRegister.registerIcon("Magic:GoldenWood");
		side = par1IconRegister.registerIcon("Magic:GoldenWoodSide");

	}
	
	
}
