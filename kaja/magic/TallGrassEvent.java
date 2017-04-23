package kaja.magic;


import java.util.Random;

import kaja.magic.generators.BonemealTallGrassGenerator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class TallGrassEvent {
	@ForgeSubscribe
	public void usedBonemeal(BonemealEvent event) {
		ItemStack stack;
		stack = event.entityPlayer.inventory.getCurrentItem();
		Random random = new Random();
		if(event.ID == Magic.goldenGrass.blockID || event.ID == Magic.darkGrass.blockID) {
			if(!event.world.isRemote) {
				(new BonemealTallGrassGenerator()).generate(event.world, random, event.X, event.Y, event.Z);
				--stack.stackSize;
			}
		}
		
	}
}
