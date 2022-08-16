package me.Tim.Survival;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor{
	private Survival main;
	public Ping(Survival plugin) {
		main = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
	    }
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ping")) {
			String Ping = Integer.toString(p.getPing());
			main.getConfig().set("Ping" + p.getPlayer(), Ping);
			p.sendRawMessage(ChatColor.WHITE + Ping);
		}
		return false;
		
	}
	

}
