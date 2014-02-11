package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class HelpCommand extends NicksCommand {

	public HelpCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("help")) return;
		
		if(!Permissions.NICKS_HELP.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}
		
		Messenger.sendRawMessage("---------- "+Nicks.prefix+"----------", sender);
		for(String s : Nicks.helpCommands())
			Messenger.sendMessage(s, sender);
	}

}
