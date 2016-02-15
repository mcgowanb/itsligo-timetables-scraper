public class Main {

    public static final String url = "https://itsligo.ie/student-hub/my-timetable/";
    private String studentId;

    public static void main(String[] args) {
        Main tt = new Main();
        tt.loadData("S00165159");

    }


    public void loadData(String studentId){
        this.studentId = studentId;
        Parser parser = new Parser(url);
        parser.process(this.studentId);


    }


}
