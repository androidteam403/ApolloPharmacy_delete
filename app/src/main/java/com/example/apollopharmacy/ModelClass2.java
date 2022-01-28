package com.example.apollopharmacy;

public class ModelClass2 {

    public String text;
    public  int image;
    public double cost;


    public ModelClass2(String text, int image, double cost) {
        this.text = text;
        this.image = image;
        this.cost = cost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
