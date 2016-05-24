package com.mcgowan.timetable.scraper;

class Course {
    private String day;
    private String time;
    private String lecturer;
    private String subject;
    private String startTime, endTime;

    public Course(String day, String time, String lecturer, String subject) {
        super();
        this.day = day;
        this.time = time;
        this.lecturer = lecturer;
        this.subject = subject;
        formatTimes(this.time);
    }

    private void formatTimes(String time) {
        String[] elems = time.split("-");
        this.startTime = elems[0].trim();
        this.endTime = elems[1].trim();
    }

    @Override
    public String toString() {
        return time + " : " + lecturer + " : " + subject;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}