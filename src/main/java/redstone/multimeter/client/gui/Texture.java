package redstone.multimeter.client.gui;

import net.minecraft.util.ResourceLocation;

public class Texture {
	
	public static final Texture OPTIONS_BACKGROUND = new Texture(new ResourceLocation("textures/gui/options_background.png"), 16, 16);
	public static final Texture OPTIONS_WIDGETS    = new Texture(new ResourceLocation("textures/gui/widgets.png"), 256, 256);
	
	public final ResourceLocation id;
	public final int width;
	public final int height;
	
	private Texture(ResourceLocation id, int width, int height) {
		this.id = id;
		this.width = width;
		this.height = height;
	}
}
