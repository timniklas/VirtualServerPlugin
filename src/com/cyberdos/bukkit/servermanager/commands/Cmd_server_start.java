package com.cyberdos.bukkit.servermanager.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd_server_start {

	public Cmd_server_start(CommandSender sender, String label, String[] args) {
			if(args.length == 2) {
				
				if(sender.hasPermission("virtualserver.start." + args[1]) || sender.hasPermission("virtualserver.start.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
					File f = new File("servers/" + args[1]);
					if (f.exists() && f.isDirectory()) {
						WorldCreator c = new WorldCreator("servers/" + args[1]);
		                World w = c.createWorld();
		                Bukkit.getWorlds().add(w);
		                
						sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
						sender.sendMessage(ChatColor.GREEN + "Server " + args[1] + " created!");
						sender.sendMessage(ChatColor.GRAY + "=============================");
						
						Player p = (Player) sender;
						Location loc = w.getSpawnLocation();
						p.teleport(loc);
		                
					} else {
						sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "World does not exist!");
					}
				} else {
					sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
				sender.sendMessage(ChatColor.GOLD + " / start " + ChatColor.BOLD + "NAME");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
}
	
}
