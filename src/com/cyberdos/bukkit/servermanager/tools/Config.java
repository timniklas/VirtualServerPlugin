package com.cyberdos.bukkit.servermanager.tools;

import java.io.File;
import java.io.IOException;

import com.cyberdos.bukkit.servermanager.main.ServerManager;

public class Config {
	
	public static boolean CfgLocalChat = true;
	public static boolean CfgLocalTablist = true;
	public static boolean CfgLocalJoinLeave = true;
	
	public static void start(ServerManager serverManager) {
			loadCfg(serverManager);
	}
	
	public static void stop(ServerManager serverManager) {
			//saveCfg(serverManager);
	}
	
	public static void loadCfg(ServerManager serverManager) {
			CfgLocalChat = checkBool(serverManager, "vhost.LocalChat", true);
			CfgLocalTablist = checkBool(serverManager, "vhost.LocalTablist", true);
			CfgLocalJoinLeave = checkBool(serverManager, "vhost.LocalJoinLeave", true);
	}
	
	private static boolean checkBool(ServerManager serverManager, String value, boolean defaultvalue) {
		if(serverManager.getConfig().isBoolean(value)) {
			Boolean bol = serverManager.getConfig().getBoolean(value);
			System.out.println("--[" + ServerManager.name + "] Loaded: " + value + " = " + bol);
			return bol;
		} else {
			System.out.println("--[" + ServerManager.name + "] Saved: " + value + " = " + defaultvalue);
			serverManager.getConfig().set(value, defaultvalue);
			saveCfg(serverManager);
			return defaultvalue;
		}
	}
	
	@SuppressWarnings("unused")
	private static String checkString(ServerManager serverManager, String value, String defaultmsg) {
		if(serverManager.getConfig().isSet(value)) {
			System.out.println("--[" + ServerManager.name + "] Loaded: " + value + " = " + serverManager.getConfig().getString(value));
			return serverManager.getConfig().getString(value);
		} else {
			System.out.println("--[" + ServerManager.name + "] Saved: " + value + " = " + defaultmsg);
			serverManager.getConfig().set(value, defaultmsg);
			saveCfg(serverManager);
			return defaultmsg;
		}
	}
	
	public static void saveCfg(ServerManager serverManager) {
		try {
			serverManager.getConfig().save(new File(serverManager.getDataFolder()+"/config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
