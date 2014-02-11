package com.codermason.nicks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class ListCommand extends NicksCommand {

	public ListCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("list")) return;
		
		if(!Permissions.NICKS_LIST.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}
		
		Messenger.sendMessage(ChatColor.BOLD+""+"QUEUED NICKNAMES", sender);
		for(String nick : Nicks.getManager().getAllNicks()) {
			Messenger.sendMessage(nick, sender);
		}
	}

}
