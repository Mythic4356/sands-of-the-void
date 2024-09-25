
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mythic.sotv.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mythic.sotv.SotvMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class SotvModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SotvMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SANDS_OF_THE_VOID_CREATIVE_TAB = REGISTRY.register("sands_of_the_void_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.sotv.sands_of_the_void_creative_tab")).icon(() -> new ItemStack(SotvModBlocks.NIXTINE_SAND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SotvModBlocks.NIXTINE_SAND.get().asItem());
				tabData.accept(SotvModBlocks.NIXTINE_SANDSTONE.get().asItem());
				tabData.accept(SotvModBlocks.ENDERMITE_EGG.get().asItem());
				tabData.accept(SotvModBlocks.HARDENED_MITENUS.get().asItem());
				tabData.accept(SotvModBlocks.MITENUS.get().asItem());
				tabData.accept(SotvModBlocks.NIXTINE_SANDSTONE_STAIRS.get().asItem());
				tabData.accept(SotvModBlocks.NIXTINE_SANDSTONE_WALL.get().asItem());
				tabData.accept(SotvModBlocks.NIXTINE_SANDSTONE_SLAB.get().asItem());
				tabData.accept(SotvModItems.CLASPEARL.get());
				tabData.accept(SotvModBlocks.ISOPETRAN_GEL.get().asItem());
				tabData.accept(SotvModItems.LATE_PEARL.get());
			})

					.build());
}
