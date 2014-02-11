package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class AcceptCommand extends NicksCommand {

	public AcceptCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("accept")) return;
		
		if(!Permissions.NICKS_ACCEPT.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}
		
		if(args.length == 2) {
			String player = args[1];
			if(Nicks.getManager().hasPlayerSudmitted(player)) {
				Nicks.getManager().acceptNick(sender, player);
			}else{
				Messenger.sendMessage("Player "+player+" has not sudmitted a nick!", sender);
			}
		}else{
			Messenger.sendMessage("Usage: /nicks accept [nick]", sender);
		}
	}
	
}
