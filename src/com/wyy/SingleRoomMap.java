package com.wyy;

import java.util.ArrayList;

/**
 * Used at initial period.
 */
class SingleRoomMap extends RoomMap{

    SingleRoomMap(int length, int width) {
        super(1, length, width);
    }
    ArrayList<ArrayList<Cell>> maze;
    @Override
    public ArrayList<ArrayList<Cell>> getRoadMap() {
        // fixed map for temporary
        maze=new ArrayList<ArrayList<Cell>>();

    }
}
