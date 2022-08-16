package me.Tim.Survival;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerDeath implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
		}
		return false;
	}
	
}
