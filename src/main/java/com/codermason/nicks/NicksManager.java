package com.codermason.nicks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.codermason.nicks.util.Messenger;
import com.earth2me.essentials.Essentials;

public class NicksManager { //what a messy class :P it was late

	private Map<String, String> playerNicks = new HashMap<String, String>();
	private Essentials ess;
	
	public NicksManager(Essentials ess) {
		this.ess = ess;
	}
	
	public Map<String, String> getMap() { return this.playerNicks; }
	
	public void acceptNick(CommandSender accepter, String player) {
		if(!hasPlayerSudmitted(player)) return;

		Player p = Bukkit.getPlayer(player);
		String nick = getMap().get(player);
		if(p == null) 
			setNick(player, nick);
		else{
			setNick(p, nick);
			Messenger.sendMessage("Player "+accepter.getName()+" has accepted your nick "+nick+"!", p);
		}
		Messenger.sendMessage("Accepted nick "+nick+" for player "+player+"!", accepter);
		removeNickname(nick);
	}
	
	public void sendNick(Player sender, String nick) {
		playerNicks.put(sender.getName(), nick);
		Messenger.sendMessage("Added your nickname "+nick+"!", sender);
	}
	
	public void denyNick(CommandSender denier, String player) {
		if(!hasPlayerSudmitted(player)) return;
		
		Player p = Bukkit.getPlayer(player);
		String nick = getMap().get(player);
		if(p != null) 
			Messenger.sendMessage("Player "+denier.getName()+" has denied your nick "+nick+"!", p);
		Messenger.sendMessage("Denied nick "+nick+" for player "+player+"!", denier);
		removeNickname(nick);
	}
	
	public void removeNickname(String nick) {
		if(isQueuedNick(nick)) playerNicks.remove(getAssociatedNick(nick));
	}
	
	public boolean isQueuedNick(String s) {
		return getAssociatedNick(s) != null;
	}
	
	public String getAssociatedNick(String s) {
		for(String name : playerNicks.keySet())
			if(playerNicks.get(name).equalsIgnoreCase(s))
				return name;
		return null;
	}
	
	public String[] getAllNicks() {
		String[] array = new String[playerNicks.size()];
		List keys = new ArrayList(playerNicks.keySet());
		for(int x=0;x<array.length;x++) {
			String pName = (String) keys.get(x);
			String nick = playerNicks.get(pName);
			array[x] = "- "+nick+" (PLAYER: "+pName+")";
		}
		return array;
	}
	
	public boolean hasPlayerSudmitted(String p) {
		return playerNicks.containsKey(p);
	}
	
	public boolean hasNickname(Player p) {
		return ess.getUser(p).getNickname() != null;
	}
	
	public String getNick(Player p) {
		return ess.getUser(p).getNickname();
	}
	
	public void setNick(Player p, String nick) {
		setNick(p.getName(), nick);
	}
	
	public void setNick(String p, String nick) {
		ess.getUser(p).setNickname(ChatColor.translateAlternateColorCodes('&', nick));
	}
	
}
