package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModEntities;
import net.mythic.sotv.entity.QueenMiteEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class QueenMiteOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		if ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_summoncooldown) : 0) == 0) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 10); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 3); index1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = SotvModEntities.SCRUTIMITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			if (entity instanceof QueenMiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(QueenMiteEntity.DATA_summoncooldown, 1200);
		} else {
			if (entity instanceof QueenMiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(QueenMiteEntity.DATA_summoncooldown, (int) ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_summoncooldown) : 0) - 1));
		}
		if ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_lasercooldown) : 0) == 2400) {
			if (entity instanceof QueenMiteEntity _datEntSetL)
				_datEntSetL.getEntityData().set(QueenMiteEntity.DATA_laser, true);
		} else if ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_lasercooldown) : 0) == 0) {
			if (entity instanceof QueenMiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(QueenMiteEntity.DATA_lasercooldown, (int) ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_lasercooldown) : 0) + 1));
		}
		if (entity instanceof QueenMiteEntity _datEntL13 && _datEntL13.getEntityData().get(QueenMiteEntity.DATA_laser)) {
			raytrace_distance = 1;
			for (int index2 = 0; index2 < 14; index2++) {
				if (!world.getBlockState(new BlockPos(
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
								.getX(),
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
								.getY(),
						entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
								.getZ()))
						.canOcclude() || raytrace_distance < 14) {
					raytrace_distance = raytrace_distance + 1;
					world.addParticle(ParticleTypes.FLAME, x, (y + 1), z, ((Math.sin(Math.toRadians(entity.getYRot() + 180)) * raytrace_distance) / 2), ((Math.sin(Math.toRadians(0 - entity.getXRot())) * raytrace_distance) / 2),
							((Math.cos(Math.toRadians(entity.getYRot())) * raytrace_distance) / 2));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									new BlockPos(
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ender_dragon.shoot")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.ender_dragon.shoot")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity) && entityiterator instanceof LivingEntity && !((entity.getVehicle()) == entityiterator) && !((entityiterator.getVehicle()) == entity)) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 5);
							}
						}
					}
				}
			}
			if (entity instanceof QueenMiteEntity _datEntSetI)
				_datEntSetI.getEntityData().set(QueenMiteEntity.DATA_lasercooldown, (int) ((entity instanceof QueenMiteEntity _datEntI ? _datEntI.getEntityData().get(QueenMiteEntity.DATA_lasercooldown) : 0) - 1));
		}
	}
}
