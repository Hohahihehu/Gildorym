package com.gildorymrp.gildorym;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.charactercards.GildorymCharacterCards;
import com.gildorymrp.charactercards.Race;
import com.gildorymrp.gildorymclasses.CharacterClass;
import com.gildorymrp.gildorymclasses.GildorymClasses;

public class RollInfoCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Player player;
		if (args.length == 0) {
			player = (Player) sender;
		} else {
			player = Bukkit.getServer().getPlayer(args[0]);
		}

		GildorymClasses gildorymClasses = (GildorymClasses) Bukkit.getServer()
				.getPluginManager().getPlugin("GildorymClasses");
		GildorymCharacterCards gildorymCharacterCards = (GildorymCharacterCards) Bukkit
				.getServer().getPluginManager()
				.getPlugin("GildorymCharacterCards");

		if (player != null) {
			CharacterClass characterClass = null;
			Race race = null;
			int level = 0;

			try {
				characterClass = gildorymClasses.classes.get(player.getName());
				level = gildorymClasses.levels.get(player.getName());
			} catch (NullPointerException ex) {
				sender.sendMessage(ChatColor.RED
						+ "You must set your class first!");
			}

			double meleeAttack = 0.0D;
			double meleeDefence = 0.0D;
			double rangedAttack = 0.0D;
			double rangedDefence = 0.0D;
			double magicAttack = 0.0D;
			double magicDefence = 0.0D;
			double luck = 0.0D;
			double reflex = 0.0D;
			int BAB_good = 0;
			int BAB_avg = 0;
			int BAB_poor = 0;

			if (level <= 20) {
				BAB_good = level;
				luck += (level + 2);
				reflex += (level + 2);
			} else {
				BAB_good = 20;
				luck += (level + 2);
				reflex += (20 + 2);
			}
			
			if (level == 1) {
				BAB_avg = 1;
				BAB_poor = 1;
			} else if (level > 1 && level <= 20) {
				BAB_avg = (int) Math.floor(((double) level) * 0.75D);
				BAB_poor = (int) Math.floor(((double) level) * 0.5D);
			} else if (level > 20) {
				BAB_avg = 15;
				BAB_avg = 10;
			}

			if (characterClass == CharacterClass.BARBARIAN) {
				meleeAttack += (5 + BAB_good);
				meleeDefence += (3 + BAB_good);
				rangedAttack += (5 + BAB_avg);
				rangedDefence += (3 + BAB_avg);
				magicAttack = 0.0D;
				magicDefence += (1 + BAB_poor);
			}

			if (characterClass == CharacterClass.BARD) {
				meleeAttack += (3 + BAB_avg);
				meleeDefence += (1 + BAB_avg);
				rangedAttack += (3 + BAB_avg);
				rangedDefence += (1 + BAB_avg);
				magicAttack += (2 + BAB_avg);
				magicDefence += (1 + BAB_avg);
				reflex += (0.25 * level);
			}

			if (characterClass == CharacterClass.CLERIC) {
				meleeAttack += (3 + BAB_avg);
				meleeDefence += (2 + BAB_good);
				rangedAttack += (1 + BAB_poor);
				rangedDefence += (1 + BAB_avg);
				magicAttack += (4 + BAB_good);
				magicDefence += (3 + BAB_good);
			}

			if (characterClass == CharacterClass.DRUID) {
				meleeAttack += (3 + BAB_avg);
				meleeDefence += (2 + BAB_avg);
				rangedAttack += (1 + BAB_avg);
				rangedDefence += (1 + BAB_avg);
				magicAttack += (4 + BAB_avg);
				magicDefence += (3 + BAB_avg);
			}

			if (characterClass == CharacterClass.FIGHTER) {
				meleeAttack += (5 + BAB_good);
				meleeDefence += (5 + BAB_good);
				rangedAttack += (3 + BAB_avg);
				rangedDefence += (3 + BAB_good);
				magicAttack = 0.0D;
				magicDefence += (1 + BAB_good);
			}

			if (characterClass == CharacterClass.MONK) {
				meleeAttack += (5 + BAB_good);
				meleeDefence += (6 + BAB_good);
				rangedAttack += (3 + BAB_avg);
				rangedDefence += (3 + BAB_good);
				magicAttack = 0.0D;
				magicDefence += (1 + BAB_poor);
				reflex += (0.5 * level);
				if ((player.getInventory().getBoots() == null)
						&& (player.getInventory().getLeggings() == null)
						&& (player.getInventory().getChestplate() == null)
						&& (player.getInventory().getHelmet() == null)) {
					meleeDefence += (0.25 * level);
					rangedDefence += (0.25 * level);
				}
			}

			if (characterClass == CharacterClass.PALADIN) {
				meleeAttack += (4 + BAB_avg);
				meleeDefence += (4 + BAB_good);
				rangedAttack += (2 + BAB_avg);
				rangedDefence += (2 + BAB_good);
				magicAttack += (3 + BAB_avg);
				magicDefence += (3 + BAB_avg);
			}

			if (characterClass == CharacterClass.RANGER) {
				meleeAttack += (2 + BAB_avg);
				meleeDefence += (2 + BAB_avg);
				rangedAttack += (4 + BAB_good);
				rangedDefence += (2 + BAB_avg);
				magicAttack += (1 + BAB_avg);
				magicDefence += (2 + BAB_avg);
				reflex += (0.25 * level);
			}

			if (characterClass == CharacterClass.ROGUE) {
				meleeAttack += (5 + BAB_good);
				meleeDefence += (4 + BAB_avg);
				rangedAttack += (3 + BAB_good);
				rangedDefence += (3 + BAB_avg);
				magicAttack = 0.0D;
				magicDefence += (2 + BAB_avg);
				reflex += (0.5 * level);
			}

			if (characterClass == CharacterClass.SORCERER) {
				meleeAttack += (2 + BAB_poor);
				meleeDefence += (2 + BAB_poor);
				rangedAttack += (1 + BAB_avg);
				rangedDefence += (1 + BAB_avg);
				magicAttack += (5 + BAB_good);
				magicDefence += (5 + BAB_good);
			}

			if (characterClass == CharacterClass.WIZARD) {
				meleeAttack += (1 + BAB_poor);
				meleeDefence += (1 + BAB_poor);
				rangedAttack += (2 + BAB_avg);
				rangedDefence += (2 + BAB_avg);
				magicAttack += (5 + BAB_good);
				magicDefence += (5 + BAB_good);
			}

			try {
				race = gildorymCharacterCards.getCharacterCards()
						.get(player.getName()).getRace();
			} catch (NullPointerException ex) {
				sender.sendMessage(ChatColor.RED
						+ "You must set your race first!");
			}

			if (race == Race.DWARF) {
				magicAttack -= 2;
				if (level > 1) {
					magicAttack -= (0.125 * level);
				}
			}

			if (race == Race.ELF) {
				rangedAttack += 2;
				reflex += 2;
				if (level > 1) {
					rangedAttack += (0.125 * level);
					reflex += (0.125 * level);
				}
			}

			if (race == Race.GNOME) {
				meleeAttack -= 2;
				rangedAttack -= 2;
				if (level > 1) {
					meleeAttack -= (0.125 * level);
					rangedAttack -= (0.125 * level);
				}
			}

			if (race == Race.HALFLING) {
				reflex += 2;
				rangedAttack += 2;
				meleeAttack -= 2;
				if (level > 1) {
					meleeAttack -= (0.125 * level);
					rangedAttack += (0.125 * level);
					reflex += (0.125 * level);
				}
			}

			if (race == Race.HALFORC) {
				meleeAttack += 2;
				rangedAttack += 2;
				magicAttack -= 4;
				magicDefence -= 2;
				if (level > 1) {
					meleeAttack += (0.125 * level);
					rangedAttack += (0.125 * level);
					magicAttack -= (0.25 * level);
					magicDefence -= (0.125 * level);
				}
			}

			Material itemType = player.getItemInHand().getType();

			switch (itemType) {
			// Melee Attack +1
			case WOOD_SWORD:
			case STONE_SPADE:
			case WOOD_PICKAXE:
			case STONE_PICKAXE:
			case IRON_PICKAXE:
			case IRON_HOE:
				meleeAttack += 1.0D;
				break;
			// Melee Attack +2
			case STONE_SWORD:
			case WOOD_AXE:
			case STONE_AXE:
			case DIAMOND_PICKAXE:
				meleeAttack += 2.0D;
				break;
			// Melee Attack +3
			case IRON_SWORD:
			case IRON_AXE:
			case IRON_SPADE:
				meleeAttack += 3.0D;
				break;
			// Melee Attack +5
			case DIAMOND_SWORD:
			case DIAMOND_AXE:
				meleeAttack += 5.0D;
				break;
			// Ranged Attack +3
			case CARROT_STICK:
				rangedAttack += 3.0D;
				break;
			// Ranged Attack +4
			case GOLD_PICKAXE:
				rangedAttack += 4.0D;
				break;
			// Ranged Attack +5
			case BOW:
				rangedAttack += 5.0D;
				break;
			// Melee Attack +1; Magic Attack +3
			case WOOD_HOE:
				meleeAttack += 1.0D;
				magicAttack += 3.0D;
				break;
			// Melee Attack +2; Magic Attack +2
			case STONE_HOE:
				meleeAttack += 2.0D;
				magicAttack += 2.0D;
				break;
			// Melee Attack +2; Magic Attack +3
			case GOLD_SWORD:
				meleeAttack += 2.0D;
				magicAttack += 3.0D;
				break;
			// Melee Attack +3; Magic Attack +2
			case GOLD_SPADE:
				meleeAttack += 3.0D;
				magicAttack += 2.0D;
				break;
			// Melee Attack +3; Magic Attack +4
			case GOLD_AXE:
			case GOLD_HOE:
				meleeAttack += 3.0D;
				magicAttack += 4.0D;
				break;
			// Magic Attack +2
			case ENDER_PEARL:
				magicAttack += 2.0D;
				break;
			// Magic Attack +3
			case DIAMOND_HOE:
			case EYE_OF_ENDER:
				magicAttack += 3.0D;
				break;
			// Magic Attack +4
			case DIAMOND_SPADE:
			case BLAZE_ROD:
			case GOLDEN_APPLE:
				magicAttack += 4.0D;
				break;
			// Magic Attack +5
			case WOOD_SPADE:
				magicAttack += 5.0D;
				break;
			default:
				break;
			}
			
			// Helmets
			if (player.getInventory().getHelmet() != null) {
				Material helmetType = player.getInventory().getHelmet().getType();
				if (helmetType == Material.LEATHER_HELMET) {
					meleeDefence += 0.25D;
					rangedDefence += 0.25D;
				} else if (helmetType == Material.CHAINMAIL_HELMET) {
					meleeDefence += 0.5D;
					rangedDefence += 0.5D;
				} else if (helmetType == Material.IRON_HELMET) {
					meleeDefence += 0.75D;
					rangedDefence += 0.75D;
				} else if (helmetType == Material.DIAMOND_HELMET) {
					meleeDefence += 1.0D;
					rangedDefence += 1.0D;
				}
			}
			
			// Chestplates
			if (player.getInventory().getChestplate() != null) {
				Material chestplateType = player.getInventory().getChestplate().getType();
				if (chestplateType == Material.LEATHER_CHESTPLATE) {
					meleeDefence += 1.75D;
					rangedDefence += 1.75D;
				} else if (chestplateType == Material.CHAINMAIL_CHESTPLATE) {
					meleeDefence += 2.25D;
					rangedDefence += 2.25D;
				} else if (chestplateType == Material.IRON_CHESTPLATE) {
					meleeDefence += 2.5D;
					rangedDefence += 2.5D;
				} else if (chestplateType == Material.DIAMOND_CHESTPLATE) {
					meleeDefence += 3.5D;
					rangedDefence += 3.5D;
				}
			}
			
			// Leggings
			if (player.getInventory().getLeggings() != null) {
				Material leggingsType = player.getInventory().getLeggings().getType();
				if (leggingsType == Material.LEATHER_LEGGINGS) {
					meleeDefence += 0.75D;
					rangedDefence += 0.75D;
				} else if (leggingsType == Material.CHAINMAIL_LEGGINGS) {
					meleeDefence += 1.75D;
					rangedDefence += 1.75D;
				} else if (leggingsType == Material.IRON_LEGGINGS) {
					meleeDefence += 2.0D;
					rangedDefence += 2.0D;
				} else if (leggingsType == Material.DIAMOND_LEGGINGS) {
					meleeDefence += 2.5D;
					rangedDefence += 2.5D;
				}
			}
			
			// Boots
			if (player.getInventory().getBoots() != null) {
				Material bootsType = player.getInventory().getBoots().getType();
				if (bootsType == Material.LEATHER_BOOTS) {
					meleeDefence += 0.25D;
					rangedDefence += 0.25D;
				} else if (bootsType == Material.CHAINMAIL_BOOTS) {
					meleeDefence += 0.5D;
					rangedDefence += 0.5D;
				} else if (bootsType == Material.IRON_BOOTS) {
					meleeDefence += 0.75D;
					rangedDefence += 0.75D;
				} else if (bootsType == Material.DIAMOND_BOOTS) {
					meleeDefence += 1.0D;
					rangedDefence += 1.0D;
				}
			}

			// Obsolete Enchantment Handler
			
			/*
			 * Iterator<Enchantment> enchantmentIterator; enchantmentIterator =
			 * ((Player)
			 * sender).getItemInHand().getEnchantments().keySet().iterator();
			 * while (enchantmentIterator.hasNext()) { Enchantment enchantment =
			 * enchantmentIterator.next(); if (((Player)
			 * sender).getItemInHand().getType() == Material.BOW) { if
			 * (enchantment == Enchantment.ARROW_DAMAGE || enchantment ==
			 * Enchantment.ARROW_FIRE) { rangedAttack += ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } }
			 * 
			 * if (((Player) sender).getItemInHand().getType() ==
			 * Material.WOOD_SWORD || ((Player)
			 * sender).getItemInHand().getType() == Material.STONE_SWORD ||
			 * ((Player) sender).getItemInHand().getType() ==
			 * Material.IRON_SWORD || ((Player)
			 * sender).getItemInHand().getType() == Material.GOLD_SWORD ||
			 * ((Player) sender).getItemInHand().getType() ==
			 * Material.DIAMOND_SWORD) { if (enchantment ==
			 * Enchantment.DAMAGE_ALL || enchantment == Enchantment.FIRE_ASPECT)
			 * { meleeAttack += ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } }
			 * 
			 * if (((Player) sender).getItemInHand().getType() == Material.STICK
			 * || ((Player) sender).getItemInHand().getType() ==
			 * Material.BLAZE_ROD || ((Player) sender).getItemInHand().getType()
			 * == Material.ENDER_PEARL || ((Player)
			 * sender).getItemInHand().getType() == Material.EYE_OF_ENDER) { if
			 * (enchantment == Enchantment.DAMAGE_ALL || enchantment ==
			 * Enchantment.FIRE_ASPECT) { magicAttack += ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } }
			 * 
			 * if (((Player) sender).getInventory().getHelmet() != null) {
			 * enchantmentIterator = ((Player)
			 * sender).getInventory().getHelmet()
			 * .getEnchantments().keySet().iterator(); while
			 * (enchantmentIterator.hasNext()) { if (enchantment ==
			 * Enchantment.PROTECTION_ENVIRONMENTAL) { meleeDefence += 0.25D *
			 * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
			 * magicDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
			 * rangedDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } } }
			 * 
			 * if (((Player) sender).getInventory().getChestplate() != null) {
			 * enchantmentIterator = ((Player)
			 * sender).getInventory().getHelmet()
			 * .getEnchantments().keySet().iterator(); while
			 * (enchantmentIterator.hasNext()) { if (enchantment ==
			 * Enchantment.PROTECTION_ENVIRONMENTAL) { meleeDefence += 0.25D *
			 * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
			 * magicDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
			 * rangedDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } } }
			 * 
			 * if (((Player) sender).getInventory().getLeggings() != null) {
			 * enchantmentIterator = ((Player)
			 * sender).getInventory().getHelmet()
			 * .getEnchantments().keySet().iterator(); while
			 * (enchantmentIterator.hasNext()) { if (enchantment ==
			 * Enchantment.PROTECTION_ENVIRONMENTAL) { meleeDefence += 0.25D *
			 * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
			 * magicDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
			 * rangedDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } } }
			 * 
			 * if (((Player) sender).getInventory().getBoots() != null) {
			 * enchantmentIterator = ((Player)
			 * sender).getInventory().getHelmet()
			 * .getEnchantments().keySet().iterator(); while
			 * (enchantmentIterator.hasNext()) { if (enchantment ==
			 * Enchantment.PROTECTION_ENVIRONMENTAL) { meleeDefence += 0.25D *
			 * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_EXPLOSIONS) {
			 * magicDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); }
			 * 
			 * if (enchantment == Enchantment.PROTECTION_PROJECTILE) {
			 * rangedDefence += 0.25D * ((Player)
			 * sender).getItemInHand().getEnchantments().get(enchantment); } } }
			 * }
			 */

			sender.sendMessage(ChatColor.GRAY + "======================");
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD
					+ player.getDisplayName() + "'s Roll Info");
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Class: "
					+ characterClass);
			sender.sendMessage(ChatColor.GRAY + "======================");
			sender.sendMessage(ChatColor.RED + "Melee   - Attack: "
					+ ChatColor.WHITE + (int) Math.floor(meleeAttack)
					+ ChatColor.RED + "  Defence: " + ChatColor.WHITE
					+ (int) Math.floor(meleeDefence));
			sender.sendMessage(ChatColor.RED + "Ranged - Attack: "
					+ ChatColor.WHITE + (int) Math.floor(rangedAttack)
					+ ChatColor.RED + "  Defence: " + ChatColor.WHITE
					+ (int) Math.floor(rangedDefence));
			sender.sendMessage(ChatColor.RED + "Magic   - Attack: "
					+ ChatColor.WHITE + (int) Math.floor(magicAttack)
					+ ChatColor.RED + "  Defence: " + ChatColor.WHITE
					+ (int) Math.floor(magicDefence));
			sender.sendMessage(ChatColor.RED + "Luck: " + ChatColor.WHITE
					+ (int) Math.floor(luck));
			sender.sendMessage(ChatColor.RED + "Reflex: " + ChatColor.WHITE
					+ (int) Math.floor(reflex));
		} else {
			sender.sendMessage(ChatColor.DARK_RED
					+ "Could not find that player!");
		}
		return true;
	}

}
