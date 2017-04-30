package com.wyy.Element;

import com.wyy.Tools.MoveTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by wyy on 2017/3/21.
 * to simulate the detector
 */
public class Detector {
    int curDir;
    private Vector<Vector<Cell>> theRealMap;
    public Map<Direction,Integer> space;// record the room(steps) we could use(go)
    public Detector(Vector<Vector<Cell>> theRealMap, Cell cell){
        this.theRealMap=theRealMap;
        updatePos(cell,curDir);
    }
    public Detector(Vector<Vector<Cell>> theRealMap, int x,int y){
        this.theRealMap=theRealMap;
        updatePos(theRealMap.get(y).get(x),curDir);
    }

    // use current cell to update the data in detector
    // dir starts with 0, left; 1 lf; 2 front; etc
    public void updatePos(Cell cell, int dir){
        space=new HashMap<>();
        space.put(Direction.BACK, MoveTools.detectDist(theRealMap,cell,Direction.BACK.offSet(dir)));
        space.put(Direction.FRONT,MoveTools.detectDist(theRealMap,cell,Direction.FRONT.offSet(dir)));
        space.put(Direction.RIGHT,MoveTools.detectDist(theRealMap,cell,Direction.RIGHT.offSet(dir)));
        space.put(Direction.LEFT,MoveTools.detectDist(theRealMap,cell,Direction.LEFT.offSet(dir)));

    }
    // Use both cell and map to reset the detector, and use the tow to make sure the direction we are facing
    public void setDetector(Vector<Vector<Cell>> theRealMap, Cell cell, int dir){
        this.theRealMap=theRealMap;
        curDir=dir;
        updatePos(cell,dir);
    }

}
