package com.mcgowan.timetable.scraper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String STUDENT_URL = "https://itsligo.ie/student-hub/my-timetable/";
    private static final String ROOM_URL = "https://itsligo.ie/student-hub/computer-labs/";

    public static void main(String[] args) {
        new Main().loadData(args[0].toUpperCase());
//        new Main().loadLabs();
    }


    private void loadData(String studentID) {
        try {
            TimeTable timetable = new TimeTable(STUDENT_URL, studentID);
//            TimeTable timetable = new TimeTable(STUDENT_URL, "computing", "SG%5FKGDEV%5FB07%2FF%2FY3%2F1%2F%28A%29");
            timetable.process();
            String today = new SimpleDateFormat("EEEE").format(new Date());

            List<Course> t = timetable.classesForDay("Tuesday");

            String s = timetable.getStudentGroup();
            System.out.println(timetable);
        } catch (IOException e) {
            System.out.println(String.format("Unable to connect to %s, please check your connection and try again", STUDENT_URL));
        }

    }

    public void loadLabs() {
        try {
            AvailableLabs labs = new AvailableLabs(ROOM_URL, "2");
            System.out.println(labs);
        } catch (IOException e) {
            System.out.println(String.format("Unable to connect to %s, please check your connection and try again", ROOM_URL));
        }
    }


}
