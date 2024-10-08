
package net.mythic.sotv.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mythic.sotv.entity.model.ScrutimiteModel;
import net.mythic.sotv.entity.layer.ScrutimiteLayer;
import net.mythic.sotv.entity.ScrutimiteEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ScrutimiteRenderer extends GeoEntityRenderer<ScrutimiteEntity> {
	public ScrutimiteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ScrutimiteModel());
		this.shadowRadius = 1f;
		this.addRenderLayer(new ScrutimiteLayer(this));
	}

	@Override
	public RenderType getRenderType(ScrutimiteEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ScrutimiteEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
