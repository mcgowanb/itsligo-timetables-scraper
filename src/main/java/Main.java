public class Main {

    public static final String URL = "https://itsligo.ie/student-hub/my-timetable/";

    public static void main(String[] args)
    {
        loadData(args[0].toUpperCase());
    }


    public static void loadData(String studentID)
    {
        TimeTable timetable = new TimeTable(URL, studentID);
        System.out.println(timetable);
    }


}
