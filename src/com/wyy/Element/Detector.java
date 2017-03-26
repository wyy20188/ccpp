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
    private Vector<Vector<Cell>> theRealMap;
    public Map<Direction,Integer> space;// record the room(steps) we could use(go)
    public Detector(Vector<Vector<Cell>> theRealMap, Cell cell){
        this.theRealMap=theRealMap;
        updatePos(cell);
    }
    public Detector(Vector<Vector<Cell>> theRealMap, int x,int y){
        this.theRealMap=theRealMap;
        updatePos(theRealMap.get(y).get(x));
    }

    // use current cell to update the data in detector
    public void updatePos(Cell cell){
        space=new HashMap<>();
        space.put(Direction.DOWN, MoveTools.detectDist(theRealMap,cell,Direction.DOWN));
        space.put(Direction.UP,MoveTools.detectDist(theRealMap,cell,Direction.UP));
        space.put(Direction.RIGHT,MoveTools.detectDist(theRealMap,cell,Direction.RIGHT));
        space.put(Direction.LEFT,MoveTools.detectDist(theRealMap,cell,Direction.LEFT));
    }
    // Use both cell and map to reset the detector
    public void setDetector(Vector<Vector<Cell>> theRealMap, Cell cell){
        this.theRealMap=theRealMap;
        updatePos(cell);
    }

}
