package com.wyy.Tools;

import com.wyy.Element.Cell;
import com.wyy.Element.Direction;

import java.util.Vector;

/**
 * Created by wyy on 2017/3/23.
 * provide some tools here
 */
public final class MoveTools {

    /**
     * @param map the map be detected
     * @param cell current cell
     * @param dir forward direction
     * @return how many spare steps can be found
     */
    public static int detectDist(Vector<Vector<Cell>> map, Cell cell, Direction dir){
        int dist=0;
        int posX,posY;
        char type;
        switch (dir){
            case DOWN:
                posY=cell.getPosY();
                type=map.get(posY).get(cell.getPosX()).getType();
                while (posY<map.size()&&(type!='w'&&type!='o')){
                    dist++;
                    posY++;
                    type=map.get(posY).get(cell.getPosX()).getType();
                }
                break;
            case UP:
                posY=cell.getPosY();
                type=map.get(posY).get(cell.getPosX()).getType();
                while (posY>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posY--;
                    type=map.get(posY).get(cell.getPosX()).getType();
                }
                break;
            case RIGHT:
                posX=cell.getPosX();
                type=map.get(cell.getPosY()).get(posX).getType();
                while (posX<map.get(0).size()&&(type!='w'&&type!='o')){
                    dist++;
                    posX++;
                    type=map.get(cell.getPosY()).get(posX).getType();
                }
                break;
            case LEFT:
                posX=cell.getPosX();
                type=map.get(cell.getPosY()).get(posX).getType();
                while (posX>-1&&(type!='w'&&type!='o')){
                    dist++;
                    posX--;
                    type=map.get(cell.getPosY()).get(posX).getType();
                }
                break;
        }
        return dist;
    }

    //this method will change the status of cells
    //It is highly recommended to use detectDist() first to avoid some faults

    /**
     * This method will change the status of cells
     * It is highly recommended to use detectDist() first to avoid some faults
     * @param map the map be detected
     * @param cell current cell
     * @param dir forward direction
     * @param num the number of steps we shall go
     * @return if true, the current cell; if false, null
     */
    public static Cell moveSteps(Vector<Vector<Cell>> map, Cell cell, Direction dir, int num){
        Cell result=null;
        int x=cell.getPosX();
        int y=cell.getPosY();
        if(dir==Direction.UP){
            for(int i=1;i<num+1;i++){
                map.get(y-1).get(x).setHasBeenCleaned(true);
                map.get(y-1).get(x).setPassedTimes(map.get(y-1).get(x).getPassedTimes()+1);
            }
            result=map.get(y-num).get(x);
        }else if(dir==Direction.DOWN){
            for(int i=1;i<num+1;i++){
                map.get(y+1).get(x).setHasBeenCleaned(true);
                map.get(y+1).get(x).setPassedTimes(map.get(y+1).get(x).getPassedTimes()+1);
            }
            result=map.get(y+num).get(x);
        }else if(dir==Direction.LEFT){
            for(int i=1;i<num+1;i++){
                map.get(y).get(x-1).setHasBeenCleaned(true);
                map.get(y).get(x-1).setPassedTimes(map.get(y).get(x-1).getPassedTimes()+1);
            }
            result=map.get(y).get(x-num);
        }else if(dir==Direction.RIGHT){
            for(int i=1;i<num+1;i++){
                map.get(y).get(x+1).setHasBeenCleaned(true);
                map.get(y).get(x+1).setPassedTimes(map.get(y+1).get(x).getPassedTimes()+1);
            }
            result=map.get(y).get(x+num);
        }
        return result;
    }
}










