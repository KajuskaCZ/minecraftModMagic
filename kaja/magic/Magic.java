package kaja.magic;

import java.util.Random;

import kaja.magic.biomes.BiomeDarkForest;
import kaja.magic.biomes.BiomeFrozenPlains;
import kaja.magic.biomes.BiomeGoldenForest;
import kaja.magic.biomes.BiomeTropicalDesert;
import kaja.magic.blocks.BlockAutominer;
import kaja.magic.blocks.BlockBigRaspberryBush;
import kaja.magic.blocks.BlockBlackberryBush;
import kaja.magic.blocks.BlockBigBlackberryBush;
import kaja.magic.blocks.BlockDarkGrass;
import kaja.magic.blocks.BlockDarkTallGrass;
import kaja.magic.blocks.BlockDarkTreeLeaves;
import kaja.magic.blocks.BlockDarkTreeSapling;
import kaja.magic.blocks.BlockDarkWood;
import kaja.magic.blocks.BlockDesertRoseFlower;
import kaja.magic.blocks.BlockEternium;
import kaja.magic.blocks.BlockFireOpalOre;
import kaja.magic.blocks.BlockGoldenGrass;
import kaja.magic.blocks.BlockGoldenTallGrass;
import kaja.magic.blocks.BlockGoldenTreeSapling;
import kaja.magic.blocks.BlockGoldenWood;
import kaja.magic.blocks.BlockIceSword;
import kaja.magic.blocks.BlockMediumBlackberryBush;
import kaja.magic.blocks.BlockMediumRaspberryBush;
import kaja.magic.blocks.BlockPalmTreeLeaves;
import kaja.magic.blocks.BlockPalmTreeSapling;
import kaja.magic.blocks.BlockPalmTreeWood;
import kaja.magic.blocks.BlockRaspberryBush;
import kaja.magic.blocks.BlockRedOrchid;
import kaja.magic.blocks.BlockSandstoneHieroglyphs;
import kaja.magic.blocks.BlockGoldenTreeLeaves;
import kaja.magic.blocks.BlockSapphireOre;
import kaja.magic.blocks.BlockSmallBlackberryBush;
import kaja.magic.blocks.BlockSmallRaspberryBush;
import kaja.magic.blocks.BlockSmallestBlackberryBush;
import kaja.magic.blocks.BlockSmallestRaspberryBush;
import kaja.magic.blocks.BlockWhiteOrchid;
import kaja.magic.generators.EterniumGenerator;
import kaja.magic.generators.FireOpalOreGenerator;
import kaja.magic.generators.IceSwordGenerator;
import kaja.magic.generators.MagicWorldGenerator;
import kaja.magic.generators.SapphireOreGenerator;
import kaja.magic.gui.GUIHandler;
import kaja.magic.items.Blackberry;
import kaja.magic.items.BlackberrySeeds;
import kaja.magic.items.BrokenDiamondSword;
import kaja.magic.items.EmeraldDiamodChestplate;
import kaja.magic.items.EmeraldDiamondAxe;
import kaja.magic.items.EmeraldDiamondBoots;
import kaja.magic.items.EmeraldDiamondHelmet;
import kaja.magic.items.EmeraldDiamondHoe;
import kaja.magic.items.EmeraldDiamondLeggins;
import kaja.magic.items.EmeraldDiamondPickaxe;
import kaja.magic.items.EmeraldDiamondShovel;
import kaja.magic.items.EmeraldDiamondSword;
import kaja.magic.items.EmeraldGem;
import kaja.magic.items.FireOpal;
import kaja.magic.items.FireOpalAxe;
import kaja.magic.items.FireOpalBoots;
import kaja.magic.items.FireOpalChestplate;
import kaja.magic.items.FireOpalGem;
import kaja.magic.items.EterniumPowder;
import kaja.magic.items.FireOpalHelmet;
import kaja.magic.items.FireOpalLeggins;
import kaja.magic.items.FireOpalPickaxe;
import kaja.magic.items.FireOpalShovel;
import kaja.magic.items.FireOpalSword;
import kaja.magic.items.Papyrus;
import kaja.magic.items.Raspberry;
import kaja.magic.items.RaspberrySeeds;
import kaja.magic.items.FireOpalHoe;
import kaja.magic.items.Sapphire;
import kaja.magic.items.SapphireDiamondAxe;
import kaja.magic.items.SapphireDiamondBoots;
import kaja.magic.items.SapphireDiamondChestplate;
import kaja.magic.items.SapphireDiamondHelmet;
import kaja.magic.items.SapphireDiamondHoe;
import kaja.magic.items.SapphireDiamondLeggins;
import kaja.magic.items.SapphireDiamondPickaxe;
import kaja.magic.items.SapphireDiamondShovel;
import kaja.magic.items.SapphireDiamondSword;
import kaja.magic.items.SapphireGem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "magic", name = "Magic", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Magic {
	@Mod.Instance("magic")
	public static Magic instance = new Magic();
	
	@SidedProxy(clientSide = "kaja.magic.ClientProxy", serverSide = "kaja.magic.CommonProxy")
	public static CommonProxy proxy;
	
	//Blocks
	
	public static Block goldenGrass = new BlockGoldenGrass(180, Material.grass);
	public static Block darkGrass = new BlockDarkGrass(181, Material.grass);

	public static Block eternium = new BlockEternium(501, Material.rock);
	public static Block sandstoneHieroglyphs = new BlockSandstoneHieroglyphs(502, Material.rock);
	public static Block goldenTreeLeaves = new BlockGoldenTreeLeaves(503, Material.leaves);
	public static Block iceSword = new BlockIceSword(504, Material.ice);
	public static Block raspberryBush = new BlockRaspberryBush(505, Material.plants);
	public static Block blackberryBush = new BlockBlackberryBush(506, Material.plants);
	public static Block goldenTallGrass = new BlockGoldenTallGrass(507, Material.vine);
	public static Block redOrchid = new BlockRedOrchid(508, Material.plants);
	public static Block goldenTreeSapling = new BlockGoldenTreeSapling(509, Material.plants);
	public static Block darkTreeLeaves = new BlockDarkTreeLeaves(510, Material.leaves);
	public static Block darkWood = new BlockDarkWood(511, Material.wood);
	public static Block goldenWood = new BlockGoldenWood(512, Material.wood);
	public static Block darkTallGrass = new BlockDarkTallGrass(513, Material.vine);
	public static Block whiteOrchid = new BlockWhiteOrchid(514, Material.plants);
	public static Block palmTreeWood = new BlockPalmTreeWood(515, Material.wood);
	public static Block palmTreeLeaves = new BlockPalmTreeLeaves(516, Material.leaves);
	public static Block dark = new BlockDarkTreeSapling(517, Material.plants);
	public static Block desertRoseFlower = new BlockDesertRoseFlower(518, Material.plants);
	public static Block sapphireOre = new BlockSapphireOre(519, Material.rock);
	public static Block fireOpalOre = new BlockFireOpalOre(520, Material.rock);
	public static Block palmTreeSapling = new BlockPalmTreeSapling(521, Material.plants);
	public static Block autominer = new BlockAutominer(522, Material.rock);
	public static Block smallestBlackberryBush = new BlockSmallestBlackberryBush(523, Material.plants);
	public static Block smallBlackberryBush = new BlockSmallBlackberryBush(524, Material.plants);
	public static Block mediumBlackberryBush = new BlockMediumBlackberryBush(525, Material.plants);
	public static Block bigBlackberryBush = new BlockBigBlackberryBush(526, Material.plants);
	public static Block smallestRaspberryBush = new BlockSmallestRaspberryBush(527, Material.plants);
	public static Block smallRaspberryBush = new BlockSmallRaspberryBush(528, Material.plants);
	public static Block mediumRaspberryBush = new BlockMediumRaspberryBush(529, Material.plants);
	public static Block bigRaspberryBush = new BlockBigRaspberryBush(530, Material.plants);
	
	//Materials
	//8 a 3
	public static EnumToolMaterial fireOpalToolMaterial = EnumHelper.addToolMaterial("FIREOPAL", 3, 2341, 12.0F, 7.0F, 10);
	public static EnumToolMaterial sapphireToolMaterial = EnumHelper.addToolMaterial("SAPPHIRE", 3, 1961, 10.0F, 4.0F, 10);
	public static EnumToolMaterial emeraldToolMaterial = EnumHelper.addToolMaterial("EMERALDTOOL", 3, 2061, 9.0F, 5.0F, 10);
	
	public static EnumArmorMaterial fireOpalArmorMaterial = EnumHelper.addArmorMaterial("FIREOPAL", 124, new int[] {3, 7, 6, 3}, 10);
	public static EnumArmorMaterial sapphireArmorMaterial = EnumHelper.addArmorMaterial("SAPPHIRE", 67, new int[] {3, 7, 6, 3}, 10);
	public static EnumArmorMaterial emeraldArmorMaterial = EnumHelper.addArmorMaterial("EMERALDARMOR", 67, new int[] {3, 7, 6, 3}, 10);
	
	//Items
	
	public static Item eterniumPowder = new EterniumPowder(5001);
	public static Item papyrus = new Papyrus(5002);
	public static Item brokenDiamondSword = new BrokenDiamondSword(5003);
	public static Item raspberry = new Raspberry(5004, 2, 0.4F, false);
	public static Item raspberrySeeds = new RaspberrySeeds(5005);
	public static Item blackberry = new Blackberry(5006, 2, 0.4F, false);
	public static Item blackberrySeeds = new BlackberrySeeds(5007);
	public static Item fireOpalHoe = new FireOpalHoe(5008, fireOpalToolMaterial);
	public static Item fireOpalGem = new FireOpalGem(5009);
	public static Item fireOpal = new FireOpal(5010);
	public static Item emeraldGem = new EmeraldGem(5011);
	public static Item sapphireGem = new SapphireGem(5012);
	public static Item sapphire = new Sapphire(5013);
	public static Item sapphireDiamondHelmet = new SapphireDiamondHelmet(5014, sapphireArmorMaterial, ModLoader.addArmor("sapphire"), 0);
	public static Item sapphireDiamondChestplate = new SapphireDiamondChestplate(5015, sapphireArmorMaterial, ModLoader.addArmor("sapphire"), 1);
	public static Item sapphireDiamondLeggins = new SapphireDiamondLeggins(5016, sapphireArmorMaterial, ModLoader.addArmor("sapphire"), 2);
	public static Item sapphireDiamondBoots = new SapphireDiamondBoots(5017, sapphireArmorMaterial, ModLoader.addArmor("sapphire"), 3);
	public static Item emeraldDiamondHelmet = new EmeraldDiamondHelmet(5018, emeraldArmorMaterial, ModLoader.addArmor("emerald"), 0);
	public static Item emeraldDiamondChestplate= new EmeraldDiamodChestplate(5019, emeraldArmorMaterial, ModLoader.addArmor("emerald"), 1);
	public static Item emeraldDiamondLeggins = new EmeraldDiamondLeggins(5020, emeraldArmorMaterial, ModLoader.addArmor("emerald"), 2);
	public static Item emeraldDiamondBoots = new EmeraldDiamondBoots(5021, emeraldArmorMaterial, ModLoader.addArmor("emerald"), 3);
	public static Item fireOpalSword = new FireOpalSword(5022, fireOpalToolMaterial);
	public static Item fireOpalHelmet = new FireOpalHelmet(5023, fireOpalArmorMaterial, ModLoader.addArmor("emerald"), 0);
	public static Item fireOpalChestplate= new FireOpalChestplate(5024, fireOpalArmorMaterial, ModLoader.addArmor("emerald"), 1);
	public static Item fireOpalLeggins = new FireOpalLeggins(5025, fireOpalArmorMaterial, ModLoader.addArmor("emerald"), 2);
	public static Item fireOpalBoots = new FireOpalBoots(5026, fireOpalArmorMaterial, ModLoader.addArmor("emerald"), 3);
	public static Item sapphireDiamondHoe = new SapphireDiamondHoe(5027, sapphireToolMaterial);
	public static Item sapphireDiamondPickaxe = new SapphireDiamondPickaxe(5028, sapphireToolMaterial);
	public static Item sapphireDiamondAxe = new SapphireDiamondAxe(5029, sapphireToolMaterial);
	public static Item sapphireDiamondShovel = new SapphireDiamondShovel(5030, sapphireToolMaterial);
	public static Item emeraldDiamondHoe = new EmeraldDiamondHoe(5031, emeraldToolMaterial);
	public static Item emeraldDiamondPickaxe = new EmeraldDiamondPickaxe(5032, emeraldToolMaterial);
	public static Item emeraldDiamondAxe = new EmeraldDiamondAxe(5033, emeraldToolMaterial);
	public static Item emeraldDiamondShovel = new EmeraldDiamondShovel(5034, emeraldToolMaterial);
	public static Item sapphireDiamondSword = new SapphireDiamondSword(5035, sapphireToolMaterial);
	public static Item emeraldDiamondSword = new EmeraldDiamondSword(5036, emeraldToolMaterial);
	public static Item fireOpalPickaxe = new FireOpalPickaxe(5037, fireOpalToolMaterial);
	public static Item fireOpalAxe = new FireOpalAxe(5038, fireOpalToolMaterial);
	public static Item fireOpalShovel = new FireOpalShovel(5039, fireOpalToolMaterial);
	
	//Generators
	
	public static EterniumGenerator eterniumGenerator = new EterniumGenerator();
	public static IceSwordGenerator iceSwordGenerator = new IceSwordGenerator();
	public static FireOpalOreGenerator fireOpalOreGenerator = new FireOpalOreGenerator();
	public static SapphireOreGenerator sapphireOreGenerator = new SapphireOreGenerator();
	public static MagicWorldGenerator magicWorldGenerator = new MagicWorldGenerator();
	
	//Biomes
	
	public static BiomeGenBase goldenForest = new BiomeGoldenForest(100);
	public static BiomeGenBase frozenPlains = new BiomeFrozenPlains(101);
	public static BiomeGenBase darkForest = new BiomeDarkForest(102);
	public static BiomeGenBase tropicalDesert = new BiomeTropicalDesert(103);
	
	//


	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(this, new GUIHandler());	
		
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		
		/*Items*/
		
		//Eternium Powder
			LanguageRegistry.addName(eterniumPowder, "Eternium Powder");
		//Papyrus
			LanguageRegistry.addName(papyrus, "Papyrus");
		//Broken Diamond Sword
			LanguageRegistry.addName(brokenDiamondSword, "Broken Diamond Sword");
		//Raspberry
			LanguageRegistry.addName(raspberry, "Raspberry");
		//Raspberry Seeds
			LanguageRegistry.addName(raspberrySeeds, "Raspberry Seeds");
		//Blackberry
			LanguageRegistry.addName(blackberry, "Blackberry");
		//Blackberry Seeds
			LanguageRegistry.addName(blackberrySeeds, "Blackberry Seeds");
		//Fire Opal Gem
			LanguageRegistry.addName(fireOpalGem, "Cut Fire Opal");
		//Fire Opal
			LanguageRegistry.addName(fireOpal, "Fire Opal");	
		//Fire Opal Hoe
			LanguageRegistry.addName(fireOpalHoe, "Fire Opal Hoe");
			GameRegistry.registerItem(fireOpalHoe, "fireOpalHoe");
		//Emerald Gem
			LanguageRegistry.addName(emeraldGem, "Cut Emerald");
		//Sapphire Gem
			LanguageRegistry.addName(sapphireGem, "Cut Sapphire");
		//Sapphire
			LanguageRegistry.addName(sapphire, "Sapphire");
		//Sapphire-Diamond Helmet
			LanguageRegistry.addName(sapphireDiamondHelmet, "Sapphire-Diamond Helmet");
			GameRegistry.registerItem(sapphireDiamondHelmet, "sapphireDiamondHelmet");
		//Sapphire-Diamond Chestplate
			LanguageRegistry.addName(sapphireDiamondChestplate, "Sapphire-Diamond Chestpalte");
			GameRegistry.registerItem(sapphireDiamondChestplate, "sapphireDiamondCheatplate");
		//Sapphire-Diamond Leggins
			LanguageRegistry.addName(sapphireDiamondLeggins, "Sapphire-Diamond Leggins");
			GameRegistry.registerItem(sapphireDiamondLeggins, "sapphireDiamondLeggins");
		//Sapphire-Diamond Boots
			LanguageRegistry.addName(sapphireDiamondBoots, "Sapphire-Diamond Boots");
			GameRegistry.registerItem(sapphireDiamondBoots, "sapphireDiamondBoots");
		//Emerald-Diamond Chestplate
			LanguageRegistry.addName(emeraldDiamondChestplate, "Emerald-Diamond Chestplate");
			GameRegistry.registerItem(emeraldDiamondChestplate, "emeraldDiamondChestplate");
		//Emerald-Diamond Helmet
			LanguageRegistry.addName(emeraldDiamondHelmet, "Emerald-Diamond Helmet");
			GameRegistry.registerItem(emeraldDiamondHelmet, "emeraldDiamondHelmet");
		//Emerald-Diamond Leggins
			LanguageRegistry.addName(emeraldDiamondLeggins, "Emerald-Diamond Leggins");
			GameRegistry.registerItem(emeraldDiamondLeggins, "emeraldDiamondLeggins");
		//Emerald-Diamond Boots
			LanguageRegistry.addName(emeraldDiamondBoots, "Emerald-Diamond Boots");
			GameRegistry.registerItem(emeraldDiamondBoots, "emeraldDiamondBoots");
		//Fire Opal Sword
			LanguageRegistry.addName(fireOpalSword, "Fire Opal Sword");
			GameRegistry.registerItem(fireOpalSword, "fireOpalSword");
		//Fire Opal Chestplate
			LanguageRegistry.addName(fireOpalChestplate, "Fire Opal Chestplate");
			GameRegistry.registerItem(fireOpalChestplate, "fireOpalChestplate");
		//Fire Opal Helmet
			LanguageRegistry.addName(fireOpalHelmet, "Fire Opal Helmet");
			GameRegistry.registerItem(fireOpalHelmet, "fireOpalHelmet");
		//Fire Opal Leggins
			LanguageRegistry.addName(fireOpalLeggins, "Fire Opal Leggins");
			GameRegistry.registerItem(fireOpalLeggins, "fireOpalLeggins");
		//Fire Opal Boots
			LanguageRegistry.addName(fireOpalBoots, "Fire Opal Boots");
			GameRegistry.registerItem(fireOpalBoots, "fireOpalBoots");
		//Sapphire Diamond Hoe
			LanguageRegistry.addName(sapphireDiamondHoe, "Sapphire Diamond Hoe");
			GameRegistry.registerItem(sapphireDiamondHoe, "sapphireDiamondHoe");
		//Sapphire Diamond Pickaxe
			LanguageRegistry.addName(sapphireDiamondPickaxe, "Sapphire Diamond Pickaxe");
			GameRegistry.registerItem(sapphireDiamondPickaxe, "sapphireDiamondPickaxe");
		//Sapphire Diamond Axe
			LanguageRegistry.addName(sapphireDiamondAxe, "Sapphire Diamond Axe");
			GameRegistry.registerItem(sapphireDiamondAxe, "sapphireDiamondAxe");
		//Sapphire Diamond Shovel
			LanguageRegistry.addName(sapphireDiamondShovel, "Sapphire Diamond Shovel");
			GameRegistry.registerItem(sapphireDiamondShovel, "sapphireDiamondShovel");
		//Emerald Diamond Hoe
			LanguageRegistry.addName(emeraldDiamondHoe, "Emerald Diamond Hoe");
			GameRegistry.registerItem(emeraldDiamondHoe, "emeraldDiamondHoe");
		//Emerald Diamond Pickaxe
			LanguageRegistry.addName(emeraldDiamondPickaxe, "Emerald Diamond Pickaxe");
			GameRegistry.registerItem(emeraldDiamondPickaxe, "emeraldDiamondPickaxe");
		//Emerald Diamond Axe
			LanguageRegistry.addName(emeraldDiamondAxe, "Emerald Diamond Axe");
			GameRegistry.registerItem(emeraldDiamondAxe, "emeraldDiamondAxe");
		//Emerald Diamond Shovel
			LanguageRegistry.addName(emeraldDiamondShovel, "Emerald Diamond Shovel");
			GameRegistry.registerItem(emeraldDiamondShovel, "emeraldDiamondShovel");
		//Emerald Diamond Sword
			LanguageRegistry.addName(emeraldDiamondSword, "Emerald Diamond Sword");
			GameRegistry.registerItem(emeraldDiamondSword, "emeraldDiamondSword");
		//Sapphire Diamond Sword
			LanguageRegistry.addName(sapphireDiamondSword, "Sappire Diamond Sword");
			GameRegistry.registerItem(sapphireDiamondSword, "sapphireDiamondSword");
		//Fire Opal Pickaxe
			LanguageRegistry.addName(fireOpalPickaxe, "Fire Opal Pickaxe");
			GameRegistry.registerItem(fireOpalPickaxe, "fireOpalPickaxe");
		//Fire Opal AXe
			LanguageRegistry.addName(fireOpalAxe, "Fire Opal Axe");
			GameRegistry.registerItem(fireOpalAxe, "fireOpalAxe");
		//Fire Opal SHovel
			LanguageRegistry.addName(fireOpalShovel, "Fire Opal Shovel");
			GameRegistry.registerItem(fireOpalShovel, "fireOpalShovel");
			
			
		/*Blocks*/
		
		//Eternium Block
			LanguageRegistry.addName(eternium, "Eternium");
			MinecraftForge.setBlockHarvestLevel(eternium, "pickaxe", 3);
			GameRegistry.registerBlock(eternium, "eternium");
		//Sandstone Hieroglyphs Block
			LanguageRegistry.addName(sandstoneHieroglyphs, "Sandstone Hieroglyphs");
			MinecraftForge.setBlockHarvestLevel(sandstoneHieroglyphs, "pickaxe", 0);
			GameRegistry.registerBlock(sandstoneHieroglyphs, "sandstoneHieroglyphs");
		//Golden Grass Block
			LanguageRegistry.addName(goldenGrass, "Golden Grass");
			GameRegistry.registerBlock(goldenGrass, "goldenGrass");
		//Ice Sword Block
			LanguageRegistry.addName(iceSword, "Frozen Diamond Sword");
			GameRegistry.registerBlock(iceSword, "iceSword");
		//Golden Tree Leaves
			LanguageRegistry.addName(goldenTreeLeaves, "Golden Tree Leaves");
			GameRegistry.registerBlock(goldenTreeLeaves, "goldenTreeLeaves");
		//Golden Wood
			LanguageRegistry.addName(goldenWood, "Golden Wood");
			GameRegistry.registerBlock(goldenWood, "goldenWood");
		//Golden Tall Grass
			LanguageRegistry.addName(goldenTallGrass, "Golden Tall Grass");
			GameRegistry.registerBlock(goldenTallGrass, "goldenTallGrass");
		//Red Orchid
			LanguageRegistry.addName(redOrchid, "Red Orchid");
			GameRegistry.registerBlock(redOrchid, "redOrchid");
		//Golden Tree Sapling
			LanguageRegistry.addName(goldenTreeSapling, "Golden Tree Sapling");
			GameRegistry.registerBlock(goldenTreeSapling, "goldenTreeSapling");
		//Dark Tree Leaves
			LanguageRegistry.addName(darkTreeLeaves, "Dark Tree Sapling");
			GameRegistry.registerBlock(darkTreeLeaves, "darkTreeSapling");
		//Dark Wood
			LanguageRegistry.addName(darkWood, "Dark Wood");
			GameRegistry.registerBlock(darkWood, "darkWood");
		//Dark Grass
			LanguageRegistry.addName(darkGrass, "Dark Grass");
			GameRegistry.registerBlock(darkGrass, "darkGrass");
		//Dark Tall Grass
			LanguageRegistry.addName(darkTallGrass, "Dark Tall Grass");
			GameRegistry.registerBlock(darkTallGrass, "darkTallGrass");
		//White Orchid
			LanguageRegistry.addName(whiteOrchid, "White Orchid");
			GameRegistry.registerBlock(whiteOrchid, "whiteOrchid");
		//Palm Wood
			LanguageRegistry.addName(palmTreeWood, "Palm Wood");
			GameRegistry.registerBlock(palmTreeWood, "palmTreeWood");
		//Palm Leaves
			LanguageRegistry.addName(palmTreeLeaves, "Palm Leaves");
			GameRegistry.registerBlock(palmTreeLeaves, "palmTreeLeaves");
		//Dark Tree Sapling
			LanguageRegistry.addName(dark, "Dark Tree Sapling");
			GameRegistry.registerBlock(dark, "dark");
		//Desert Rose Flower
			LanguageRegistry.addName(desertRoseFlower, "Desert Rose");
			GameRegistry.registerBlock(desertRoseFlower, "desertRoseFlower");
		//Sapphire Ore
			LanguageRegistry.addName(sapphireOre, "Sapphire Ore");
			GameRegistry.registerBlock(sapphireOre, "sapphireOre");
		//Fire Opal Ore
			LanguageRegistry.addName(fireOpalOre, "Fire Opal Ore");
			GameRegistry.registerBlock(fireOpalOre, "fireOpalOre");
		//Palm Tree Sapling
			LanguageRegistry.addName(palmTreeSapling, "Palm Sapling");
			GameRegistry.registerBlock(palmTreeSapling, "palmTreeSapling");
		//Autominer
			LanguageRegistry.addName(autominer, "Autominer");
			GameRegistry.registerBlock(autominer, ItemBlock.class, "autominer");
			GameRegistry.registerTileEntity(kaja.magic.blocks.TileAutominer.class, "TileAutominer");
		//Smallest Blackberry Bush
			LanguageRegistry.addName(smallestBlackberryBush, "Smallest Blackberry Bush");
			GameRegistry.registerBlock(smallestBlackberryBush, "smallestBlackberryBush");
			GameRegistry.registerTileEntity(kaja.magic.blocks.TileSmallestBush.class, "TileSmallestBush");
		//Small Blackberry Bush
			LanguageRegistry.addName(smallBlackberryBush, "Small Blackberry Bush");
			GameRegistry.registerBlock(smallBlackberryBush, "smallBlackberryBush");
			GameRegistry.registerTileEntity(kaja.magic.blocks.TileSmallBush.class, "TileSmallBush");
		//Medium Blackberry Bush
			LanguageRegistry.addName(mediumBlackberryBush, "Medium Blackberry Bush");
			GameRegistry.registerBlock(mediumBlackberryBush, "mediumBlackberryBush");
			GameRegistry.registerTileEntity(kaja.magic.blocks.TileSmallBush.class, "TileMediumBush");
		//Big Blackberry Bush
			LanguageRegistry.addName(bigBlackberryBush, "Backberry Bush");
			GameRegistry.registerBlock(bigBlackberryBush, "bigBlackberryBush");
		//Smallest Raspberry Bush
			LanguageRegistry.addName(smallestRaspberryBush, "Smallest Raspberry Bush");
			GameRegistry.registerBlock(smallestRaspberryBush, "smallestRaspberryBush");
		//Small Raspberry Bush
			LanguageRegistry.addName(smallRaspberryBush, "Small Raspberry Bush");
			GameRegistry.registerBlock(smallRaspberryBush, "smallRaspberryBush");
		//Medium Raspberry Bush
			LanguageRegistry.addName(mediumRaspberryBush, "Medium Raspberry Bush");
			GameRegistry.registerBlock(mediumRaspberryBush, "mediumRaspberryBush");
		//Big Raspberry Bush
			LanguageRegistry.addName(bigRaspberryBush, "Raspberry Bush");
			GameRegistry.registerBlock(bigRaspberryBush, "bigRaspberryBush");
		//Raspberry Bush
			LanguageRegistry.addName(raspberryBush, "Raspberry Bush");
			GameRegistry.registerBlock(raspberryBush, "raspberryBush");
		//Raspberry Bush
			LanguageRegistry.addName(blackberryBush, "Blackberry Bush");
			GameRegistry.registerBlock(blackberryBush, "blackberryBush");
			
		/*Recipes*/
			
		//Papyrus recipe
			GameRegistry.addRecipe(new ItemStack(papyrus, 3), "xxx", " y ", 'x', new ItemStack(Item.paper, 3), 'y', new ItemStack(Item.dyePowder, 1, 0));
		//Snadstone Hieroglyphs Block recipe
			ItemStack smoothSandStoneStack = new ItemStack(Block.sandStone, 1, 2);
			GameRegistry.addRecipe(new ItemStack(sandstoneHieroglyphs, 1), " y ", "xxx", 'x', new ItemStack(papyrus, 1), 'y', new ItemStack(Block.sandStone));
			GameRegistry.addRecipe(new ItemStack(sandstoneHieroglyphs, 1), 
					" y ", "xxx", 'x', new ItemStack(papyrus, 1), 'y', new ItemStack(Block.sandStone, 1, 2));
		//Diamond Sword recipe using Broken Diamond Sword
			Random random = new Random();
			ItemStack diamondSword = new ItemStack(Item.swordDiamond, 1);
			diamondSword.setItemDamage(random.nextInt(156) + 624);
			GameRegistry.addRecipe(diamondSword,"xxx", 'x', new ItemStack(brokenDiamondSword, 3));
		//Raspberry seeds recipe
			GameRegistry.addRecipe(new ItemStack(raspberrySeeds, 1), "x", 'x', new ItemStack(raspberry, 1));
		//Blackerry seeds recipe
			GameRegistry.addRecipe(new ItemStack(blackberrySeeds, 1), "x", 'x', new ItemStack(blackberry, 1));
		//Sapphire-Diamond pickaxe
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondPickaxe, 1), 
					"www", "xyz", "xyz",'x', new ItemStack(sapphireGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Emerald-Diamond pickaxe
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondPickaxe, 1), 
					"www", "xyz", "xyz",'x', new ItemStack(emeraldGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Fire Opal pickaxe
			GameRegistry.addRecipe(new ItemStack(fireOpalPickaxe, 1), 
					"xxx", " y ", " y ",'x', new ItemStack(fireOpalGem, 1), 'y', new ItemStack(Item.stick));
		//Sapphire-diamond shovel
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondShovel, 1), 
					" w ", "xyz", "xyz",'x', new ItemStack(sapphireGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Emerald-diamond shovel
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondShovel, 1), 
					" w ", "xyz", "xyz",'x', new ItemStack(emeraldGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Fire Opal shovel
			GameRegistry.addRecipe(new ItemStack(fireOpalShovel, 1), 
					" x ", " y ", " y ",'x', new ItemStack(fireOpalGem, 1), 'y', new ItemStack(Item.stick));
		//Sapphire-diamond hoe
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondHoe, 1), 
					" ww", "xyz", "xyz",'x', new ItemStack(sapphireGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Emerald-diamond hoe
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondHoe, 1), 
					" ww", "xyz", "xyz",'x', new ItemStack(emeraldGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Fire Opal hoe
			GameRegistry.addRecipe(new ItemStack(fireOpalHoe, 1), 
					" xx", " y ", " y ",'x', new ItemStack(fireOpalGem, 1), 'y', new ItemStack(Item.stick));
		//Sapphire-diamond Axe
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondAxe, 1), 
					"zww", "xyw", "xyz",'x', new ItemStack(sapphireGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Emerald-diamond Axe
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondAxe, 1), 
					"zww", "xyw", "xyz",'x', new ItemStack(emeraldGem, 1), 'y', new ItemStack(Item.stick), 
					'z', new ItemStack(Item.ingotGold),'w', new ItemStack(Item.diamond));
		//Fire Opal Axe
			GameRegistry.addRecipe(new ItemStack(fireOpalAxe, 1), 
					" xx", " yx", " y ",'x', new ItemStack(fireOpalGem, 1), 'y', new ItemStack(Item.stick));
		//Sapphire-diamond Sword
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondSword, 1), 
					" w ", " w ", "xzx",'x', new ItemStack(sapphireGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Emerald-diamond Sword
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondSword, 1), 
					" w ", " w ", "xzx",'x', new ItemStack(emeraldGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Fire Opal Sword
			GameRegistry.addRecipe(new ItemStack(fireOpalSword, 1), 
					" x ", " x ", "zyz",'x', new ItemStack(fireOpalGem, 1), 'y', new ItemStack(Item.stick),
					'z', new ItemStack(fireOpal));
		//Sapphire-diamond helmet
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondHelmet, 1), 
					"xzx", "www", "w w",'x', new ItemStack(sapphireGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Emerald-diamond helmet
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondHelmet, 1), 
					"xzx", "www", "w w",'x', new ItemStack(emeraldGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Fire Opal Helmet
			GameRegistry.addRecipe(new ItemStack(fireOpalHelmet, 1), "xxx", "x x",'x', new ItemStack(fireOpal));
		//Sapphire-diamond Chestplate
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondChestplate, 1), 
					"x x", "zwz", "xwx",'x', new ItemStack(sapphireGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Emerald-diamond Chestplate
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondChestplate, 1), 
					"x x", "zwz", "xwx",'x', new ItemStack(emeraldGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Fire Opal Chestplate
			GameRegistry.addRecipe(new ItemStack(fireOpalChestplate, 1), "x x", "xxx", "xxx",'x', new ItemStack(fireOpal));
		//Sapphire-diamond Leggins
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondLeggins, 1), 
					"xwx", "z z", "x x",'x', new ItemStack(sapphireGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Emerald-diamond Leggins
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondLeggins, 1), 
					"xwx", "z z", "x x",'x', new ItemStack(emeraldGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Fire Opal Leggins
			GameRegistry.addRecipe(new ItemStack(fireOpalLeggins, 1), "xxx", "x x", "x x",'x', new ItemStack(fireOpal));
		//Sapphire-diamond Boots
			GameRegistry.addRecipe(new ItemStack(sapphireDiamondBoots, 1), 
					"z z", "x x",'x', new ItemStack(sapphireGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Emerald-diamond Boots
			GameRegistry.addRecipe(new ItemStack(emeraldDiamondBoots, 1), 
					"z z", "x x",'x', new ItemStack(emeraldGem, 1), 'z', new ItemStack(Item.ingotGold),
					'w', new ItemStack(Item.diamond));
		//Fire Opal Boots
			GameRegistry.addRecipe(new ItemStack(fireOpalBoots, 1), "x x", "x x",'x', new ItemStack(fireOpal));
			
		/*Smelting*/

		//Frozen Diamond Sword smelting
			ItemStack diamondSword2 = new ItemStack(Item.swordDiamond, 1);
			diamondSword2.setItemDamage(random.nextInt(156) + 468);
			GameRegistry.addSmelting(iceSword.blockID, diamondSword2, 0.1f);
		
		/*Generators*/
		
		GameRegistry.registerWorldGenerator(eterniumGenerator);
		GameRegistry.registerWorldGenerator(iceSwordGenerator);
		GameRegistry.registerWorldGenerator(fireOpalOreGenerator);
		GameRegistry.registerWorldGenerator(sapphireOreGenerator);
		//GameRegistry.registerWorldGenerator(magicWorldGenerator);
		
		/*Biomes*/
		
		//Golden Wood
			GameRegistry.addBiome(goldenForest);
		//Frozen Plains
			GameRegistry.addBiome(frozenPlains);
		//Dark Forest
			GameRegistry.addBiome(darkForest);
		//Tropical Desert
			GameRegistry.addBiome(tropicalDesert);
			
		/*Events*/
			
		MinecraftForge.EVENT_BUS.register(new TreeEvent());
		MinecraftForge.EVENT_BUS.register(new TallGrassEvent());
		
			
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
	

}
