package com.wyy;

import java.io.*;
import java.util.*;

// this class represents the map used for test
// there are two kinds of the map, 1) created by random; 2) read from a text file

class RoomMap{
    private int length;
    private int width;
    private int roomNum;// if 0, means get from outside
    ArrayList< ArrayList<Cell> > theMap;
    //if we want a random map
    RoomMap(int roomNum, int length, int width) {
        this.roomNum = roomNum;
        this.length = length;
        this.width = width;
//        Initial();
    }
    //if we want to read from a text
    RoomMap(String fileName){
        theMap=new ArrayList<ArrayList<Cell>>();
        try {
            BufferedReader br=new BufferedReader(new FileReader(fileName));
            String line=br.readLine();
            int index=0;
            while(line!=null){
                ArrayList<Cell> theLine=new ArrayList<Cell>();
                for(int i=0;i<line.length();i++){
                    Cell cell=new Cell();
                    cell.posX=i;
                    cell.poxY=index;
                    cell.type=line.charAt(i);
                    //todo we can add some other attributes here later
                    theLine.add(cell);
                }
                theMap.add(theLine);
                line=br.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void printRoomTrace(ArrayList<ArrayList<Cell>> theTrace){
        if(theTrace==null){
            return;
        }
        for (ArrayList<Cell> aTheTrace : theTrace) {
            for (Cell anATheTrace : aTheTrace) {
                System.out.print(anATheTrace.type);
            }
            System.out.println();
        }
    }

//    // initial() method will build the wall, the obstacle and other room space
//    private void Initial() {
//        // 1.
//        Random rand=new Random(System.currentTimeMillis());
//        int x=rand.nextInt(5)+10;
//        LandScape=new ArrayList<>(3);
//    }


//
//    public ArrayList<ArrayList<Cell>> getRoadMap(BufferedReader br) {
//        theMap=new ArrayList<ArrayList<Cell>>();
//
//    }
}























