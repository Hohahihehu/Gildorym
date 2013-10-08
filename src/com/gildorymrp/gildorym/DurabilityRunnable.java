package com.gildorymrp.gildorym;

import org.bukkit.inventory.ItemStack;

public class DurabilityRunnable implements Runnable {
 
private Gildorym plugin;
	
	public DurabilityRunnable(Gildorym plugin) {
		this.plugin = plugin;
	}
	
    ItemStack item;
    short durability;
    short MaxDurability = item.getType().getMaxDurability();
 
    public DurabilityRunnable (ItemStack item, short durability) {
        this.item = item;
        this.durability = durability;
    }
    @Override
    public void run() {
    	if (plugin.doDurabilityDamage(durability, MaxDurability, 1) == false){
    		item.setDurability(durability);
    	}else{
    		return;
    	}
    }
}
