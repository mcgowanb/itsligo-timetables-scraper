package com.mcgowan.timetable.scraper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day {

    private Map<String, String> dayNames;

    public Day()
    {
        String[] sNames = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        String[] names = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        dayNames = new LinkedHashMap<String, String>();

        for (int i = 0; i < sNames.length; i++) {
            dayNames.put(sNames[i], names[i]);
        }
    }

    public Map<String, String> getDayNames()
    {
        return dayNames;
    }
}
