package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_notificatio {
    String noti_titile,noti_details,noti_date;
    int image,drop_down;

    public String getNoti_titile() {
        return noti_titile;
    }

    public void setNoti_titile(String noti_titile) {
        this.noti_titile = noti_titile;
    }

    public String getNoti_details() {
        return noti_details;
    }

    public void setNoti_details(String noti_details) {
        this.noti_details = noti_details;
    }

    public String getNoti_date() {
        return noti_date;
    }

    public void setNoti_date(String noti_date) {
        this.noti_date = noti_date;
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

    public Model_for_notificatio(String noti_titile, String noti_details, String noti_date, int image, int drop_down) {
        this.noti_titile = noti_titile;
        this.noti_details = noti_details;
        this.noti_date = noti_date;
        this.image = image;
        this.drop_down = drop_down;
    }
}
