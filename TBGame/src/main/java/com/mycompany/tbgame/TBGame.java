/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tbgame;

import java.util.Scanner;


/**
 *
 * @author Students Account
 */
public class TBGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero("Arannis", 100, 50);
        QuestManager questManager = new QuestManager();
        ActionHistory actionHistory = new ActionHistory();

        // Add starting quest
        Quest quest = new Quest("Save the Village", "Drive the goblins from the dungeon.");
        questManager.addQuest(quest);

        // Add starting item
        Item potion = new Item("Health Potion", "Restores 30 HP", 30);
        hero.getInventory().addItem(potion);

        // Add a skill
        Skill fireball = new Skill("Fireball", "Deal 20 fire damage", 10);
        hero.addSkill(fireball);

        // Dungeon setup
        DungeonEncounter dungeon = new DungeonEncounter();
        dungeon.enqueueMonster(new Monster("Goblin", 30, 8));
        dungeon.enqueueMonster(new Monster("Goblin Leader", 50, 15));

        System.out.println("Welcome, " + hero.getName() + "!");

        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. View Quests\n2. Enter Dungeon\n3. View Inventory\n4. View Skills\n5. View Action History\n6. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    questManager.showQuests();
                    break;
                case "2":
                    while (!dungeon.isEmpty() && !hero.isDefeated()) {
                        Monster m = dungeon.nextMonster();
                        System.out.println("\nA wild " + m.getName() + " appears!");
                        while (!m.isDefeated() && !hero.isDefeated()) {
                            System.out.println("Your HP: " + hero.getHealth() + " | Mana: " + hero.getMana() + " | Monster HP: " + m.getHealth());
                            System.out.println("Choose: 1-Attack 2-Use Item 3-Use Skill");
                            String battleChoice = sc.nextLine();
                            if (battleChoice.equals("1")) {
                                m.takeDamage(10); // Basic attack
                                System.out.println("You attack the monster!");
                                actionHistory.pushAction(new Action("Attacked " + m.getName()));
                            } else if (battleChoice.equals("2")) {
                                hero.getInventory().showInventory();
                                System.out.print("Type item name to use: ");
                                String itemName = sc.nextLine();
                                Item used = hero.getInventory().useItem(itemName);
                                if (used != null) {
                                    hero.heal(used.getHealAmount());
                                    System.out.println("You used " + used.getName() + " and healed " + used.getHealAmount() + " HP!");
                                    actionHistory.pushAction(new Action("Used item " + used.getName()));
                                } else {
                                    System.out.println("Invalid item!");
                                }
                            } else if (battleChoice.equals("3")) {
                                for (Skill s : hero.getSkills()) {
                                    System.out.println(s.getName() + " (" + s.getManaCost() + " mana): " + s.getDescription());
                                }
                                System.out.print("Type skill name to use: ");
                                String skillName = sc.nextLine();
                                Skill found = null;
                                for (Skill s : hero.getSkills()) {
                                    if (s.getName().equalsIgnoreCase(skillName)) found = s;
                                }
                                if (found != null && hero.getMana() >= found.getManaCost()) {
                                    m.takeDamage(20); // Fireball sample
                                    hero.useMana(found.getManaCost());
                                    System.out.println("You cast " + found.getName() + "!");
                                    actionHistory.pushAction(new Action("Cast skill " + found.getName()));
                                } else {
                                    System.out.println("Not enough mana or skill not found.");
                                }
                            }
                            // Monster turn
                            if (!m.isDefeated()) {
                                hero.takeDamage(m.attack());
                                System.out.println(m.getName() + " attacks you for " + m.attack() + "!");
                                actionHistory.pushAction(new Action(m.getName() + " attacked"));
                            }
                        }
                        if (hero.isDefeated()) {
                            System.out.println("You were defeated!");
                            break;
                        } else {
                            System.out.println("Monster defeated!");
                        }
                    }
                    if (dungeon.isEmpty()) {
                        System.out.println("Dungeon cleared!");
                        questManager.completeQuest("Save the Village");
                    }
                    break;
                case "3":
                    hero.getInventory().showInventory();
                    break;
                case "4":
                    for (Skill s : hero.getSkills())
                        System.out.println(s.getName() + ": " + s.getDescription() + " (Mana: " + s.getManaCost() + ")");
                    break;
                case "5":
                    actionHistory.showHistory();
                    break;
                case "6":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

