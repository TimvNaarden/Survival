package me.Tim.Survival;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
	private Survival main;
	public Spawn(Survival plugin) {
		main = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
	    }
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("togglespawn")) {
			if (p.isOp()) {
				Boolean SpawnToggle = (Boolean) main.getConfig().getBoolean("SpawnToggle");
				if (SpawnToggle == true) {
					SpawnToggle = false;
					main.getConfig().set("SpawnToggle", SpawnToggle);
					main.saveConfig();
				} else {
					SpawnToggle = true;
					main.getConfig().set("SpawnToggle", SpawnToggle);
					main.saveConfig();
					return false;
				}
			} else {
				p.sendMessage(ChatColor.RED + "Je moet een operator zijn voor dit command!");
				return false;
			}
			
		}
		
		
		Boolean SpawnToggle = (Boolean) main.getConfig().get("SpawnToggle");
		if (SpawnToggle == true) {
			if(cmd.getName().equalsIgnoreCase("spawn")) {
				Location worldspawn = (Location) p.getWorld().getSpawnLocation();
				p.teleport(worldspawn);
			}
		} else {
			p.sendMessage(ChatColor.RED + "Spawn is uitgeschakeld");
		}
		return false;
		
	
	}

}
