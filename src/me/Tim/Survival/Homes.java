package me.Tim.Survival;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;


public class Homes implements CommandExecutor{
	private Survival main;
	public Homes(Survival plugin) {
		main = plugin;
	}
	public File Homesfile;
	public FileConfiguration Homescfg;
	public File MainHomes;
	public FileConfiguration MainHomescfg;
	public void SaveHomes(File Name) {
		try {
			Homescfg.save(Name);
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The Homes.yml file has been saved");

		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the players.yml file");
		}
	}
	@EventHandler
	public void onPlayerDeath(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) {
			Homescfg.set("Homes" + p.getName(),"");
		}
	}
	public void CreateHome(String Name) {
		Homesfile = new File(main.getDataFolder(), Name);
		if (!main.getDataFolder().exists()) {
			main.getDataFolder().mkdir();
		}
		if (!Homesfile.exists()) {
			try {
				Homesfile.createNewFile();
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The Homes.yml file has been created");
				Homescfg = YamlConfiguration.loadConfiguration(Homesfile);
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the Homes.yml file");
			}
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
		}
		
		Player p = (Player) sender;
		MainHomes =  new File(main.getDataFolder(), "Homes.yml");
		MainHomescfg = YamlConfiguration.loadConfiguration(MainHomes);
		Homesfile = new File(main.getDataFolder(), "Homes" + p.getName() + ".yml");
		Homescfg = YamlConfiguration.loadConfiguration(Homesfile);
		CreateHome("Homes" + p.getName() + ".yml");
		if(cmd.getName().equalsIgnoreCase("togglehomes")) {
			if (p.isOp()) {
				Boolean HomeToggle = (Boolean) Homescfg.getBoolean("HomeToggle");
				if (HomeToggle == true) {
					HomeToggle = false;
					Homescfg.set("HomeToggle", HomeToggle);
					SaveHomes(MainHomes);
				} else {
					HomeToggle = true;
					Homescfg.set("HomeToggle", HomeToggle);
					SaveHomes(MainHomes);
					return false;
				}
			} else {
				p.sendMessage(ChatColor.RED + "Je moet een operator zijn voor dit command!");
				return false;
			}
			
		}
		
		
		Boolean HomeToggle = (Boolean) Homescfg.getBoolean("HomeToggle");
		if (HomeToggle == true) {
			if(cmd.getName().equalsIgnoreCase("maxhomes")) {
				if (p.isOp()) { 
					MainHomescfg.set("HomesMax", Integer.valueOf(args[0]));
					SaveHomes(MainHomes);
					return false;
				}
			}
			if(cmd.getName().equalsIgnoreCase("sethome")) {
				String homes = (String) MainHomescfg.getString("Homes" + p.getName());
				Long HomesAmount = homes.chars().filter(c -> c == (int) ' ').count();
				int HomesAmounts = (int) Math.toIntExact(HomesAmount);
				int HomesMax = (int) Homescfg.getInt("HomesMax");
				if (HomesMax == HomesAmounts) {
					p.sendMessage(ChatColor.RED + "Maximaal aantal homes bereikt!");
					return false;
				} else { 
					Homescfg.set("Home" + p.getName() + args[0].toLowerCase() , p.getLocation());
					String homess = homes + args[0];
					Homescfg.set("Homes" + p.getName(), homess + " ");
					SaveHomes(MainHomes);
					return false;
				}
			}
			if(cmd.getName().equalsIgnoreCase("home")) {
				Location homeloc = (Location) Homescfg.get("Home" + p.getName() + args[0].toLowerCase());
				p.teleport(homeloc);
				return false;
			}
				
			if (cmd.getName().equalsIgnoreCase("homes")) {
				String home = (String) Homescfg.get("Homes" + p.getName());
				Long HomesAmounts = home.chars().filter(c -> c == (int) ' ').count();
				int MaxHomes = (int) MainHomescfg.get("HomesMax");
				String homes = home.replaceAll(" ", "\n");
				p.sendMessage("Homes " + p.getName() + " " + HomesAmounts + "/" + MaxHomes + ":");
				p.sendMessage(homes);
				return false;
					
			}
				
			if (cmd.getName().equalsIgnoreCase("delhome")) {
				Homescfg.set("Home" + p.getName() + args[0], null);
				String home = (String) Homescfg.get("Homes" + p.getName());
				String homess = home.replace(args[0].toLowerCase() + " ", "");
				Homescfg.set("Homes" + p.getName(), homess);
				SaveHomes(Homesfile);
			    
			}
			
		} else {
			p.sendMessage(ChatColor.RED + "Homes zijn uitgeschakeld!!");
			return false;
			
		}
		
		
		return false;
	}
	

}
