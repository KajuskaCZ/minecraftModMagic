package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PalmTreeGenerator extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		int ran = random.nextInt(20);
		if(ran > 12) {
			if(canPlaceBigTree(world, x, y, z)) {
				if (world.getBlockId(x, y-1, z) == Block.sand.blockID || world.getBlockId(x, y-1, z) == Magic.goldenGrass.blockID 
						|| world.getBlockId(x, y-1, z) == Block.grass.blockID ||world.getBlockId(x, y-1, z) ==  Block.dirt.blockID 
						|| world.getBlockId(x, y-1, z) == Magic.darkGrass.blockID) {
					int[] X = {0, -1, -1, 0, 0, -1, 0, 0, 0, 0, 1, 1, 1, 1, 5, -5, -1};
					int[] Y = {0, 0, 0, 1, 1, 1, 2, 2, 3, 4, 4, 5, 6};
					int[] Z = {0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 2, 2, 2, 7, 2, 3, -2};
					
					for(int i = 0; i < 13; i++) {
						world.setBlock(x + X[i], y + Y[i], z + Z[i], Magic.palmTreeWood.blockID);
					}
					
					for(int addY = 6; addY < 10; addY++) {
						if(addY == 9) {
							for(int addX = -2; addX < 3;addX++) {
								for(int addZ = 1; addZ < 6; addZ++) {
									if(addX == 0 && addZ == 3)
										world.setBlock(x + addX, y + addY, z + 3, Magic.palmTreeWood.blockID);
									else if((addX == 0 || addZ == 3) || ((addX == -1 || addX == 1) && (addZ == 4) || (addZ == 2))) {
										world.setBlock(x + addX, y + addY, z + addZ, Magic.palmTreeLeaves.blockID);
									}
								}
							}
						}
						else if(addY == 8) {
							for(int addX = -1; addX < 2;addX++) {
								for(int addZ = 2; addZ < 5; addZ++) {
									if(addX == 0 && addZ == 3)
										world.setBlock(x + addX, y + addY, z + 3, Magic.palmTreeWood.blockID);
									else if(addX == 0 || addZ == 3) {
										world.setBlock(x + addX, y + addY, z + addZ, Magic.palmTreeLeaves.blockID);
									}
								}
							}	
						}
						else	
							world.setBlock(x, y + addY, z + 3, Magic.palmTreeWood.blockID);
					}
					
					for(int addY = 10; addY < 12; addY++) {
						if(addY == 11) {
							for(int addX = -2; addX < 3; addX++) {
								if(addX == 0){
									for(int addZ = 1; addZ < 6; addZ++) {
										world.setBlock(x, y + addY, z + addZ, Magic.palmTreeLeaves.blockID);
									}	
								}
								else
									world.setBlock(x + addX, y + addY, z + 3, Magic.palmTreeLeaves.blockID);		
							}
						}
						else {
							for(int addX = -3; addX < 4; addX ++) {
								for(int addZ = 0; addZ < 7; addZ++) {
									if((addX == 0 && (addZ != 0 || addZ != 6)) || (addZ == 3 && (addX != -3 || addX != 3))) {
										for(int XX = -2; XX < 3; XX++) {
											if(XX == 0){
												for(int ZZ = 1; ZZ < 6; ZZ++) {
													world.setBlock(x, y + addY, z + ZZ, Magic.palmTreeWood.blockID);
												}	
											}
											else
												world.setBlock(x + XX, y + addY, z + 3, Magic.palmTreeWood.blockID);	
										}
									}
									else
										if((addX == 3 || addX == -3) && (addZ == 6 || addZ == 0))
											continue;
										if(((addX == -3 || addX == 3) && (addZ == 5 || addZ == 1)) || ((addZ == 0 || addZ == 6) && (addX == 2 || addX == -2)))
											continue;
										world.setBlock(x + addX, y + addY, z + addZ, Magic.palmTreeLeaves.blockID);
								}
							}
						}
					}
					
					int[] X1 = {-2, -3, 3, 1, -2, 3, 4, 4, -4, -3, -4, -3, 2, 3, 2, -1, -3, 4, -4, 3};
					int[] Z1 = {6, 6, 6, 7, 7, 5, 5, 2, 3, 1, 1, 0, 0, 0, -1, -1, 7, 6, 0, -1};
					
					for(int i = 0; i < 20; i++) {
						if(i >= 16 && i < 20) {
							for(int addY = 6; addY < 9; addY ++) {
								world.setBlock(x + X1[i], y + addY, z + Z1[i], Magic.palmTreeLeaves.blockID);
							}		
						}
						else
							world.setBlock(x + X1[i], y + 9, z + Z1[i], Magic.palmTreeLeaves.blockID);
					}
					
					for(int i = 13; i < 17; i++) {
						for(int addY = 7; addY < 9; addY++) {
							world.setBlock(x + X[i], y + addY, z + Z[i], Magic.palmTreeLeaves.blockID);
						}
					}
				}
				else
					return false;
			}
			else
				return false;
			}
		
		else if(ran <= 12 && ran > 5) {
			if(canPlaceStraightTree(world, x, y, z)) {
				if (world.getBlockId(x, y-1, z) == Block.sand.blockID || world.getBlockId(x, y-1, z) == Magic.goldenGrass.blockID 
						|| world.getBlockId(x, y-1, z) == Block.grass.blockID ||world.getBlockId(x, y-1, z) ==  Block.dirt.blockID 
						|| world.getBlockId(x, y-1, z) == Magic.darkGrass.blockID) {
						int treeHeight = 9 + random.nextInt(3);
						
						for(int addY = 0; addY < treeHeight + 1; addY++) {
							world.setBlock(x, y + addY, z, Magic.palmTreeWood.blockID);
						}
						world.setBlock(x, y + treeHeight + 1, z, Magic.palmTreeLeaves.blockID);
						
						for(int addX = -2; addX < 3; addX++) {
							for(int addZ = -2; addZ < 3; addZ++) {
								if(addZ == 0 && addX == 0)
									continue;
								if(addZ == 0 || addX == 0)
									world.setBlock(x + addX, y + treeHeight, z + addZ, Magic.palmTreeLeaves.blockID);
							}
						}
						
						for(int addY = -2; addY < 0; addY++) {
							for(int addX = -1; addX < 2; addX++) {
								for(int addZ = -1; addZ < 2; addZ++) {
									if(addZ == 0 && addX == 0)
										continue;
									if(addY == -1) {
										if(addZ == 0 || addX == 0)
											world.setBlock(x + addX, y + treeHeight + addY, z + addZ, Magic.palmTreeWood.blockID);
										else
											world.setBlock(x + addX, y + treeHeight + addY, z + addZ, Magic.palmTreeLeaves.blockID);
									}
									else
										if(addZ == 0 || addX == 0)
											world.setBlock(x + addX, y + treeHeight + addY, z + addZ, Magic.palmTreeLeaves.blockID);
								}
							}
						}
						
						for(int addX = -2; addX < 3; addX++) {
							for(int addZ = -2; addZ < 3; addZ++) {
								if((addX == 0 && (addZ == -2 || addZ == 2)) || (addZ == 0 && (addX == -2 || addX == 2)))
									world.setBlock(x + addX, y + treeHeight - 1, z + addZ, Magic.palmTreeLeaves.blockID);
							}
						}
						
						int[] addX = {0, -2, 2, -3, 3, -2, 2, 0};
						int[] addZ = {3, 2, 2, 0, 0, -2, -2, -3};
						
						for(int addY = treeHeight -3; addY < treeHeight; addY++) {
							for(int i = 0; i < 8; i++) {
								world.setBlock(x + addX[i], y + addY, z + addZ[i], Magic.palmTreeLeaves.blockID);
							}
						}	
					
				}
				else 
					return false;
			}
			else
				return false;
		}
		
		else if(ran <= 5) {
			if(canPlaceTree(world, x, y, z)) {
				if (world.getBlockId(x, y-1, z) == Block.sand.blockID || world.getBlockId(x, y-1, z) == Magic.goldenGrass.blockID 
						|| world.getBlockId(x, y-1, z) == Block.grass.blockID ||world.getBlockId(x, y-1, z) ==  Block.dirt.blockID 
						|| world.getBlockId(x, y-1, z) == Magic.darkGrass.blockID) {
					for(int addY = 0; addY < 11; addY++) {
						if(addY < 3) {
							world.setBlock(x, y + addY, z, Magic.palmTreeWood.blockID);
						}
						if(addY > 1 && addY < 5) {
							world.setBlock(x + 1, y + addY, z, Magic.palmTreeWood.blockID);
						}
						if(addY > 3 && addY < 6) {
							world.setBlock(x + 2, y + addY, z, Magic.palmTreeWood.blockID);
						}
						if(addY > 4) {
							world.setBlock(x + 3, y + addY, z, Magic.palmTreeWood.blockID);
						}	
					}
					world.setBlock(x + 3, y + 11, z, Magic.palmTreeLeaves.blockID);
					
					for(int addX = 1; addX < 6; addX++) {
						for(int addZ = -2; addZ < 3; addZ++) {
							if(addZ == 0 && addX == 3)
								continue;
							if(addZ == 0 || addX == 3)
								world.setBlock(x + addX, y + 10, z + addZ, Magic.palmTreeLeaves.blockID);
						}
					}
					
					for(int addY = -2; addY < 0; addY++) {
						for(int addX = 2; addX < 5; addX++) {
							for(int addZ = -1; addZ < 2; addZ++) {
								if(addZ == 0 && addX == 3)
									continue;
								if(addY == -1) {
									if(addZ == 0 || addX == 3)
										world.setBlock(x + addX, y + 10 + addY, z + addZ, Magic.palmTreeWood.blockID);
									else
										world.setBlock(x + addX, y + 10 + addY, z + addZ, Magic.palmTreeLeaves.blockID);
								}
								else
									if(addZ == 0 || addX == 3)
										world.setBlock(x + addX, y + 10 + addY, z + addZ, Magic.palmTreeLeaves.blockID);
							}
						}
					}
					
					for(int addX = 1; addX < 6; addX++) {
						for(int addZ = -2; addZ < 3; addZ++) {
							if((addX == 3 && (addZ == -2 || addZ == 2)) || (addZ == 0 && (addX == 1 || addX == 5)))
								world.setBlock(x + addX, y + 9, z + addZ, Magic.palmTreeLeaves.blockID);
						}
					}
					
					int[] addX = {3, 1, 5, 0, 6, 1, 5, 3};
					int[] addZ = {3, 2, 2, 0, 0, -2, -2, -3};
					
					for(int addY = 7; addY < 10; addY++) {
						for(int i = 0; i < 8; i++) {
							world.setBlock(x + addX[i], y + addY, z + addZ[i], Magic.palmTreeLeaves.blockID);
						}
					}	
				}
				else
					return false;
			}
			else
				return false;
			
		}
		
		return true;
	}
	
	private boolean canPlaceBigTree(World world, int argX, int argY, int argZ) {
			
			int blockID;
			
			int[] x = {0, -1, -1};
			int[] z = {0, 0, 1};
			
			for(int i = 0; i < 3; i++) {
				blockID = world.getBlockId(argX + x[i], argY - 1, argZ + z[i]);
				if (!(blockID == Block.sand.blockID || blockID == Block.dirt.blockID || blockID == Block.grass.blockID 
						|| blockID == Magic.goldenGrass.blockID || blockID == Magic.darkGrass.blockID)) {
					return false;
				}
			}
			
			for(int addY = 5; addY < 13; addY++) {
				for(int addX = -6; addX < 7; addX++) {
					for(int addZ = -3; addZ < 9; addZ++) {
						if (!world.isAirBlock(argX + addX , argY + addY, argZ + addZ))
							return false;
					}
				}
			}
			return true;
	}
	
	private boolean canPlaceStraightTree(World world, int argX, int argY, int argZ) {
		for(int addY = 5; addY < 11; addY++) {
			for(int addX = -3; addX < 4; addX++) {
				for(int addZ = -3; addZ < 4; addZ++) {
					if (!world.isAirBlock(argX + addX , argY + addY, argZ + addZ))
						return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean canPlaceTree(World world, int argX, int argY, int argZ) {
		for(int addY = 5; addY < 11; addY++) {
			for(int addX = 0; addX < 7; addX++) {
				for(int addZ = -3; addZ < 4; addZ++) {
					if (!world.isAirBlock(argX + addX , argY + addY, argZ + addZ))
						return false;
				}
			}
		}
		return true;
	}
}
