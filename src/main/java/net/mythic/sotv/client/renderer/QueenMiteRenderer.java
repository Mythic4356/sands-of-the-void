
package net.mythic.sotv.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.mythic.sotv.entity.model.QueenMiteModel;
import net.mythic.sotv.entity.layer.QueenMiteLayer;
import net.mythic.sotv.entity.QueenMiteEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class QueenMiteRenderer extends GeoEntityRenderer<QueenMiteEntity> {
	public QueenMiteRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new QueenMiteModel());
		this.shadowRadius = 1f;
		this.addRenderLayer(new QueenMiteLayer(this));
	}

	@Override
	public RenderType getRenderType(QueenMiteEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, QueenMiteEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 3f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(QueenMiteEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
