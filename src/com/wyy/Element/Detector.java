package com.wyy.Element;

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
        this(theRealMap,cell.posX,cell.posY);
    }
    public Detector(Vector<Vector<Cell>> theRealMap, int x,int y){
        this.theRealMap=theRealMap;
        cell=theRealMap.get(y).get(x);
        Initial();
    }

    private void Initial() {
        space=new HashMap<>();
        space.keySet().add(Direction.DOWN);
        space.keySet().add(Direction.UP);
        space.keySet().add(Direction.RIGHT);
        space.keySet().add(Direction.LEFT);
        space.put(Direction.DOWN,detectDist(Direction.DOWN));
        space.put(Direction.UP,detectDist(Direction.UP));
        space.put(Direction.RIGHT,detectDist(Direction.RIGHT));
        space.put(Direction.LEFT,detectDist(Direction.LEFT));
    }
    private int detectDist(Direction dir){
        int dist=0;
        int posX,posY;
        char type;
        switch (dir){
            case DOWN:
                posY=cell.getPosY();
                type=theRealMap.get(posY).get(cell.getPosX()).getType();
                while (posY<theRealMap.size()&&(type!='w'&&type!='o')){
                    dist++;
                    posY++;
                    type=theRealMap.get(posY).get(cell.getPosX()).getType();
                }
                return dist;
            case UP:
                posY=cell.getPosY();
                type=theRealMap.get(posY).get(cell.getPosX()).getType();
                while (posY>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posY--;
                    type=theRealMap.get(posY).get(cell.getPosX()).getType();
                }
                return dist;
            case RIGHT:
                posX=cell.getPosX();
                type=theRealMap.get(cell.getPosY()).get(posX).getType();
                while (posX<theRealMap.get(0).size()&&(type!='w'&&type!='o')){
                    dist++;
                    posX++;
                    type=theRealMap.get(cell.getPosY()).get(posX).getType();
                }
                return dist;
            case LEFT:
                posX=cell.getPosX();
                type=theRealMap.get(cell.getPosY()).get(posX).getType();
                while (posX>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posX--;
                    type=theRealMap.get(cell.getPosY()).get(posX).getType();
                }
                return dist;
        }
        return dist;
    }
}
