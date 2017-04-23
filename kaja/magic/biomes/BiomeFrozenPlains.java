package kaja.magic.biomes;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeFrozenPlains extends BiomeGenBase {

	public BiomeFrozenPlains(int id) {
		super(id);
		
		topBlock = (byte)Block.blockSnow.blockID;
		fillerBlock = (byte)Block.ice.blockID;
		setBiomeName("Frozen Plains");
		setMinMaxHeight(0.20F,0.22F);
		setTemperatureRainfall(0.0F, 0.5F);
		
	}
	

}
