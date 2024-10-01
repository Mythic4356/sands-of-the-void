package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModBlocks;
import net.mythic.sotv.entity.ScrutimiteEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class ScrutimiteOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof ScrutimiteEntity _datEntL0 && _datEntL0.getEntityData().get(ScrutimiteEntity.DATA_egg)) {
			if (entity instanceof ScrutimiteEntity animatable)
				animatable.setTexture("scrutimite_egg_hold");
		} else {
			if (entity instanceof ScrutimiteEntity animatable)
				animatable.setTexture("scrutimite");
		}
		if (Mth.nextInt(RandomSource.create(), 1, 50) == 20) {
			if (entity instanceof ScrutimiteEntity _datEntL4 && _datEntL4.getEntityData().get(ScrutimiteEntity.DATA_egg)) {
				world.setBlock(BlockPos.containing(x, y, z), SotvModBlocks.ENDERMITE_EGG.get().defaultBlockState(), 3);
				if (entity instanceof ScrutimiteEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ScrutimiteEntity.DATA_egg, false);
			} else {
				sx = -3;
				found = false;
				for (int index0 = 0; index0 < 6; index0++) {
					sy = -3;
					for (int index1 = 0; index1 < 6; index1++) {
						sz = -3;
						for (int index2 = 0; index2 < 6; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == SotvModBlocks.ENDERMITE_EGG.get()) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
								found = true;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (entity instanceof ScrutimiteEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ScrutimiteEntity.DATA_egg, found);
			}
		}
	}
}
