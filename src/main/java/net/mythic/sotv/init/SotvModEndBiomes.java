package net.mythic.sotv.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mythic.sotv.endbiomes.TheEndBiomes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SotvModEndBiomes {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registries.BIOME, new ResourceLocation("minecraft:end_highlands")), ResourceKey.create(Registries.BIOME, new ResourceLocation("sotv:nix_desert")), 1.6d);
		});
	}
}
