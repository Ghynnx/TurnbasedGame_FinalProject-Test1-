/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
import java.util.Stack;

public class ActionHistory {
    private Stack<Action> actions = new Stack<>();

    public void pushAction(Action a) { actions.push(a); }
    public Action popAction() { return actions.isEmpty() ? null : actions.pop(); }
    public void showHistory() {
        System.out.println("Action History:");
        for (Action a : actions) {
            System.out.println(a.getDescription());
        }
    }
}