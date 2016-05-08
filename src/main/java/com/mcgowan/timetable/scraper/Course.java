package com.mcgowan.timetable.scraper;

class Course {
    public String day;
    public String time;
    public String lecturer;
    public String subject;
    public String startTime, endTime;

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
}