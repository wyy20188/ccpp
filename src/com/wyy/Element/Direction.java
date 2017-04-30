package com.wyy.Element;

/**
 * Created by wyy on 2017/3/20.
 * direction
 */
public enum Direction {
    LEFT,
    FL, // FRONT+LEFT
    FRONT,
    FR, // FRONT+RIGHT
    RIGHT,
    BR,  // BACK+RIGHT
    BACK,
    BL; // BACK+LEFT

    public Direction offSet(int num){
        return values()[(ordinal() + num)%values().length];
    }
}

