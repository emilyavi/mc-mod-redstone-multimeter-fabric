package rsmm.fabric.mixin.meterable;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.DetectorRailBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import rsmm.fabric.common.event.EventType;
import rsmm.fabric.server.MeterableBlock;

@Mixin(DetectorRailBlock.class)
public class DetectorRailBlockMixin implements MeterableBlock {
	
	@Override
	public boolean isActive(World world, BlockPos pos, BlockState state) {
		return state.get(Properties.POWERED);
	}
	
	@Override
	public int getDefaultMeteredEvents() {
		return EventType.ACTIVE.flag() | EventType.MOVED.flag();
	}
}
