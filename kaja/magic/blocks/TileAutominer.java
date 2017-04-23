package kaja.magic.blocks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JFrame;

import kaja.magic.Magic;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileAutominer extends TileEntity  implements IInventory {
	private ItemStack[] inv;
	private int clock;
	
	public TileAutominer() {
		 inv = new ItemStack[1];
		 clock = 0;
	}
	
	@Override
	public void updateEntity() {
		int blockID;
		int speed, tSpeed = 20;
		String temp;
		try{
        	Scanner scanner = new Scanner(new FileInputStream("autominerSpeed.txt"), "UTF8");
        	try {
        	temp = scanner.nextLine();
        	tSpeed = Integer.parseInt(temp);
        	} catch (NoSuchElementException e) {
        		scanner.close();
        		return;
        	}
        	scanner.close();
	        } catch(IOException e) {
	        	return;
	        }
		
		speed = (21 - tSpeed) * 10;
		Random random = new Random();
		if(clock % speed != 0) {
			++clock;
			return;
		}
		++clock;
		if(clock > 100000) {
			clock -= 100000;
		}
		
		int stairs = 3;
		if(!this.getWorldObj().isRemote) {
			if(inv[0] != null) {
				if(inv[0].itemID == Magic.eterniumPowder.itemID) {
					if(inv[0].stackSize >= 1) {
						for(int y = this.yCoord - 1; y > 0; y--) {
							for(int z = this.zCoord + stairs; z < this.zCoord + stairs + 4; z++) {
								for(int x = this.xCoord - 1; x < this.xCoord + 2; x++) {
									blockID = this.getWorldObj().getBlockId(x, y, z);
									if(blockID != 0 && blockID != Block.bedrock.blockID) {
										--inv[0].stackSize;
										this.getWorldObj().setBlock(x, y, z, 0);
										EntityItem entityItem = new EntityItem(this.getWorldObj(), this.xCoord, this.yCoord + 1, this.zCoord, 
												new ItemStack(blockID, 1, 0));
										this.getWorldObj().spawnEntityInWorld(entityItem);
										return;
									}
								}
							}
							stairs++;
						}
					}
					else {
						inv[0] = null;
						}
				}
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
                ItemStack stack = inv[i];
                if (stack != null) {
                        NBTTagCompound tag = new NBTTagCompound();
                        tag.setByte("Slot", (byte) i);
                        stack.writeToNBT(tag);
                        itemList.appendTag(tag);
                }
        }
        tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		 super.readFromNBT(tagCompound);
         NBTTagList tagList = tagCompound.getTagList("Inventory");
         for (int i = 0; i < tagList.tagCount(); i++) {
                 NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                 byte slot = tag.getByte("Slot");
                 if (slot >= 0 && slot < inv.length) {
                         inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                 }
         }
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}		
	}

	@Override
	public String getInvName() {
		return "autominerinventory";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
						zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
