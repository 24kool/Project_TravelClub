package com.kindacool.java.travelClub.entity;

import com.kindacool.java.travelClub.util.DateUtil;

import java.util.UUID;

public class TravelClub {
    //Fields
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 10;

    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;


    //Constructors
    private TravelClub(){
        this.id = UUID.randomUUID().toString();
    }

    public TravelClub(String clubName, String intro){
        this();
        setClubName(clubName);
        setIntro(intro);
        this.foundationDay = DateUtil.today();
    }

    //Methods
    //setters
    public void setClubName(String clubName){
        if(clubName.length() < MINIMUM_NAME_LENGTH){
            System.out.println("Club name should be longer then " + MINIMUM_NAME_LENGTH);
            return;
        }
        this.clubName = clubName;
    }

    public void setIntro(String intro){
        if(intro.length() < MINIMUM_INTRO_LENGTH){
            System.out.println("Intro length should be longer then " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }
    // id and foundation are made automatically so don't need setter method for them.

    //getters
    public String getClubName(){
        return this.clubName;
    }

    public String getIntro(){
        return this.intro;
    }

    public String getId(){
        return this.id;
    }

    public String getFoundationDay(){
        return this.foundationDay;
    }

    //Tester
    public static TravelClub getSample(){
//        String clubName = "Sample Club";
//        String intro = "Sample club intro~";
//        TravelClub sampleClub = new TravelClub(clubName, intro);
//        return sampleClub;

        return new TravelClub("Sample Club", "Sample Club Intro bahbahbah");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TravelClub club ID : ").append(id);
        builder.append(", Clubname : ").append(clubName);
        builder.append(", Intro : ").append(intro);
        builder.append(", FounddationDay : ").append(foundationDay);

        return builder.toString();
    }
}
