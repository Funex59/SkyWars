package fr.funex.skywarsfunex;

import org.bukkit.plugin.java.JavaPlugin;

import fr.funex.skywarsfunex.listeners.ListenerManager;

public class SkyWars extends JavaPlugin{
	
	public static SkyWars INSTANCE;
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		new ListenerManager(this).registerListeners();
		GameStatus.setStatus(GameStatus.LOBBY);
		

	}
	
	@Override
	public void onDisable() {

	}
	
	public String getPrefix(){
		return "§6Sky§eWars>>";
	}

}
