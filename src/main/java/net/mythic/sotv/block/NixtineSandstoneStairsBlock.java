
package net.mythic.sotv.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NixtineSandstoneStairsBlock extends StairBlock {
	public NixtineSandstoneStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(1.2f, 0.4f).dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 0.4f;
	}
}