/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
public class Item {
    private String name;
    private String description;
    private int healAmount;

    public Item(String name, String description, int healAmount) {
        this.name = name;
        this.description = description;
        this.healAmount = healAmount;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHealAmount() { return healAmount; }
}