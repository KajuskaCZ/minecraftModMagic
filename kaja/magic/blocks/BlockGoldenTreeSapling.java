package kaja.magic.blocks;

import java.util.List;
import java.util.Random;

import kaja.magic.Magic;
import kaja.magic.generators.GoldenTreeGenerator;
import kaja.magic.generators.MagicWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockGoldenTreeSapling extends BlockFlower {
	
	public BlockGoldenTreeSapling(int id, Material material) {
		super(id, material);

		setUnlocalizedName("goldenTreeSapling");
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		func_111022_d("magic:GoldenTreeSapling");
		
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
            	this.growTree(par1World, par2, par3, par4, par5Random);
            }
        }
    }
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
		return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Magic.goldenGrass.blockID || par1 == Magic.darkGrass.blockID;
	 }
	  
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) { 
		 
	     if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
	     Object object = new GoldenTreeGenerator();
	     
	     //sapling jde pryc
	     par1World.setBlock(par2, par3, par4, 0);
	     
	     //nepodarilo se strom vygenerovat, zustava tam sapling
	    if (!((WorldGenerator)object).generate(par1World, par5Random, par2 , par3, par4))
	     {
	    	par1World.setBlock(par2, par3, par4, this.blockID);   
	     }
	   }
}
