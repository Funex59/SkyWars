package fr.funex.skywarsfunex.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.funex.skywarsfunex.GameStatus;
import fr.funex.skywarsfunex.SkyWars;
import fr.funex.skywarsfunex.runnable.LobbyRunnable;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		event.setJoinMessage(SkyWars.INSTANCE.getPrefix() + ChatColor.GRAY + player.getName() + "§6 a rejoint la partie . . . §7" + Bukkit.getOnlinePlayers().size() + " §6joueurs ");
		
		player.getInventory();
		player.setFoodLevel(20);
		player.setHealth(20);
		player.setLevel(0);
		player.setGameMode(GameMode.SURVIVAL);
		
		if ((!LobbyRunnable.start) && (!GameStatus.isStatus(GameStatus.LOBBY)))	{
			new LobbyRunnable().runTaskTimer(SkyWars.INSTANCE, 0L, 20L);
			LobbyRunnable.start = true;
			return;
		}
	}

}
