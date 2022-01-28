package com.example.apollopharmacy;

public class ModelClass
{
    public int number;
    public int image;
    public String desc;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ModelClass(int number, int image, String desc) {
        this.number = number;
        this.image = image;
        this.desc = desc;
    }
}
