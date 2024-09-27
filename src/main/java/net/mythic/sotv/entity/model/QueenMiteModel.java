package net.mythic.sotv.entity.model;

import software.bernie.geckolib.animation.AnimationState;

public class QueenMiteModel extends GeoModel<QueenMiteEntity> {
	@Override
	public ResourceLocation getAnimationResource(QueenMiteEntity entity) {
		return new ResourceLocation("sotv", "animations/queenmite.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(QueenMiteEntity entity) {
		return new ResourceLocation("sotv", "geo/queenmite.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(QueenMiteEntity entity) {
		return new ResourceLocation("sotv", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(QueenMiteEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}