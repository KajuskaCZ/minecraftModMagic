package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PyramidGenerator extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

		if (canPlacePyramid(world, x, y, z)) {
			//System.out.println("tady: " + x + " " + y + " " + z);
			for(int addY = -2; addY < 1; addY++) {	
				for(int addX = -3; addX < 4; addX++) {
					for(int addZ = -3; addZ < 4; addZ++) {
						if(addY == -2) {
							if(addX == 0 && addZ == 0) {
								world.setBlock(x + addX, y - 3, z + addZ, Block.lavaStill.blockID);
								if(random.nextInt(3) == 1)
									world.setBlock(x + addX, y + addY, z + addZ, Block.blockIron.blockID);
								else
									world.setBlock(x + addX, y + addY, z + addZ, Block.blockGold.blockID);
							}
							else
								world.setBlock(x + addX, y + addY, z + addZ, Block.sandStone.blockID, 2, 2);
						}
						if(addY == -1) {
							if(addX == 0 && addZ == 0) {
								world.setBlock(x + addX, y + addY, z + addZ, Block.chest.blockID);
							
								TileEntity entity = world.getBlockTileEntity(x + addX, y + addY, z + addZ);
								if (entity instanceof IInventory) {
									//Emerald-diamod Sword
									ItemStack emeradlDiamondSword = new ItemStack(Magic.emeraldDiamondSword, 1);
									emeradlDiamondSword.addEnchantment(Enchantment.looting, 2);
									((IInventory) entity).setInventorySlotContents(4, emeradlDiamondSword);
									//Diamond
									int ran = random.nextInt(4);
									ItemStack diamond = new ItemStack(Item.diamond, ran);
									((IInventory) entity).setInventorySlotContents(21, diamond);
									//Papyrus
									ran = random.nextInt(7);
									ItemStack papyrus = new ItemStack(Magic.papyrus, ran);
									((IInventory) entity).setInventorySlotContents(14, papyrus);
									//Fire Opal Pickaxe
									ItemStack fireOpalPickaxe = new ItemStack(Magic.fireOpalPickaxe, 1);
									fireOpalPickaxe.addEnchantment(Enchantment.efficiency, 3);
									fireOpalPickaxe.addEnchantment(Enchantment.fortune, 3);
									((IInventory) entity).setInventorySlotContents(26, fireOpalPickaxe);
									
								}
							}
							else if(addX != 2 && addX != -2 && addZ != 2 && addZ != -2 && addX != 3 && addX != -3 && addZ != 3 && addZ != -3)
								world.setBlock(x + addX, y + addY, z + addZ, Block.stoneSingleSlab.blockID, 1, 2);
							else if(addX == 3 || addX == -3 || addZ == 3 || addZ == -3) {
								if(random.nextInt(8) == 1)
									world.setBlock(x + addX, y + addY, z + addZ, Magic.sandstoneHieroglyphs.blockID);
								else
									world.setBlock(x + addX, y + addY, z + addZ, Block.sandStone.blockID, 2, 2);
							}	
							else {
								if(random.nextInt(8) == 1)
									world.setBlock(x + addX, y + addY, z + addZ, Magic.sandstoneHieroglyphs.blockID);
								else
									world.setBlock(x + addX, y + addY, z + addZ, Block.sandStone.blockID, 2, 2);
							}
						}	
						if(addY == 0) {
							if(addX == 2 || addX == -2 || addZ == 2 || addZ == -2) {
								if(addX == 3 || addX == -3 || addZ == 3 || addZ == -3)
									continue;
								else {
									if(random.nextInt(8) == 1)
										world.setBlock(x + addX, y + addY, z + addZ, Magic.sandstoneHieroglyphs.blockID);
									else
										world.setBlock(x + addX, y + addY, z + addZ, Block.sandStone.blockID, 2, 2);
								}
							}
							else
								world.setBlock(x + addX, y + addY, z + addZ, 0);
						}
						
					}
				}
			}
			for(int addX = -1; addX < 2; addX++) {
				for(int addZ = -1; addZ < 2; addZ++) {
					if(addX == 0 && addZ == 0)
						continue;
					else {
						if(random.nextInt(10) == 1)
							world.setBlock(x + addX, y + 1, z + addZ,  Magic.sandstoneHieroglyphs.blockID);
						else
							world.setBlock(x + addX, y + 1, z + addZ, Block.sandStone.blockID, 2, 2);
					}
				}	
			}
			world.setBlock(x, y + 2, z, Magic.sandstoneHieroglyphs.blockID);
		}
		else
			return false;
		return true;
	}
	
	private boolean canPlacePyramid(World world, int argX, int argY, int argZ) {
		
		int blockID;
		
		for(int addX = -3; addX < 4; addX++) {
			for(int addZ = -3; addZ < 4; addZ++) {
				blockID = world.getBlockId(argX + addX, argY - 1, argZ + addZ);
				if (world.isAirBlock(argX + addX , argY - 2, argZ + addZ) || blockID == Block.waterStill.blockID)
					return false;
			}
		}
		for(int addX = -1; addX < 2; addX++) {
			for(int addZ = -1; addZ < 1; addZ++) {
				if (!world.isAirBlock(argX + addX , argY + 1, argZ + addZ))
					return false;
			}
		}
		if (!world.isAirBlock(argX, argY + 2, argZ))
			return false;
		
		return true;
	}
}
