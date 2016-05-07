package com.mcgowan.timetable.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AvailableLabs implements Serializable {

    private Document doc;
    private Map<String, List<Lab>> labsByDay;
    private String day;

    /**
     * Takes URL only. Use this to load available classes for the current day
     *
     * @throws IOException
     */
    public AvailableLabs(String URL) throws IOException {
        this.doc = loadPage(URL);
        parseClassesPerDay(doc);
        this.day = getDayFromDoc();
    }

    /**
     * Takes URL and String of integer value 1 - 5 to represent Monday to Friday. Returns available classes for day requested
     *
     * @param day
     * @throws IOException
     */
    public AvailableLabs(String URL, String day) throws IOException {
        this.doc = loadPage(URL, day);
        parseClassesPerDay(doc);
        this.day = getDayFromDoc();
    }

    /**
     * returns day of week from current docuument
     *
     * @return
     */
    private String getDayFromDoc() {
        day = new SelectedOption(doc, "#dayofweek").toString();
        return day;
    }

    /**
     * creates main object for consumption
     *
     * @param doc
     */
    private void parseClassesPerDay(Document doc) {
        Elements timeSlots = doc.select("div.timeslot");

        labsByDay = new LinkedHashMap<String, List<Lab>>();

        for (Element slot : timeSlots) {
            String time = slot.select(".time").first().text();
            if (time.contains("30")) {
                continue;
            }
            Elements room = slot.select(".room");

            List<Lab> labs = new ArrayList<Lab>();
            for (Element s : room.select("span")) {
                Lab lab = new Lab(s.select("a").first());
                labs.add(lab);
            }
            labsByDay.put(time, labs);
        }
    }

    /**
     * loads HTML into JSOUP document via GET with no arguements
     *
     * @return
     * @throws IOException
     */
    private Document loadPage(String URL) throws IOException {
        doc = Jsoup.connect(URL).get();
        return doc;
    }

    /**
     * loads HTML into JSOUP document via GET with day of week as argument
     *
     * @param day
     * @return
     * @throws IOException
     */
    private Document loadPage(String URL, String day) throws IOException {
        doc = Jsoup.connect(URL)
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .data("dayofweek", day)
                .post();
        return doc;
    }

    @Override
    public String toString() {
        String output = String.format("%s\n\n", day);
        for (Map.Entry<String, List<Lab>> entry : labsByDay.entrySet()) {
            output += entry.getKey() + "\n";
            output += TimeTable.lineBreak + "\n";
            for (Lab l : entry.getValue()) {
                output += l;
            }
            output += "\n" + TimeTable.lineBreak + "\n";
        }


        return output;
    }
}
