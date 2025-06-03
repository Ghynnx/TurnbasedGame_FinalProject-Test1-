/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item useItem(String itemName) {
        return items.remove(itemName); // returns and removes the item
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        System.out.println("Inventory:");
        for (Item item : items.values()) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }
}