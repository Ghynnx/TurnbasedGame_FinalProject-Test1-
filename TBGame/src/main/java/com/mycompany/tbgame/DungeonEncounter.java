/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
import java.util.LinkedList;
import java.util.Queue;

public class DungeonEncounter {
    private Queue<Monster> monsters = new LinkedList<>();

    public void enqueueMonster(Monster m) { monsters.add(m); }
    public Monster nextMonster() { return monsters.poll(); }
    public boolean isEmpty() { return monsters.isEmpty(); }
}