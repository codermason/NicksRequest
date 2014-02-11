package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.util.Messenger;

public class CommandRouter implements CommandExecutor {

	private Nicks plugin;
	
	public CommandRouter(Nicks plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 0) {
			Messenger.sendMessage("NicksRequest written by codermason v1.0", sender);
			Messenger.sendMessage("Use /nicks help for help!", sender);
		}else{
			
			if(args[0].equalsIgnoreCase("help")) {
				new HelpCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				new ListCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("mine")) {
				new MineCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("send")) {
				new SendCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("accept")) {
				new AcceptCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			if(args[0].equalsIgnoreCase("deny")) {
				new DenyCommand(this.plugin).execute(sender, command, args);
				return true;
			}
			
			Messenger.sendMessage("Unknown command!", sender);
			
		}
		
		return false;
	}
	
}
