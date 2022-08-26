package com.example.easytour;

public class Hotel {
    private int id;
    private String name;
    private String rate;
    private String num;

    public Hotel(){

    }

    public Hotel(int id, String name, String rate, String num) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
