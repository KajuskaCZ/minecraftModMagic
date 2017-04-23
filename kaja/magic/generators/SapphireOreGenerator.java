package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SapphireOreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;
		if(world.provider.dimensionId == 0) { 
			for (int i = 0; i < 4; i++) {
				chunkX = chunkX + random.nextInt(16);
				int chunkY = random.nextInt(13);
				chunkZ = chunkZ + random.nextInt(16);
				
				(new WorldGenMinable(Magic.sapphireOre.blockID, 4)).generate(
						world, random, chunkX, chunkY, chunkZ);
				
			}
              
			
		}
		
	}

}
