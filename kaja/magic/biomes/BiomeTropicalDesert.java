package kaja.magic.biomes;

import java.util.Random;

import kaja.magic.Magic;
import kaja.magic.generators.PalmTreeGenerator;
import kaja.magic.generators.PyramidGenerator;
import kaja.magic.generators.TallGrassGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeTropicalDesert extends BiomeGenBase {

	public BiomeTropicalDesert(int id) {
		super(id);

		topBlock = (byte)Block.sand.blockID;
		fillerBlock = (byte)Block.sandStone.blockID;
		setBiomeName("Tropical Desert");
		setMinMaxHeight(0.22F,0.23F);
		setTemperatureRainfall(1.2F, 0.9F);
		
		this.waterColorMultiplier = 0x7CD1FF;
		
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.cactiPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = 5;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.clayPerChunk = 0;
		this.theBiomeDecorator.reedsPerChunk = 0;
	}
	
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return new PalmTreeGenerator();
    }
	
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return new TallGrassGenerator();
    }
	
	public void decorate(World par1World, Random random, int x, int z)
    {
       super.decorate(par1World, random, x, z);
        
       if(random.nextInt(50) == 1) {
            PyramidGenerator pyramid = new PyramidGenerator();
            pyramid.generate(par1World, random, x, par1World.getHeightValue(x, z), z);
       }   
    }

}
