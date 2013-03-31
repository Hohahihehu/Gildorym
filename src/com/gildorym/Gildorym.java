package com.gildorym;

import org.bukkit.plugin.java.JavaPlugin;

public class Gildorym extends JavaPlugin {
	
	public void onEnable() {
		this.getCommand("newcharacter").setExecutor(new NewCharacterCommand());
		this.getCommand("surname").setExecutor(new SurnameCommand());
		this.getCommand("rollinfo").setExecutor(new RollInfoCommand());
		this.getCommand("roll").setExecutor(new RollCommand());
		//this.getServer().getPluginManager().registerEvents(new ClassChangeListener(), this);
		this.getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
	}

}
