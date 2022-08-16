package me.Tim.Survival;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listheader implements CommandExecutor, Listener  {
	private Survival main;
	public Listheader(Survival plugin) {
		main = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
	    }
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("listheader")) {
			p.setPlayerListHeader(args[0]);
			main.getConfig().set("Listheader" + p.getName(), args[0]);
			main.saveConfig();
		}
		return false;
	}	
	
	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Object Listheader = main.getConfig().get("Listheader" + p.getName());	
		p.setPlayerListHeader((String) Listheader);
		
		
	}
	
}