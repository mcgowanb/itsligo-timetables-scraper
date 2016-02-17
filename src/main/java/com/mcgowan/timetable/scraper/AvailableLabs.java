package com.mcgowan.timetable.scraper;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AvailableLabs {

    private final String URL = "https://itsligo.ie/student-hub/computer-labs/";
    private Document doc;
    private Map<String, List<Lab>> labsByDay;
    private String day;

    public AvailableLabs() throws IOException
    {
        //overload loadPage if params are set
        this.doc = loadPage();
        parseClassesPerDay(doc);
        this.day = getDayFromDoc();
    }

    private String getDayFromDoc()
    {
        day = new SelectedOption(doc, "#dayofweek").toString();
        return day;
    }

    private void parseClassesPerDay(Document doc)
    {
        Elements timeSlots = doc.select("div.timeslot");

        labsByDay = new LinkedHashMap<String, List<Lab>>();

        for (Element slot : timeSlots) {
            String time = slot.select(".time").first().text();
            if (time.contains("30")) continue;
            Elements room = slot.select(".room");

            List<Lab> labs = new ArrayList<Lab>();
            for (Element s : room.select("span")) {
                Lab lab = new Lab(s.select("a").first());
                labs.add(lab);
            }
            labsByDay.put(time, labs);
        }
    }

    private Document loadPage() throws IOException
    {
        doc = Jsoup.connect(URL).get();
        return doc;
    }

    @Override
    public String toString()
    {
        String output = "";
        for (Map.Entry<String, List<Lab>> entry : labsByDay.entrySet()) {
            output += entry.getKey() + "\n";
            output += TimeTable.lineBreak + "\n";
            for (Lab l : entry.getValue()){
                output += l;
            }
            output += "\n" + TimeTable.lineBreak + "\n";
        }



        return output;
    }
}
