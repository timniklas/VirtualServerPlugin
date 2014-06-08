package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd_lobby {

	public static boolean run(CommandSender sender, String label, String[] args) {
		
		Player p = (Player) sender;
		Location loc = Bukkit.getWorlds().get(0).getSpawnLocation();
		
		if(p.getWorld().getSpawnLocation() != loc) {
			p.teleport(loc);
			p.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.GRAY + "Teleported to lobby...");
		} else {
			p.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "You are already on the lobby server!");
		}
		
		return true;
	}

}
