package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class CommandHandler {

	public static boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("vhost")){
			return Cmd_server.run(sender, label, args);
		} else
		
		if(cmd.getName().equalsIgnoreCase("server")){
			return Cmd_svr.run(sender, label, args);
		} else
			
		if(cmd.getName().equalsIgnoreCase("lobby") && sender instanceof Player){
			return Cmd_lobby.run(sender, label, args);
		} else {
			if(sender instanceof Player) {} else {
				sender.sendMessage("[" + ServerManager.name + "]" + "You are not a player!");
			}
		}
		
		return false;
	}

}
