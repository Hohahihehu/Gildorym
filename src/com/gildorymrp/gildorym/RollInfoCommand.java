package com.gildorymrp.gildorym;

//import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import com.gildorym.basicchar.BasicChar;
import com.gildorym.basicchar.CharacterClass;
import com.gildorym.charactercards.CharacterCards;
import com.gildorym.charactercards.Race;

public class RollInfoCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player;
		if (args.length == 0) {
			player = (Player) sender;
		} else {
			player = Bukkit.getServer().getPlayer(args[0]);
		}

		//Heroes heroes = (Heroes) Bukkit.getServer().getPluginManager().getPlugin("Heroes");
		BasicChar basicChar = (BasicChar) Bukkit.getServer().getPluginManager().getPlugin("BasicChar");
		CharacterCards characterCards = (CharacterCards) Bukkit.getServer().getPluginManager().getPlugin("CharacterCards");

		if (player != null) {
			//HeroClass heroClass = heroes.getCharacterManager().getHero(player).getHeroClass();
			//Integer heroLevel = Integer.valueOf(heroes.getCharacterManager().getHero(player).getLevel(heroClass));
			CharacterClass characterClass = basicChar.classes.get(player.getName());
			Integer level = basicChar.levels.get(player.getName()) * 2;

			Double meleeAttack = 0.0D;
			Double meleeDefence = 0.0D;
			Double rangedAttack = 0.0D;
			Double rangedDefence = 0.0D;
			Double magicAttack = 0.0D;
			Double magicDefence = 0.0D;
			Double luck = 0.0D;
			Double reflex = 0.0D;

			meleeAttack += level;
			meleeDefence += level;
			rangedAttack += level;
			rangedDefence += level;
			magicAttack += level;
			magicDefence += level;
			luck += level;
			reflex += level;
			
			if (characterClass == CharacterClass.BARBARIAN) {
				meleeAttack += 4;
				meleeDefence += 2;
				rangedAttack += 4;
				rangedDefence += 2;
				magicAttack = 0.0D;
			}
			
			if (characterClass == CharacterClass.BARD) {
				meleeAttack += 4;
				meleeDefence += 1;
				rangedAttack += 3;
				rangedDefence += 1;
				magicAttack += 2;
				magicDefence += 1;
			}
			
			if (characterClass == CharacterClass.CLERIC) {
				meleeAttack += 3;
				meleeDefence += 2;
				magicAttack += 4;
				magicDefence += 3;
			}
			
			if (characterClass == CharacterClass.DRUID) {
				meleeAttack += 3;
				meleeDefence += 2;
				magicAttack += 4;
				magicDefence += 3;
			}

			if (characterClass == CharacterClass.FIGHTER) {
				meleeAttack += 4;
				meleeDefence += 4;
				rangedAttack += 2;
				rangedDefence += 2;
				magicAttack = 0.0D;
			}
			
			if (characterClass == CharacterClass.MONK) {
				meleeAttack += 4;
				meleeDefence += 4;
				rangedAttack += 2;
				rangedDefence += 2;
				magicAttack = 0.0D;
			}
			
			if (characterClass == CharacterClass.PALADIN) {
				meleeAttack += 3;
				meleeDefence += 3;
				rangedAttack += 1;
				rangedDefence += 1;
				magicAttack += 2;
				magicDefence += 2;
			}
			
			if (characterClass == CharacterClass.RANGER) {
				meleeAttack += 2;
				meleeDefence += 2;
				rangedAttack += 4;
				rangedDefence += 2;
				magicDefence += 2;
			}
			
			if (characterClass == CharacterClass.ROGUE) {
				meleeAttack += 4;
				meleeDefence += 3;
				rangedAttack += 2;
				rangedDefence += 2;
				magicAttack = 0.0D;
				magicDefence += 1;
			}
			
			if (characterClass == CharacterClass.SORCERER) {
				meleeAttack += 1;
				meleeDefence += 1;
				magicAttack += 5;
				magicDefence += 5;
			}
			
			if (characterClass == CharacterClass.WIZARD) {
				meleeAttack += 2;
				meleeDefence += 2;
				magicAttack += 4;
				magicDefence += 4;
			}

			if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.DWARF) {
				magicAttack -= 2;
			}
			
			if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.ELF) {
				rangedAttack += 2;
				reflex += 2;
			}
			
			if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.GNOME) {
				meleeAttack -= 2;
				rangedAttack -= 2;
			}
			
			if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.HALFLING) {
				reflex += 2;
				rangedAttack += 2;
				meleeAttack -= 2;
			}
			
			if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.HALFORC) {
				meleeAttack += 2;
				rangedAttack += 2;
				magicAttack -= 4;
				magicDefence -= 2;
			}

			/*if (characterCards.getCharacterCards().get(player.getName()).getRace() == Race.DROW) {
				Block block = ((Player)sender).getWorld().getBlockAt(((Player)sender).getLocation());

				if (block.getLightLevel() <= 7) {
					meleeAttack += 1.0D;
					meleeDefence += 1.0D;
					magicAttack += 1.0D;
					magicDefence += 1.0D;
					rangedAttack += 1.0D;
					rangedDefence += 1.0D;
					reflex += 1.0D;
					luck += 1.0D;
				}

				if (block.getLightLevel() >= 8) {
					meleeAttack -= 1.0D;
					meleeDefence -= 1.0D;
					magicAttack -= 1.0D;
					magicDefence -= 1.0D;
					rangedAttack -= 1.0D;
					rangedDefence -= 1.0D;
					reflex -= 1.0D;
					luck -= 1.0D;
				}
			}*/

			if (player.getItemInHand().getType() == Material.getMaterial(268)) {
				meleeAttack += 2.0D;
			}
			
			if (player.getItemInHand().getType() == Material.getMaterial(272)) {
				meleeAttack += 3.0D;
			}

			if (player.getItemInHand().getType() == Material.getMaterial(267)) {
				meleeAttack += 4.0D;
			}

			if (player.getItemInHand().getType() == Material.getMaterial(276)) {
				meleeAttack += 5.0D;
			}

			if (player.getItemInHand().getType() == Material.getMaterial(261)) {
				rangedAttack += 4.0D;
			}

			if (player.getItemInHand().getType() == Material.getMaterial(280)) {
				magicAttack += 2.0D;
			}
			
			if (player.getItemInHand().getType() == Material.getMaterial(387)) {
				magicAttack += 3.0D;
			}
			
			if (player.getItemInHand().getType() == Material.getMaterial(368)) {
				magicAttack += 4.0D;
			}
			
			if (player.getItemInHand().getType() == Material.getMaterial(369)) {
				magicAttack += 5.0D;
			}

			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.getMaterial(298))) {
				meleeDefence += 0.25D;
				rangedDefence += 0.25D;
			}

			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.getMaterial(299))) {
				meleeDefence += 1.0D;
				rangedDefence += 1.0D;
			}
			
			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.getMaterial(300))) {
				meleeDefence += 0.5D;
				rangedDefence += 0.5D;
			}
			
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.getMaterial(301))) {
				meleeDefence += 0.25D;
				rangedDefence += 0.25D;
			}

			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.getMaterial(302))) {
				meleeDefence += 0.5D;
				rangedDefence += 0.5D;
			}

			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.getMaterial(303))) {
				meleeDefence += 1.25D;
				rangedDefence += 1.25D;
			}

			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.getMaterial(304))) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.getMaterial(305))) {
				meleeDefence += 0.5D;
				rangedDefence += 0.5D;
			}

			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.getMaterial(306))) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.getMaterial(307))) {
				meleeDefence += 1.5D;
				rangedDefence += 1.5D;
			}

			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.getMaterial(308))) {
				meleeDefence += 1.0D;
				rangedDefence += 1.0D;
			}
			
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.getMaterial(309))) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.getMaterial(310))) {
				meleeDefence += 1.0D;
				rangedDefence += 1.0D;
			}

			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.getMaterial(311))) {
				meleeDefence += 1.75D;
				rangedDefence += 1.75D;
			}

			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.getMaterial(312))) {
				meleeDefence += 1.25D;
				rangedDefence += 1.25D;
			}

			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.getMaterial(313))) {
				meleeDefence += 1.0D;
				rangedDefence += 1.0D;
			}
			
			/*Iterator<Enchantment> enchantmentIterator;
			enchantmentIterator = ((Player) sender).getItemInHand().getEnchantments().keySet().iterator();
			while (enchantmentIterator.hasNext()) {
				Enchantment enchantment = enchantmentIterator.next();
				if (((Player) sender).getItemInHand().getType() == Material.BOW) {
					if (enchantment == Enchantment.ARROW_DAMAGE || enchantment == Enchantment.ARROW_FIRE) {
						rangedAttack += ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
					}
				}
				
				if (((Player) sender).getItemInHand().getType() == Material.WOOD_SWORD
						|| ((Player) sender).getItemInHand().getType() == Material.STONE_SWORD
						|| ((Player) sender).getItemInHand().getType() == Material.IRON_SWORD
						|| ((Player) sender).getItemInHand().getType() == Material.GOLD_SWORD
						|| ((Player) sender).getItemInHand().getType() == Material.DIAMOND_SWORD) {
					if (enchantment == Enchantment.DAMAGE_ALL || enchantment == Enchantment.FIRE_ASPECT) {
						meleeAttack += ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
					}
				}
				
				if (((Player) sender).getItemInHand().getType() == Material.STICK
						|| ((Player) sender).getItemInHand().getType() == Material.BLAZE_ROD
						|| ((Player) sender).getItemInHand().getType() == Material.ENDER_PEARL
						|| ((Player) sender).getItemInHand().getType() == Material.EYE_OF_ENDER) {
					if (enchantment == Enchantment.DAMAGE_ALL || enchantment == Enchantment.FIRE_ASPECT) {
						magicAttack += ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
					}
				}
				
				if (((Player) sender).getInventory().getHelmet() != null) {
					enchantmentIterator = ((Player) sender).getInventory().getHelmet().getEnchantments().keySet().iterator();
					while (enchantmentIterator.hasNext()) {
						if (enchantment == Enchantment.PROTECTION_ENVIRONMENTAL) {
							meleeDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
							magicDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
							rangedDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
					}
				}
				
				if (((Player) sender).getInventory().getChestplate() != null) {
					enchantmentIterator = ((Player) sender).getInventory().getHelmet().getEnchantments().keySet().iterator();
					while (enchantmentIterator.hasNext()) {
						if (enchantment == Enchantment.PROTECTION_ENVIRONMENTAL) {
							meleeDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
							magicDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
							rangedDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
					}
				}
				
				if (((Player) sender).getInventory().getLeggings() != null) {
					enchantmentIterator = ((Player) sender).getInventory().getHelmet().getEnchantments().keySet().iterator();
					while (enchantmentIterator.hasNext()) {
						if (enchantment == Enchantment.PROTECTION_ENVIRONMENTAL) {
							meleeDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
							magicDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
							rangedDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
					}
				}
				
				if (((Player) sender).getInventory().getBoots() != null) {
					enchantmentIterator = ((Player) sender).getInventory().getHelmet().getEnchantments().keySet().iterator();
					while (enchantmentIterator.hasNext()) {
						if (enchantment == Enchantment.PROTECTION_ENVIRONMENTAL) {
							meleeDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
							magicDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
						
						if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
							rangedDefence += 0.25D * ((Player) sender).getItemInHand().getEnchantments().get(enchantment);
						}
					}
				}
			}*/

			sender.sendMessage(ChatColor.GRAY + "======================");
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + player.getDisplayName() + "'s Roll Info");
			sender.sendMessage(ChatColor.GRAY + "======================");
			sender.sendMessage(ChatColor.RED + "Melee   - Attack: " + ChatColor.WHITE + (int) Math.round(meleeAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.round(meleeDefence));
			sender.sendMessage(ChatColor.RED + "Ranged - Attack: " + ChatColor.WHITE + (int) Math.round(rangedAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.round(rangedDefence));
			sender.sendMessage(ChatColor.RED + "Magic   - Attack: " + ChatColor.WHITE + (int) Math.round(magicAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.round(magicDefence));
			sender.sendMessage(ChatColor.RED + "Luck: " + ChatColor.WHITE + (int) Math.round(luck));
			sender.sendMessage(ChatColor.RED + "Reflex: " + ChatColor.WHITE + (int) Math.round(reflex));
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "Could not find that player!");
		}
		return true;
	}
	
}
