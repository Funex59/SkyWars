package fr.funex.skywarsfunex.runnable;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.funex.skywarsfunex.GameStatus;

public class LobbyRunnable extends BukkitRunnable{
	
	public int timer = 60;
	public static boolean start = false;

	@Override
	public void run() {
		timer--;

		if((Bukkit.getOnlinePlayers().size() == 1) || (GameStatus.isStatus(GameStatus.LOBBY))){
			Bukkit.broadcastMessage("§cIl n'y a pas assez de joueurs pour lancer la partie . . .");
			//nombre de joueurs minimum pour lancer la partie//
			timer = 60;
			this.cancel();
			return;
		}
		
		if (timer == 60 || timer == 45 || timer == 30 || timer == 15 || timer == 10 || timer == 5 || timer == 3 || timer == 2 || timer == 1){
			Bukkit.broadcastMessage("§6La partie commence dans §c" + timer + "§6" + getSecond(timer));
			//messages de timer
			for (Player players : Bukkit.getOnlinePlayers()){
				players.playSound(players.getLocation(), Sound.BLOCK_SLIME_BLOCK_FALL, 1f, 1f);
				//son au lancement
			}
			return;
		}
		
		setLevel();
		
		if (timer == 0){
			timer = 60;
			this.cancel();
			return;
		}
		
	}
	
	public void setLevel(){
		for (Player players : Bukkit.getOnlinePlayers()){
			players.setLevel(timer);
		}
	}
	
	
	private String getSecond(int time){
		
		if(time == 1) return "seconde.";
		
		return "secondes.";
	}
	
	

}
