
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mythic.sotv.client.renderer.ScrutimiteRenderer;
import net.mythic.sotv.client.renderer.QueenMiteRenderer;
import net.mythic.sotv.client.renderer.LatePearlEntityRenderer;
import net.mythic.sotv.client.renderer.IncendimiteRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SotvModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SotvModEntities.LATE_PEARL_ENTITY.get(), LatePearlEntityRenderer::new);
		event.registerEntityRenderer(SotvModEntities.SCRUTIMITE.get(), ScrutimiteRenderer::new);
		event.registerEntityRenderer(SotvModEntities.QUEEN_MITE.get(), QueenMiteRenderer::new);
		event.registerEntityRenderer(SotvModEntities.INCENDIMITE.get(), IncendimiteRenderer::new);
	}
}
