package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Cmd_server_delete {
	
	public Cmd_server_delete(CommandSender sender, String label, String[] args) {
			if(args.length == 2) {
				if(sender.hasPermission("virtualserver.delete." + args[1]) || sender.hasPermission("virtualserver.delete.*") || sender.hasPermission("virtualserver.*") || sender.isOp()) {
						/*WorldCreator wc = new WorldCreator("servers/" + args[1]);
						Bukkit.createWorld(wc);
						World w = Bukkit.getWorld("servers/" + args[1]);
						String n = w.getName();
		
		
						Bukkit.unloadWorld(w, false);
						Bukkit.getWorlds().remove(w);
						
						for (Player player : Bukkit.getOnlinePlayers()) {
							Location loc = Bukkit.getWorlds().get(0).getSpawnLocation();
							if(player.getLocation().getWorld() == w) {
								
							player.teleport(loc);
							player.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "You were kicked to the Lobby! <Reason: Server closed!>");
							}
							}
						
						AdvenTourDeleteFolder.DeleteFileFolder(n, (Player) sender);
						
						sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
						sender.sendMessage(ChatColor.RED + "Server " + n + "deleted!");
						sender.sendMessage(ChatColor.GRAY + "=============================");*/
						
				} else {
					sender.sendMessage(ChatColor.BLUE + "[ServerManager]" + ChatColor.RED + "Sorry but you don't have permissions for this!");
				}
			} else {
				sender.sendMessage(ChatColor.GRAY + "======= Server Manager =======");
				sender.sendMessage(ChatColor.GOLD + " / delete " + ChatColor.BOLD + "NAME");
				sender.sendMessage(ChatColor.GRAY + "=============================");
			}
	}

}
