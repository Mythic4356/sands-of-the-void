
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.SpawnPlacementRegisterEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.mythic.sotv.entity.QueenMiteEntity;
import net.mythic.sotv.entity.LatePearlEntityEntity;
import net.mythic.sotv.SotvMod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SotvModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SotvMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<LatePearlEntityEntity>> LATE_PEARL_ENTITY = register("late_pearl_entity",
			EntityType.Builder.<LatePearlEntityEntity>of(LatePearlEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(0).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<QueenMiteEntity>> QUEEN_MITE = register("queen_mite",
			EntityType.Builder.<QueenMiteEntity>of(QueenMiteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 1.8f));

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(SpawnPlacementRegisterEvent event) {
		LatePearlEntityEntity.init(event);
		QueenMiteEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LATE_PEARL_ENTITY.get(), LatePearlEntityEntity.createAttributes().build());
		event.put(QUEEN_MITE.get(), QueenMiteEntity.createAttributes().build());
	}
}
