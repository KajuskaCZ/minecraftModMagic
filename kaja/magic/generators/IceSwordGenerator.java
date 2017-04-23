package kaja.magic.generators;

import java.util.Random;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class IceSwordGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		chunkX *= 16;
		chunkZ *= 16;
		if(world.provider.dimensionId == 0) {
			BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
            if(b.biomeName.equals("Taiga")) {
				for (int i = 0; i < 32; i++) {
					chunkX = chunkX + random.nextInt(16);
					int chunkY = 33 + random.nextInt(8);
					chunkZ = chunkZ + random.nextInt(16);
					
					(new WorldGenMinable(Magic.iceSword.blockID, 3)).generate(
							world, random, chunkX, chunkY, chunkZ);
				}
			}
			
		}
		
		
	}

}
