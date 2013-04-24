package com.gildorymrp.gildorym;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RollCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String rollString = args[0];
		if (!rollString.contains("d")) {
			rollString = "1d" + rollString;
		}
		
		if (rollString.startsWith("d")) {
			rollString = "1" + rollString;
		}
		
		if (rollString.endsWith("d")) {
			sender.sendMessage(ChatColor.RED + "You must specify the number of sides.");
		}
		
		try {
			Integer amount = Integer.parseInt(rollString.split("d")[0]);
			Integer maxRoll;
			Integer plus;
			if (rollString.split("d")[1].contains("+")) {
				maxRoll = Integer.parseInt(rollString.split("d")[1].split("+")[0]);
				plus = Integer.parseInt(rollString.split("d")[1].split("+")[1]);
			} else {
				maxRoll = Integer.parseInt(rollString.split("d")[1]);
				plus = 0;
			}
			Integer[] rolls = new Integer[amount];
			Random random = new Random();
			for (int i = 0; i < amount; ++i) {
				rolls[i] = random.nextInt(maxRoll) + 1;
			}
			
			String rollMessage = "(";
			Integer rollTotal = 0;
			
			for (int i = 0; i < amount - 1; ++i) {
				rollMessage += rolls[i].toString() + " + ";
				rollTotal += rolls[i];
			}
			
			rollMessage += rolls[rolls.length - 1];
			rollTotal += rolls[rolls.length - 1];
			
			if (plus >= 1) {
				rollMessage += " + " + plus;
				rollTotal += plus;
			}
			
			rollMessage += ") = " + rollTotal.toString();
			
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				if (((Player) sender).getWorld() == player.getWorld()) {
					if (((Player) sender).getLocation().distance(player.getLocation()) <= 32) {
						player.sendMessage(ChatColor.GRAY + ((Player) sender).getDisplayName() + " rolled " + rollString);
						player.sendMessage(ChatColor.GRAY + rollMessage);
					}
				}
			}
		} catch (NumberFormatException exception) {
			sender.sendMessage(ChatColor.RED + "Failed to parse the roll.");
		}
		return true;
	}

}
