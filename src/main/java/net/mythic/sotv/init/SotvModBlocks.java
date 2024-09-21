
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mythic.sotv.block.NixtineSandstoneBlock;
import net.mythic.sotv.block.NixtineSandBlock;
import net.mythic.sotv.block.MitenusBlock;
import net.mythic.sotv.block.HardenedMitenusBlock;
import net.mythic.sotv.block.EndermiteEggBlock;
import net.mythic.sotv.SotvMod;

import net.minecraft.world.level.block.Block;

public class SotvModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(SotvMod.MODID);
	public static final DeferredHolder<Block, Block> NIXTINE_SAND = REGISTRY.register("nixtine_sand", NixtineSandBlock::new);
	public static final DeferredHolder<Block, Block> NIXTINE_SANDSTONE = REGISTRY.register("nixtine_sandstone", NixtineSandstoneBlock::new);
	public static final DeferredHolder<Block, Block> ENDERMITE_EGG = REGISTRY.register("endermite_egg", EndermiteEggBlock::new);
	public static final DeferredHolder<Block, Block> HARDENED_MITENUS = REGISTRY.register("hardened_mitenus", HardenedMitenusBlock::new);
	public static final DeferredHolder<Block, Block> MITENUS = REGISTRY.register("mitenus", MitenusBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
