package com.icey.walls.timers;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;

import com.icey.walls.framework.WallsArena;
import com.icey.walls.runnables.WallsCountdown;
import com.icey.walls.scoreboard.WallsScoreboard;

public class WallsLobbyCountdown extends WallsCountdown {
	
	public WallsLobbyCountdown(int minutes, int seconds, Collection<WallsScoreboard> wallsSB, WallsArena arena) {
		super(minutes, seconds, wallsSB, arena);
	}
	
	@Override
	public void runNextStage() {
		getArena().startPrep();
	}

	@Override
	public void runEverySecond() {
		if (getSeconds() == 10 && getMinutes()==0) {
			for (UUID id : getArena().getPlayersInGame()) {
				Bukkit.getPlayer(id).playSound(Bukkit.getPlayer(id).getLocation(), Sound.WOOD_CLICK, 10, 1);
				Bukkit.getPlayer(id).sendMessage(ChatColor.GOLD +"Game starting in " + ChatColor.GREEN +""+getSeconds()+""+ChatColor.GOLD+" seconds!");
			}
		}
		else if (getSeconds() >= 0 && getSeconds() <= 5 && getMinutes()==0) {
			for (UUID id : getArena().getPlayersInGame()) {
				Bukkit.getPlayer(id).playSound(Bukkit.getPlayer(id).getLocation(), Sound.WOOD_CLICK, 10, 1);
				Bukkit.getPlayer(id).sendMessage(ChatColor.GOLD +"Game starting in " + ChatColor.GREEN +""+getSeconds()+""+ChatColor.GOLD+" seconds!");
			}
		}
	}
}
