package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Cmd_svr {

	public static boolean run(CommandSender sender, String label, String[] args) {
		
		Player p = (Player) sender;
		World w = p.getWorld();
		
		if(w.getName().startsWith("servers/")) {
			String name = w.getName().substring("servers/".length());
			p.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.GOLD + "You are on server: " + name);
		} else {
			p.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.GOLD + "You are on server: " + "lobby");
		}
		
		return true;
	}

}
