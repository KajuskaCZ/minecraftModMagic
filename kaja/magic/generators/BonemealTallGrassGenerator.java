package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BonemealTallGrassGenerator extends WorldGenerator{

	@Override
	public boolean generate(World world, Random random, int argX, int argY, int argZ) {
		Block block;
		int blockID;
		
			for(int addX = -1; addX < 2; addX++) {
				for(int addZ = -1; addZ < 2; addZ++) {
					block = Block.blocksList[world.getBlockId(argX + addX, argY + 1, argZ + addZ)];
					blockID = world.getBlockId(argX + addX, argY, argZ + addZ);
					if((addX == -1 && addZ == -1) || (addX == 1 && addZ == -1))
						continue;
					if(block == null && blockID == Magic.goldenGrass.blockID) {
						if(random.nextInt(20) == 1)
							world.setBlock(argX + addX, argY + 1, argZ + addZ, Magic.redOrchid.blockID);	
						else
							world.setBlock(argX + addX, argY + 1, argZ + addZ, Magic.goldenTallGrass.blockID);	
					}
					else if(block == null && blockID == Magic.darkGrass.blockID) {
						if(random.nextInt(20) == 1)
							world.setBlock(argX + addX, argY + 1, argZ + addZ, Magic.whiteOrchid.blockID);	
						else
							world.setBlock(argX + addX, argY + 1, argZ + addZ, Magic.darkTallGrass.blockID);
					}
				}	
			}
			
			int[] addX = {-2, 1, 2, 2};
			int[] addZ = {-1, 2, 1, -1};
			
			for(int i = 0; i < 4; i++) {
				block = Block.blocksList[world.getBlockId(argX + addX[i], argY + 1, argZ + addZ[i])];
				blockID = world.getBlockId(argX + addX[i], argY, argZ + addZ[i]);
				if(block == null && blockID == Magic.goldenGrass.blockID) {
					if(random.nextInt(20) == 1)
						world.setBlock(argX + addX[i], argY + 1, argZ + addZ[i], Magic.redOrchid.blockID);	
					else
						world.setBlock(argX + addX[i], argY + 1, argZ + addZ[i], Magic.goldenTallGrass.blockID);	
				}
				else if(block == null && blockID == Magic.darkGrass.blockID) {
					if(random.nextInt(20) == 1)
						world.setBlock(argX + addX[i], argY + 1, argZ + addZ[i], Magic.whiteOrchid.blockID);	
					else
						world.setBlock(argX + addX[i], argY + 1, argZ + addZ[i], Magic.darkTallGrass.blockID);	
				}
			}
			
			
		
		return true;
	}

}
