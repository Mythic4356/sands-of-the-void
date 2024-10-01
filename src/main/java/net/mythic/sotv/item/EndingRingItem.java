
package net.mythic.sotv.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

import javax.annotation.Nullable;

public class EndingRingItem extends Item implements ICurioItem {
	public EndingRingItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		EndingRingWhileBaubleIsEquippedTickProcedure.execute();
	}
}