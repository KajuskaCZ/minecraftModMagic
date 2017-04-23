package kaja.magic.biomes;

import java.util.Random;

import kaja.magic.Magic;
import kaja.magic.generators.DarkTreeGenerator;
import kaja.magic.generators.TallGrassGenerator;
import kaja.magic.generators.GoldenTreeGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDarkForest extends BiomeGenBase {

	public BiomeDarkForest(int id) {
		super(id);
		
		topBlock = (byte)Magic.darkGrass.blockID;
		fillerBlock = (byte)Block.dirt.blockID;
		setBiomeName("Dark Forest");
		setMinMaxHeight(0.22F,0.25F);
		setTemperatureRainfall(0.7F, 0.8F);
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 25;
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.clayPerChunk = 0;
		this.theBiomeDecorator.reedsPerChunk = 0;
		
	}
	
	 public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	    {
	        return new DarkTreeGenerator();
	    }
	 
	 public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	    {
	        return new TallGrassGenerator();
	    }
	  

}
