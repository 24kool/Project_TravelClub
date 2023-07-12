package com.kindacool.java.travelClub.ui.console;

import com.kindacool.java.travelClub.service.ClubService;
import com.kindacool.java.travelClub.service.ServiceLogicLifeCycler;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole(){
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
