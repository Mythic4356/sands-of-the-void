package net.mythic.sotv.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Final;

import net.mythic.sotv.endbiomes.SamplerHooks;

import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.core.HolderGetter;

@Mixin(RandomState.class)
public class NoiseConfigMixin {
	@Shadow
	@Final
	private Climate.Sampler sampler;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void init(NoiseGeneratorSettings chunkGeneratorSettings, HolderGetter<NormalNoise.NoiseParameters> arg, long seed, CallbackInfo ci) {
		((SamplerHooks) (Object) sampler).setSeed(seed);
	}
}
