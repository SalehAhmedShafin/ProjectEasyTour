package com.example.easytour;

public class Item {
    String Title;
    String Image;
    String Details;

    public Item(){

    }

    public Item(String title, String image, String details) {
        Title = title;
        Image = image;
        Details = details;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
