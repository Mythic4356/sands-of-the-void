
package net.mythic.sotv.world.features;

import net.mythic.sotv.procedures.EndermiteNestAdditionalGenerationConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class EndermiteNestFeature extends GeodeFeature {
	public EndermiteNestFeature() {
		super(GeodeConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<GeodeConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!EndermiteNestAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
