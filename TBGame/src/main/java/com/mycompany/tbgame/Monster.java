/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
public class Monster {
    private String name;
    private int health;
    private int attack;

    public Monster(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void takeDamage(int dmg) { health -= dmg; }
    public boolean isDefeated() { return health <= 0; }
    public int attack() { return attack; }
}
