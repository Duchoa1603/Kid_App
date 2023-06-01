package com.example.apphoctap.model;

public class Quizz {
    private String cauhoi;

    private int anhConvat;
    private String dapan;
    private String ansA,ansB,ansC,ansD;

    public Quizz(String cauhoi, String ansA, String ansB, String ansC, String ansD, String dapan) {
        this.cauhoi = cauhoi;
        this.dapan = dapan;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
    }

    public Quizz(int anhConvat, String ansA, String ansB, String ansC, String ansD, String dapan) {
        this.anhConvat = anhConvat;
        this.dapan = dapan;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
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

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }
}
