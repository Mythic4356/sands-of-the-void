
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mythic.sotv.SotvMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class SotvModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, SotvMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ISOPETRAN_LASER = REGISTRY.register("isopetran_laser", () -> new SimpleParticleType(false));
}
