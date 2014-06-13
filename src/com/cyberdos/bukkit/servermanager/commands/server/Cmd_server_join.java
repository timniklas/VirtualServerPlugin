package com.cyberdos.bukkit.servermanager.commands.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cyberdos.bukkit.servermanager.commands.Cmd_server;
import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Cmd_server_join {
	
	public Cmd_server_join(CommandSender sender, String label, String[] args) {
			if(args.length == 2) {
				if(sender.hasPermission("virtualserver.join." + args[1]) || sender.hasPermission("virtualserver.join.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
						World w = Bukkit.getWorld("servers/" + args[1]);
						if(w != null) {
							String n = w.getName().substring(8);
							
							Player p = (Player) sender;
							Location loc = w.getSpawnLocation();
							
							if(Bukkit.getWorlds().contains(w)) {
								p.teleport(loc);
								sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.GREEN + " You were teleported to " + n + "!");
							} else {
								sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + " Server " + n + " is offline!");
							}
						} else {
							sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + " Server is offline!");
						}
				} else {
					sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
				sender.sendMessage(ChatColor.GOLD + " /" + Cmd_server.cmd + " join " + ChatColor.BOLD + "NAME");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}

}
