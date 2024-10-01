package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModBlocks;
import net.mythic.sotv.entity.ScrutimiteEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class ScrutimiteEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.sculk_shrieker.shriek")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
		if (entity instanceof ScrutimiteEntity _datEntL1 && _datEntL1.getEntityData().get(ScrutimiteEntity.DATA_egg)) {
			world.setBlock(BlockPos.containing(x, y, z), SotvModBlocks.ENDERMITE_EGG.get().defaultBlockState(), 3);
		}
	}
}
