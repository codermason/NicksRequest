package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class DenyCommand extends NicksCommand {

	public DenyCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("deny")) return;
		
		if(!Permissions.NICKS_DENY.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}
		
		if(args.length == 2) {
			String player = args[1];
			if(Nicks.getManager().hasPlayerSudmitted(player)) {
				Nicks.getManager().denyNick(sender, player);
			}else{
				Messenger.sendMessage("Player "+player+" has not sudmitted a nick!", sender);
			}
		}else{
			Messenger.sendMessage("Usage: /nicks deny [nick]", sender);
		}
	}

}
