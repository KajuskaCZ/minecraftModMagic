package kaja.magic.blocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSmallestBush extends TileEntitySpecialRenderer {

	private ModelBase model = new ModelBase() {};
	   	ModelRenderer Shape1;

	public RenderSmallestBush() {
		 model.textureWidth = 32;
		    model.textureHeight = 32;
		    
		      Shape1 = new ModelRenderer(model, 0, 0);
		      Shape1.addBox(0F, 0F, 0F, 4, 4, 4);
		      Shape1.setRotationPoint(6F, 12F, 6F);
		      Shape1.setTextureSize(32, 32);
		      Shape1.mirror = true;
	    
	      
	      setTileEntityRenderer(TileEntityRenderer.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		this.renderSmallestBush((TileSmallestBush) tileentity, d0, d1, d2, f);

	}

	private void renderSmallestBush(TileSmallestBush tileEntityBush, double par1, double par2, double par3, float par4) {

		this.func_110628_a(new ResourceLocation("magic", "textures/blocks/SmallestBush.png"));

		GL11.glPushMatrix();
		GL11.glTranslatef((float) par1, (float) par2 + 1, (float) par3 + 1);
		GL11.glRotatef(0, 0.0F, 0.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);
		
		Shape1.render(0.0625F);
	
		
		GL11.glPopMatrix();
	}

}
