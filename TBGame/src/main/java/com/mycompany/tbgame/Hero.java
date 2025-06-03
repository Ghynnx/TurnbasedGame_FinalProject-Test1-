/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
import java.util.HashSet;
import java.util.Set;

public class Hero {
    private String name;
    private int health;
    private int mana;
    private Inventory inventory = new Inventory();
    private Set<Skill> skills = new HashSet<>();

    public Hero(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public Inventory getInventory() { return inventory; }
    public Set<Skill> getSkills() { return skills; }
    public void takeDamage(int dmg) { health -= dmg; }
    public boolean isDefeated() { return health <= 0; }
    public void heal(int amt) { health += amt; }
    public void addSkill(Skill skill) { skills.add(skill); }
    public void useMana(int amt) { mana -= amt; }
    public void restoreMana(int amt) { mana += amt; }
}