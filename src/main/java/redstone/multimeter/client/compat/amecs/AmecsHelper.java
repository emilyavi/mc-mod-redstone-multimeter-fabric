package redstone.multimeter.client.compat.amecs;
/*
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import de.siphalor.amecs.api.KeyBindingUtils;
import de.siphalor.amecs.api.KeyModifier;
import de.siphalor.amecs.api.KeyModifiers;
import de.siphalor.amecs.impl.ModifierPrefixTextProvider.Variation;

import net.fabricmc.loader.api.FabricLoader;
*/
import net.minecraft.client.KeyMapping;
//import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

//import redstone.multimeter.util.TextUtils;

public class AmecsHelper {
/*
	private static boolean isAmecsApiLoaded = FabricLoader.getInstance().isModLoaded("amecsapi");

	public static Collection<KeyModifier> getKeyModifiers(KeyMapping keybind) {
		KeyModifiers keyModifiers = KeyBindingUtils.getBoundModifiers(keybind);

		if (keyModifiers.isUnset()) {
			return Collections.emptyList();
		}

		Collection<KeyModifier> modifiers = new LinkedList<>();

		for (KeyModifier modifier : KeyModifier.VALUES) {
			if (modifier != KeyModifier.NONE && keyModifiers.get(modifier)) {
				modifiers.add(modifier);
			}
		}

		return modifiers;
	}

	public static Component getModifierName(KeyModifier modifier, Variation variation) {
		return MutableComponent.create(variation.getTranslatableText(modifier.getTranslationKey()));
	}

	public static Component getModifierName(KeyModifier modifier) {
		return getModifierName(modifier, Variation.NORMAL);
	}
*/
	public static MutableComponent addModifiers(MutableComponent text, KeyMapping keybind) {
		/*if (isAmecsApiLoaded) {
			for (KeyModifier modifier : getKeyModifiers(keybind)) {
				text.
					append(TextUtils.formatKey(getModifierName(modifier))).
					append(" + ");
			}
		}*/

		return text;
	}
}
