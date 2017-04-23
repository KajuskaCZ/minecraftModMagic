package kaja.magic.items;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlackberrySeeds extends Item {

	public BlackberrySeeds(int par1) {
		super(par1);

		maxStackSize = 64;
		setUnlocalizedName("blackberrySeeds");
		setCreativeTab(CreativeTabs.tabMaterials);
		func_111206_d("magic:BlackberrySeeds");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, 
			int x, int y, int z, int side, float par8, float par9, float par10) {
		
		int blockID = world.getBlockId(x, y, z);
		if(blockID == Block.grass.blockID || blockID == Block.dirt.blockID || blockID == Block.tilledField.blockID || blockID == Magic.goldenGrass.blockID
				|| blockID == Magic.darkGrass.blockID) {
			if(side == 1) {
				blockID = world.getBlockId(x, y + 1, z);
				if(blockID == 0) {
					world.setBlock(x, y + 1, z, Magic.smallestBlackberryBush.blockID);
					--itemStack.stackSize;
					return true;
				}
			}
		}
        return false;
    }
}
