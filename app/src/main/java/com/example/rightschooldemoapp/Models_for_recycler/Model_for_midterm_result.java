package com.example.rightschooldemoapp.Models_for_recycler;

public class Model_for_midterm_result {

    String result_month,result_image;

    int image,drop_down;

    public Model_for_midterm_result(String result_month, String result_image, int image, int drop_down) {
        this.result_month = result_month;
        this.result_image = result_image;
        this.image = image;
        this.drop_down = drop_down;
    }

    public String getResult_month() {
        return result_month;
    }

    public void setResult_month(String result_month) {
        this.result_month = result_month;
    }

    public String getResult_image() {
        return result_image;
    }

    public void setResult_image(String result_image) {
        this.result_image = result_image;
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
}
