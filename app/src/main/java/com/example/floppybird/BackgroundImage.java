package com.example.floppybird;

public class BackgroundImage {

    private int backgroundImageX;
    private int backgroundImageY;
    private int backgroundVelocity;

    public BackgroundImage(){
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundVelocity = 3;
    }

    public int getBackgroundImageX() {
        return backgroundImageX;
    }

    public void setBackgroundImageX(int backgroundImageX) {
        this.backgroundImageX = backgroundImageX;
    }

    public int getBackgroundImageY() {
        return backgroundImageY;
    }

    public void setBackgroundImageY(int backgroundImageY) {
        this.backgroundImageY = backgroundImageY;
    }

    public int getBackgroundVelocity() {
        return backgroundVelocity;
    }

    public void setBackgroundVelocity(int backgroundVelocity) {
        this.backgroundVelocity = backgroundVelocity;
    }
}
