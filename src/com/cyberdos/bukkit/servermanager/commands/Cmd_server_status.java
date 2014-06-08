package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

public class Cmd_server_status {
	
	public Cmd_server_status(CommandSender sender, String label, String[] args) {
			if(args.length == 1) {
				if(sender.hasPermission("virtualserver.status.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
					
					String str1 = "";
					for (World world : Bukkit.getWorlds()) {
						if(world.getName().startsWith("servers/")) {
							str1 += world.getName().substring("servers/".length()) + ", ";
						}
						
					}
					sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
					if(str1 != "") {
						sender.sendMessage(ChatColor.GRAY + str1.substring(0, str1.length() -2));
					} else {
						sender.sendMessage(ChatColor.GRAY + "No servers online! :(");
					}
					sender.sendMessage(ChatColor.GRAY + "=============================");
					
				} else {
					sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
				sender.sendMessage(ChatColor.GOLD + " / status ");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}

}
