package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_holidays {

    String title,details,time;
    int image,drop_down;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDrop_down() {
        return drop_down;
    }

    public void setDrop_down(int drop_down) {
        this.drop_down = drop_down;
    }

    public Model_for_holidays(String title, String details, String time, int image, int drop_down) {
        this.title = title;
        this.details = details;
        this.time = time;
        this.image = image;
        this.drop_down = drop_down;
    }
}
