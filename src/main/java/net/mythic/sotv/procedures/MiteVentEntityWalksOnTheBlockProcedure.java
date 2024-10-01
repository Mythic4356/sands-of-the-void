package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class MiteVentEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).equals("minecraft:player")) {
			if (Mth.nextInt(RandomSource.create(), 1, 50) == 25) {
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 0, 1); index0++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = SotvModEntities.SCRUTIMITE.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
				for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 0, 1); index1++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			}
		}
	}
}
