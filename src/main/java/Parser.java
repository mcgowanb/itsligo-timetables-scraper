import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    private String url;
    private Week weeklyData;

    public Parser(String url)
    {
        this.url = url;
    }

    public void process(String studentID)
    {
        Element content = getTimetable(studentID);
        weeklyData = parseDaysFromDoc(content);
        System.out.println(weeklyData);
    }

    private Week parseDaysFromDoc(Element content)
    {
        Week weeklyData = new Week(content).getWeek();
        return weeklyData;
    }

    private Element getTimetable(String studentID)
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

        return doc.select("section.entry-content").first();
    }
}
