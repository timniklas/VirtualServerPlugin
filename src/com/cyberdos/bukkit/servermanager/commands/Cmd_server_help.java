package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Cmd_server_help {
	
	public Cmd_server_help(CommandSender sender, String label, String[] args) {
		Plugin plugin = Bukkit.getPluginManager().getPlugin("ServerManager");
		String version = plugin.getDescription().getVersion();
		
		sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "parameters:");
		sender.sendMessage(ChatColor.GOLD + "  help ,  create ,  delete");
		sender.sendMessage(ChatColor.GOLD + "  start ,  stop ,  status ");
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "commands:");
		sender.sendMessage(ChatColor.GOLD + "  /server ,  /vhost ,  /lobby ");
		sender.sendMessage(ChatColor.GOLD + " VirtualServerVersion: " + version);
		sender.sendMessage(ChatColor.GRAY + "=============================");
	}

}
