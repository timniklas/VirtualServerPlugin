package com.cyberdos.bukkit.servermanager.events;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@SuppressWarnings("deprecation")
public class EventListener implements Listener {
	
	@EventHandler
    public void OnJoind(PlayerJoinEvent e){
		
		Player player = e.getPlayer();
		
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	        if(p.getWorld() == player.getWorld() && player != p) {
	        	
	        	p.sendMessage(e.getJoinMessage());
	        	
	        }
	    }
		
        e.setJoinMessage(""); //don't broadcast global
    }
	
	@EventHandler
    public void OnLeave(PlayerQuitEvent e){
        
		Player player = e.getPlayer();
		
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	        if(p.getWorld() == player.getWorld() && player != p) {
	        	
	        	p.sendMessage(e.getQuitMessage());
	        	
	        }
	    }
		
		e.setQuitMessage(""); //don't broadcast global
    }
	
	
	@EventHandler
    public void fixOnlineList(PlayerChangedWorldEvent e){
        for(Iterator<?> iterator = e.getPlayer().getWorld().getPlayers().iterator(); iterator.hasNext();){
            Player player = (Player)iterator.next();
            if(player != null){
                player.showPlayer(e.getPlayer());
                e.getPlayer().showPlayer(player);
            }
        }

        for(Iterator<?> iterator1 = e.getFrom().getPlayers().iterator(); iterator1.hasNext();){
            Player player = (Player)iterator1.next();
            if(player != null){
                player.hidePlayer(e.getPlayer());
                e.getPlayer().hidePlayer(player);
            }
        }

    }
	
	@EventHandler
	public void fixLeave(PlayerQuitEvent e){
            for(Iterator<?> iterator = e.getPlayer().getWorld().getPlayers().iterator(); iterator.hasNext();){
                Player player = (Player)iterator.next();
                if(player != null){
                    player.showPlayer(e.getPlayer());
                    e.getPlayer().showPlayer(player);
                }
            }
        
            for(Player play : Bukkit.getOnlinePlayers()){
        	if(!(e.getPlayer().getWorld().getPlayers().contains(play))){
        		e.getPlayer().hidePlayer(play);
        		play.hidePlayer(e.getPlayer());
        	}
        	if(!(e.getPlayer().hasPlayedBefore())){
        		e.getPlayer().hidePlayer(play);
        		play.hidePlayer(e.getPlayer());
        	}
            }
        }
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChat(final PlayerChatEvent event) {
     
            event.getRecipients().clear();

    String worldName = event.getPlayer().getWorld().getName();

    List<Player> recipients = new LinkedList<Player>();
   
    for (Player recipient : Bukkit.getServer().getOnlinePlayers()) {
        if (recipient.getWorld().getName().equals(worldName)) {
            //System.out.print(recipient.getWorld().getName());
            recipients.add(recipient);
        } else {
            //System.out.print(recipient.getWorld().getName());
        }
    }
    
    event.getRecipients().addAll(recipients);
    }

}
