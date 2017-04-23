package kaja.magic;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	// Client stuff
		public void registerRenderThings() {
			// Nothing here as the server doesn't render graphics or entities!
		}
		
		public void registerServerTickHandler() {
			TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		}
}
