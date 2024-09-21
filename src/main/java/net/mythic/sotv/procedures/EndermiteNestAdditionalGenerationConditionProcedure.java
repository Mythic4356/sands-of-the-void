package net.mythic.sotv.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EndermiteNestAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR);
	}
}
