import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Week {
    private String department, studentGroup;
    private ArrayList<Day> days;
    private Element content;

    public Week(Element content)
    {
        this.content = content;
        this.department = parseTitles("dept");
        this.studentGroup = parseTitles("studentgroup");
        this.days = gatherDays();
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
        Elements elements = content.getElementsByClass("tt_details");
        System.out.println(elements);
//iteration through elements to be refined here.
        for (Element e : elements) {
            Day day = new Day();
            day.setDay(e.getElementsByClass("tt_day").first().text());
//            day.setSubject(e.getElementsByClass("tt_detail").first().text());
//            day.setLecturer(e.getElementsByClass("tt_lecturer").first().text());
            day.setLocation("toDo");
            day.setTime(e.getElementsByClass("tt_timeslot").first().text());
        }


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
