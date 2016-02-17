package com.mcgowan.timetable.scraper;

import java.io.IOException;

public class Main {

    public static final String STUDENT_URL = "https://itsligo.ie/student-hub/my-timetable/";
    public static final String ROOM_URL = "https://itsligo.ie/student-hub/computer-labs/";

    public static void main(String[] args)
    {
        new Main().loadData(args[0].toUpperCase());
//        new Main().loadLabs();
    }


    public void loadData(String studentID)
    {
        try{
            TimeTable timetable = new TimeTable(STUDENT_URL, studentID);
            System.out.println(timetable);
        } catch(IOException e){
            System.out.println(String.format("Unable to connect to %s, please check your connection and try again", STUDENT_URL));
        }

    }

    public void loadLabs(){
        try{
            AvailableLabs labs = new AvailableLabs();
            System.out.println(labs);
        }
        catch(IOException e){
            System.out.println(String.format("Unable to connect to %s, please check your connection and try again", ROOM_URL));
        }
    }


}
