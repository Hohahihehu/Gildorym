package com.gildorymrp.gildorym;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDamageByEntityListener implements Listener {

	private final Integer maxDistance = 16;

	private Gildorym plugin;
	
	public EntityDamageByEntityListener(Gildorym plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		Random randomGenerator = new Random();

		int fall = (int) event.getEntity().getFallDistance();
		int roll = randomGenerator.nextInt(20) + 1;
		
		if (event.isCancelled() != false){
			
			//Injury messages
			if ((event.getEntity() instanceof Player)) {
	
				Player damaged = (Player) event.getEntity();

				//Automated fall damage
				if (event.getEntity() instanceof Player) {
					if (event.getCause() == DamageCause.FALL) {
						if (fall < 5) {
							event.setCancelled(true);
						} else if (fall >= 5) {
							int noinjury;
							int minorinjury;
							int majorinjury;

							if (fall < 10) {
								noinjury = 11;
								minorinjury = 4;
								majorinjury = 1;
							} else if (fall < 14) {
								noinjury = 15;
								minorinjury = 8;
								majorinjury = 1;
							} else if (fall < 17) {
								noinjury = 19;
								minorinjury = 12;
								majorinjury = 3;
							} else if (fall < 20) {
								noinjury = 21;
								minorinjury = 20;
								majorinjury = 16;
							} else {
								noinjury = 21;
								minorinjury = 21;
								majorinjury = 21;
							}

							if (roll >= noinjury) {
								damaged
										.sendMessage(ChatColor.BLUE
												+ "You have fallen "
												+ (int) Math.floor(event
														.getEntity()
														.getFallDistance())
												+ " blocks, escaping without injury.");
								event.setCancelled(true);
								return;
							} else if (roll >= minorinjury) {
								plugin.onInjury(damaged, "minor", 50);
								for (Player player : Bukkit.getServer()
										.getOnlinePlayers()) {
									if (player
											.hasPermission("falldamagedetector.notify")) {
										player.sendMessage(ChatColor.BLUE
												+ ((Player) event.getEntity())
														.getName()
												+ " has just fallen "
												+ (int) Math.floor(event
														.getEntity()
														.getFallDistance())
												+ " blocks, check on them if you want.");
									}
								}
								return;
							} else if (roll >= majorinjury) {
								plugin.onInjury(damaged, "major", 50);
								for (Player player : Bukkit.getServer()
										.getOnlinePlayers()) {
									if (player
											.hasPermission("falldamagedetector.notify")) {
										player.sendMessage(ChatColor.BLUE
												+ ((Player) event.getEntity())
														.getName()
												+ " has just fallen "
												+ (int) Math.floor(event
														.getEntity()
														.getFallDistance())
												+ " blocks, check on them if you want.");
									}
								}
								return;
							} else {
								damaged
										.sendMessage(ChatColor.DARK_RED
												+ "You have fallen "
												+ (int) Math.floor(event
														.getEntity()
														.getFallDistance())
												+ " blocks, and died.");
								((LivingEntity) event.getEntity()).addPotionEffect(
										new PotionEffect(PotionEffectType.SLOW,
												999999999, 10), true);

								for (Player player : Bukkit.getServer()
										.getOnlinePlayers()) {
									if (player
											.hasPermission("falldamagedetector.notify")) {
										player.sendMessage(ChatColor.RED
												+ ((Player) event.getEntity())
														.getName()
												+ "/"
												+ ((Player) event.getEntity())
														.getDisplayName()
												+ " has just fallen "
												+ (int) Math.floor(event
														.getEntity()
														.getFallDistance())
												+ " blocks, and died.");
									}
								}
								return;
							}
						}
					}
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
				}
			}
		}
	}		
}
