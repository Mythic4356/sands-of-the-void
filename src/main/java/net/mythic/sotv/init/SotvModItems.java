
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.mythic.sotv.item.LatePearlItem;
import net.mythic.sotv.item.EndingRingItem;
import net.mythic.sotv.item.ClaspearlItem;
import net.mythic.sotv.SotvMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

public class SotvModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, SotvMod.MODID);
	public static final DeferredHolder<Item, Item> NIXTINE_SAND = block(SotvModBlocks.NIXTINE_SAND);
	public static final DeferredHolder<Item, Item> NIXTINE_SANDSTONE = block(SotvModBlocks.NIXTINE_SANDSTONE);
	public static final DeferredHolder<Item, Item> ENDERMITE_EGG = block(SotvModBlocks.ENDERMITE_EGG);
	public static final DeferredHolder<Item, Item> HARDENED_MITENUS = block(SotvModBlocks.HARDENED_MITENUS);
	public static final DeferredHolder<Item, Item> MITENUS = block(SotvModBlocks.MITENUS);
	public static final DeferredHolder<Item, Item> NIXTINE_SANDSTONE_STAIRS = block(SotvModBlocks.NIXTINE_SANDSTONE_STAIRS);
	public static final DeferredHolder<Item, Item> NIXTINE_SANDSTONE_WALL = block(SotvModBlocks.NIXTINE_SANDSTONE_WALL);
	public static final DeferredHolder<Item, Item> NIXTINE_SANDSTONE_SLAB = block(SotvModBlocks.NIXTINE_SANDSTONE_SLAB);
	public static final DeferredHolder<Item, Item> CLASPEARL = REGISTRY.register("claspearl", ClaspearlItem::new);
	public static final DeferredHolder<Item, Item> ISOPETRAN_GEL = block(SotvModBlocks.ISOPETRAN_GEL);
	public static final DeferredHolder<Item, Item> LATE_PEARL = REGISTRY.register("late_pearl", LatePearlItem::new);
	public static final DeferredHolder<Item, Item> GELCOON = block(SotvModBlocks.GELCOON);
	public static final DeferredHolder<Item, Item> SCRUTIMITE_SPAWN_EGG = REGISTRY.register("scrutimite_spawn_egg", () -> new DeferredSpawnEggItem(SotvModEntities.SCRUTIMITE, -13434829, -65536, new Item.Properties()));
	public static final DeferredHolder<Item, Item> QUEEN_MITE_SPAWN_EGG = REGISTRY.register("queen_mite_spawn_egg", () -> new DeferredSpawnEggItem(SotvModEntities.QUEEN_MITE, -6750055, -10092442, new Item.Properties()));
	public static final DeferredHolder<Item, Item> MITE_VENT = block(SotvModBlocks.MITE_VENT);
	public static final DeferredHolder<Item, Item> ENDING_RING = REGISTRY.register("ending_ring", EndingRingItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
