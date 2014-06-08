package com.cyberdos.bukkit.servermanager.tools;

import java.io.File;

import org.bukkit.entity.Player;

public class AdvenTourDeleteFolder {
	
	public static void DeleteFileFolder(String path, Player sender) {

	    File file = new File(path);
	    if(file.exists())
	    {
	        removeDirectory(file);
	    }else
	    {
	    	sender.sendMessage("File or Folder not found : "+path);
	    }

	}
	
	public static boolean removeDirectory(File directory) {

		  // System.out.println("removeDirectory " + directory);

		  if (directory == null)
		    return false;
		  if (!directory.exists())
		    return true;
		  if (!directory.isDirectory())
		    return false;

		  String[] list = directory.list();

		  // Some JVMs return null for File.list() when the
		  // directory is empty.
		  if (list != null) {
		    for (int i = 0; i < list.length; i++) {
		      File entry = new File(directory, list[i]);

		      //        System.out.println("\tremoving entry " + entry);

		      if (entry.isDirectory())
		      {
		        if (!removeDirectory(entry))
		          return false;
		      }
		      else
		      {
		        if (!entry.delete())
		          return false;
		      }
		    }
		  }

		  return directory.delete();
		}


}
