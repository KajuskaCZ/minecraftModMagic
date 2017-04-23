package kaja.magic;

import java.util.EnumSet;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	//if armor is on player body
	private void onPlayerTick(EntityPlayer player) {
		Random random = new Random();
		int sap = 0, em = 0, fir = 0;
		//helmet
		if(player.getCurrentItemOrArmor(4) != null) {
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			if(helmet.getItem() == Magic.sapphireDiamondHelmet) {
				//20 tick = 1 sec
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40, 0));
				sap++;
			}
			else if(helmet.getItem() == Magic.emeraldDiamondHelmet) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
				em++;
			}
			else if(helmet.getItem() == Magic.fireOpalHelmet) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
				if(random.nextInt(3000) < 1) {
					player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 40, 0));
				}
				fir++;
			}
		}
		
		//chestplate
		if(player.getCurrentItemOrArmor(3) != null) {
			ItemStack chestplate = player.getCurrentItemOrArmor(3);
			if(chestplate.getItem() == Magic.sapphireDiamondChestplate) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40, 0));
				sap++;
			}
			else if(chestplate.getItem() == Magic.emeraldDiamondChestplate) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
				em++;
			}
			else if(chestplate.getItem() == Magic.fireOpalChestplate) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
				if(random.nextInt(3000) < 1) {
					player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 40, 0));
				}
				fir++;
			}
		}
		
		//leggins
		if(player.getCurrentItemOrArmor(2) != null) {
			ItemStack chestplate = player.getCurrentItemOrArmor(2);
			if(chestplate.getItem() == Magic.sapphireDiamondLeggins) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40, 0));
				sap++;
			}
			if(chestplate.getItem() == Magic.emeraldDiamondLeggins) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
				em++;
			}
			if(chestplate.getItem() == Magic.fireOpalLeggins) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
				if(random.nextInt(3000) < 1) {
					player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 40, 0));
				}
				fir++;
			}
		}
		
		//boots
		if(player.getCurrentItemOrArmor(1) != null) {
			ItemStack chestplate = player.getCurrentItemOrArmor(1);
			if(chestplate.getItem() == Magic.sapphireDiamondBoots) {
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 40, 0));
				if(sap == 3) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 0));
				}
			}
			if(chestplate.getItem() == Magic.emeraldDiamondBoots) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 40, 0));
				if(em == 3) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 0));
				}
			}
			if(chestplate.getItem() == Magic.fireOpalBoots) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 40, 0));
				if(random.nextInt(3000) < 1) {
					player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 40, 0));
				}
				if(fir == 3) {
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 40, 1));
				}
			}
		}
		
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
