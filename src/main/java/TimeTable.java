
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class TimeTable {

    public static final String url = "https://itsligo.ie/student-hub/my-timetable/";
    private String studentId;

    public static void main(String[] args) {
        TimeTable tt = new TimeTable();
        tt.loadData("S00165159");

    }


    public void loadData(String studentId){
        this.studentId = studentId;
        Parser parser = new Parser(url);
        parser.process(this.studentId);


    }


}
