package net.mythic.sotv.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.mythic.sotv.entity.IncendimiteEntity;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class IncendimiteModel extends GeoModel<IncendimiteEntity> {
	@Override
	public ResourceLocation getAnimationResource(IncendimiteEntity entity) {
		return new ResourceLocation("sotv", "animations/incendimite.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(IncendimiteEntity entity) {
		return new ResourceLocation("sotv", "geo/incendimite.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(IncendimiteEntity entity) {
		return new ResourceLocation("sotv", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(IncendimiteEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
