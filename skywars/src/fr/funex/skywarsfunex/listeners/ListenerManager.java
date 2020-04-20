package fr.funex.skywarsfunex.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.funex.skywarsfunex.listeners.player.PlayerJoinListener;
import fr.funex.skywarsfunex.listeners.player.PlayerQuitListener;



public class ListenerManager {
	
	public Plugin plugin;
	public PluginManager pluginManager;
	
	public ListenerManager(Plugin plugin){
		this.plugin = plugin;
		this.pluginManager = Bukkit.getPluginManager();
		
	}
	
	public void registerListeners(){
		this.pluginManager.registerEvents(new PlayerJoinListener(), this.plugin);
		this.pluginManager.registerEvents(new PlayerQuitListener(), this.plugin);
		
	}

}
