package com.cyberdos.bukkit.servermanager.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmd_server {

	public static boolean run(CommandSender sender, String label, String[] args) {
		
		if(args.length != 0) {
			if(args[0].equalsIgnoreCase("help")) {
				new Cmd_server_help(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("create")) {
				new Cmd_server_create(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("delete")) {
				new Cmd_server_delete(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("start")) {
				new Cmd_server_start(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("stop")) {
				new Cmd_server_stop(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("status")) {
				new Cmd_server_status(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("join") && sender instanceof Player) {
				new Cmd_server_join(sender, label, args);
			} else
				
				
			if(args[0].equalsIgnoreCase("kick")) {
				new Cmd_server_kick(sender, label, args);
			}
			
		} else {
			new Cmd_server_help(sender, label, args);
		}
		
		return true;
	}

}
