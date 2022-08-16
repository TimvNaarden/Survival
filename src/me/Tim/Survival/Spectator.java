package me.Tim.Survival;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spectator implements CommandExecutor {
	private Survival main;
	public Spectator(Survival plugin) {
		main = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
	if(!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
		return false; 
	}
	
	Player p = (Player) sender;
	
	if(cmd.getName().equalsIgnoreCase("c")) {
		if(p.getGameMode() == GameMode.SURVIVAL) {
			Location location = p.getLocation();
			main.getConfig().set("GState" + p.getName(), location);
			main.saveConfig();
			p.setGameMode(GameMode.SPECTATOR);
			return true;
		}
		if(p.getGameMode() == GameMode.SPECTATOR ) {
			Location GState = (Location) main.getConfig().get("GState" + p.getName());
			p.teleport(GState);
			p.setGameMode(GameMode.SURVIVAL);
			
		}
	}
	return false;
}
}
