package com.cyberdos.bukkit.servermanager.events;

import org.bukkit.Bukkit;
import org.bukkit.World;

import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Disable {

	public Disable(ServerManager serverManager) {
		
		for (World world : Bukkit.getWorlds()) {
			world.save();
		}
	}

}
