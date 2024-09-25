
package net.mythic.sotv.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class LatePearlItem extends Item {
	public LatePearlItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}
}