package com.mcgowan.timetable.scraper;

public class Course {
    private String day, time, lecturer, subject, startTime, endTime, room;


    public Course(String day, String time, String lecturer, String subject) {
        super();
        this.day = day;
        this.time = time;
        this.lecturer = lecturer;
        this.subject = subject;
        formatTimes(this.time);
        getClassAndRoomDetails(subject);
    }

    private String getClassAndRoomDetails(String details) {
        String[] elems = details.split("-");
        String idx = elems[0].trim();
        this.room = idx.substring(idx.length() - 5, idx.length());
        this.subject = idx.substring(0, idx.length() - room.length()).trim();
        return room;
    }

    private void formatTimes(String time) {
        String[] elems = time.split("-");
        this.startTime = elems[0].trim();
        this.endTime = elems[1].trim();
    }

    @Override
    public String toString() {
        return String.format("%s : %s : %s : %s", day, time, lecturer, subject);
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
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}