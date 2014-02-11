package com.codermason.nicks.util;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.codermason.nicks.Nicks;

public class Messenger {

	public static void sendMessage(String msg, Player p) {
		p.sendMessage(Nicks.prefix+msg);
	}
	
	public static void sendMessage(String msg, CommandSender sender) {
		sender.sendMessage(Nicks.prefix+msg);
	}
	
	public static void sendRawMessage(String msg, CommandSender sender) {
		sender.sendMessage(msg);
	}
	
}
