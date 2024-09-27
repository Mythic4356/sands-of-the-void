package net.mythic.sotv.procedures;

import net.mythic.sotv.init.SotvModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class ScrutimiteEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
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
		sx = -2;
		for (int index0 = 0; index0 < 4; index0++) {
			sy = -2;
			sz = -2;
			for (int index1 = 0; index1 < 4; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == SotvModBlocks.ENDERMITE_EGG.get()) {
					world.destroyBlock(BlockPos.containing(x + sx, y + sy, z + sz), false);
				}
				sz = sz + 1;
			}
			sy = sy + 1;
			sx = sx + 1;
		}
	}
}
