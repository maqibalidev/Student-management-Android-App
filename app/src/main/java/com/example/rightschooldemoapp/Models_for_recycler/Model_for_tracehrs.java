package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_tracehrs {

    String teacher_name, teacher_data;
    int teacher_number;
    int teacher_pic, drop_down, drop_up;
String num;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_data() {
        return teacher_data;
    }

    public void setTeacher_data(String teacher_data) {
        this.teacher_data = teacher_data;
    }

    public int getTeacher_number() {
        return teacher_number;
    }

    public void setTeacher_number(int teacher_number) {
        this.teacher_number = teacher_number;
    }

    public int getTeacher_pic() {
        return teacher_pic;
    }

    public void setTeacher_pic(int teacher_pic) {
        this.teacher_pic = teacher_pic;
    }

    public int getDrop_down() {
        return drop_down;
    }

    public void setDrop_down(int drop_down) {
        this.drop_down = drop_down;
    }

    public int getDrop_up() {
        return drop_up;
    }

    public void setDrop_up(int drop_up) {
        this.drop_up = drop_up;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Model_for_tracehrs(String teacher_name, String teacher_data, int teacher_number, int teacher_pic, int drop_down, int drop_up, String num) {
        this.teacher_name = teacher_name;
        this.teacher_data = teacher_data;
        this.teacher_number = teacher_number;
        this.teacher_pic = teacher_pic;
        this.drop_down = drop_down;
        this.drop_up = drop_up;
        this.num = num;
    }
}
