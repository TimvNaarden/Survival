package me.Tim.Survival;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Playerheads implements Listener{
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player speler = e.getEntity();
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwningPlayer(speler);
		skull.setItemMeta(meta);
		speler.getLocation().getWorld().dropItemNaturally(speler.getLocation(), skull);
	}

}
