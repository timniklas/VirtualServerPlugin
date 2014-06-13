package com.cyberdos.bukkit.servermanager.commands.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cyberdos.bukkit.servermanager.commands.Cmd_server;
import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Cmd_server_stop {

	public Cmd_server_stop(CommandSender sender, String label, String[] args) {
			if(args.length == 2) {
				if(sender.hasPermission("virtualserver.stop." + args[1]) || sender.hasPermission("virtualserver.stop.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
						World w = Bukkit.getWorld("servers/" + args[1]);
						if(w != null) {
							String n = w.getName();
							
							if(Bukkit.getWorlds().contains(w)) {
								sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
								sender.sendMessage(ChatColor.GOLD + "Server " + n.substring(8) + ChatColor.RED + " stoped!");
								sender.sendMessage(ChatColor.GRAY + "=============================");
							} else {
								sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
								sender.sendMessage(ChatColor.GOLD + "Server " + n.substring(8) + ChatColor.RED + " already Offline!");
								sender.sendMessage(ChatColor.GRAY + "=============================");
							}
							
							for (Player player : Bukkit.getOnlinePlayers()) {
								Location loc = Bukkit.getWorlds().get(0).getSpawnLocation();
								if(player.getLocation().getWorld() == w) {
									
								player.teleport(loc);
								player.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "You were kicked to the Lobby! <Reason: Server closed!>");
								}
								}
							w.save();
							Bukkit.unloadWorld(w, false);
							Bukkit.getWorlds().remove(w);
						} else {
							sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "Server is already offline!");
						}
				} else {
					sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
				sender.sendMessage(ChatColor.GOLD + " /" + Cmd_server.cmd + " stop " + ChatColor.BOLD + "NAME");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}
	
}
