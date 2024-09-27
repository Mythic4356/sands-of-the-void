package net.mythic.sotv.entity.layer;

public class ScrutimiteLayer extends GeoRenderLayer<ScrutimiteEntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("sotv", "textures/entities/scrutimite_e.png");

	public ScrutimiteLayer(GeoRenderer<ScrutimiteEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, ScrutimiteEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType glowRenderType = RenderType.eyes(LAYER);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}