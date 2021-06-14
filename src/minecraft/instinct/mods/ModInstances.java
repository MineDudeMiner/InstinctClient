package instinct.mods;

import instinct.gui.hud.HUDManager;
import instinct.mods.impl.ModFPS;
import instinct.mods.impl.ModFullbright;
 
public class ModInstances {
 
	private static ModFPS modFPS;
	private static ModFullbright modFullbright;
 
	public static void register(HUDManager api) {
		modFPS = new ModFPS();
		api.register(modFPS);
		
		modFullbright = new ModFullbright();
		api.register(modFullbright);
	}
	
 
	public static ModFPS getC() {
		return modFPS;
	}
 
}
