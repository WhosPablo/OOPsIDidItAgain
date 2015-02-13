package com.oopsididitagain.model;

import java.util.HashMap;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    
    public Entity() {
    	inventory = new Inventory();
    }
    
	public void addToInventory(TakeableItem takeableItem) {
		this.inventory.addItem(takeableItem);
		System.out.println(takeableItem);
		printInventory();
	}
	
	public void printInventory() {
	    HashMap<String , Item> hash = inventory.getInventory();
		
		for (String name: hash.keySet())
            System.out.println(name);
	}
}
