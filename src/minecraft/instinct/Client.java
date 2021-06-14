package instinct;

import instinct.event.EventManager;
import instinct.event.EventTarget;
import instinct.event.impl.ClientTickEvent;
import instinct.gui.SplashProgress;
import instinct.gui.hud.HUDManager;
import instinct.gui.options.GuiModToggle;
import instinct.mods.ModInstances;
import net.minecraft.client.Minecraft;

public class Client {
	
	
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() { 
		
		return INSTANCE; 
		
	}
			
	private DiscordRP discordRP = new DiscordRP();
	
	private HUDManager hudManager;
	
	public void init() {	
		FileManager.init();
		SplashProgress.setProgress(1, "Client -Initializing Discord RP");
		discordRP.start();
		
		EventManager.register(this);
		
		
	}
	
	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
	}
	
	
	public void shutdown() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		
		if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
			hudManager.openConfigScreen();
		}
		
		if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_TOGGLE.isPressed()) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiModToggle());
			
		}
		
	}

}
