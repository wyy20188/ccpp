package com.wyy.Tools;

import com.wyy.Element.Cell;

import java.util.Vector;

/**
 * Created by wyy on 2017/3/23.
 * This class contains some useful tools to debug
 */
public class DebugTools {
    // this method is used to monitor the status of the maze
    public static void printRoomTrace(Vector<Vector<Cell>> theTrace, int type){
        if(theTrace==null){
            return;
        }
        for (Vector<Cell> aTheTrace : theTrace) {
            for (Cell anATheTrace : aTheTrace) {
                if(type==0)
                    System.out.print(anATheTrace.getType());
                else if (type==1)
                    System.out.print(anATheTrace.getPassedTimes());
            }
            System.out.println();
        }
    }
}
