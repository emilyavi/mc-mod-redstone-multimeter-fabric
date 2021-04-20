package rsmm.fabric.client.gui.log;

import rsmm.fabric.common.Meter;
import rsmm.fabric.common.event.EventType;

public class ActiveEventRenderer extends ToggleEventRenderer {
	
	public ActiveEventRenderer() {
		super(EventType.ACTIVE);
	}
	
	@Override
	protected void updateMode(Meter meter) {
		mode = meter.isMetering(EventType.POWERED) ? Mode.BOTTOM : Mode.ALL;
	}
	
	@Override
	protected boolean isToggled(Meter meter) {
		return meter.isActive();
	}
}