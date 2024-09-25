
package net.mythic.sotv.client.renderer;

public class LatePearlEntityRenderer extends HumanoidMobRenderer<LatePearlEntityEntity, HumanoidModel<LatePearlEntityEntity>> {

	public LatePearlEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 1f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(LatePearlEntityEntity entity) {
		return new ResourceLocation("sotv:textures/entities/late_pearl_entity.png");
	}

}
