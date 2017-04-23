package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class FireOpalOreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;
		if(world.provider.dimensionId == 0) {
			BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
            if(b.biomeName.equals("Golden Forest") || b.biomeName.equals("Dark Forest")) {
				for (int i = 0; i < 4; i++) {
					chunkX = chunkX + random.nextInt(16);
					int chunkY = random.nextInt(13);
					chunkZ = chunkZ + random.nextInt(16);
					
					(new WorldGenMinable(Magic.fireOpalOre.blockID, 4)).generate(
							world, random, chunkX, chunkY, chunkZ);
				}
			}
			
		}
		
	}

}
