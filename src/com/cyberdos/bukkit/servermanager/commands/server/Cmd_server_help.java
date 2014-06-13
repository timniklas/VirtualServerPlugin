package com.cyberdos.bukkit.servermanager.commands.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Cmd_server_help {
	
	public Cmd_server_help(CommandSender sender, String label, String[] args) {
		Plugin plugin = Bukkit.getPluginManager().getPlugin(ServerManager.name);
		String version = plugin.getDescription().getVersion();
		sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "parameters:");
		sender.sendMessage(ChatColor.GOLD + "  help ,  create ,  delete");
		sender.sendMessage(ChatColor.GOLD + "  start ,  stop ,  status");
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "commands:");
		sender.sendMessage(ChatColor.GOLD + "  /server ,  /vhost ,  /lobby ");
		sender.sendMessage(ChatColor.GOLD + "To reload the config use /reload");
		sender.sendMessage(ChatColor.GRAY + " VirtualServerVersion: " + version);
		sender.sendMessage(ChatColor.GRAY + "=============================");
	}

}
