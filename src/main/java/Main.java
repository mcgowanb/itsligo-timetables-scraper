public class Main {

    public static final String URL = "https://itsligo.ie/student-hub/my-timetable/";

    public static void main(String[] args) {
        loadData(args[0]);
    }


    public static void loadData(String studentId){
        TimeTable timetable = new TimeTable(URL, "S00165159");
        timetable.generateWeeklyTimetable();
        System.out.println(timetable);


    }


}
