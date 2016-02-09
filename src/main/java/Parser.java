import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parser {

    private Document doc;
    private String url;

    public Parser(String url){
        this.url = url;
    }

    public void process(String studentID) {


        try {
            doc = Jsoup.connect(url)
                    .header("Content-Type","application/x-www-form-urlencoded;charset=UTF-8")
                    .data("dept", "")
                    .data("student_id", studentID)
                    .data("studentgroup", "")
                    .data("view", "View Timetable")
                    .post();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element content = doc.select("section.entry-content").first();
        System.out.println(content);
    }
}
