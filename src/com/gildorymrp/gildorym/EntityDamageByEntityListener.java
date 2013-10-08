package com.gildorymrp.gildorym;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class EntityDamageByEntityListener implements Listener {

	private final Integer maxDistance = 16;

	private Gildorym plugin;
	
	public EntityDamageByEntityListener(Gildorym plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {

			Player damaged = (Player) event.getEntity();

			if ((((float) damaged.getHealth() / (float) damaged.getMaxHealth()) * 100.0D > 25.0D)
					&& (((float) damaged.getHealth() / (float) damaged
							.getMaxHealth()) * 100.0D <= 50.0D)) {
				for (Player player : event.getEntity().getWorld().getPlayers()) {
					if (event.getEntity().getLocation()
							.distance(player.getLocation()) <= this.maxDistance
							.intValue()) {
						player.sendMessage(ChatColor.RED
								+ ((Player) event.getEntity()).getDisplayName()
								+ " appears wounded!");
					}
				}
			}

			if (((float) damaged.getHealth() / (float) damaged.getMaxHealth()) * 100.0D <= 25.0D) {
				for (Player player : event.getEntity().getWorld().getPlayers()) {
					if (event.getEntity().getLocation()
							.distance(player.getLocation()) <= this.maxDistance
							.intValue()) {
						player.sendMessage(ChatColor.RED
								+ ((Player) event.getEntity()).getDisplayName()
								+ " appears gravely wounded!");
					}
				}
			}
			
			
			int armorPiece, maxDurability, damage1;
			if (event.isCancelled() == false && event.getCause() != DamageCause.DROWNING && event.getCause() != DamageCause.FALL){
			
				if (damaged.getInventory().getHelmet() != null) {				
					armorPiece = damaged.getInventory().getHelmet().getDurability();
					maxDurability = damaged.getInventory().getHelmet().getType().getMaxDurability();
					damage1 = (int) event.getDamage();
					
					//DEBUG CODE
					//damaged.sendMessage("Item Info: Helmet; Durability: " + armorPiece + "; MaxDurability: " + maxDurability);
					//boolean damagearmour = doDurabilityDamage(armorPiece, maxDurability, damaged);
					//damaged.sendMessage("doDurabilityDamage returned: " + damagearmour);
					if (plugin.doDurabilityDamage(armorPiece, maxDurability, damage1) == false) {
						if (armorPiece > 0){
							damaged.getInventory().getHelmet().setDurability((short) (armorPiece - 1));
						}else{
							return;
						}
					}else{
						//damaged.sendMessage("Helmet damaged");
					}
				}
				if (damaged.getInventory().getChestplate() != null) {
					armorPiece = damaged.getInventory().getChestplate().getDurability();
					maxDurability = damaged.getInventory().getChestplate().getType().getMaxDurability();
					damage1 = (int) event.getDamage();
					
					//DEBUG CODE
					//damaged.sendMessage("Item Info: Chestplate; Durability: " + armorPiece + "; MaxDurability: " + maxDurability);
					//boolean damagearmour = doDurabilityDamage(armorPiece, maxDurability, damaged);
					//damaged.sendMessage("doDurabilityDamage returned: " + damagearmour);
					if (plugin.doDurabilityDamage(armorPiece, maxDurability, damage1) == false) {
						if (armorPiece > 0){
							damaged.getInventory().getChestplate().setDurability((short) (armorPiece - 1));
						}else{
							return;
						}
							
						//DEBUG CODE
						//damaged.sendMessage("Added 1 to durability.");
					}else{
						//damaged.sendMessage("Chestplate damaged");
					}
				}
				if (damaged.getInventory().getLeggings() != null) {
					armorPiece = damaged.getInventory().getLeggings().getDurability();
					maxDurability = damaged.getInventory().getLeggings().getType().getMaxDurability();
					damage1 = (int) event.getDamage();
					
					//DEBUG CODE
					//damaged.sendMessage("Item Info: Leggings; Durability: " + armorPiece + "; MaxDurability: " + maxDurability);
					//boolean damagearmour = doDurabilityDamage(armorPiece, maxDurability, damaged);
					//damaged.sendMessage("doDurabilityDamage returned: " + damagearmour);
					if (plugin.doDurabilityDamage(armorPiece, maxDurability, damage1) == false) {
						if (armorPiece > 0){
							damaged.getInventory().getLeggings().setDurability((short) (armorPiece - 1));
						}else{
							return;
						}
					}else{
						//damaged.sendMessage("Leggings damaged");
					}
				}
				if (damaged.getInventory().getBoots() != null) {
					armorPiece = damaged.getInventory().getBoots().getDurability();
					maxDurability = damaged.getInventory().getBoots().getType().getMaxDurability();
					damage1 = (int) event.getDamage();
					
					//DEBUG CODE
					//damaged.sendMessage("Item Info: Boots; Durability: " + armorPiece + "; MaxDurability: " + maxDurability);
					//boolean damagearmour = doDurabilityDamage(armorPiece, maxDurability, damaged);
					//damaged.sendMessage("doDurabilityDamage returned: " + damagearmour);
					if (plugin.doDurabilityDamage(armorPiece, maxDurability, damage1) == false) {
						if (armorPiece > 0){
							damaged.getInventory().getBoots().setDurability((short) (armorPiece - 1));
						}else{
							return;
						}
					}else{
						//damaged.sendMessage("Boots damaged");
					}
				}
			}
			
			
		}
	}
}
