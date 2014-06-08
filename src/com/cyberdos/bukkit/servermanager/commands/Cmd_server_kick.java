package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd_server_kick {
	
	public Cmd_server_kick(CommandSender sender, String label, String[] args) {
			if(args.length >= 3) {
				if(sender.hasPermission("virtualserver.kick." + args[1]) || sender.hasPermission("virtualserver.kick.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
						@SuppressWarnings("deprecation")
						Player player = Bukkit.getPlayer(args[1]);
						Location loc = Bukkit.getWorlds().get(0).getSpawnLocation();
						
						if(loc != player.getWorld().getSpawnLocation()) {
							player.teleport(loc);
							String result = "";
							for (String s : args) {
							    result += s + " ";
							}
							player.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "You were kicked to the Lobby! <Reason: " + result.substring(args[1].length() + 5) + "!>");
						} else {
							sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "Player already on the lobby server!");
						}
				} else {
					sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
				sender.sendMessage(ChatColor.GOLD + " / kick " + ChatColor.BOLD + "PLAYER REASON");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}

}
