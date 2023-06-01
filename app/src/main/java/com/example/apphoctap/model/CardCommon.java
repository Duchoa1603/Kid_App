package com.example.apphoctap.model;

public class CardCommon {
    private int image;

    private String color;
    private int sound;

    public CardCommon() {
    }

    public CardCommon(int image, int sound) {
        this.image = image;
        this.sound = sound;
    }

    public CardCommon(String color, int sound) {
        this.color = color;
        this.sound = sound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
