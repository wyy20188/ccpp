package com.wyy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        RoomMap roomMap=new RoomMap("E://CCPP/maze.txt");
        roomMap.printRoomTrace(roomMap.theMap);
        System.out.println();
    }
}
