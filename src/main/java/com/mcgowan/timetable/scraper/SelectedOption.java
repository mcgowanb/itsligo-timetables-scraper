package com.mcgowan.timetable.scraper;

import org.jsoup.nodes.Document;

public class SelectedOption {
    private String name;

    /**
     * returns selected option as a string from a list of options
     * @param doc
     * @param selector
     */
    public SelectedOption(Document doc, String selector){
        try {
            this.name = doc.select("select" + selector + " > option[selected]").first().text();
        } catch (NullPointerException e) {
            this.name = "";
        }
    }

    @Override
    public String toString()
    {
        return name;
    }
}
