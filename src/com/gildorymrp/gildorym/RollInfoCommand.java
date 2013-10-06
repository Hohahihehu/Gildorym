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


import com.gildorymrp.charactercards.GildorymCharacterCards;
import com.gildorymrp.charactercards.Race;
import com.gildorymrp.gildorymclasses.CharacterClass;
import com.gildorymrp.gildorymclasses.GildorymClasses;


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
		GildorymClasses gildorymClasses = (GildorymClasses) Bukkit.getServer().getPluginManager().getPlugin("GildorymClasses");
		GildorymCharacterCards gildorymCharacterCards = (GildorymCharacterCards) Bukkit.getServer().getPluginManager().getPlugin("GildorymCharacterCards");


		if (player != null) {
			//HeroClass heroClass = heroes.getCharacterManager().getHero(player).getHeroClass();
			//Integer heroLevel = Integer.valueOf(heroes.getCharacterManager().getHero(player).getLevel(heroClass));
			CharacterClass characterClass = gildorymClasses.classes.get(player.getName());
			int level = gildorymClasses.levels.get(player.getName());


			double meleeAttack = 0.0D;
			double meleeDefence = 0.0D;
			double rangedAttack = 0.0D;
			double rangedDefence = 0.0D;
			double magicAttack = 0.0D;
			double magicDefence = 0.0D;
			double luck = 0.0D;
			double reflex = 0.0D;
			int	BAB_good = 0;
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
			} else if (level == 2) {
				BAB_avg = 1; 
				BAB_poor = 1;
			} else if (level == 3) {
				BAB_avg = 2; 
				BAB_poor = 1;
			} else if (level == 4) {
				BAB_avg = 3; 
				BAB_poor = 2;
			} else if (level == 5) {
				BAB_avg = 3; 
				BAB_poor = 2;
			} else if (level == 6) {
				BAB_avg = 4; 
				BAB_poor = 3;
			} else if (level == 7) {
				BAB_avg = 5; 
				BAB_poor = 3;
			} else if (level == 8) {
				BAB_avg = 6; 
				BAB_poor = 4;
			} else if (level == 9) {
				BAB_avg = 6; 
				BAB_poor = 4;
			} else if (level == 10) {
				BAB_avg = 7; 
				BAB_poor = 5;
			} else if (level == 11) {
				BAB_avg = 8; 
				BAB_poor = 5;
			} else if (level == 12) {
				BAB_avg = 9; 
				BAB_poor = 6;
			} else if (level == 13) {
				BAB_avg = 9; 
				BAB_poor = 6;
			} else if (level == 14) {
				BAB_avg = 10; 
				BAB_poor = 7;
			} else if (level == 15) {
				BAB_avg = 11; 
				BAB_poor = 7;
			} else if (level == 16) {
				BAB_avg = 12; 
				BAB_poor = 8;
			} else if (level == 17) {
				BAB_avg = 12; 
				BAB_poor = 8;
			} else if (level == 18) {
				BAB_avg = 13; 
				BAB_poor = 9;
			} else if (level == 19) {
				BAB_avg = 14; 
				BAB_poor = 9;
			} else if (level == 20) {
				BAB_avg = 15; 
				BAB_poor = 10;
			} else {
				BAB_avg = 15; 
				BAB_poor = 10;
			}
			
			//meleeAttack += level;
			//meleeDefence += level;
			//rangedAttack += level;
			//rangedDefence += level;
			//magicAttack += level;
			//magicDefence += level;
		
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
				if ((player.getInventory().getBoots() == null) && (player.getInventory().getLeggings() == null) && (player.getInventory().getChestplate() == null) && (player.getInventory().getHelmet() == null)) {
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


			if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.DWARF) {
				magicAttack -= 2;
				if (level > 1) {
					magicAttack -= (0.125 * level);
				}	
			}


			if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.ELF) {
				rangedAttack += 2;
				reflex += 2;
				if (level > 1) {
					rangedAttack += (0.125 * level);
					reflex += (0.125 * level);
				}	
			}


			if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.GNOME) {
				meleeAttack -= 2;
				rangedAttack -= 2;
				if (level > 1) {
					meleeAttack -= (0.125 * level);
					rangedAttack -= (0.125 * level);
				}	
			}


			if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.HALFLING) {
				reflex += 2;
				rangedAttack += 2;
				meleeAttack -= 2;
				if (level > 1) {
					meleeAttack -= (0.125 * level);
					rangedAttack += (0.125 * level);
					reflex += (0.125 * level);
				}	
			}


			if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.HALFORC) {
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


			/*if (gildorymCharacterCards.getCharacterCards().get(player.getName()).getRace() == Race.DROW) {
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

			//WOOD_SWORD
			if (player.getItemInHand().getType() == Material.WOOD_SWORD {
				meleeAttack += 1.0D;
			}
			
			//STONE_SWORD
			if (player.getItemInHand().getType() == Material.STONE_SWORD {
				meleeAttack += 2.0D;
			}
			
			//IRON_SWORD
			if (player.getItemInHand().getType() == Material.IRON_SWORD {
				meleeAttack += 3.0D;
			}
			
			//DIAMOND_SWORD
			if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				meleeAttack += 5.0D;
			}
			
			//GOLDEN_SWORD
			if (player.getItemInHand().getType() == Material.GOLD_SWORD){
				meleeAttack += 2.0D;
				magicAttack += 3.0D;
			}
			
			//WOOD_AXE
			if (player.getItemInHand().getType() == Material.WOOD_AXE) {
				meleeAttack += 2.0D;
			}
			
			//STONE_AXE
			if (player.getItemInHand().getType() == Material.STONE_AXE) {
				meleeAttack += 2.0D;
			}
			
			//IRON_AXE
			if (player.getItemInHand().getType() == Material.IRON_AXE) {
				meleeAttack += 3.0D;
			}
			
			//DIAMOND_AXE
			if (player.getItemInHand().getType() == Material.DIAMOND_AXE {
				meleeAttack += 5.0D;
			}
			
			//GOLD_AXE
			if (player.getItemInHand().getType() == Material.GOLD_AXE){
				meleeAttack += 3.0D;
				magicAttack += 4.0D;
			}
			
			//WOOD_SPADE
			if (player.getItemInHand().getType() == Material.WOOD_SPADE){
				magicAttack += 5.0D;
			}
			
			//STONE_SPADE
			if (player.getItemInHand().getType() == Material.STONE_SPADE){
				meleeAttack += 1.0D;
			}
			
			//IRON_SPADE
			if (player.getItemInHand().getType() == Material.IRON_SPADE){
				meleeAttack += 3.0D;
			}
			
			//DIAMOND_SPADE
			if (player.getItemInHand().getType() == Material.DIAMOND_SPADE){
				magicAttack += 4.0D;
			}
			
			//GOLD_SPADE
			if (player.getItemInHand().getType() == Material.GOLD_SPADE){
				meleeAttack += 3.0D;
				magicAttack += 2.0D;
			}
			
			//WOOD_PICKAXE
			if (player.getItemInHand().getType() == Material.WOOD_PICKAXE){
				meleeAttack += 1.0D;
			}
			
			//STONE_PICKAXE
			if (player.getItemInHand().getType() == Material.STONE_PICKAXE) {
				meleeAttack += 1.0D;
			}
			
			//IRON_PICKAXE
			if (player.getItemInHand().getType() == Material.IRON_PICKAXE) {
				meleeAttack += 1.0D;
			}
			
			//DIAMOND_PICKAXE
			if (player.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
				meleeAttack += 2.0D;
			}
			
			//GOLD_PICKAXE
			if (player.getItemInHand().getType() == Material.GOLD_PICKAXE){
				rangedAttack += 4.0D;
			}
			
			//WOOD_HOE
			if (player.getItemInHand().getType() == Material.WOOD_HOE) {
				meleeAttack += 1.0D;
				magicAttack += 3.0D;
			}
			
			//STONE_HOE
			if (player.getItemInHand().getType() == Material.STONE_HOE){
				meleeAttack += 2.0D;
				magicAttack += 2.0D;
			}
			
			//IRON_HOE
			if (player.getItemInHand().getType() == Material.IRON_HOE){
				meleeAttack += 1.0D;
			}
			
			//DIAMOND_HOE
			if (player.getItemInHand().getType() == Material.DIAMOND_HOE) {
				magicAttack += 3.0D;
			}
			
			//GOLD_HOE
			if (player.getItemInHand().getType() == Material.GOLD_HOE) {
				meleeAttack += 3.0D;
				magicAttack += 4.0D;
			}
			
			//BOW
			if (player.getItemInHand().getType() == Material.BOW) {
				rangedAttack += 5.0D;
			}
			
			//CARROT_STICK
			if (player.getItemInHand().getType() == Material.CARROT_STICK){
				rangedAttack += 3.0D;
			}
			
			//BLAZE_ROD
			if (player.getItemInHand().getType() == Material.BLAZE_ROD) {
				magicAttack += 4.0D;
			}
			
			//GOLDEN_APPLE
			if (player.getItemInHand().getType() == Material.GOLDEN_APPLE){
				magicAttack += 4.0D;
			}

			//ENDER_PEARL
			if (player.getItemInHand().getType() == Material.ENDER_PEARL) {
				magicAttack += 2.0D;
			}
			
			//EYE_OF_ENDER
			if (player.getItemInHand().getType() == Material.EYE_OF_ENDER){
				magicAttack += 3.0D;
			}
			
			//LEATHER_HELMET
			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.LEATHER_HELMET)) {
				meleeDefence += 0.25D;
				rangedDefence += 0.25D;
			}

			//LEATHER_CHESTPLATE
			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE)) {
				meleeDefence += 1.75D;
				rangedDefence += 1.75D;
			}

			//LEATHER_LEGGINGS
			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS)) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			//LEATHER_BOOTS
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.LEATHER_BOOTS)) {
				meleeDefence += 0.25D;
				rangedDefence += 0.25D;
			}

			//CHAINMAIL_HELMET
			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET)) {
				meleeDefence += 0.5D;
				rangedDefence += 0.5D;
			}

			//CHAINMAIL_CHESTPLATE
			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE)) {
				meleeDefence += 2.25D;
				rangedDefence += 2.25D;
			}

			//CHAINMAIL_LEGGINGS
			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.CHAINMAIL_LEGGINGS)) {
				meleeDefence += 1.75D;
				rangedDefence += 1.75D;
			}

			//CHAINMAIL_BOOTS
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS)) {
				meleeDefence += 0.5D;
				rangedDefence += 0.5D;
			}

			//IRON_HELMET
			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.IRON_HELMET)) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			//IRON_CHESTPLATE
			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE)) {
				meleeDefence += 2.5D;
				rangedDefence += 2.5D;
			}

			//IRON_LEGGINGS
			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.IRON_LEGGINGS)) {
				meleeDefence += 2.0D;
				rangedDefence += 2.0D;
			}

			//IRON_BOOTS
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.IRON_BOOTS)) {
				meleeDefence += 0.75D;
				rangedDefence += 0.75D;
			}

			//DIAMOND_HELMET
			if ((player.getInventory().getHelmet() != null) && (player.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET)) {
				meleeDefence += 1.0D;
				rangedDefence += 1.0D;
			}

			//DIAMOND_CHESTPLATE
			if ((player.getInventory().getChestplate() != null) && (player.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE)) {
				meleeDefence += 3.5D;
				rangedDefence += 3.5D;
			}

			//DIAMOND_LEGGINGS
			if ((player.getInventory().getLeggings() != null) && (player.getInventory().getLeggings().getType() == Material.DIAMOND_LEGGINGS)) {
				meleeDefence += 2.5D;
				rangedDefence += 2.5D;
			}

			//DIAMOND_BOOTS
			if ((player.getInventory().getBoots() != null) && (player.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS)) {
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
			sender.sendMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Class: " + characterClass);
			sender.sendMessage(ChatColor.GRAY + "======================");
			sender.sendMessage(ChatColor.RED + "Melee   - Attack: " + ChatColor.WHITE + (int) Math.floor(meleeAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.floor(meleeDefence));
			sender.sendMessage(ChatColor.RED + "Ranged - Attack: " + ChatColor.WHITE + (int) Math.floor(rangedAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.floor(rangedDefence));
			sender.sendMessage(ChatColor.RED + "Magic   - Attack: " + ChatColor.WHITE + (int) Math.floor(magicAttack) + ChatColor.RED + "  Defence: " + ChatColor.WHITE + (int)Math.floor(magicDefence));
			sender.sendMessage(ChatColor.RED + "Luck: " + ChatColor.WHITE + (int) Math.floor(luck));
			sender.sendMessage(ChatColor.RED + "Reflex: " + ChatColor.WHITE + (int) Math.floor(reflex));
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "Could not find that player!");
		}
		return true;
	}


}

