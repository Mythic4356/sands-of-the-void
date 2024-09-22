package net.mythic.sotv.procedures;

import net.neoforged.bus.api.Event;

public class EndermiteEggHatchPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:hoes"))))) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
