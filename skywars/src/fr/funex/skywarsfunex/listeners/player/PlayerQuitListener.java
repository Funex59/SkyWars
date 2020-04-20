package fr.funex.skywarsfunex.listeners.player;



import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class PlayerQuitListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerQuitEvent event){
		event.setQuitMessage(null);
		
	}

}
