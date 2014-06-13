package com.cyberdos.bukkit.servermanager.events;

import java.io.IOException;

import com.cyberdos.bukkit.servermanager.main.ServerManager;
import com.cyberdos.bukkit.servermanager.tools.Config;
import com.cyberdos.bukkit.servermanager.tools.Metrics;

public class Enable {

	public Enable(ServerManager serverManager) {
		serverManager.getServer().getPluginManager().registerEvents(new EventListener(), serverManager);
		
		Config.start(serverManager);
		
		try {
		    Metrics metrics = new Metrics(serverManager);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}

}
