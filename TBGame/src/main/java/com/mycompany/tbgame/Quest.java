/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
public class Quest {
    private String name;
    private String description;
    private boolean completed;

    public Quest(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public void complete() { this.completed = true; }
}
