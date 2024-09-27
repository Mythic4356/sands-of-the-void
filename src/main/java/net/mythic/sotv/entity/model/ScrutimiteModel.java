package net.mythic.sotv.entity.model;

import software.bernie.geckolib.animation.AnimationState;

public class ScrutimiteModel extends GeoModel<ScrutimiteEntity> {
	@Override
	public ResourceLocation getAnimationResource(ScrutimiteEntity entity) {
		return new ResourceLocation("sotv", "animations/scrutimite.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ScrutimiteEntity entity) {
		return new ResourceLocation("sotv", "geo/scrutimite.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ScrutimiteEntity entity) {
		return new ResourceLocation("sotv", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(ScrutimiteEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}