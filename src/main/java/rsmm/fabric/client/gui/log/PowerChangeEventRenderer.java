package rsmm.fabric.client.gui.log;

import static rsmm.fabric.client.gui.HudSettings.*;

import net.minecraft.client.util.math.MatrixStack;

import rsmm.fabric.common.Meter;
import rsmm.fabric.common.event.EventType;
import rsmm.fabric.common.event.MeterEvent;

public class PowerChangeEventRenderer extends BasicEventRenderer {
	
	public PowerChangeEventRenderer() {
		super(EventType.POWER_CHANGE, (m, e) -> BACKGROUND_COLOR, (m, e) -> m.getColor());
	}
	
	@Override
	protected void drawCenter(MatrixStack matrices, int x, int y, Meter meter, MeterEvent event) {
		int metaData = event.getMetaData();
		int oldPower = (metaData >> 8) & 0xFF;
		int newPower = metaData        & 0xFF;
		
		boolean increased = (newPower > oldPower);
		
		int half = ROW_HEIGHT / 2;
		int color = centerColorProvider.apply(meter, event);
		
		if (increased) {
			fill(matrices, x + 1, y + half, x + COLUMN_WIDTH, y + ROW_HEIGHT - half, color);
		} else {
			fill(matrices, x, y + half, x + COLUMN_WIDTH - 1, y + ROW_HEIGHT - half, color);
		}
	}
}