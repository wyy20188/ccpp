package com.wyy;

import java.util.*;

// this class represents the map used for test
// w means wall, x means obstacle,
class RoomMap implements IMap{
    protected int length;
    protected int width;
    protected int roomNum;

    RoomMap(int roomNum, int length, int width) {
        this.roomNum = roomNum;
        this.length = length;
        this.width = width;
        Initial();
    }
    // initial() method will build the wall, the obstacle and other room space
    private void Initial() {
        // 1.
        Random rand=new Random(System.currentTimeMillis());
        int x=rand.nextInt(5)+10;
        LandScape=new ArrayList<>(3);
    }

    protected ArrayList< ArrayList<Cell> > LandScape;

    @Override
    public ArrayList<ArrayList<Cell>> getRoadMap() {
        return LandScape;
    }
}























