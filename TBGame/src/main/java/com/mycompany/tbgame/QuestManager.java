/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tbgame;

/**
 *
 * @author Students Account
 */
import java.util.ArrayList;
import java.util.List;

public class QuestManager {
    private List<Quest> activeQuests = new ArrayList<>();

    public void addQuest(Quest quest) { activeQuests.add(quest); }
    public void completeQuest(String questName) {
        for (Quest q : activeQuests) {
            if (q.getName().equals(questName)) q.complete();
        }
    }
    public void showQuests() {
        for (Quest q : activeQuests) {
            System.out.println(q.getName() + " - " + (q.isCompleted() ? "[COMPLETED]" : "[ACTIVE]"));
            System.out.println("  " + q.getDescription());
        }
    }
}
