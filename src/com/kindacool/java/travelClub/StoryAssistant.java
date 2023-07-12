package com.kindacool.java.travelClub;

import com.kindacool.java.travelClub.entity.TravelClub;
import com.kindacool.java.travelClub.ui.menu.ClubMenu;

public class StoryAssistant {

    private void startStory(){

        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }

    public static void main(String[] args) {
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();

    }
}
