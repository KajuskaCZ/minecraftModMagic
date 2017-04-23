package kaja.magic;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import kaja.magic.blocks.BlockGoldenTreeSapling;
import kaja.magic.blocks.BlockDarkTreeSapling;
import kaja.magic.blocks.BlockPalmTreeSapling;

public class TreeEvent {
	@ForgeSubscribe
	public void usedBonemeal(BonemealEvent event) {
		ItemStack stack;
		stack = event.entityPlayer.inventory.getCurrentItem();
		if(event.ID == Magic.goldenTreeSapling.blockID) {
			if(!event.world.isRemote) {
				((BlockGoldenTreeSapling)Magic.goldenTreeSapling).growTree(event.world,event.X,event.Y,event.Z,event.world.rand);
				--stack.stackSize;
			}
		}
		else if(event.ID == Magic.dark.blockID) {
			if(!event.world.isRemote) {
				((BlockDarkTreeSapling)Magic.dark).growTree(event.world,event.X,event.Y,event.Z,event.world.rand);
				--stack.stackSize;
			}
		}
		else if(event.ID == Magic.palmTreeSapling.blockID) {
			if(!event.world.isRemote) {
				((BlockPalmTreeSapling)Magic.palmTreeSapling).growTree(event.world,event.X,event.Y,event.Z,event.world.rand);
				--stack.stackSize;
			}
		}	
	}

}
