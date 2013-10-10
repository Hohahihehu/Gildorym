package com.gildorymrp.gildorym;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener{

	private Gildorym plugin;
	
	public PlayerInteractListener(Gildorym plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerInteractEvent(PlayerInteractEvent event){
		ItemStack item = event.getPlayer().getItemInHand();
		short durability = item.getDurability();
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new DurabilityRunnable(item, durability), 1);
		
		event.getPlayer().sendMessage("I saw that");
	}
}
