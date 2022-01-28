package com.example.apollopharmacy;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemCartModelClass {
    public int Image;
    public String text;
    public double price;
    public int quantity;
    public double total;

//    public ItemCartModelClass(int image, String text, double price, int quantity, double total) {
//        Image = image;
//        this.text = text;
//        this.price = price;
//        this.quantity = quantity;
//        this.total = total;
//    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
