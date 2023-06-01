package com.example.apphoctap.model;

public class GhepTu {
    private int iamge;
    private String cauhoi;
    private String dapan;

    public GhepTu(int iamge, String cauhoi, String dapan) {
        this.iamge = iamge;
        this.cauhoi = cauhoi;
        this.dapan = dapan;
    }

    public int getIamge() {
        return iamge;
    }

    public void setIamge(int iamge) {
        this.iamge = iamge;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }
}
