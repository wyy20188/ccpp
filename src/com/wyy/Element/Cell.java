package com.wyy.Element;

// suggest the coordination of (left,up) as (0,0)
public class Cell {
    private char type;// r room; o obstacle; g gate; w wall;
    private int posX;
    private int posY;
    private int passedTimes;
    private boolean hasBeenCleaned;
    private int height;// optional
    private int attr=0;// used to represent the current direction temporarily

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPoxY(int posY) {
        this.posY = posY;
    }

    public int getPassedTimes() {
        return passedTimes;
    }

    public void setPassedTimes(int passedTimes) {
        this.passedTimes = passedTimes;
    }

    public boolean isHasBeenCleaned() {
        return hasBeenCleaned;
    }

    public void setHasBeenCleaned(boolean hasBeenCleaned) {
        this.hasBeenCleaned = hasBeenCleaned;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }
}
