package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModEntities;
import net.mythic.sotv.entity.QueenMiteEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class QueenMiteOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
	}
}
