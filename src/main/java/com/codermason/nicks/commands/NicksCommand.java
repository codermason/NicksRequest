package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;

public abstract class NicksCommand {

	private Nicks plugin;
	
	public NicksCommand(Nicks plugin) {
		this.plugin = plugin;
	}
	
	public abstract void execute(CommandSender sender, Command command, String[] args);
	
}
