package kaja.magic.blocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderAutominer extends TileEntitySpecialRenderer {
	private ModelBase model = new ModelBase() {
	};
	   	ModelRenderer Shape1;
	    ModelRenderer Shape2;
	    ModelRenderer Shape3;
	    ModelRenderer Shape4;
	    ModelRenderer Shape5;
	    ModelRenderer Shape6;
	    ModelRenderer Shape7;
	    ModelRenderer Shape8;
	    ModelRenderer Shape9;

	public RenderAutominer() {
		model.textureWidth = 128;
	    model.textureHeight = 32;
	    
	      Shape1 = new ModelRenderer(model, 0, 0);
	      Shape1.addBox(0F, 0F, 0F, 16, 14, 16);
	      Shape1.setRotationPoint(0F, 2F, 0F);
	      Shape1.setTextureSize(128, 32);
	      Shape1.mirror = true;
	      Shape2 = new ModelRenderer(model, 48, 0);
	      Shape2.addBox(0F, 0F, 0F, 1, 2, 1);
	      Shape2.setRotationPoint(0F, 0F, 0F);
	      Shape2.setTextureSize(128, 32);
	      Shape2.mirror = true;
	      Shape3 = new ModelRenderer(model, 48, 0);
	      Shape3.addBox(0F, 0F, 0F, 1, 2, 1);
	      Shape3.setRotationPoint(15F, 0F, 0F);
	      Shape3.setTextureSize(128, 32);
	      Shape3.mirror = true;
	      Shape4 = new ModelRenderer(model, 48, 0);
	      Shape4.addBox(0F, 0F, 0F, 1, 2, 1);
	      Shape4.setRotationPoint(0F, 0F, 15F);
	      Shape4.setTextureSize(128, 32);
	      Shape4.mirror = true;
	      Shape5 = new ModelRenderer(model, 48, 0);
	      Shape5.addBox(0F, 0F, 0F, 1, 2, 1);
	      Shape5.setRotationPoint(15F, 0F, 15F);
	      Shape5.setTextureSize(128, 32);
	      Shape5.mirror = true;
	      Shape6 = new ModelRenderer(model, 48, 3);
	      Shape6.addBox(0F, 0F, 0F, 14, 1, 1);
	      Shape6.setRotationPoint(1F, 0F, 0F);
	      Shape6.setTextureSize(128, 32);
	      Shape6.mirror = true;
	      Shape7 = new ModelRenderer(model, 64, 15);
	      Shape7.addBox(0F, 0F, 0F, 1, 1, 14);
	      Shape7.setRotationPoint(0F, 0F, 1F);
	      Shape7.setTextureSize(128, 32);
	      Shape7.mirror = true;
	      Shape8 = new ModelRenderer(model, 64, 15);
	      Shape8.addBox(0F, 0F, 0F, 1, 1, 14);
	      Shape8.setRotationPoint(15F, 0F, 1F);
	      Shape8.setTextureSize(128, 32);
	      Shape8.mirror = true;
	      Shape9 = new ModelRenderer(model, 48, 3);
	      Shape9.addBox(0F, 0F, 0F, 14, 1, 1);
	      Shape9.setRotationPoint(1F, 0F, 15F);
	      Shape9.setTextureSize(128, 32);
	      Shape9.mirror = true;
	      
	      setTileEntityRenderer(TileEntityRenderer.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,
			double d2, float f) {
		this.renderAutominer((TileAutominer) tileentity, d0, d1, d2, f);

	}

	private void renderAutominer(TileAutominer par1TileEntityChest,
			double par1, double par2, double par3, float par4) {

		this.func_110628_a(new ResourceLocation("magic", "textures/blocks/Autominer.png"));

		GL11.glPushMatrix();
		GL11.glTranslatef((float) par1, (float) par2 + 1, (float) par3 + 1);
		GL11.glRotatef(0, 0.0F, 0.0F, 0.0F);
		GL11.glScalef(1.0F, -1F, -1F);
		
		Shape1.render(0.0625F);
		Shape2.render(0.0625F);
		Shape3.render(0.0625F);
		Shape4.render(0.0625F);
		Shape5.render(0.0625F);
		Shape6.render(0.0625F);
		Shape7.render(0.0625F);
		Shape8.render(0.0625F);
		Shape9.render(0.0625F);
		
		GL11.glPopMatrix();
	}
}
