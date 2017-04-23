package kaja.magic.blocks;

import java.util.Random;

import kaja.magic.Magic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockIceSword extends Block{
	Icon side, top, bottom;
	
	public BlockIceSword(int id, Material material) {
		super(id, material);
		
		setHardness(0.5F);
		setStepSound(soundGlassFootstep);
		setUnlocalizedName("iceSwords");
		setCreativeTab(CreativeTabs.tabBlock);
		slipperiness = 0.98F;
		setLightOpacity(3);
		
	}

	@Override
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	    {
	        return 1;
	    }
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Magic.brokenDiamondSword.itemID;
	}

	@Override
	public Icon getIcon(int i, int j) {
		switch(i){
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
	
		bottom = par1IconRegister.registerIcon("Magic:Ice");
		top = par1IconRegister.registerIcon("Magic:IceSwordTop");
		side = par1IconRegister.registerIcon("Magic:Ice");
	
	}
}