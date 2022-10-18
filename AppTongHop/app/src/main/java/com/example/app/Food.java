package com.example.app;

import java.io.Serializable;

public class Food implements Serializable {
    public int img;
    public String money, name;

    public Food(int img, String money, String name) {
        this.img = img;
        this.money = money;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
