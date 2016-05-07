package com.mcgowan.timetable.scraper;


import org.jsoup.nodes.Element;

public class Lab extends Link {

    public Lab(Element e) {
        super(e);
    }

    @Override
    public String toString() {
        return title + ", ";
    }
}
