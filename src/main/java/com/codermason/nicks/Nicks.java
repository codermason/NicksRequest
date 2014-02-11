package com.codermason.nicks;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.codermason.nicks.commands.CommandRouter;
import com.earth2me.essentials.Essentials;

public class Nicks extends JavaPlugin {

	private static Essentials ess;
	private static NicksManager manager;
	
	public static String prefix = ChatColor.BOLD+""+ChatColor.BLACK+"["+""+ChatColor.AQUA+"Nicks"+ChatColor.BLACK+"] "+ChatColor.RESET;
	
	private static List<String> helpCommands;
	
	public void onEnable() {
		if(!setupEssentials()) {
			this.getLogger().log(Level.SEVERE, "Could not find Essentials! Shutting down...");
			this.getServer().getPluginManager().disablePlugin(this);
		}
		
		this.getLogger().info("Hooked into Essentials successfully!");
		
		getCommand("nicks").setExecutor(new CommandRouter(this));
		
		helpCommands = Arrays.asList(
				"/nicks mine - show your queued nickname",
				"/nicks list - show list of all nicknames",
				"/nicks send [nick] - send a given nickname",
				"/nicks accept [nick] - accept a given nickname",
				"/nicks deny [nick] - deny a given nickname");
		
		manager = new NicksManager(ess);
		
	}
	
	private boolean setupEssentials() {
		ess = (Essentials) this.getServer().getPluginManager().getPlugin("Essentials");
		return ess != null;
	}
	
	public static List<String> helpCommands() {
		return helpCommands;
	}
	
	public static NicksManager getManager() { return manager; }
	
}
