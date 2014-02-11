package com.codermason.nicks.permissions;

import org.bukkit.command.CommandSender;

public enum Permissions {

	NICKS_SEND,
	NICKS_DENY,
	NICKS_ACCEPT,
	NICKS_LIST,
	NICKS_MINE,
	NICKS_HELP;
	
	public boolean validate(CommandSender sender) {
		return sender.hasPermission(toString());
	}
	
	public String toString() {
		return this.name().toLowerCase().replace("_", ".");
	}
	
}
