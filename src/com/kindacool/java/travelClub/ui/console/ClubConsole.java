package com.kindacool.java.travelClub.ui.console;

import com.kindacool.java.travelClub.entity.TravelClub;
import com.kindacool.java.travelClub.service.ClubService;
import com.kindacool.java.travelClub.service.ServiceLogicLifeCycler;
import com.kindacool.java.travelClub.service.logic.ClubServiceLogic;
import com.kindacool.java.travelClub.util.ConsoleUtil;

import java.util.Locale;

public class ClubConsole {

    private ConsoleUtil consoleUtil;
    private ClubService clubService;

    public ClubConsole(){
        this.consoleUtil = new ConsoleUtil();

        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register(){
        //
        while(true){
            String clubName = consoleUtil.getValueOf("Club Name(0.Club Menu)");
            if(clubName.equals("0")){
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu");
            if(intro.equals("0")){
                return;
            }

            TravelClub newClub = new TravelClub(clubName, intro);

            //Save it into the register(Array)
            clubService.register(newClub);

            System.out.println("Registered club : " + newClub.toString());
        }
    }

    public void findAll(){
        //
        TravelClub[] foundClubs = clubService.findAll();
        if(foundClubs.length == 0){
            System.out.println("Empty. There is no clubs yet");
            return;
        }

        for(TravelClub club : foundClubs){
            System.out.println(club.toString());
        }
    }

    public void findById(){
        TravelClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValueOf("Type the club id to find. (type 0 to return club menu)");
            if (clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null){
                System.out.println(foundClub);
            }else{
                System.out.println("Cannot find the club ID : " + clubId);
            }
        }

    }

    public void findByName(){
        TravelClub[] foundClubs = null;
        while(true) {
            String clubName = consoleUtil.getValueOf("Type the club name to find. (type 0 to return club menu)");
            if (clubName.equals("0")){
                break;
            }

            foundClubs = clubService.findByName(clubName);

            if(foundClubs != null && foundClubs.length != 0){
                for(TravelClub club : foundClubs){
                    System.out.println(club);
                }
            }else{
                System.out.println("Cannot find the club Name : " + clubName);
            }

        }

    }

    private TravelClub findOne(){
        TravelClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValueOf("Type the club id to find. (type 0 to return to the club menu)");
            if (clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null){
                break;
            }else{
                System.out.println("Cannot find the club ID : " + clubId);
            }
        }
        return foundClub;

    }

    public void modify(){
        TravelClub targetClub = findOne();

        String newName = consoleUtil.getValueOf("Type new club name you want. Enter 0 if you don't want to change");
        if(newName.equals("0")){
            return;
        }
        if(!newName.isEmpty()){
            targetClub.setClubName(newName);
        }

        String newIntro = consoleUtil.getValueOf("Type new intro you want. Enter 0 if you don't want to change");

        if(!newIntro.isEmpty()){
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);

        System.out.println("Modify Club : " + targetClub.toString());

    }

    public void remove(){
        TravelClub targetClub = findOne();

        String confirmStr = consoleUtil.getValueOf("Do you want to remove this club? (Y: Yes, N: No)");
        if(confirmStr.toLowerCase().equals("y") || confirmStr.toLowerCase().equals("yes")){
            System.out.println("Removing club -->" + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        }else{
            System.out.println("Remove has been cancelled. Your club is safe." + targetClub.getClubName());
        }

    }


}
