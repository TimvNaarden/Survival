package me.Tim.Survival;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;



public class Survival extends JavaPlugin implements CommandExecutor{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents( new Welcome(this), this);
		Bukkit.getPluginManager().registerEvents( new Listheader(this), this);
		Bukkit.getPluginManager().registerEvents( new Playerheads(), this);
		getCommand("welcome").setExecutor(new Welcome(this));
		getCommand("c").setExecutor(new Spectator(this));
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("ping").setExecutor(new Ping(this));
		getCommand("hallo").setExecutor(new Hallo());
		getCommand("listheader").setExecutor(new Listheader(this));
		getCommand("sethome").setExecutor(new Homes(this));
		getCommand("home").setExecutor(new Homes(this));
		getCommand("homes").setExecutor(new Homes(this));
		getCommand("delhome").setExecutor(new Homes(this));
		getCommand("admin").setExecutor(new Admin());
		getCommand("togglehomes").setExecutor(new Homes(this));
		getCommand("maxhomes").setExecutor(new Homes(this));
		getCommand("togglespawn").setExecutor(new Spawn(this));
		loadConfigs();
	
	}	
	
	public void loadConfigs(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	

}
