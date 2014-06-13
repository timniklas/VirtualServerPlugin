package com.cyberdos.bukkit.servermanager.commands.server;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cyberdos.bukkit.servermanager.commands.Cmd_server;
import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Cmd_server_create {
	
	public Cmd_server_create(CommandSender sender, String label, String[] args) {
			if(args.length == 4) {
				if(sender.hasPermission("virtualserver.create") ||  sender.hasPermission("virtualserver.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
					File f = new File("servers/" + args[1]);
					if (f.exists() && f.isDirectory()) {
						sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "World already exist!");
		                
					} else {
						WorldCreator c = new WorldCreator("servers/" + args[1]);
		                c.environment(c.environment());
		                c.generator(args[3]);
		                long l = Long.parseLong(args[2]);
		                c.seed(l);
		                World w = c.createWorld();
		                Bukkit.getWorlds().add(w);
		                
						sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
						sender.sendMessage(ChatColor.GREEN + "Server " + args[1] + " created!");
						sender.sendMessage(ChatColor.GRAY + "=============================");
						
						Player p = (Player) sender;
						Location loc = w.getSpawnLocation();
						p.teleport(loc);
				}
				} else {
					sender.sendMessage(ChatColor.BLUE + "[" + ServerManager.name + "]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
	                
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= " + ServerManager.name + " =======");
				sender.sendMessage(ChatColor.GOLD + " /" + Cmd_server.cmd + " create " + ChatColor.BOLD + "NAME SEED(number) WORLDGENERATOR(default is NORMAL)");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}

}
