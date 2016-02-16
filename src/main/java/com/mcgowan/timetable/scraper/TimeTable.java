package com.mcgowan.timetable.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class TimeTable {

    private String url, studentID, department, studentGroup;
    private Link link;
    private Document doc;
    private Map<String, List<Course>> coursesByDay;
    private Map<String, String> dayNames;
    private String lineBreak = "==================================================";


    public TimeTable(String url, String studentID)
    {
        this.studentID = studentID;
        this.url = url;
        dayNames = new Day().getDayNames();
        this.doc = loadDataFromWeb(studentID);
        parseDaysFromDoc(doc);
        generateLink();
        department = selectedTitle("select-dept");
        studentGroup = selectedTitle("select-studentgroup");
    }


    private void generateLink()
    {
        Element e = doc.select("div.tt_details > div.tt_detail > a").first();
        link = new Link(e);
    }

    private void parseDaysFromDoc(Document doc)
    {
        Elements courseEls = doc.select("div.tt_details:not(:has(div.tt_day, a))");

        coursesByDay = new LinkedHashMap<String, List<Course>>();
        for (Element courseEl : courseEls) {
            Element timeSlotEl = courseEl.select(".tt_timeslot").first();
            String timeSlotStr = timeSlotEl.ownText();
            String dayStr = timeSlotEl.select(".tt_day_small").first().text().trim().replace("(", "").replace(")", "");
            dayStr = dayNames.get(dayStr);
            String detailStr = courseEl.select(".tt_detail").first().text();
            String lecturerStr = courseEl.select(".tt_lecturer").first().text();

            Course course = new Course(dayStr, timeSlotStr, lecturerStr, detailStr);
            List<Course> courses = coursesByDay.get(dayStr);

            if (courses == null) {
                courses = new ArrayList<Course>();
                coursesByDay.put(dayStr, courses);
            }
            courses.add(course);
        }
    }


    private Document loadDataFromWeb(String studentID)
    {
        Document doc;
        try {
            doc = Jsoup.connect(url)
                    .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                    .data("dept", "")
                    .data("student_id", studentID)
                    .data("studentgroup", "")
                    .data("view", "View Timetable")
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return doc;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += String.format("Student Number: %s\nDepartment: %s\nClass: %s\ncom.mcgowan.timetable.scraper.Link Title: %s\nURL: %s \n", studentID, department, studentGroup, link.getTitle(), link.getLink());
        for (Map.Entry<String, List<Course>> entry : coursesByDay.entrySet()) {
            output += entry.getKey() + "\n";
            output += lineBreak + "\n";
            for (Course c : entry.getValue()) {
                output += "\t" + c + "\n";
            }
        }
        return output;
    }

    private String selectedTitle(String selector)
    {
        return doc.select("div." + selector + " > div select option[selected]").first().text();
    }
}
