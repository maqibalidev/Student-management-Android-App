package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_homeWork {

   String homeWork_img;
    String homeWorkDate;
    int image,drop_down;

    public String getHomeWork_img() {
        return homeWork_img;
    }

    public void setHomeWork_img(String homeWork_img) {
        this.homeWork_img = homeWork_img;
    }

    public String getHomeWorkDate() {
        return homeWorkDate;
    }

    public void setHomeWorkDate(String homeWorkDate) {
        this.homeWorkDate = homeWorkDate;
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

    public Model_for_homeWork(String homeWork_img, String homeWorkDate, int image, int drop_down) {
        this.homeWork_img = homeWork_img;
        this.homeWorkDate = homeWorkDate;
        this.image = image;
        this.drop_down = drop_down;
    }
}
