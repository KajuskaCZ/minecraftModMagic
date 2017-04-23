package kaja.magic.gui;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

import kaja.magic.blocks.TileAutominer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GUIAutominer extends GuiContainer {
	public int speed;
	public GUIAutominer(InventoryPlayer inventoryPlayer, TileAutominer tileEntity) {
		super(new ContainerAutominer(inventoryPlayer, tileEntity));
		speed = 20;
		String temp;
		try{
        	Scanner scanner = new Scanner(new FileInputStream("autominerSpeed.txt"), "UTF8");
        	try {
        	temp = scanner.nextLine();
        	speed = Integer.parseInt(temp);
        	} catch (NoSuchElementException e) {
        		scanner.close();
        	}
        	scanner.close();
	        } catch(IOException e) {
	        }
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		mc.renderEngine.func_110577_a(new ResourceLocation("magic", "textures/tileGui/Autominer.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		String sSpeed = String.valueOf(speed);
		fontRenderer.drawString("Autominer", 8, 6, 4210752);
		fontRenderer.drawString("Inventory", 8, 72, 4210752);
		fontRenderer.drawString("Speed", 120, 6, 4210752);
		fontRenderer.drawString(sSpeed, 128, 28, 4210752);
		
	}
	
	@Override
	 public void initGui() {
        super.initGui();
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        buttonList.add(new GuiButton(1, x + 112, y + 45, 20, 20, "-"));
        buttonList.add(new GuiButton(2, x + 132, y + 45, 20, 20, "+"));
	}
	
	protected void actionPerformed(GuiButton guibutton) {
        switch(guibutton.id) {
        case 1:
        		if(speed  > 1)
        			speed -= 1;
                break;
        case 2:
        		if(speed < 20)
        			speed += 1;
        		break;
        }
        try{
        	Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("autominerSpeed.txt"), "UTF8"));
        	String sSpeed = String.valueOf(speed);
        	writer.write(sSpeed);
        	writer.close();
        }catch(IOException e){
        	System.out.println(e);
        	return;
        }
        
	}



            
        
}
