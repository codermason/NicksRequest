package com.codermason.nicks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class SendCommand extends NicksCommand {

	public SendCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("send")) return;
		
		if(!Permissions.NICKS_SEND.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}else if(!(sender instanceof Player)) {
			Messenger.sendMessage("Only players can use this command!", sender);
			return;
		}
		
		Player p = (Player) sender;
		if(args.length == 2) {
			if(!Nicks.getManager().hasPlayerSudmitted(p.getName())) {
				Nicks.getManager().sendNick(p, args[1]);
			}else{
				Messenger.sendMessage("You've already suddmitted a nickname!", sender);
			}
		}else{
			Messenger.sendMessage("Usage: /nicks send [nick]", p);
		}
	}

}
