
public class Day {
    private String day, subject, time, className, location, lecturer;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString()
    {
        return "Day{" +
                "day='" + day + '\'' +
                ", subject='" + subject + '\'' +
                ", time='" + time + '\'' +
                ", className='" + className + '\'' +
                ", location='" + location + '\'' +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }
}
