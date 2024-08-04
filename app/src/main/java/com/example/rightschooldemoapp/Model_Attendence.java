package com.example.rightschooldemoapp;

public class Model_Attendence {

    String day,attendence;

    public Model_Attendence(String day, String attendence) {
        this.day = day;
        this.attendence = attendence;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }
}
