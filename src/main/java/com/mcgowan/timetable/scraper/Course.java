package com.mcgowan.timetable.scraper;

class Course {
    public String day;
    public String time;
    public String lecturer;
    public String subject;

    public Course(String day, String time, String lecturer, String subject)
    {
        super();
        this.day = day;
        this.time = time;
        this.lecturer = lecturer;
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return time + " : " + lecturer + " : " + subject;
    }
}