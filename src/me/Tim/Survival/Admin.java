package me.Tim.Survival;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Admin implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Je bent geen speler je moet een speler zijn voor dit command!");
			return false;
		}
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("admin")) {
			if (p.isOp()) {
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				ItemMeta swordmeta = sword.getItemMeta();
				swordmeta.setDisplayName(ChatColor.RED + "Admin Sword");
				ArrayList<String> swordlore = new ArrayList<>();
				swordlore.add(ChatColor.YELLOW + "Smite 3000");
				swordlore.add(ChatColor.YELLOW + "Looting 3000");
				swordlore.add(ChatColor.YELLOW + "Sharpness 3000");
				swordlore.add(ChatColor.YELLOW + "Unbreaking 3000");
				swordlore.add(ChatColor.YELLOW + "Fire Aspect 3000");
				swordlore.add(ChatColor.YELLOW + "Sweeping Edge 3000");
				swordlore.add(ChatColor.YELLOW + "Bane of Arthopods 3000");
				swordmeta.addEnchant(Enchantment.DAMAGE_ALL, 3000, true);
				swordmeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3000, true);
				swordmeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 3000, true);
				swordmeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 3000, true);
				swordmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				swordmeta.addEnchant(Enchantment.FIRE_ASPECT, 3000, true);
				swordmeta.addEnchant(Enchantment.SWEEPING_EDGE, 3000, true);
				swordmeta.addEnchant(Enchantment.MENDING, 1, true);
				swordmeta.setLore(swordlore);
				swordmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				sword.setItemMeta(swordmeta);
				p.getInventory().addItem(sword);
				
				ItemStack bow = new ItemStack(Material.BOW);
				ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.setDisplayName(ChatColor.RED + "Admin Bow");
				ArrayList<String> bowlore = new ArrayList<>();
				bowlore.add(ChatColor.YELLOW + "Flame 3000");
				bowlore.add(ChatColor.YELLOW + "Punch 3000");
				bowlore.add(ChatColor.YELLOW + "Power 3000");
				bowlore.add(ChatColor.YELLOW + "Infinity 3000");
				bowlore.add(ChatColor.YELLOW + "Unbreaking 3000");
				bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 3000, true);
				bowmeta.addEnchant(Enchantment.ARROW_FIRE, 3000, true);
				bowmeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 3000, true);
				bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 3000, true);
				bowmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				bowmeta.addEnchant(Enchantment.MENDING, 1, true);
				bowmeta.setLore(bowlore);
				bowmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				bow.setItemMeta(bowmeta);
				p.getInventory().addItem(bow);
				
				ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
				ItemMeta axemeta = axe.getItemMeta();
				axemeta.setDisplayName(ChatColor.RED + "Admin Axe");
				ArrayList<String> axelore = new ArrayList<>();
				axelore.add(ChatColor.YELLOW + "Efficiency 3000");
				axelore.add(ChatColor.YELLOW + "Sharpness 3000");
				axelore.add(ChatColor.YELLOW + "Unbreaking 3000");
				axemeta.addEnchant(Enchantment.DAMAGE_ALL, 3000, true);
				axemeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				axemeta.addEnchant(Enchantment.DIG_SPEED, 3000, true);
				axemeta.addEnchant(Enchantment.MENDING, 1, true);
				axemeta.setLore(axelore);
				axemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				axe.setItemMeta(axemeta);
				p.getInventory().addItem(axe);
				
				ItemStack cross = new ItemStack(Material.CROSSBOW);
				ItemMeta crossmeta = cross.getItemMeta();
				ArrayList<String> crosslore = new ArrayList<>();
				crossmeta.setDisplayName(ChatColor.RED + "Admin Crossbow");
				crossmeta.addEnchant(Enchantment.MULTISHOT, 3000, true);
				crossmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				crossmeta.addEnchant(Enchantment.QUICK_CHARGE, 5, true);
				crossmeta.addEnchant(Enchantment.PIERCING, 3000, true);
				crosslore.add(ChatColor.YELLOW + "Piercing 3000");
				crosslore.add(ChatColor.YELLOW + "Multishot 3000");
				crosslore.add(ChatColor.YELLOW + "Unbreaking 3000");
				crosslore.add(ChatColor.YELLOW + "Quick Charge 3000");
				crossmeta.addEnchant(Enchantment.MENDING, 1, true);
				crossmeta.setLore(crosslore);
				crossmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				cross.setItemMeta(crossmeta);
				p.getInventory().addItem(cross);
				
				ItemStack tri = new ItemStack(Material.TRIDENT);
				ItemMeta trimeta = tri.getItemMeta();
				ArrayList<String> trilore = new ArrayList<>();
				trimeta.setDisplayName(ChatColor.RED + "Admin Trident");
				trimeta.addEnchant(Enchantment.IMPALING, 3000, true);
				trimeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				trimeta.addEnchant(Enchantment.LOYALTY, 10, true);
				trimeta.addEnchant(Enchantment.RIPTIDE, 50, true);
				trimeta.addEnchant(Enchantment.CHANNELING, 3000, true);
				trilore.add(ChatColor.YELLOW + "Riptide 3000");
				trilore.add(ChatColor.YELLOW + "Loyalty 3000");
				trilore.add(ChatColor.YELLOW + "Impaling 3000");
				trilore.add(ChatColor.YELLOW + "Channeling 3000");
				trilore.add(ChatColor.YELLOW + "Unbreaking 3000");
				trimeta.addEnchant(Enchantment.MENDING, 1, true);
				trimeta.setLore(trilore);
				trimeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				tri.setItemMeta(trimeta);
				p.getInventory().addItem(tri);
				
				ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
				ItemMeta helmetmeta = helmet.getItemMeta();
				ArrayList<String> helmetlore = new ArrayList<>();
				helmetmeta.setDisplayName(ChatColor.RED + "Admin Armor");
				helmetmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3000, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3000, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3000, true);
				helmetmeta.addEnchant(Enchantment.PROTECTION_FIRE, 3000, true);
				helmetmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				helmetmeta.addEnchant(Enchantment.THORNS, 3000, true);
				helmetmeta.addEnchant(Enchantment.OXYGEN, 3000, true);
				helmetmeta.addEnchant(Enchantment.WATER_WORKER, 3000, true);
				helmetlore.add(ChatColor.YELLOW + "Thorns 3000");
				helmetlore.add(ChatColor.YELLOW + "Protection 3000");
				helmetlore.add(ChatColor.YELLOW + "Unbreaking 3000");
				helmetlore.add(ChatColor.YELLOW + "Respiration 3000");
				helmetlore.add(ChatColor.YELLOW + "Aqua Affinity 3000");
				helmetlore.add(ChatColor.YELLOW + "Blast Protection 3000");
				helmetlore.add(ChatColor.YELLOW + "Projectile Protection 3000");
				helmetmeta.addEnchant(Enchantment.MENDING, 1, true);
				helmetmeta.setLore(helmetlore);
				helmetmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				helmet.setItemMeta(helmetmeta);
				p.getInventory().addItem(helmet);
				
				ItemStack leg = new ItemStack(Material.NETHERITE_LEGGINGS);
				ItemMeta legmeta = leg.getItemMeta();
				ArrayList<String> leglore = new ArrayList<>();
				legmeta.setDisplayName(ChatColor.RED + "Admin Armor");
				legmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3000, true);
				legmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3000, true);
				legmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3000, true);
				legmeta.addEnchant(Enchantment.PROTECTION_FIRE, 3000, true);
				legmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				legmeta.addEnchant(Enchantment.THORNS, 3000, true);
				leglore.add(ChatColor.YELLOW + "Thorns 3000");
				leglore.add(ChatColor.YELLOW + "Protection 3000");
				leglore.add(ChatColor.YELLOW + "Unbreaking 3000");
				leglore.add(ChatColor.YELLOW + "Blast Protection 3000");
				leglore.add(ChatColor.YELLOW + "Projectile Protection 3000");
				legmeta.addEnchant(Enchantment.MENDING, 1, true);
				legmeta.setLore(leglore);
				legmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				leg.setItemMeta(legmeta);
				p.getInventory().addItem(leg);
				
				ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
				ItemMeta chestplatemeta = chestplate.getItemMeta();
				ArrayList<String> chestplatelore = new ArrayList<>();
				chestplatemeta.setDisplayName(ChatColor.RED + "Admin Armor");
				chestplatemeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3000, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3000, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3000, true);
				chestplatemeta.addEnchant(Enchantment.PROTECTION_FIRE, 3000, true);
				chestplatemeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				chestplatemeta.addEnchant(Enchantment.THORNS, 3000, true);
				chestplatelore.add(ChatColor.YELLOW + "Thorns 3000");
				chestplatelore.add(ChatColor.YELLOW + "Protection 3000");
				chestplatelore.add(ChatColor.YELLOW + "Unbreaking 3000");
				chestplatelore.add(ChatColor.YELLOW + "Blast Protection 3000");
				chestplatelore.add(ChatColor.YELLOW + "Projectile Protection 3000");
				chestplatemeta.addEnchant(Enchantment.MENDING, 1, true);
				chestplatemeta.setLore(chestplatelore);
				chestplatemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				chestplate.setItemMeta(chestplatemeta);
				p.getInventory().addItem(chestplate);
				
				ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
				ItemMeta bootsmeta = boots.getItemMeta();
				ArrayList<String> bootslore = new ArrayList<>();
				bootsmeta.setDisplayName(ChatColor.RED + "Admin Armor");
				bootsmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3000, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_FALL, 3000, true);
				bootsmeta.addEnchant(Enchantment.DEPTH_STRIDER, 3000, true);
				bootsmeta.addEnchant(Enchantment.SOUL_SPEED, 3000, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3000, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3000, true);
				bootsmeta.addEnchant(Enchantment.PROTECTION_FIRE, 3000, true);
				bootsmeta.addEnchant(Enchantment.DURABILITY, 3000, true);
				bootsmeta.addEnchant(Enchantment.THORNS, 3000, true);
				bootsmeta.addEnchant(Enchantment.MENDING, 1, true);
				bootslore.add(ChatColor.YELLOW + "Thorns 3000");
				bootslore.add(ChatColor.YELLOW + "Protection 3000");
				bootslore.add(ChatColor.YELLOW + "Unbreaking 3000");
				bootslore.add(ChatColor.YELLOW + "Soul Speed 3000");
				bootslore.add(ChatColor.YELLOW + "Feather Falling 3000");
				bootslore.add(ChatColor.YELLOW + "Blast Protection 3000");
				bootslore.add(ChatColor.YELLOW + "Projectile Protection 3000");
				bootsmeta.setLore(bootslore);
				bootsmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				boots.setItemMeta(bootsmeta);
				p.getInventory().addItem(boots);
			} 
		} else {
			p.sendMessage(ChatColor.RED + "Je moet een operator zijn voor dit command!");
		}
		return false;
	}
}