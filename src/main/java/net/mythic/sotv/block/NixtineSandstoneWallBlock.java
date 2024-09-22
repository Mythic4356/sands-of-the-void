
package net.mythic.sotv.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NixtineSandstoneWallBlock extends WallBlock {
	public NixtineSandstoneWallBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.2f, 0.4f).dynamicShape().forceSolidOn());
	}
}