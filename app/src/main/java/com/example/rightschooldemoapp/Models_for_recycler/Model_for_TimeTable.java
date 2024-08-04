package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_TimeTable {

    String class_time,day_timeTable,time_timeTable;

    public Model_for_TimeTable(String class_time, String day_timeTable, String time_timeTable) {
        this.class_time = class_time;
        this.day_timeTable = day_timeTable;
        this.time_timeTable = time_timeTable;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getDay_timeTable() {
        return day_timeTable;
    }

    public void setDay_timeTable(String day_timeTable) {
        this.day_timeTable = day_timeTable;
    }

    public String getTime_timeTable() {
        return time_timeTable;
    }

    public void setTime_timeTable(String time_timeTable) {
        this.time_timeTable = time_timeTable;
    }
}
