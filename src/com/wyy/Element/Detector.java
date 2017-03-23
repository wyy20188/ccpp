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
    private Cell cell;
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
        this.cell=cell;
        space=new HashMap<>();
        space.keySet().add(Direction.DOWN);
        space.keySet().add(Direction.UP);
        space.keySet().add(Direction.RIGHT);
        space.keySet().add(Direction.LEFT);
        space.put(Direction.DOWN, MoveTools.detectDist(theRealMap,cell,Direction.DOWN));
        space.put(Direction.UP,MoveTools.detectDist(theRealMap,cell,Direction.UP));
        space.put(Direction.RIGHT,MoveTools.detectDist(theRealMap,cell,Direction.RIGHT));
        space.put(Direction.LEFT,MoveTools.detectDist(theRealMap,cell,Direction.LEFT));
    }
    public void setDetector(Vector<Vector<Cell>> theRealMap, Cell cell){
        this.theRealMap=theRealMap;
        updatePos(cell);
    }


//    private int detectDist(Direction dir){
//        int dist=0;
//        int posX,posY;
//        char type;
//        switch (dir){
//            case DOWN:
//                posY=cell.getPosY();
//                type=theRealMap.get(posY).get(cell.getPosX()).getType();
//                while (posY<theRealMap.size()&&(type!='w'&&type!='o')){
//                    dist++;
//                    posY++;
//                    type=theRealMap.get(posY).get(cell.getPosX()).getType();
//                }
//                break;
//            case UP:
//                posY=cell.getPosY();
//                type=theRealMap.get(posY).get(cell.getPosX()).getType();
//                while (posY>-1&&(type!='w'&&type!='o')){
//                    dist++;
//                    posY--;
//                    type=theRealMap.get(posY).get(cell.getPosX()).getType();
//                }
//                break;
//            case RIGHT:
//                posX=cell.getPosX();
//                type=theRealMap.get(cell.getPosY()).get(posX).getType();
//                while (posX<theRealMap.get(0).size()&&(type!='w'&&type!='o')){
//                    dist++;
//                    posX++;
//                    type=theRealMap.get(cell.getPosY()).get(posX).getType();
//                }
//                break;
//            case LEFT:
//                posX=cell.getPosX();
//                type=theRealMap.get(cell.getPosY()).get(posX).getType();
//                while (posX>-1&&(type!='w'&&type!='o')){
//                    dist++;
//                    posX--;
//                    type=theRealMap.get(cell.getPosY()).get(posX).getType();
//                }
//                break;
//        }
//        return dist;
//    }
}
