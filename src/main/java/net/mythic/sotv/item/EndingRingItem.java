
package net.mythic.sotv.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.mythic.sotv.procedures.EndingRingWhileBaubleIsEquippedTickProcedure;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class EndingRingItem extends Item implements ICurioItem {
	public EndingRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		EndingRingWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity());
	}
}
