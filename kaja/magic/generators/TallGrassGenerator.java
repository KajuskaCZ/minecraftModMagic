package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;



public class TallGrassGenerator extends WorldGenerator {
   
    public boolean generate(World world, Random random, int x, int y, int z)
    {
    	BiomeGenBase b = world.getBiomeGenForCoords(x, z);
    	if(b.biomeName.equals("Tropical Desert")) {
    		if (world.isAirBlock(x, world.getHeightValue(x, z), z) && Block.blocksList[Magic.desertRoseFlower.blockID].canBlockStay(world, x, world.getHeightValue(x, z), z)) {
    			if(random.nextInt(20) == 1) {
    				world.setBlock(x, world.getHeightValue(x, z), z, Magic.desertRoseFlower.blockID);
    			}
    		}
    	}

    	else if (world.isAirBlock(x, world.getHeightValue(x, z), z) && Block.blocksList[Magic.goldenTallGrass.blockID].canBlockStay(world, x, world.getHeightValue(x, z), z))
        {
        	if(b.biomeName.equals("Golden Forest")) {
            	if(random.nextInt(20) == 1)
            		 world.setBlock(x, world.getHeightValue(x, z), z, Magic.redOrchid.blockID);
            	else
                world.setBlock(x, world.getHeightValue(x, z), z, Magic.goldenTallGrass.blockID);
        	}
        	
        	if(b.biomeName.equals("Dark Forest")) {
        		if(random.nextInt(20) == 1)
            		 world.setBlock(x, world.getHeightValue(x, z), z, Magic.whiteOrchid.blockID);
            	else
            		world.setBlock(x, world.getHeightValue(x, z), z, Magic.darkTallGrass.blockID);
        	}
        }
    	return true;
    }
}
