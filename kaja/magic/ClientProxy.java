package kaja.magic;

import kaja.magic.blocks.RenderAutominer;
import kaja.magic.blocks.RenderMediumBush;
import kaja.magic.blocks.RenderSmallBush;
import kaja.magic.blocks.RenderSmallestBush;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(kaja.magic.blocks.TileAutominer.class, new RenderAutominer());
		ClientRegistry.bindTileEntitySpecialRenderer(kaja.magic.blocks.TileSmallestBush.class, new RenderSmallestBush());
		ClientRegistry.bindTileEntitySpecialRenderer(kaja.magic.blocks.TileSmallBush.class, new RenderSmallBush());
		ClientRegistry.bindTileEntitySpecialRenderer(kaja.magic.blocks.TileMediumBush.class, new RenderMediumBush());
	}
}
