
package net.mythic.sotv.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class ClaspearlItem extends Item {
	public ClaspearlItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ClaspearlRightclickedProcedure.execute();
		return ar;
	}
}