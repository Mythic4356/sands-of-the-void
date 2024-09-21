
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mythic.sotv.world.features.EndermiteNestFeature;
import net.mythic.sotv.SotvMod;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

public class SotvModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, SotvMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> ENDERMITE_NEST = REGISTRY.register("endermite_nest", EndermiteNestFeature::new);
}
