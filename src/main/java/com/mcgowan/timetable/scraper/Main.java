package com.mcgowan.timetable.scraper;

import java.io.IOException;

public class Main {

    public static final String URL = "https://itsligo.ie/student-hub/my-timetable/";

    public static void main(String[] args)
    {
        new Main().loadData(args[0].toUpperCase());
    }


    public void loadData(String studentID)
    {
        try{
            TimeTable timetable = new TimeTable(URL, studentID);
            System.out.println(timetable);
        } catch(IOException e){
            System.out.println(String.format("Unable to connect to %s, please check your connection and try again", URL));
        }

    }


}
