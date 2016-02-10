import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Week {
    private String department, studentGroup;
    private Link link;
    private ArrayList<Day> days;
    private Element content;

    public Week(Element content)
    {
        this.content = content;
        this.department = parseTitles("dept");
        this.studentGroup = parseTitles("studentgroup");
        this.link = new Link(parseLink());
        this.days = gatherDays();
    }

    private Element parseLink()
    {
        Element e = content.getElementsByTag("a").first();
        return e;
    }

    private String parseTitles(String selector)
    {
        String s = content.getElementById(selector).getElementsByAttribute("selected").text();
        return s;
    }

    public Week getWeek()
    {
        return this;
    }

    private ArrayList<Day> gatherDays()
    {
        days = new ArrayList<Day>();
        System.out.println(content);
        Elements dayNames = content.getElementsByClass("tt_day");
        Elements times = content.getElementsByClass("tt_timeslot");
        Elements lecturers = content.getElementsByClass("tt_lecturer");
        Elements details = content.getElementsByClass("tt_detail");

        for (int i = 0; i < dayNames.size(); i++) {
            Day d = new Day();
            d.setDay(dayNames.get(i).text());
            d.setTime(times.get(i).text());
            d.setLecturer(lecturers.get(i).text());
            days.add(d);
        }
        System.out.println(days);
        return days;
    }

    @Override
    public String toString()
    {
        return "Week{" +
                "department='" + department + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                '}';
    }
}
