package com.codermason.nicks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.codermason.nicks.Nicks;
import com.codermason.nicks.permissions.Permissions;
import com.codermason.nicks.util.Messenger;

public class MineCommand extends NicksCommand {

	public MineCommand(Nicks plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, Command command, String[] args) {
		if(!args[0].equalsIgnoreCase("mine")) return;
		
		if(!Permissions.NICKS_MINE.validate(sender)) {
			Messenger.sendMessage("You do not have permission!", sender);
			return;
		}else if(!(sender instanceof Player)) {
			Messenger.sendMessage("Only players can use this command!", sender);
			return;
		}
		
		Player p = (Player) sender;
		String currentNickname = ChatColor.BOLD+"CURRENT: "+ChatColor.RESET;
		String queuedNickname = ChatColor.BOLD+"QUEUED: "+ChatColor.RESET;
		if(Nicks.getManager().hasPlayerSudmitted(p.getName()))
			queuedNickname+= Nicks.getManager().getMap().get(p.getName());
		if(Nicks.getManager().hasNickname(p))
			currentNickname += Nicks.getManager().getNick(p);
		Messenger.sendMessage(currentNickname, sender);
		Messenger.sendMessage(queuedNickname, sender);
	}

}
