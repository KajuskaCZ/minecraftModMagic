package kaja.magic.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSmallBush extends TileEntitySpecialRenderer {

	private ModelBase model = new ModelBase() {};
	   	ModelRenderer Shape1;

	public RenderSmallBush() {
		 model.textureWidth = 32;
		    model.textureHeight = 32;
		    
		      Shape1 = new ModelRenderer(model, 0, 0);
		      Shape1.addBox(0F, 0F, 0F, 8, 8, 8);
		      Shape1.setRotationPoint(4F, 8F, 4F);
		      Shape1.setTextureSize(32, 32);
		      Shape1.mirror = true;
	    
	      
	      setTileEntityRenderer(TileEntityRenderer.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		this.renderSmallBush((TileSmallBush) tileentity, d0, d1, d2, f);

	}

	private void renderSmallBush(TileSmallBush tileEntityBush, double par1, double par2, double par3, float par4) {

		this.func_110628_a(new ResourceLocation("magic", "textures/blocks/SmallBush.png"));

		GL11.glPushMatrix();
		GL11.glTranslatef((float) par1, (float) par2 + 1, (float) par3 + 1);
		GL11.glRotatef(0, 0.0F, 0.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);
		
		Shape1.render(0.0625F);
	
		
		GL11.glPopMatrix();
	}

}
