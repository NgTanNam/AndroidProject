package com.example.lab8;

public class SinhVien {
    private int id;
    private String ten;
    private String msv;

    public SinhVien(int id, String ten, String msv) {
        this.id = id;
        this.ten = ten;
        this.msv = msv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }
}
