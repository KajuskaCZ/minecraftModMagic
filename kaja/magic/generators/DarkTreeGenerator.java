package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DarkTreeGenerator extends WorldGenerator{

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		if (world.getBlockId(x, y-1, z) == Magic.darkGrass.blockID || world.getBlockId(x, y-1, z) == Magic.goldenGrass.blockID || world.getBlockId(x, y-1, z) == Block.grass.blockID ||world.getBlockId(x, y-1, z) ==  Block.dirt.blockID) {
			if (canPlaceTree(world, x, y, z)) {
				//System.out.println("tady " + x + " " + y + " " + z);

				if(random.nextInt(20) > 1) {
					int treeHeight = 4 + random.nextInt(4);
					for(int addY = 0; addY < treeHeight +1; addY++) {
						world.setBlock(x, y + addY, z, Magic.darkWood.blockID);	
					}
					
					for(int addX = -1; addX < 2; addX++) {
			            for(int addZ = -1; addZ <2; addZ++) {
			            	if(addX == 0 || addZ == 0) {
			            	world.setBlock(x + addX, y + treeHeight + 1, z + addZ, Magic.darkTreeLeaves.blockID);
			            	}
			            }
			        }
					
					for(int addX = -1; addX < 2; addX++) {
			            for(int addZ = -1; addZ <2; addZ++) {
			            	if(addX == 0 && addZ == 0)
			            		continue;
			            	if(addX == 0 || addZ == 0) {
			            		world.setBlock(x + addX, y + treeHeight, z + addZ, Magic.darkTreeLeaves.blockID);
			            	}
			            	if(random.nextInt(20) < 11) {
			            		world.setBlock(x + addX, y + treeHeight, z + addZ, Magic.darkTreeLeaves.blockID);	
			            	}
			            }
			        }
					
					for(int addY = treeHeight -1; addY > treeHeight - 3; addY--)
						{
						for(int addX = -2; addX < 3; addX++) {
				            for(int addZ = -2; addZ <3; addZ++) {
				            	if(addX == 0 && addZ == 0)
				            		continue;
				            	if((addZ == 2 && addX == 2) || (addZ == -2 && addX == -2) || (addZ == 2 && addX == -2) || (addZ == -2 && addX == 2)) {
				            		if(random.nextInt(20) < 11)
				            			continue;	
				            	}
				            	world.setBlock(x + addX, y + addY, z + addZ, Magic.darkTreeLeaves.blockID);	
				            }
				        }
					}
				}
				
				else {
					int treeHeight = 5 + random.nextInt(2);
					for(int addY = 0; addY < treeHeight +1; addY++) {
						world.setBlock(x, y + addY, z, Magic.darkWood.blockID);	
					
					}
					
					for(int addX = -1; addX < 2; addX++) {
			            for(int addZ = -1; addZ <2; addZ++) {
			            	if(addX == 0 || addZ == 0) {
			            	world.setBlock(x + addX, y + treeHeight + 1, z + addZ, Magic.darkTreeLeaves.blockID);
			            	}
			            }
			        }
					
					for(int addY = 0; addY < 3; addY++) {
						for(int addX = -2; addX < 3; addX++) {
				            for(int addZ = -2; addZ < 3; addZ++) {
				            	if(addY == 1) continue;
				            	if(addX == 0 && addZ == 0)
				            		continue;
				            	if(addX == 0 || addZ == 0) {
				            		world.setBlock(x + addX, y + treeHeight - addY, z + addZ, Magic.darkTreeLeaves.blockID);
				            	}
				            	if((addX == 1 && addZ == 1) || (addX == -1 && addZ == -1) || (addX == 1 && addZ == -1) || (addX == -1 && addZ == 1)) {
				            		world.setBlock(x + addX, y + treeHeight - addY, z + addZ, Magic.darkTreeLeaves.blockID);	
				            	}
				            }
				        }
					}
					
					for(int addX = -2; addX < 3; addX++) {
			            for(int addZ = -2; addZ < 3; addZ++) {
			            	if(addX == 0 && addZ == 0)
			            		continue;
			            	if((addZ == 2 && addX == 2) || (addZ == -2 && addX == -2) || (addZ == 2 && addX == -2) || (addZ == -2 && addX == 2)) {
			            		continue;
			            	}
			            	world.setBlock(x + addX, y + treeHeight - 1, z + addZ, Magic.darkTreeLeaves.blockID);	
			            }
			        }
					
					for(int addX = -1; addX < 2; addX++) {
			            for(int addZ = -1; addZ <2; addZ++) {
			            	if(addX == 0 && addZ == 0)
			            		continue;
			            	if(addX == 0 || addZ == 0) {
			            	world.setBlock(x + addX, y + treeHeight - 3, z + addZ, Magic.darkTreeLeaves.blockID);
			            	}
			            }
			        }
				}	
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		return true;
	}

	private boolean canPlaceTree(World world, int argX, int argY, int argZ) {
		for (int y = 1; y < 3; y++) {
			if (!world.isAirBlock(argX, argY + y, argZ))
				return false;
		}
		
		for (int x = -2; x < 3; x++) {
			for (int z = -2; z < 3; z++) {
				for (int y = 3; y < 9; y++) {
					if (!world.isAirBlock(argX + x, argY + y, argZ + z))
						return false;
				}
			}
		}
		return true;
	}
}
