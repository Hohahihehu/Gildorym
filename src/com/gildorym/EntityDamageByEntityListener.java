package com.gildorym;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageByEntityListener implements Listener {
	
	private final Integer maxDistance = 16;
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player damaged = (Player)event.getEntity();

			if ((((float) damaged.getHealth() / (float) damaged.getMaxHealth()) * 100.0D > 25.0D) && (((float) damaged.getHealth() / (float) damaged.getMaxHealth()) * 100.0D <= 50.0D)) {
				for (Player player : event.getEntity().getWorld().getPlayers()) {
					if (event.getEntity().getLocation().distance(player.getLocation()) <= this.maxDistance.intValue()) {
						player.sendMessage(ChatColor.RED + ((Player)event.getEntity()).getDisplayName() + " appears wounded!");
					}
				}
			}

			if (((float) damaged.getHealth() / (float) damaged.getMaxHealth()) * 100.0D <= 25.0D) {
				for (Player player : event.getEntity().getWorld().getPlayers()) {
					if (event.getEntity().getLocation().distance(player.getLocation()) <= this.maxDistance.intValue()) {
						player.sendMessage(ChatColor.RED + ((Player)event.getEntity()).getDisplayName() + " appears gravely wounded!");
					}
				}
			}
		}
	}

}
