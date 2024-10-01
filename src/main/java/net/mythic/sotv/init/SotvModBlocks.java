
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mythic.sotv.block.NixtineSandstoneWallBlock;
import net.mythic.sotv.block.NixtineSandstoneStairsBlock;
import net.mythic.sotv.block.NixtineSandstoneSlabBlock;
import net.mythic.sotv.block.NixtineSandstoneBlock;
import net.mythic.sotv.block.NixtineSandBlock;
import net.mythic.sotv.block.MitenusBlock;
import net.mythic.sotv.block.MiteVentBlock;
import net.mythic.sotv.block.IsopetranGelBlock;
import net.mythic.sotv.block.HardenedMitenusBlock;
import net.mythic.sotv.block.GelcoonBlock;
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
	public static final DeferredHolder<Block, Block> NIXTINE_SANDSTONE_STAIRS = REGISTRY.register("nixtine_sandstone_stairs", NixtineSandstoneStairsBlock::new);
	public static final DeferredHolder<Block, Block> NIXTINE_SANDSTONE_WALL = REGISTRY.register("nixtine_sandstone_wall", NixtineSandstoneWallBlock::new);
	public static final DeferredHolder<Block, Block> NIXTINE_SANDSTONE_SLAB = REGISTRY.register("nixtine_sandstone_slab", NixtineSandstoneSlabBlock::new);
	public static final DeferredHolder<Block, Block> ISOPETRAN_GEL = REGISTRY.register("isopetran_gel", IsopetranGelBlock::new);
	public static final DeferredHolder<Block, Block> GELCOON = REGISTRY.register("gelcoon", GelcoonBlock::new);
	public static final DeferredHolder<Block, Block> MITE_VENT = REGISTRY.register("mite_vent", MiteVentBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
