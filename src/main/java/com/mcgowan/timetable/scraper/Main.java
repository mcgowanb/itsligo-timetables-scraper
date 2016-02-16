package com.mcgowan.timetable.scraper;

public class Main {

    public static final String URL = "https://itsligo.ie/student-hub/my-timetable/";

    public static void main(String[] args)
    {
        new Main().loadData(args[0].toUpperCase());
    }


    public void loadData(String studentID)
    {
        TimeTable timetable = new TimeTable(URL, studentID);
        System.out.println(timetable);
    }


}
