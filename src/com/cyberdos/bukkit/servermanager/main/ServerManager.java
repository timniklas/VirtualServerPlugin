package com.cyberdos.bukkit.servermanager.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.cyberdos.bukkit.servermanager.commands.CommandHandler;
import com.cyberdos.bukkit.servermanager.events.Enable;

public class ServerManager extends JavaPlugin {
	
	public void onEnable(){
		new Enable(this);
	}
	
	public void onDisable(){
		//new Disable(this);
		
		for (World world : Bukkit.getWorlds()) {
			world.save();
		}
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		return CommandHandler.onCommand(sender, cmd, label, args);
	}

}
